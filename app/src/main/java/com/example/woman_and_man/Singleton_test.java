package com.example.woman_and_man;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class Singleton_test {
    private void Singleton_test() {
    }

    private static Object syncRoot = new Object();
    private static Singleton_test instance;

    public static Singleton_test getInstance() {
        if (instance == null) {
            synchronized (syncRoot) {
                if (instance == null) {
                    instance = new Singleton_test();
                }
            }
        }
        return instance;
    }
    public void showDialog(Context context) {
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("haha");
            alertDialog = builder.create();
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    alertDialog = null;
                }
            });
        }
        alertDialog.show();
    }

    public void dismissDialog() {
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    }
    private AlertDialog alertDialog;
}
