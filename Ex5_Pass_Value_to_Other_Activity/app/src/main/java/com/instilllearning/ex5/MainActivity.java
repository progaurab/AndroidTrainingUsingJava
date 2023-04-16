package com.instilllearning.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et=(EditText)findViewById(R.id.editText1);
        final EditText et1=(EditText)findViewById(R.id.editText2);
        Button send=(Button)findViewById(R.id.button1);
        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                String s=et.getText().toString();
                String s1=et1.getText().toString();
                Intent it=new Intent(MainActivity.this,SecondActivity.class);
                it.putExtra("uname", s);
                it.putExtra("pwd", s1);
                startActivity(it);
            }
        });
    }
}