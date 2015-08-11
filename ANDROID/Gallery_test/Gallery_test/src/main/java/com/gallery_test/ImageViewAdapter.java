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

    //���ڷ���ͼ��������Ҫע����ǣ�����������ܴ���ͼ���ʵ����������С��ͼ���ʵ��������������׳�Խ���쳣��
    public int getCount() {
        //�Ż�һ
        //return imageIDs.length;
        return Integer.MAX_VALUE;
    }

    public Object getItem(int position) {
        return imageIDs[position];
    }

    public long getItemId(int position) {
        return position;
    }

    //ScaleType���÷�
    //CENTER/center  ��ͼƬ��ԭ��size������ʾ����ͼƬ��/����View�ĳ�/�����ȡͼƬ�ľ��в�����ʾ
    //CENTER_CROP/centerCrop  ����������ͼƬ��size������ʾ��ʹ��ͼƬ�� (��)���ڻ����View�ĳ�(��)
    //CENTER_INSIDE/centerInside  ��ͼƬ����������������ʾ��ͨ����������С ��ԭ����sizeʹ��ͼƬ��/����ڻ�С��View�ĳ�/��
    //FIT_CENTER/fitCenter  ��ͼƬ����������/��С��View�Ŀ�ȣ�������ʾ
    //FIT_END/fitEnd   �� ͼƬ����������/��С��View�Ŀ�ȣ���ʾ��View���²���λ��
    //FIT_START/fitStart  �� ͼƬ����������/��С��View�Ŀ�ȣ���ʾ��View���ϲ���λ��
    //FIT_XY/fitXY  ��ͼƬ �������� ����/��С��View�Ĵ�С��ʾ
    //MATRIX/matrix �þ���������
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        //�Ż�����ͨ��ȡ����ѭ��ȡ��imageIDs�����е�ͼ����ԴID��ȡ����Դ�������Դ���˷�
        iv.setImageResource(imageIDs[position%imageIDs.length]);
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        return iv;

    }

}