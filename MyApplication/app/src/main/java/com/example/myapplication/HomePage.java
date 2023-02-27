package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    ///initialize
    Toolbar toolbar;
    ImageSlider imageSlider;
    String product_name[];
    String product_details[];
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

       toolbar=findViewById(R.id.toolbar);
       imageSlider =findViewById(R.id.image_slider);
       recyclerView=findViewById(R.id.recyclearview);


       setSupportActionBar(toolbar);


        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.s,null));
        imageList.add(new SlideModel(R.drawable.s,null));
        imageList.add(new SlideModel(R.drawable.s,null));
        imageSlider.setImageList(imageList);


        product_name = getResources().getStringArray(R.array.product_name);
        product_details=getResources().getStringArray(R.array.product_details);
        Adapter adapter=new Adapter(this,product_name,product_details);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        adapter.OnitemClickListener(new Adapter.OntiemClick() {
            @Override
            public void onclick(View view, int position) {
                Intent intent=new Intent(HomePage.this,Product_details.class);
                startActivity(intent);
                Toast.makeText(HomePage.this, "Click"+position, Toast.LENGTH_SHORT).show();
            }
        });





    }
}