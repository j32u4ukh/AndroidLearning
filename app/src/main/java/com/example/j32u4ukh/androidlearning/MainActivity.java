package com.example.j32u4ukh.androidlearning;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.ActionMenuView;
import android.widget.Toast;

import com.example.j32u4ukh.androidlearning.Example.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            TabFragment tabFragment = new TabFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_fragment, tabFragment)
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    // 按返回鍵退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            ConfirmExit();//按返回鍵，則執行退出確認
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //退出確認
    public void ConfirmExit(){
        AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
        ad.setTitle("離開")
                .setMessage("確定要離開此程式嗎?")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    //退出按鈕
                    public void onClick(DialogInterface dialog, int i) {
                        MainActivity.this.finish();//關閉activity
                    }
                })
                .setNegativeButton("否",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                //不退出不用執行任何操作
            }
        })
                .show();//顯示對話框
    }
}
