package com.chao.gallery_imageswitch;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;


public class MainActivity extends Activity implements ViewFactory{
    private ImageSwitcher imageSwitcher;
    private Gallery gallery;
    private int InAnimation=android.R.anim.fade_in;
    private int OutAnimation=android.R.anim.fade_out;
    private SelfAdapter adapter;

    private int backgroundcolor=0xFF000000;
    private FrameLayout.LayoutParams params;

    private Integer[] drawableResource={R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
    R.drawable.photo4,R.drawable.photo5,R.drawable.photo6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery);
        imageSwitcher=(ImageSwitcher)findViewById(R.id.imageswitch);
        adapter=new SelfAdapter(this);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,InAnimation));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,OutAnimation));
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageSwitcher.setImageResource(drawableResource[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    @Override
    public View makeView(){
        ImageView imageView=new ImageView(this);
        params=new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        imageView.setBackgroundColor(backgroundcolor);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(params);
        return imageView;
    }



}

