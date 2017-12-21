package com.example.administrator.gittest.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gittest.R;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context) {
        super(context);
        init(context);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
        Button btnLeft = this.findViewById(R.id.btn_left);
        Button btnRight = this.findViewById(R.id.btn_right);
        TextView tvTitle = this.findViewById(R.id.title_text);
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"you clicked left",Toast.LENGTH_SHORT).show();
            }
        });
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"you clicked right",Toast.LENGTH_SHORT).show();
            }
        });
    }

}