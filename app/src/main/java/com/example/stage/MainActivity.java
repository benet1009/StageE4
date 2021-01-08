package com.example.stage;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);

        //Récupération du Spinner déclaré dans le fichier xml
        spinner = (Spinner) findViewById(R.id.spinner);
        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List cultureList = new ArrayList();
        cultureList.add("Luzerne");
        cultureList.add("Trèfle violet");
        cultureList.add("RGI");
        cultureList.add("Fétuque");
        cultureList.add("Autre prairie");
        cultureList.add("Autre culture");
        cultureList.add("Jachère");
        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                cultureList
        );


        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner.setAdapter(adapter);

    }
}