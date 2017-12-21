package com.example.administrator.gittest.activity.layout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.gittest.R;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ActionBar actionBar = getSupportActionBar();
        if(null!=actionBar){
            actionBar.hide();
        }
    }
}
