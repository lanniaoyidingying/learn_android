package com.example.administrator.gittest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.gittest.R;

public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        TextView textView = (TextView)findViewById(R.id.tvMessage);
        Button btnRes = (Button)findViewById(R.id.btnResponse);
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result","this is result form second activity");
                setResult(10,intent);
                finish();
            }
        });
        String mestsage = getIntent().getStringExtra("data");
        if(!(TextUtils.isEmpty(mestsage))){
            textView.setText(mestsage);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("result","this is result form second activity");
        setResult(10,intent);
        finish();
    }
}