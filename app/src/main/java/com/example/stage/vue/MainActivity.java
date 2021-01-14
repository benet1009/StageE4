package com.example.stage.vue;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.stage.R;
import com.example.stage.modele.Parcelle;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);
        init();
    }
    private Spinner spCulture;
    private EditText NbSurface;
    private EditText NbSurface1;
    private EditText txtTypeSol;
    private EditText txtTravailSol;
    private EditText txtSemis;
    private EditText txtCompost;
    private EditText nbN;
    private EditText nbP;
    private EditText nbK;
    private EditText nbS;
    private EditText nbCA;
    private EditText txtPhytos;
    private EditText nbIFT;
    private EditText nbCoupe1, nbCoupe2, nbCoupe3, nbCoupe4;
    private EditText nbCoupe1_1, nbCoupe2_1, nbCoupe3_1, nbCoupe4_1;
    private TextView txtTbotte, txtTbotte1;
    private EditText nbPoidsBotte;
    private TextView txtKGTotal;
    private EditText nbTauxMS;
    private TextView txtMSR;
    private TextView txtRMS;
    Parcelle p = new Parcelle();
    //Initialisation des liens avec les objets graphiques

    private void init(){
        NbSurface = (EditText)findViewById(R.id.NbSurface);
        NbSurface1 = (EditText)findViewById(R.id.NbSurface1);
        txtTypeSol = (EditText)findViewById(R.id.txtTypeSol);
        spCulture = (Spinner) findViewById(R.id.spCulture);
        txtTravailSol = (EditText)findViewById(R.id.txtTravailSol);
        txtSemis = (EditText)findViewById(R.id.txtSemis);
        txtCompost = (EditText)findViewById(R.id.txtCompost);
        nbN = (EditText)findViewById(R.id.nbN);
        nbP = (EditText)findViewById(R.id.nbP);
        nbK = (EditText)findViewById(R.id.nbK);
        nbS = (EditText)findViewById(R.id.nbS);
        nbCA = (EditText)findViewById(R.id.nbCA);
        txtPhytos = (EditText)findViewById(R.id.txtPhytos);
        nbIFT = (EditText)findViewById(R.id.nbIFT);
        nbCoupe1 = (EditText)findViewById(R.id.nbCoupe1);
        nbCoupe2 = (EditText)findViewById(R.id.nbCoupe2);
        nbCoupe3 = (EditText)findViewById(R.id.nbCoupe3);
        nbCoupe4 = (EditText)findViewById(R.id.nbCoupe4);
        nbCoupe1_1 = (EditText)findViewById(R.id.nbCoupe1_1);
        nbCoupe2_1 = (EditText)findViewById(R.id.nbCoupe2_1);
        nbCoupe3_1 = (EditText)findViewById(R.id.nbCoupe3_1);
        nbCoupe4_1 = (EditText)findViewById(R.id.nbCoupe4_1);
        txtTbotte = (TextView)findViewById(R.id.txtTbotte);
        txtTbotte1 = (TextView)findViewById(R.id.txtTbotte1);
        nbPoidsBotte = (EditText)findViewById(R.id.nbPoidsBotte);
        txtKGTotal = (TextView)findViewById(R.id.txtKGTotal);
        nbTauxMS = (EditText)findViewById(R.id.nbTauxMS);
        txtMSR = (TextView)findViewById(R.id.txtMSR);
        txtRMS = (TextView)findViewById(R.id.txtRMS);

        culture();
        ecouteCalculBotteT(nbCoupe1, nbCoupe2, nbCoupe3, nbCoupe4, txtTbotte);
        ecouteCalculBotteT(nbCoupe1_1, nbCoupe2_1, nbCoupe3_1, nbCoupe4_1, txtTbotte1);
        ecouteCalculKGT();
        ecouteCalculMSR();
        ecouteCalculRMS();
        //test();
        //tes();
    }

    private void culture() {

        //Récupération du Spinner déclaré dans le fichier xml
        //Création d'une liste d'élément à mettre dans le Spinner
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
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cultureList);
        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spCulture.setAdapter(adapter);

    }

    private void ecouteCalculBotteT(final TextView c1, final TextView c2, final TextView c3, final TextView c4, final TextView txt){
        ((Button) findViewById(R.id.btnBotteT)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Integer coupe1 = 0;
                Integer coupe2 = 0;
                Integer coupe3 = 0;
                Integer coupe4 = 0;
                // récupération des données saisies
                try {
                    coupe1 = Integer.parseInt(c1.getText().toString());
                    coupe2 = Integer.parseInt(c2.getText().toString());
                    coupe3 = Integer.parseInt(c3.getText().toString());
                    coupe4 = Integer.parseInt(c4.getText().toString());
                }catch(Exception e){}
                afficheResult1(coupe1,coupe2, coupe3, coupe4, txt);
            }
        });
    }

    private void afficheResult1(Integer coupe1,Integer coupe2,Integer coupe3,Integer coupe4, TextView txt){
        p.resultat1(coupe1,coupe2, coupe3, coupe4);
        Integer botteT = p.getBotteT();
        txt.setText(String.valueOf(botteT));
    }

    private void ecouteCalculKGT(){
        ((Button) findViewById(R.id.btnMBT)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                float poidsBotte = 0;
                // récupération des données saisies
                try {
                    poidsBotte = Float.parseFloat(nbPoidsBotte.getText().toString());
                }catch(Exception e){}
                afficheResult2(poidsBotte);
            }
        });
    }

    private void ecouteCalculMSR(){
        ((Button) findViewById(R.id.btnMSR)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                float tauxMS = 0;
                // récupération des données saisies
                try {
                    tauxMS = Float.parseFloat(nbTauxMS.getText().toString());
                }catch(Exception e){}
                afficheResult3(tauxMS);
            }
        });
    }

    private void ecouteCalculRMS(){
        ((Button) findViewById(R.id.btnRMS)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                float surface = 0;
                // récupération des données saisies
                try {
                    surface = Float.parseFloat(NbSurface.getText().toString());
                }catch(Exception e){}
                afficheResult4(surface);
            }
        });
    }




    private void afficheResult2(float poidsBotte){
        p.resultat2(poidsBotte);
        float kgt = p.getKgTotal();
        txtKGTotal.setText(String.valueOf(kgt));
    }

    private void afficheResult3(float tauxMS){
        p.resultat3(tauxMS);
        float MSR = p.getMSR();
        txtMSR.setText(String.valueOf(MSR));
    }

    private void afficheResult4(float surface){
        p.resultat4(surface);
        float RMS = p.getRMS();
        txtRMS.setText(String.valueOf(RMS));
    }

}