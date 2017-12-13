package com.example.administrator.gittest.lifeCycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.gittest.R;

public class OtherActivity extends AppCompatActivity {

    private static final String TAG = "Activity";
    private static final String Tag = "AppCompat";
    private Button btnNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        btnNormal = (Button)findViewById(R.id.start_normal_activity_fromOther);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtherActivity.this,NormalActivity.class));
            }
        });
        Log.e(TAG, "onCreate: OtherActivity" );
        Log.e(Tag, this.toString() +"  "+this.getTaskId() );
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: OtherActivity" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: OtherActivity" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: OtherActivity" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: OtherActivity" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: OtherActivity" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: OtherActivity" );
    }
}
