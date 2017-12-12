package com.example.administrator.gittest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*activity
编写注意首先需要先定义activity然后创建activity的资源xml文件然后加载资源文件，并且在manifest文件中注册，
* 当然现在的IDE都集成了这些功能可以自主化的完成，但是需要知道整个
* activity的加载的流程
* 课程目标学习创建menu菜单
* 首先在资源文件中创建一个文件夹命名为menu在这个文件夹中创建一个menu的xml文件
* 标签是menu中间选项是item指定item的id 和显示的文字
* 然后在activity中复写onCreateOptionsMenu
* 并且通过menuInflater加载相应的menu文件
* 然后复写onOptionsItemSelected方法进行对应条目点击的操作
* 当两个activity都添加了actionmain 和catergri时默认先添加的为程序的主入口
*
* */
public class HelloWorldActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);
        Button btnTry = (Button) findViewById(R.id.button_first_try);
        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelloWorldActivity.this,"first try",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        Button btnStart = (Button)findViewById(R.id.button_start_activity);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloWorldActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button btnNotStart = (Button)findViewById(R.id.button_not_str_start_activity);
        btnNotStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.addCategory("tian.wang.gai.di.hu");
                intent.setAction("com.example.administrator.gittest.MainActivity");
                startActivity(intent);
            }
        });
        Button btnBaidu = (Button)findViewById(R.id.button_start_baidu);
        btnBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button btnHttp = (Button)findViewById(R.id.button_start_http);
        btnHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button btnDial = (Button)findViewById(R.id.button_start_dial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086" ));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(HelloWorldActivity.this,"you click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(HelloWorldActivity.this, "you click remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}