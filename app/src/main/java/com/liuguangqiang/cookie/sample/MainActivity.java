package com.liuguangqiang.cookie.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liuguangqiang.cookie.CookieBar;
import com.liuguangqiang.cookie.OnActionClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTop = (Button) findViewById(R.id.btn_top);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setMessage("你又变帅了！！！咦？怎么没有标题？")
                        .show();
            }
        });

        Button btnBottom = (Button) findViewById(R.id.btn_bottom);
        btnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar
                        .Builder(MainActivity.this)
                        .setTitle("提示")
                        .setMessage("你又变帅了！！！")
                        .setLayoutGravity(Gravity.BOTTOM)
                        .setAction("点击一下", new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "点击后，我更帅了!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        Button btnTopWithIcon = (Button) findViewById(R.id.btn_top_with_icon);
        btnTopWithIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setTitle("提示")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("你又变帅了！！！")
                        .setDuration(3000)
                        .setAction("点击一下", new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "点击后，我更帅了!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        Button btnCustom = (Button) findViewById(R.id.btn_custom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setTitle("提示")
                        .setMessage("你又变帅了！！！")
                        .setDuration(3000)
                        .setBackgroundColor(R.color.colorPrimary)
                        .setActionColor(android.R.color.white)
                        .setTitleColor(R.color.colorAccent)
                        .setAction("点击一下", new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "点击后，我更帅了!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });
    }
}
