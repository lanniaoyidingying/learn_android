package com.example.administrator.gittest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gittest.R;
import com.example.administrator.gittest.beans.Fruit;

import java.util.List;
import java.util.zip.Inflater;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    private List<Fruit> lists;
    private Context mContext;
    public FruitAdapter(@NonNull Context context, int resource, List<Fruit> fruitList) {
        super(context, resource,fruitList);
        resourceId = resource;
        lists = fruitList;
        mContext = context;
        Toast.makeText(getContext(),""+2,Toast.LENGTH_SHORT).show();
    }

/*    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(mContext).inflate(resourceId,parent,false);
        //Toast.makeText(getContext(),""+333,Toast.LENGTH_SHORT).show();
        ImageView imageView = (ImageView) view.findViewById(R.id.fruit_pic);
        TextView textView = (TextView)view.findViewById(R.id.fruit_name);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());
        return view;
    }*/

/*    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        if(null == convertView){
            convertView = LayoutInflater.from(mContext).inflate(resourceId,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.fruit_pic);
        TextView textView = convertView.findViewById(R.id.fruit_name);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());
        return convertView;
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        FruitHolder holder;
        if(null == convertView){
            convertView = LayoutInflater.from(mContext).inflate(resourceId,parent,false);
            holder = new FruitHolder();
            holder.imageView = convertView.findViewById(R.id.fruit_pic);
            holder.textView = convertView.findViewById(R.id.fruit_name);
            convertView.setTag(holder);
        }else{
            holder = (FruitHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getName());
        return convertView;
    }

    private class FruitHolder{
        public ImageView imageView;
        public TextView textView;
    }
}