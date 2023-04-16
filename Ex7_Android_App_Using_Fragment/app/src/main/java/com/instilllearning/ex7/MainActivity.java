package com.instilllearning.ex7;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    FragmentContainerView fragmentContainerView;
    MaterialButton btnBlue;
    MaterialButton btnOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainerView =
                findViewById(R.id.fragmentContainer);
        btnBlue = findViewById(R.id.btnBlue);
        btnOrange = findViewById(R.id.btnOrange);

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean blueIsClicked = true;
                openFragment(blueIsClicked);
            }
        });

        btnOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean blueIsClicked = false;
                openFragment(blueIsClicked);
            }
        });
    }

    private void openFragment(boolean blueIsClicked) {
        FragmentManager fragmentManager =
                getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        if (blueIsClicked == true) {
            fragmentTransaction.replace
                    (R.id.fragmentContainer, new BlueFragment());
        }
        else fragmentTransaction.replace
                (R.id.fragmentContainer, new OrangeFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}