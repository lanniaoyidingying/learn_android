package com.example.administrator.gittest.activity.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gittest.R;

import java.io.InputStream;

public class CommonComponentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mHelloBtn;
    private Button mGetButton;
    private EditText mEditText;
    private Button mChangeBtn;
    private ImageView mChangeImageView;
    private ProgressBar mHelloProgressBar;
    private Button mBtnChangeProgressBar;
    private Button mBtnCtrlprogressBar;
    private Button mBtnHideShow;
    private TextView mTvProgress;
    private Button mBtnAlertDialog;
    private Button mBtnProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_component);
        initView();
       setlistener();
    }

    private void initView() {
        mHelloBtn = (Button)findViewById(R.id.hello_button);
        mGetButton = (Button)findViewById(R.id.get_editText);
        mEditText = (EditText)findViewById(R.id.hello_editText);
        mChangeBtn = (Button)findViewById(R.id.change_Image);
        mChangeImageView = (ImageView)findViewById(R.id.change_imageView) ;
        mHelloProgressBar = (ProgressBar)findViewById(R.id.hello_progress);
        mBtnHideShow = (Button)findViewById(R.id.hide_show);
        mBtnChangeProgressBar = (Button)findViewById(R.id.change_progress);
        mBtnCtrlprogressBar = (Button)findViewById(R.id.btn_progressCtrl);
        mTvProgress = (TextView)findViewById(R.id.tv_progress);
        mBtnAlertDialog = (Button)findViewById(R.id.btn_dialog);
        mBtnProgressDialog = (Button)findViewById(R.id.btn_progressDialog);
    }

    private void setlistener() {
        mBtnHideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mHelloProgressBar.getVisibility()==View.VISIBLE){
                    mHelloProgressBar.setVisibility(View.GONE);
                }else{
                    mHelloProgressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        mBtnChangeProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHelloProgressBar.setProgress(mHelloProgressBar.getProgress()+10);
            }
        });
        mBtnCtrlprogressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvProgress.setText(""+mHelloProgressBar.getProgress());
            }
        });
        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                InputStream inStream = CommonComponentActivity.this.getResources().openRawResource(R.raw.img);

                Bitmap bitmap = BitmapFactory.decodeStream(inStream,null,options);
                //mChangeImageView.setImageBitmap(bitmap);
                mChangeImageView.setImageResource(R.drawable.img);
            }
        });
        mHelloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CommonComponentActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        mGetButton.setOnClickListener(this);
        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(CommonComponentActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("SomeThing is important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //dialog.create().show();
                dialog.show();
            }
        });
        mBtnProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pd = new ProgressDialog(CommonComponentActivity.this);
                pd.setTitle("This is ProgressDialog");
                pd.setMessage("Loading");
                pd.setCancelable(true);
                pd.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_editText:
                String text = mEditText.getText().toString();
                Toast.makeText(CommonComponentActivity.this,text,Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(CommonComponentActivity.this,"Error",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
