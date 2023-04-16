package com.instilllearning.ex3_user_input;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // These are the global variables
    EditText editName, editInstitute;
    TextView result;
    Button buttonSubmit, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editInstitute = (EditText) findViewById(R.id.editInstitute);
        result = (TextView) findViewById(R.id.tvResult);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonReset = (Button) findViewById(R.id.buttonReset);

        //Submit Button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String institute = editInstitute.getText().toString();
                result.setText("Name:\t" + name + "\nInstitute:\t" + institute);

                // Reset Button
                buttonReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editName.setText("");
                        editInstitute.setText("");
                        result.setText("");
                        editName.requestFocus();
                    }
                });
            }
        });
    }
}