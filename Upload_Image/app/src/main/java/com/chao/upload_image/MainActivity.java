package com.chao.upload_image;

import java.io.FileNotFoundException;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.b01);
        button.setText("选择图片");
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);

            }

        });
    }

     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        Uri uri = data.getData();
         Log.e("uri", uri.toString());
        System.out.println(uri.toString());
        ContentResolver cr = this.getContentResolver();
        try {
        Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
        ImageView imageView = (ImageView) findViewById(R.id.iv01);

         imageView.setImageBitmap(bitmap);
        }
        catch (FileNotFoundException e) {
            Log.e("Exception", e.getMessage(),e);

        }
    }
    super.onActivityResult(requestCode, resultCode, data);
    }


    /**
        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
    Uri selectedImage = data.getData();
    String[] filePathColumn = { MediaStore.Images.Media.DATA };

    Cursor cursor = getContentResolver().query(selectedImage,
    filePathColumn, null, null, null);
    cursor.moveToFirst();

    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
    String picturePath = cursor.getString(columnIndex);
    cursor.close();

    ImageView imageView = (ImageView) findViewById(R.id.iv01);
    imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

    }

    }
      * @param requestCode
     * @param resultCode
     * @param data
     */

}
