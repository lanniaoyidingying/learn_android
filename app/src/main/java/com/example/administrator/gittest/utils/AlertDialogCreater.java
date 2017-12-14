package com.example.administrator.gittest.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class AlertDialogCreater {
    private static AlertDialog   mAlertDialog;
    private AlertDialog.Builder mBuilder;
    public AlertDialogCreater(Context context){
        new AlertDialogCreater(context,null);
    }
    private AlertDialogCreater(Context context,String pTtitle){
        new AlertDialogCreater(context,pTtitle,null);
    }
    private AlertDialogCreater(final Context context,String pTtitle,String pMessage){
        mBuilder = new AlertDialog.Builder(context);
        mAlertDialog = mBuilder.create();
        mAlertDialog.setTitle(pTtitle);
        mAlertDialog.setMessage(pMessage);
        mAlertDialog.setCancelable(false);
        mAlertDialog.setCanceledOnTouchOutside(true);
        mAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(context,"you click cancle!",Toast.LENGTH_SHORT).show();
                mAlertDialog.cancel();
            }
        });
        mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(context,"you click ok!",Toast.LENGTH_SHORT).show();
                mAlertDialog.cancel();
            }
        });
        mAlertDialog.show();
    }

    public static AlertDialog getAlertDialog(Context context,String pTtitle,String pMessage){
        new AlertDialogCreater(context,pTtitle,pMessage);
        return mAlertDialog;
    }
    public static AlertDialog getAlertDialog(Context context,String pTtitle){
        new AlertDialogCreater(context,pTtitle);
        return mAlertDialog;

    }
    public static AlertDialog getAlertDialog(Context context){
        new AlertDialogCreater(context);
        return mAlertDialog;
    }
}