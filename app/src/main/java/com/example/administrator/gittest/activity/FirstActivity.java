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

public class FirstActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        tvResult = (TextView)findViewById(R.id.tvResult);
        Button btntransInformation = (Button)findViewById(R.id.transInformation);
        btntransInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("data","This is first trans to me");
                //startActivity(intent);
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==10&&resultCode==10){
            String result = data.getStringExtra("result");
            if(!TextUtils.isEmpty(result)){
                tvResult.setText(result);
            }
        }
    }
}