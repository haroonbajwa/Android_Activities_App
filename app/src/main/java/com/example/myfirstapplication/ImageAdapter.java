package com.example.myfirstapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;

public class ImageAdapter implements SpinnerAdapter {

    private Context myContext;
    // Put some images to project-folder: /res/drawable/
    // format: jpg, gif, png, bmp, ...
    private int[] myImageIds = { R.drawable.image1, R.drawable.image2,
            R.drawable.image3, R.drawable.image4, R.drawable.image5 };

    public ImageAdapter(Activity_Image_Gallery activity_image_gallery) {
        this.myContext = activity_image_gallery;
    }

    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return this.myImageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get a View to display image data
        ImageView iv = new ImageView(this.myContext);
        iv.setImageResource(this.myImageIds[position]);

        iv.setScaleType(ImageView.ScaleType.FIT_END);

        iv.setLayoutParams(new Gallery.LayoutParams(95, 70));
        return iv;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
