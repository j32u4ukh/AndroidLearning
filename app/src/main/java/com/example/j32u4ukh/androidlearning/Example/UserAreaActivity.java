package com.example.j32u4ukh.androidlearning.Example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.j32u4ukh.androidlearning.R;

public class UserAreaActivity extends AppCompatActivity {
    TextView textUserName, textAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        textUserName = (TextView)findViewById(R.id.textUserName);
        textAge = (TextView)findViewById(R.id.textAge);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);

        /*
        String un =  getResources().getString(R.string.textUserName) + name;
        textUserName.setText(un);
        String ta = getResources().getString(R.string.textAge) + String.valueOf(age);
        textAge.setText(ta);*/
    }
}
