package com.example.administrator.gittest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.gittest.utils.ActivityCollections;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, this.getClass().getName());
        ActivityCollections.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        ActivityCollections.removeActivity(this);
        super.onDestroy();
    }
}