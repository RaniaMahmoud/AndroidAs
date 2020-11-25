package com.example.ass3;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView btnCall,btnCallFriend,btnMap,btnWeb, ImgFeel;
    Button btnA;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btnCall=findViewById(R.id.imageViewCall);
        btnCallFriend=findViewById(R.id.imageViewCall);
        btnMap=findViewById(R.id.imageViewLocation);
        btnWeb=findViewById(R.id.imageViewWeb);
        btnA=findViewById(R.id.button);
        ImgFeel = findViewById(R.id.imageViewP);

        String v=getIntent().getStringExtra("Visible");

        //btnCall.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Intent intent =new Intent(Intent.ACTION_DIAL);
        //        startActivity(intent);
        //    }
        //});

        String number=getIntent().getStringExtra("Number");
        String Web=getIntent().getStringExtra("WebSite");
        String location=getIntent().getStringExtra("Location");
        Bundle bundle = getIntent().getExtras();

        if(number !=null && location !=null && Web !=null && bundle != null){
            btnCallFriend.setVisibility(View.VISIBLE);
            btnWeb.setVisibility(View.VISIBLE);
            btnMap.setVisibility(View.VISIBLE);
            int resId = bundle.getInt("IMX");
            ImgFeel.setImageResource(resId);
            ImgFeel.setVisibility(View.VISIBLE);
        }
        btnCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Integer.parseInt(number)));
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www."+Web+".com"));
                startActivity(intent);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        Active2.class);
                startActivity(intent);
            }
        });
    }
}