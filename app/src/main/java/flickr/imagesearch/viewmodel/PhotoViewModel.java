package flickr.imagesearch.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import androidx.databinding.ObservableInt;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import flickr.imagesearch.data.utils.APIClient;
import flickr.imagesearch.data.utils.APIInterface;
import flickr.imagesearch.data.utils.URLBuilder;
import flickr.imagesearch.model.Photo;
import flickr.imagesearch.model.PhotoResponse;
import flickr.imagesearch.model.Photos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoViewModel extends java.util.Observable {
    private static final String TAG = PhotoViewModel.class.getSimpleName();

    private Context context;

    public ObservableInt progress;
    public ObservableInt gridview;

    private Photos flickrApiResponse;
    private List<Photo> photoList;

    private URLBuilder url;
    private boolean isLoading;


    /**
     * Constructor to initialize / instantiate all variable / classes
     *
     * @param context           application context
     * @param photoList         photo list instance
     * @param url               URLBuilder instance
     * @param flickrApiResponse FlickrApiResponse instance
     */
    public PhotoViewModel(Context context, List<Photo> photoList, URLBuilder url, Photos flickrApiResponse) {
        this.context = context;

        this.progress = new ObservableInt(View.GONE);
        this.gridview = new ObservableInt(View.VISIBLE);

        this.photoList = photoList;

        this.url = url;
        this.flickrApiResponse = flickrApiResponse;
    }

    /**
     * to get the list of photos
     *
     * @return list of photos
     */
    public List<Photo> getPhotoList() {
        return this.photoList;
    }


    /**
     * this method manages http call
     */
    private void fetch() {
        setLoading();
        progress.set(View.VISIBLE);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<PhotoResponse> call = apiInterface.getData(url.getQuery(), String.valueOf(url.getPage()));
        call.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(@NotNull Call<PhotoResponse> call, @NotNull Response<PhotoResponse> response) {
                Log.d("rxjava", "onResponse: " + response.code());
                PhotoResponse resource = response.body();

                setLoaded();
                progress.set(View.GONE);

                if (resource != null && resource.getPhotos() != null) {
                    flickrApiResponse.setPage(resource.getPhotos().getPage());
                    flickrApiResponse.setPages(resource.getPhotos().getPages());

                    if (response.code() == 200) {
                        photoList.addAll(resource.getPhotos().getPhotoList());
                        setChanged();
                        notifyObservers();
                    } else {
                        Toast.makeText(context, "Failed to Fetch", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Invalid Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<PhotoResponse> call, @NotNull Throwable t) {
                call.cancel();
                Log.d("rxjava", "onFailure: " + t.getMessage());

                setLoaded();
                progress.set(View.GONE);
            }
        });
    }

    /**
     * set false on http response
     */
    private void setLoaded() {
        this.isLoading = false;
    }

    /**
     * set true on http request
     */
    private void setLoading() {
        this.isLoading = true;
    }

    /**
     * reset old record when search with new query
     */
    private void clear() {
        flickrApiResponse.setPage(0);
        flickrApiResponse.setPages(0);

        photoList.clear();
        setChanged();
        notifyObservers();
    }


    /**
     * overridden method call when ime search button clicked
     *
     * @param newText search box text
     * @return false
     */
    public boolean onQueryTextSubmit(String newText) {
        this.clear();
        this.url.setQuery(newText);
        this.fetch();

        return false;
    }

    /**
     * overridden method call when ime search button clicked
     *
     * @param newText search box text
     * @return false
     */
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    /**
     * Overridden method of gridview when scrolled
     *
     * @param view             AbsListView instance
     * @param firstVisibleItem first visible item
     * @param visibleItemCount number of visible item
     * @param totalItemCount   number of total item
     */
    public void onGridScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount >= totalItemCount) {
            Log.i(TAG, "onScrolled -> " + visibleItemCount + "-" + totalItemCount + "-" + firstVisibleItem);

            if (!isLoading && flickrApiResponse.getPage() < flickrApiResponse.getPages() - 1) {
                this.url.setPage(flickrApiResponse.getPage() + 1);
                this.fetch();
            }
        }
    }
}