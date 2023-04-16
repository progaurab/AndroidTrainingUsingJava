package com.instilllearning.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] state = { "Select State", "Telangana", "Karnataka", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "West Bengal", "Other"};

    EditText editName, editPassword,editAddress,editAge;
    TextView result;
    Button buttonSubmit;
    String selectedState, selectedGender;
    private RadioGroup radioGroup;

    //private RadioGroup radioSexGroup;
    //private RadioButton radioSexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editAge = (EditText) findViewById(R.id.editAge);
       // radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);
                //Toast.makeText(MainActivity.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                selectedGender = (String) radioButton.getText();
             }
        });


        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the state list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,state);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        result = (TextView) findViewById(R.id.tvResult);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                String address= editAddress.getText().toString();
                String age = editAge.getText().toString();

                result.setText(
                        "Name:\t" + name +
                        "\nPassword:\t" + password +
                        "\nAGE:\t" + age +
                        "\nGender:\t" + selectedGender +
                        "\nAddress:\t" + address +
                        "\nState:\t" + selectedState  );

            }
        });

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(getApplicationContext(),state[position] , Toast.LENGTH_LONG).show();
        selectedState = state[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}