package com.example.stage.vue;

import android.content.Intent;
import android.os.Bundle;
import com.example.stage.R;
import com.example.stage.controleur.PutData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText txtNom, txtMdp;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtNom = findViewById(R.id.txtNom);
        txtMdp = findViewById(R.id.txtMdp);
        btn = findViewById(R.id.btn);
        ecoutebtn();
    }


    private void ecoutebtn() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nom, mdp;

                //prend la valeur qui a ete ecrite dans l application
                nom = String.valueOf(txtNom.getText());
                mdp = String.valueOf(txtMdp.getText());

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {//Démarrer l'écriture et la lecture des données avec l'URL

                        String[] field = new String[2];//Création d'un tableau pour les paramètres
                        field[0] = "nom";
                        field[1] = "mdp";

                        String[] data = new String[2];//Création d un tableau pour les données
                        data[0] = nom;
                        data[1] = mdp;

                        PutData putData = new PutData("http://sc1chfl1498.universe.wf/Equ26K7z/LesAges/login_android.php", "POST", field, data);
                        if (putData.startPut()) {//envoie de toute les données
                            if (putData.onComplete()) {//si toute les donnée sont acquise
                                String result = putData.getResult();//recupere le resultat cad le echo du php
                                if (result.equals("reussi1")) {
                                    Toast.makeText(getApplicationContext(), "Authentification réussi", Toast.LENGTH_SHORT).show();
                                    ecouteCarte();

                                }else if(result.equals("reussi2")){
                                    Toast.makeText(getApplicationContext(), "Authentification réussi", Toast.LENGTH_SHORT).show();
                                    ecouteProf();

                                }else {
                                    if (result.equals("echec")){
                                        Toast.makeText(getApplicationContext(), "Mot de passe incorrecte", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }
                        }
                    }
                });

            }

        });
    }
    private void ecouteCarte(){
                Intent intent = new Intent(login.this, carte.class);
                startActivity(intent);
            }
    private void ecouteProf(){
        Intent intent = new Intent(login.this, Visiteur.class);
        startActivity(intent);
    }


}



