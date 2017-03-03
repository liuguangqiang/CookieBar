package com.liuguangqiang.cookie;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AlertDialog.Builder(this).setTitle("").show();

        TextView tvTest = (TextView) findViewById(R.id.tv_test);
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar
                        .Builder(MainActivity.this)
                        .setTitle("提示")
                        .setMessage("你又变帅了！！")
                        .setDuration(3000)
                        .setLayoutGravity(Gravity.TOP)
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
