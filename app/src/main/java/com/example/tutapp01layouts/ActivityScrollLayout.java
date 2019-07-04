package com.example.tutapp01layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ActivityScrollLayout extends AppCompatActivity {

    Button btnGetData, btnShowData;
    TextView txtData;
    String link = "https://jsonplaceholder.typicode.com/users", result;
    URL url;
    HttpURLConnection httpURLConnection;
    InputStream inputStream;
    StringBuffer stringBuffer = new StringBuffer();
    StringBuffer resultBuffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_layout);

        txtData = findViewById(R.id.txtData);
        btnGetData = findViewById(R.id.btnGetData);
        btnShowData = findViewById(R.id.btnShowData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try
                        {
                            url = new URL(link);

                            httpURLConnection = (HttpURLConnection) url.openConnection();

                            httpURLConnection.setReadTimeout(10000);
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setRequestMethod("GET");

                            inputStream=httpURLConnection.getInputStream();

                            int c = 0;

                            int responceCode = httpURLConnection.getResponseCode();

                            if( responceCode == HttpURLConnection.HTTP_OK){
                                while ( ( c = inputStream.read() ) != -1 )
                                {
                                    stringBuffer.append( (char) c );
                                }
                            }

                            result = stringBuffer.toString();

                            JSONArray jsonArray = new JSONArray(result);

                            for( int i=0; i < jsonArray.length(); i++ ){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                int id = jsonObject.getInt("id");
                                String name = jsonObject.getString("name");

                                resultBuffer.append( id + "   " + name + "\n");
                            }
                        }
                        catch (Exception e) { e.printStackTrace(); }

                    }
                }).start();
            }
        });

        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText(resultBuffer);
            }
        });
    }
}
