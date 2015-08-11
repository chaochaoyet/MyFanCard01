package com.chao.gridview_emotions;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends Activity {
    private Integer[] mImageIds={
            R.drawable.aini,R.drawable.aoteman,R.drawable.baibai,R.drawable.beishang,R.drawable.bishi,
            R.drawable.bizui,R.drawable.buyao,R.drawable.chanzui,R.drawable.chijing,R.drawable.come_on,
            R.drawable.cool,R.drawable.dangao,R.drawable.ding,R.drawable.duixiang,R.drawable.fuyun,
            R.drawable.ganmao,R.drawable.geili,R.drawable.good,R.drawable.guzhang,R.drawable.haha,
            R.drawable.haixiu,R.drawable.han,R.drawable.hehe,R.drawable.heixian,R.drawable.heng,
            R.drawable.huatong,R.drawable.huaxin,R.drawable.hufen,R.drawable.jiong,R.drawable.keai,
            R.drawable.kelian,R.drawable.kun,R.drawable.landelini,R.drawable.lazhu,R.drawable.lei,
            R.drawable.liwu,R.drawable.lvxing,R.drawable.madaochenggong,R.drawable.money,R.drawable.nanhaier,
            R.drawable.nu,R.drawable.numa,R.drawable.nvhaier,R.drawable.ok,R.drawable.qinqin,R.drawable.ruo,
            R.drawable.shangxin,R.drawable.shengbing,R.drawable.shenma,R.drawable.shiwang,R.drawable.shuai,
            R.drawable.shudaizi,R.drawable.shuijiao,R.drawable.sikao,R.drawable.taikaixin,R.drawable.touxiao,
            R.drawable.tu,R.drawable.tuzi,R.drawable.v5,R.drawable.wabishi,R.drawable.weiqu,R.drawable.xin,
            R.drawable.xiongmao,R.drawable.xixi,R.drawable.xu,R.drawable.xue,R.drawable.ye,R.drawable.yinxian,
            R.drawable.yiwen,R.drawable.youhengheng,R.drawable.yun,R.drawable.zan,R.drawable.zhuakuang,
            R.drawable.zhutou,R.drawable.zuoguilian,R.drawable.zuohengheng
    };
    private int i=0;
    private Button button;
    private MyEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button=(Button)findViewById(R.id.button);
        editText=(MyEditText)findViewById(R.id.edittext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                MainActivity.this.startActivityForResult(intent,CONTEXT_RESTRICTED);


            }
        });





    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
         i = bundle.getInt("emotions");
        editText.insertDrawable(mImageIds[i]);

    }



}
