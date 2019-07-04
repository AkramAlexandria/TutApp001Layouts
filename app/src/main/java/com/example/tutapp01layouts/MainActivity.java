package com.example.tutapp01layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLinLayout;
    Button btnRelLayout;
    Button btnTableLayout;
    Button btnScrollLayout;
    Button btnTabsLayout;
    Button btnFragLayout;
    Button btnFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinLayout = (Button) findViewById(R.id.btnLinLayout);
        btnRelLayout = (Button) findViewById(R.id.btnRelLayout);
        btnTableLayout = (Button) findViewById(R.id.btnTableLayout);
        btnScrollLayout = (Button) findViewById(R.id.btnScrollLayout);
        btnTabsLayout = (Button) findViewById(R.id.btnTabsLayout);
        btnFragLayout = (Button) findViewById(R.id.btnFragLayout);
        btnFrameLayout = (Button) findViewById(R.id.btnFrameLayout);

        btnLinLayout.setOnClickListener(this);
        btnRelLayout.setOnClickListener(this);
        btnTableLayout.setOnClickListener(this);
        btnScrollLayout.setOnClickListener(this);
        btnTabsLayout.setOnClickListener(this);
        btnFragLayout.setOnClickListener(this);
        btnFrameLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLinLayout:
                startActivity(new Intent(this, ActivityLinearLayout.class));
                break;
            case R.id.btnRelLayout:
                startActivity(new Intent(this, ActivityRelativeLayout.class));
                break;
            case R.id.btnTableLayout:
                startActivity(new Intent(this, ActivityTableLayout.class));
                break;
            case R.id.btnScrollLayout:
                startActivity(new Intent(this, ActivityScrollLayout.class));
                break;
            case R.id.btnTabsLayout:
                startActivity(new Intent(this, ActivityTabsLayout.class));
                break;
            case R.id.btnFragLayout:
                startActivity(new Intent(this, ActivityFragmentLayout.class));
                break;
            case R.id.btnFrameLayout:
                startActivity(new Intent(this, ActivityFrameLayout.class));
                break;
        }
    }
}