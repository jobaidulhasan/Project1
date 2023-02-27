package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BestQuality extends AppCompatActivity {

    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_quality);
        skip=findViewById(R.id.skip);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(BestQuality.this,HomePage.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();


        skip=findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homepage=new Intent(BestQuality.this,HomePage.class);
                startActivity(homepage);
                finish();

            }
        });
    }
}