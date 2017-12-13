package com.example.administrator.gittest.lifeCycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.gittest.R;

public class DialogActivity extends AppCompatActivity {
private static final String TAG = "Activity";
    private Button btnNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btnNormal = (Button)findViewById(R.id.start_normal_activity);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DialogActivity.this,NormalActivity.class));
            }
        });
        Log.e(TAG, "onCreate: DialogActivity" );
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: DialogActivity" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: DialogActivity" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: DialogActivity" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: DialogActivity" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: DialogActivity" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: DialogActivity" );
    }
}
