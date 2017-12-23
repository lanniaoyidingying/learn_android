package com.example.administrator.gittest.activity.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gittest.R;
import com.example.administrator.gittest.beans.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TryRecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> lists = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_recycler_view);
        initData();
        initView();
    }

    private void initData() {
        for(int i = 0;i<2;i++){
            lists.add(new Fruit("Apple",R.drawable.apple_pic));
            lists.add(new Fruit("Banana",R.drawable.banana_pic));
            lists.add(new Fruit("Orange",R.drawable.orage_pic));
            lists.add(new Fruit("Watermelon",R.drawable.watermelon_pic));
            lists.add(new Fruit("Pear",R.drawable.pear_pic));
            lists.add(new Fruit("Grape",R.drawable.grape_pic));
            lists.add(new Fruit("Pineapple",R.drawable.pineapple_pic));
            lists.add(new Fruit("Strawberry",R.drawable.strawberry_pic));
            lists.add(new Fruit("Cherry",R.drawable.cherry_pic));
            lists.add(new Fruit("Mango",R.drawable.mango_pic));
        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecyclerAdapter mAdapter = new RecyclerAdapter(lists);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.FruitHolder>{
        private List<Fruit> fruitList;
        private RecyclerView.ViewHolder holder;
        private int position;

        public RecyclerAdapter(List<Fruit> fruitList){
            this.fruitList = fruitList;
        }
        @Override
        public FruitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruits_list,parent,false);
            final FruitHolder fruitHolder = new FruitHolder(view);
            fruitHolder.fruitView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = fruitHolder.getAdapterPosition();
                    Fruit fruit = fruitList.get(position);
                    Toast.makeText(TryRecyclerViewActivity.this,"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
                }
            });

            fruitHolder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = fruitHolder.getAdapterPosition();
                    Fruit fruit = fruitList.get(position);
                    Toast.makeText(TryRecyclerViewActivity.this,"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
                }
            });
            return fruitHolder;
        }

        @Override
        public void onBindViewHolder(FruitHolder holder, int position) {
            final Fruit fruit = fruitList.get(position);
            holder.mImageView.setImageResource(fruit.getImageId());
            holder.mTextView.setText(getName(fruit.getName()));
        }

        @Override
        public int getItemCount() {
            return fruitList.size();
        }

        class FruitHolder extends RecyclerView.ViewHolder{

            public FruitHolder(View itemView) {
                super(itemView);
                fruitView = itemView;
                mImageView = itemView.findViewById(R.id.fruit_pic);
                mTextView = itemView.findViewById(R.id.fruit_name);
            }
            public ImageView mImageView;
            public TextView mTextView;
            public View fruitView;
        }
    }

    private StringBuilder getName(String name){
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int count = random.nextInt(20)+1;
        for(int i= 0 ;i<count;i++){
            builder.append(name);
        }
        return builder;
    }
}
