package com.chao.gridview_emotions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by chao on 2015/6/9.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
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

    public GridViewAdapter(Context mContext) {
        this.mContext = mContext;
    }



    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if(view==null){
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100,100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        }
        else {
            imageView=(ImageView)view;
        }
        imageView.setImageResource(mImageIds[i]);
        return imageView;
    }
}
