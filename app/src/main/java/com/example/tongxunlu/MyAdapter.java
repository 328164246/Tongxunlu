package com.example.tongxunlu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 张晓红 on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {
  private List<Phone> list;
  private Context context;

    public MyAdapter(List<Phone> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         Holder holder;
         if(null==convertView){
             holder=new Holder();
             convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
             holder. tv_name = convertView.findViewById(R.id.tv_name);
             holder. tv_number = convertView.findViewById(R.id.tv_number);

             convertView.setTag(holder);
         }else{
             holder= (Holder) convertView.getTag();
         }
         holder.tv_name.setText(list.get(position).getName());
         holder.tv_number.setText(list.get(position).getNumber());
        return convertView;
    }
    class Holder{
        TextView tv_name ;
        TextView tv_number;
    }


}
