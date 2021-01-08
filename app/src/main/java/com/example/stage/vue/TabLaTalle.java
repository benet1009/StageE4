package com.example.stage.vue;

import android.graphics.Color;
import android.os.Bundle;

import com.example.stage.R;
import com.example.stage.modele.Parcelle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TabLaTalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_la_talle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }
    private EditText NbSurface;
    private EditText nbCoupe1, nbCoupe2, nbCoupe3, nbCoupe4;
    private TextView txtTbotte;
    private EditText nbPoidsBotte;
    private TextView txtKGTotal;
    private EditText nbTauxMS;
    private TextView txtMSR;
    private TextView txtRMS;
    private Button btnBotteT;
    private Button btnMBT;
    private Button btnMSR;
    private Button btnRMS;
    Parcelle p = new Parcelle();
    //Initialisation des liens avec les objets graphiques

    private void init(){
        NbSurface = (EditText)findViewById(R.id.NbSurface);
        nbCoupe1 = (EditText)findViewById(R.id.nbCoupe1);
        nbCoupe2 = (EditText)findViewById(R.id.nbCoupe2);
        nbCoupe3 = (EditText)findViewById(R.id.nbCoupe3);
        nbCoupe4 = (EditText)findViewById(R.id.nbCoupe4);
        txtTbotte = (TextView)findViewById(R.id.txtTbotte);
        nbPoidsBotte = (EditText)findViewById(R.id.nbPoidsBotte);
        txtKGTotal = (TextView)findViewById(R.id.txtKGTotal);
        nbTauxMS = (EditText)findViewById(R.id.nbTauxMS);
        txtMSR = (TextView)findViewById(R.id.txtMSR);
        txtRMS = (TextView)findViewById(R.id.txtRMS);
        btnBotteT = (Button)findViewById(R.id.btnBotteT);
        btnMBT = (Button)findViewById(R.id.btnMBT);
        btnMSR = (Button)findViewById(R.id.btnMSR);
        btnRMS = (Button)findViewById(R.id.btnRMS);
        ecouteCalculBotteT();
        ecouteCalculKGT();
        ecouteCalculMSR();
        ecouteCalculRMS();
        //test();
        //tes();
    }
    private void ecouteCalculBotteT(){
        ((Button) findViewById(R.id.btnBotteT)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Integer coupe1 = 0;
                Integer coupe2 = 0;
                Integer coupe3 = 0;
                Integer coupe4 = 0;
                // récupération des données saisies
                try {
                    coupe1 = Integer.parseInt(nbCoupe1.getText().toString());
                    coupe2 = Integer.parseInt(nbCoupe2.getText().toString());
                    coupe3 = Integer.parseInt(nbCoupe3.getText().toString());
                    coupe4 = Integer.parseInt(nbCoupe4.getText().toString());
                }catch(Exception e){}
                afficheResult1(coupe1,coupe2, coupe3, coupe4);
            }
        });
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

    private void afficheResult1(Integer coupe1,Integer coupe2,Integer coupe3,Integer coupe4){
        p.resultat1(coupe1,coupe2, coupe3, coupe4);
        Integer botteT = p.getBotteT();
        txtTbotte.setText(String.valueOf(botteT));
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
   /* private void test(){
        p.setBotteT(1);

    }
    private void tes(){
        txtKGTotal.setText(String.valueOf(p.getBotteT()));
    }*/




}