package flickr.imagesearch.view.adapter;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import flickr.imagesearch.model.Photo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * PhotoAdapter local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PhotoAdapterUnitTest
{
    private PhotoAdapter photoAdapter;

    @Before
    public void setUpAdapter()
    {
        this.photoAdapter = new PhotoAdapter(new Activity(), new ArrayList<Photo>());
    }

    @Test
    public void getCount()
    {
        assertEquals(0, photoAdapter.getPhotoList().size());

        photoAdapter.getPhotoList().add(new Photo());

        assertEquals(1, photoAdapter.getPhotoList().size());
    }


    @Test
    public void getItem()
    {
        photoAdapter.getPhotoList().add(new Photo());
        photoAdapter.getPhotoList().add(new Photo());

        assertNotNull(photoAdapter.getItem(1));
    }
}