package flickr.imagesearch.data.utils;

import flickr.imagesearch.model.PhotoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("services/rest/?method=flickr.photos.search&api_key=37ad288835e4c64fc0cb8af3f3a1a65d&format=json&nojsoncallback=1&safe_search=1")
    Call<PhotoResponse> getData(@Query("text") String text, @Query("page") String page);
}
