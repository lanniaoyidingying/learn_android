package com.example.administrator.gittest.activity.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.gittest.R;
import com.example.administrator.gittest.adapter.FruitAdapter;
import com.example.administrator.gittest.beans.Fruit;
import com.example.administrator.gittest.consts.TestConsts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TryListViewActivity extends AppCompatActivity {

    //private ListView mListView;
    private ListView mListView1;
    private String[] mDatas = TestConsts.fruits;
    private List<Fruit> lists = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_list_view);
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
        //mListView = (ListView)findViewById(R.id.listview);
        mListView1 = (ListView)findViewById(R.id.listview1);
        //ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mDatas);
        //mListView.setAdapter(mAdapter);
        //Toast.makeText(this,""+lists.toString(),Toast.LENGTH_SHORT).show();
        FruitAdapter mAdapter = new FruitAdapter(this,R.layout.fruits_list,lists);
        mListView1.setAdapter(mAdapter);

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),""+lists.get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
