package flickr.imagesearch.data.utils;

import android.util.Log;

import flickr.imagesearch.model.Photo;

public class URLBuilder
{
//    private static final String TAG = URLBuilder.class.getSimpleName();
//
//    private static final String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&\n" +
//            "format=json&nojsoncallback=1&safe_search=1";

    private int page;
    private String query;

//    @Override
//    public String toString()
//    {
//        String url = BASE_URL.concat("&text=" + query).concat(page > 0 ? "&page=" + page : "");
//        Log.i(TAG, url);
//
//        return url;
//    }

    public String toPhotoUrl(Photo photo)
    {
        return "http://farm".concat(String.valueOf(photo.getFarm())).concat(".static.flickr.com/")
                .concat(photo.getServer()).concat("/").concat(photo.getId())
                .concat("_").concat(photo.getSecret()).concat(".jpg");

    }

    public String getQuery()
    {
        return this.query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public int getPage()
    {
        return this.page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
}