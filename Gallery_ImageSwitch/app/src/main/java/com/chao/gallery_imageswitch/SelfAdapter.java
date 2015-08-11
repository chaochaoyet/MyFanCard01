package com.chao.gallery_imageswitch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by chao on 2015/4/7.
 */
public class SelfAdapter extends BaseAdapter{
    private Context context;
    private Integer[] drawableResource={R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
            R.drawable.photo4,R.drawable.photo5,R.drawable.photo6};
    public SelfAdapter(Context context){
        this.context=context;

    }
    public int getCount(){
        return drawableResource.length;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public Object getItem(int position){
        return drawableResource[position];
    }
    @Override
    public View getView(int position,View view,ViewGroup parent){
        ImageView imageView=new ImageView(context);

        imageView.setImageResource(drawableResource[position]);
        imageView.setAdjustViewBounds(true);
        return imageView;


    }


}
