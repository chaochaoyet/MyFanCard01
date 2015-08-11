package com.gallery;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Gallery gallery;
    private ImageView imageView;
    private myImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageAdapter=new myImageAdapter(this);
        gallery=(Gallery)findViewById(R.id.gallery_view);
        imageView=(ImageView)findViewById(R.id.image_view);
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"’‚ «Õº∆¨"+i+"∫≈",Toast.LENGTH_LONG).show();
                imageView.setBackgroundResource(imageAdapter.myImageIds[i]);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
