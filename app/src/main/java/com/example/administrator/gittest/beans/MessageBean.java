package com.example.administrator.gittest.beans;

public class MessageBean {
    public static final int MESSAGE_RECIVED =0;
    public static final int MESSAGE_SEND = 1;
    private String mContent;

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public int getMessageType() {
        return mMessageType;
    }

    public void setMessageType(int mMessageType) {
        this.mMessageType = mMessageType;
    }

    private int mMessageType;
    public MessageBean(String pContent,int pMessageType){
        mContent = pContent;
        mMessageType = pMessageType;
    }


}