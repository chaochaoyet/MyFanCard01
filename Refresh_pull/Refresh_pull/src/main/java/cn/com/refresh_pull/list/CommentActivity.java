package cn.com.refresh_pull.list;

/**
 * Created by chao on 15-3-16.
 */
import android.app.Activity;
import android.content.Intent;
import android.view.View;//注意view的大小写
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
public class CommentActivity extends Activity{
    private Button my_button2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_activity);
        my_button2=(Button)findViewById(R.id.my_button2);
        my_button2.setText("发表评论");
        my_button2.setOnClickListener(new MyButtonListener2());
    }
    class MyButtonListener2 implements OnClickListener{
        public void onClick(View view){
            Intent intent=new Intent();
            intent.setClass(CommentActivity.this,MainActivity.class);
            CommentActivity.this.startActivity(intent);
        }
    }
}