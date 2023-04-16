package com.instilllearning.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv=(TextView)findViewById(R.id.textView1);
        TextView tv1=(TextView)findViewById(R.id.textView2);
        tv.setText(getIntent().getExtras().getString("uname"));
        tv1.setText(getIntent().getExtras().getString("pwd"));

        Button send=(Button)findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}