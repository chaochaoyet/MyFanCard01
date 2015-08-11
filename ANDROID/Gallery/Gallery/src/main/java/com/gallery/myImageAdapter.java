package com.gallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class myImageAdapter extends BaseAdapter{
    int mGalleryItemBackground;
    private Context context;
    public Integer[] myImageIds={R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
            R.drawable.photo4,R.drawable.photo5,R.drawable.photo6};
    public myImageAdapter(Context context){
        this.context=context;
        TypedArray typed_array=context.obtainStyledAttributes(R.styleable.Gallery);
        mGalleryItemBackground=typed_array.getResourceId(R.styleable.Gallery_android_galleryTtemBackground,0);
        typed_array.recycle();
    }
    @Override
    public int getCount(){
        return myImageIds.length;
    }
    @Override
    public Object getItem(int position){
        return position;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(myImageIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(128,128));
        imageView.setBackgroundResource(mGalleryItemBackground);
        return imageView;
    }
}