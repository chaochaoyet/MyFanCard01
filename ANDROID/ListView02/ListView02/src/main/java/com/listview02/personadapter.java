package com.listview02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import itemperson.person;

import java.util.List;

/**
 * Created by chao on 15-3-26.
 */
public class personadapter extends ArrayAdapter {
    private LayoutInflater layoutInflater=null;
    private List<person> persons;
    public personadapter(Context context, int textViewResourceId, List objects) {
        super(context, textViewResourceId, objects);
        layoutInflater = LayoutInflater.from(context);
        persons = objects;
    }

    /**
     * ��ȡadapter���ж��ٸ�������
     */
    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * ������ʾ�����ݽ���
     *
     * Adapter�����þ���ListView����������֮���������
     * ���б����ÿһ����ʾ��ҳ��ʱ���������Adapter��getView��������һ��View��
     * ���û�У� �����ǵ��б���1000000��ʱ����ʲô���ģ��ǲ��ǻ�ռ�ü����ϵͳ��Դ��
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        // �Ż�ǰ
        ViewHolder holder = new ViewHolder();
        convertView = layoutInflater.inflate(R.layout.main, null);
        holder.id = (TextView)convertView.findViewById(R.id.id);
        holder.name = (TextView)convertView.findViewById(R.id.name);
        holder.age = (TextView)convertView.findViewById(R.id.age);
        convertView.setTag(holder);

        holder.id.setText(persons.get(position).getId());
        holder.name.setText(persons.get(position).getName());
        holder.age.setText(persons.get(position).getAge());
        return convertView;
        */

        // �Ż���
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.activity_main, null);
            holder = new ViewHolder();
            holder.id = (TextView)convertView.findViewById(R.id.id);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.age = (TextView)convertView.findViewById(R.id.age);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.id.setText(persons.get(position).getId());
        holder.name.setText(persons.get(position).getName());
        holder.age.setText(persons.get(position).getAge());
        return convertView;
    }

    /**
     * �����ϵ���ʾ�ؼ�
     *
     * @author jiqinlin
     *
     */
    private static class ViewHolder{
        private TextView id;
        private TextView name;
        private TextView age;
    }


}
