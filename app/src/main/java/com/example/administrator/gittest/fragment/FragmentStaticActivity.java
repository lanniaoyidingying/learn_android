package com.example.administrator.gittest.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.administrator.gittest.R;

public class FragmentStaticActivity extends AppCompatActivity {

    private Button btnLeftFragment;
    private FrameLayout framLayoutRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_static);
        initView();
        initData();
        replaceFragment(new RightFragment());
    }

    private void initView() {
        btnLeftFragment = findViewById(R.id.btnLeftFragment);
        framLayoutRight = findViewById(R.id.right_FramLayout);
    }

    private void initData() {
        btnLeftFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AnotherFragment());
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.right_FramLayout,fragment);
        transaction.commit();
    }
}
