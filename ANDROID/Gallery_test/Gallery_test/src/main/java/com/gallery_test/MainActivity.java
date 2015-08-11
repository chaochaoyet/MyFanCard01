package com.gallery_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements ViewFactory {
    private Gallery gallery = null;
    private ImageSwitcher imageSwitcher=null;
    int[] imageIDs={
            R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
            R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,
           };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher);
        // 设置ImageSwitcher组件的工厂对象
        imageSwitcher.setFactory(this);
        // 设置ImageSwitcher组件显示图像的动画效果
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        gallery = (Gallery) findViewById(R.id.gallery);
        ImageViewAdapter adapter=new ImageViewAdapter(MainActivity.this, imageIDs);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //选中Gallery中某个图像时，在ImageSwitcher组件中放大显示该图像
                imageSwitcher.setImageResource(imageIDs[position%imageIDs.length]);
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        gallery.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("ljq", "parent="+parent.getClass().getName()); //Gallery
                Log.i("ljq", "view="+view.getClass().getName()); //ImageView
                Log.i("ljq", "position=" + position); //1
                Log.i("ljq", "id=" + id);//1
                Gallery gl=(Gallery)parent;
                ImageView iv=(ImageView)view;
            }
        });


    }

    // ImageSwitcher组件需要这个方法来创建一个View对象（一般为ImageView对象）
    // 来显示图像
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0xFF000000);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        return imageView;
    }
}