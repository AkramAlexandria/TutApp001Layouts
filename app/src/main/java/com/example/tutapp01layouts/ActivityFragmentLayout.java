package com.example.tutapp01layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityFragmentLayout extends AppCompatActivity implements View.OnClickListener {

    Button btn01, btn02, btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final FragmentA fragmentA = new FragmentA();
        final FragmentB fragmentB = new FragmentB();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (view.getId()) {
            case R.id.btn01: {
                if( manager.findFragmentByTag("fragB") == null) {
                    //transaction.remove(manager.findFragmentByTag("fragB"));
                    transaction.add(R.id.fragSpace, fragmentA, "fragA");
                    transaction.commit(); }
                else {
                    transaction.remove(manager.findFragmentByTag("fragB"));
                    transaction.add(R.id.fragSpace, fragmentA, "fragA");
                    transaction.commit(); }
                break;
            }
            case R.id.btn02: {
                if( manager.findFragmentByTag("fragA") != null)
                    transaction.remove(manager.findFragmentByTag("fragA")).commit();
                break;
            }
            case R.id.btn03: {
                if( manager.findFragmentByTag("fragA") != null) {
                    transaction.remove(manager.findFragmentByTag("fragA"));
                    transaction.add(R.id.fragSpace, fragmentB, "fragB");
                    //transaction.replace(R.id.fragSpace, fragmentB);
                    transaction.commit(); }
                break;
            }
        }
    }
}


