package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Delivery extends AppCompatActivity {
    TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        skip=findViewById(R.id.skip);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_delivery);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(Delivery.this,BestQuality.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();


        skip=findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.interrupt();
                Intent homepage=new Intent(Delivery.this,HomePage.class);
                startActivity(homepage);
                finish();

            }
        });
    }
}