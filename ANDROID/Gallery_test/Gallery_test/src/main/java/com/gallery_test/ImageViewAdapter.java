package com.gallery_test;

/**
 * Created by chao on 15-3-25.
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageViewAdapter extends BaseAdapter{
    private int[] imageIDs=null;
    private Context context=null;

    public ImageViewAdapter(Context context, int[] imageIDs) {
        this.context=context;
        this.imageIDs=imageIDs;
    }

    //用于返回图像总数，要注意的是，这个总数不能大于图像的实际数（可以小于图像的实际数），否则会抛出越界异常。
    public int getCount() {
        //优化一
        //return imageIDs.length;
        return Integer.MAX_VALUE;
    }

    public Object getItem(int position) {
        return imageIDs[position];
    }

    public long getItemId(int position) {
        return position;
    }

    //ScaleType的用法
    //CENTER/center  按图片的原来size居中显示，当图片长/宽超过View的长/宽，则截取图片的居中部分显示
    //CENTER_CROP/centerCrop  按比例扩大图片的size居中显示，使得图片长 (宽)等于或大于View的长(宽)
    //CENTER_INSIDE/centerInside  将图片的内容完整居中显示，通过按比例缩小 或原来的size使得图片长/宽等于或小于View的长/宽
    //FIT_CENTER/fitCenter  把图片按比例扩大/缩小到View的宽度，居中显示
    //FIT_END/fitEnd   把 图片按比例扩大/缩小到View的宽度，显示在View的下部分位置
    //FIT_START/fitStart  把 图片按比例扩大/缩小到View的宽度，显示在View的上部分位置
    //FIT_XY/fitXY  把图片 不按比例 扩大/缩小到View的大小显示
    //MATRIX/matrix 用矩阵来绘制
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        //优化二，通过取余来循环取得imageIDs数组中的图像资源ID，取余可以大大较少资源的浪费
        iv.setImageResource(imageIDs[position%imageIDs.length]);
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        return iv;

    }

}