package com.example.appmobile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    //1:Déclaration des variables View
    EditText name,psw;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //2:Récuperation des variables view
        name=findViewById(R.id.login);
        psw=findViewById(R.id.pwd);
        signIn=findViewById(R.id.btn_login);

        //3:lancer un ecouteru d'action
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pseudo=name.getText().toString();
                String password=psw.getText().toString();

                if(pseudo.equalsIgnoreCase("admin") && (password.equals("000"))){

                    Intent i=new Intent(login.this,Drawer.class);
                    startActivity(i);

                }else{
                    Toast.makeText(login.this,"Login &psw invalide!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}