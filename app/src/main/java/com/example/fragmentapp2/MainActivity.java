package com.example.fragmentapp2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Button btnOne= (Button) findViewById(R.id.btnOne);
       final  Button btnTwo= (Button) findViewById(R.id.btnTwo);


        loadFragment(new FragmentOne());
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click","Button One Click");
                btnOne.setBackgroundColor(getResources().getColor(R.color.black));
                btnTwo.setBackgroundColor(getResources().getColor(R.color.white));
                loadFragment(new FragmentOne());

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","Button Two Click");
                loadFragment(new FragmentTwo());
                btnTwo.setBackgroundColor(getResources().getColor(R.color.black));
                btnOne.setBackgroundColor(getResources().getColor(R.color.white));


            }
        });

    }
    private void loadFragment(Fragment fragment)
    {
        FragmentManager fm =getFragmentManager();
        final FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.frmLayout, fragment);
        ft.commit();

    }
}