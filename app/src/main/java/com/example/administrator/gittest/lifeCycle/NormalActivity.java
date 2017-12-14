package com.example.administrator.gittest.lifeCycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.gittest.R;
import com.example.administrator.gittest.base.BaseActivity;
import com.example.administrator.gittest.utils.AlertDialogCreater;

public class NormalActivity extends BaseActivity {
private static final String TAG = "Activity";
private static final String Tag = "AppCompat";
    private Button btnNormal;
    private Button btnOther;
    private Button btnNormalMode;
    private Button btnSingleTop;
    private Button btnSingleTask;
    private Button btnNormalSingleInstance;
    private Button btnDialogShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Log.e(TAG, "onCreate: NormalActivity" );

        Log.e(Tag, this.toString() +"  "+this.getTaskId() );
        if(!(null == savedInstanceState)){
            Toast.makeText(getApplicationContext(),savedInstanceState.getString("save"),Toast.LENGTH_SHORT).show();
        }
        initView();
        initListener();
    }

    private void initListener() {
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NormalActivity.this,DialogActivity.class));
            }
        });
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NormalActivity.this,OtherActivity.class));
            }
        });
        btnNormalMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NormalActivity.this,NormalActivity.class));
            }
        });
        btnSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NormalActivity.this,NormalActivity.class));
            }
        });
        btnSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NormalActivity.this,NormalActivity.class));
            }
        });
        btnNormalSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NormalActivity.this,NormalActivity.class));
            }
        });
        btnDialogShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog sAlertDialog = AlertDialogCreater.getAlertDialog(NormalActivity.this,"Dialog","this is myDialog");

            }
        });
    }

    private void initView() {
        btnNormal = (Button)findViewById(R.id.start_normal);
        btnOther = (Button)findViewById(R.id.start_btnOther);
        btnNormalMode = (Button)findViewById(R.id.start_normal_mode);
        btnSingleTop = (Button)findViewById(R.id.start_singleTop);
        btnSingleTask = (Button)findViewById(R.id.start_singleTask);
        btnNormalSingleInstance = (Button)findViewById(R.id.start_singleInstance);
        btnDialogShow = (Button)findViewById(R.id.btnDialogShow);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: NormalActivity" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: NormalActivity" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: NormalActivity" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: NormalActivity" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: NormalActivity" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: NormalActivity" );
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString("sava","save");
    }
}
