package com.chao.gridview_emotions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by chao on 2015/6/9.
 */
public class SecondActivity extends Activity{
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        GridView gridView=(GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new GridViewAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SecondActivity.this,"hello"+i,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("emotions", i);
                intent.putExtras(bundle);
                setResult(CONTEXT_RESTRICTED,intent);
                finish();
            }
        });

    }
}
