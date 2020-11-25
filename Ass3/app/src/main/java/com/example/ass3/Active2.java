package com.example.ass3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;

public class Active2 extends AppCompatActivity {

    EditText Box1,Box2,Box3,Box4;
    ImageView IMF,IMH,IMS;
    boolean check=false;
    Button passButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Box1 = findViewById(R.id.etName);
        Box2 = findViewById(R.id.etNumber);
        Box3 = findViewById(R.id.etlocation);
        Box4 = findViewById(R.id.etlink);
        IMF = findViewById(R.id.imageViewF);
        IMS = findViewById(R.id.imageViewS);
        IMH = findViewById(R.id.imageViewH);
        passButton= findViewById(R.id.btnTow);
        Intent intent = new Intent(Active2.this, MainActivity.class);
        IMF.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                intent.putExtra("IMX",R.drawable.ic_baseline_sentiment_satisfied_24);
                Toast.makeText(Active2.this,"IMF !",
                        Toast.LENGTH_LONG).show();
                check=true;
            }});
        IMS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                intent.putExtra("IMX",R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
                Toast.makeText(Active2.this,"IMS !",
                        Toast.LENGTH_LONG).show();
                check=true;
            }});
        IMH.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                intent.putExtra("IMX",R.drawable.ic_baseline_sentiment_satisfied_alt_24);
                Toast.makeText(Active2.this,"IMH !",
                        Toast.LENGTH_LONG).show();
                check=true;
            }});
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Box1.getText().toString().trim().isEmpty() ||Box2.getText().toString().trim().isEmpty()
                ||Box3.getText().toString().trim().isEmpty()||Box4.getText().toString().trim().isEmpty() || !check){
                    Toast.makeText(Active2.this,"enter All Filed !",
                            Toast.LENGTH_LONG).show();
                }else{
                String name = Box1.getText().toString();
                String phone = Box2.getText().toString();
                String location = Box3.getText().toString();
                String web = Box4.getText().toString();

                intent.putExtra("Name", name);
                intent.putExtra("Number", phone);
                intent.putExtra("Location", location);
                intent.putExtra("WebSite", web);
                intent.putExtra("Visible", "visible");

                startActivity(intent);
                }
            }
        });
    }
}
