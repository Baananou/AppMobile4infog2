package com.example.appmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1:Déclaration de variables view
    EditText taille,poids;
    TextView result;
    Button calcul;
    ImageView instagram,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2:récuperation des variables
        taille=findViewById(R.id.taille);
        poids=(EditText)findViewById(R.id.poids);
        result=findViewById(R.id.result);
        calcul=findViewById(R.id.btn_imc);
        instagram=findViewById(R.id.insta);
        phone=findViewById(R.id.tel);



        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double t=Double.parseDouble(taille.getText().toString());
                Double p=Double.parseDouble(poids.getText().toString());

                Double r=p/t*t;
                String res="";
                if(r>=40){
                    res="Obésité massive";
                }else if(r<40 && r>=29.9){
                    res="Obésité";
                }else if(r<29.9 && r>=24.9){
                    res="Surpoids";
                }else if(r<24.9 && r>=18.5){
                    res="normal";
                }else{
                    res="Maigreur";
                }
                result.setText(res);

            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri chemin=Uri.parse("https://www.instagram.com");
                Intent insta=new Intent(Intent.ACTION_VIEW,chemin);
                startActivity(insta);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri appel=Uri.parse("tel:0021625423569");
                Intent A=new Intent(Intent.ACTION_DIAL,appel);
                startActivity(A);
            }
        });







    }

}
