package com.example.administrator.gittest.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gittest.R;
import com.example.administrator.gittest.beans.MessageBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NinePatchActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mETContent;
    private Button mOptions;
    private RecyclerView mShowRecyclerView;
    private MessageAdapter mAdapter;
    private List<MessageBean> mMessagwes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_patch);
        initView();
        initData();
    }
private void initData() {
        mOptions.setOnClickListener(this);
        mAdapter = new MessageAdapter(mMessagwes,R.layout.message_layout,this);
        mShowRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager mManager = new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        mShowRecyclerView.setLayoutManager(mManager);
    }

    private void initView() {
        mETContent = findViewById(R.id.mMessage);
        mOptions = findViewById(R.id.btnOptions);
        mShowRecyclerView = findViewById(R.id.message_recyclerView);
    }

    @Override
    public void onClick(View view) {
        Random rand = new Random();
        int type = rand.nextInt(2);
        String content = mETContent.getText().toString().trim();
        if(content.equals("")){
            Toast.makeText(NinePatchActivity.this,"can't be null",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(NinePatchActivity.this,content,Toast.LENGTH_SHORT).show();
        MessageBean messageBean = new MessageBean(content,type);
        mMessagwes.add(messageBean);
        mAdapter.notifyItemInserted(mMessagwes.size()-1);
        mShowRecyclerView.scrollToPosition(mMessagwes.size()-1);
        mETContent.setText("");
    }

    class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
        public List<MessageBean> mDatas;
        public int mResId;
        private Context mContext;
        public MessageAdapter(List<MessageBean> pDatas, int pResId, Context pContext){
            mDatas = pDatas;
            mResId = pResId;
            mContext = pContext;
        }

        @Override
        public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(mResId,parent,false);
            return new MessageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MessageViewHolder holder, int position) {
            MessageBean msg = mDatas.get(position);
            if(msg.getMessageType() == MessageBean.MESSAGE_RECIVED){
                holder.linearLayoutLeft.setVisibility(View.GONE);
                holder.linearLayoutRight.setVisibility(View.VISIBLE);
                holder.textViewRight.setText(msg.getContent());
            }else if(msg.getMessageType() == MessageBean.MESSAGE_SEND){
                holder.linearLayoutLeft.setVisibility(View.VISIBLE);
                holder.linearLayoutRight.setVisibility(View.GONE);
                holder.textViewLeft.setText(msg.getContent());
            }
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
        class MessageViewHolder extends RecyclerView.ViewHolder{
            public LinearLayout linearLayoutLeft;
            public LinearLayout linearLayoutRight;
            public TextView textViewLeft;
            public TextView textViewRight;

            public MessageViewHolder(View itemView) {
                super(itemView);
                linearLayoutLeft = itemView.findViewById(R.id.leftbg);
                linearLayoutRight = itemView.findViewById(R.id.rightbg);
                textViewLeft = itemView.findViewById(R.id.leftContent);
                textViewRight = itemView.findViewById(R.id.rightContent);
            }

        }
    }
}
