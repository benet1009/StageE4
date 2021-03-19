package com.example.stage.vue;

import android.os.Bundle;
import com.example.stage.R;
import com.example.stage.controleur.PutData;
import com.example.stage.modele.Parcelle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
public class FishBrenne extends AppCompatActivity {

    private Spinner spCulture, spAnnee, SPAnnee;
    private EditText NbSurface, txtTypeSol, txtTravailSol, txtSemis, txtCompost, nbtxtN, nbtxtP, nbtxtK, nbtxtS, nbtxtCA, txtPhytos, txtPhytos2, nbIFT, nbCoupe1, nbCoupe2, nbCoupe3, nbCoupe4, nbPoidsBotte, nbTauxMS;
    private TextView txtTbotte, txtKGTotal, txtMSR, txtRMS, affSurface, affTypeSol, affCulture, affTravailSol, affSemis, affCompost, affN, affP, affK, affS, affCA, affPhytos, affPhytos2, affIFT, affCoupe1, affCoupe2, affCoupe3, affCoupe4, affTBotte, affPoidsBotte, affKGTotal, affTauxMS, affMSR, affRMS;
    Parcelle p = new Parcelle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_brenne);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

    }

    private void init(){
        NbSurface = findViewById(R.id.NbSurface);
        txtTypeSol = findViewById(R.id.txtTypeSol);
        spCulture =  findViewById(R.id.spCulture);
        spAnnee =  findViewById(R.id.spAnnee);
        SPAnnee =  findViewById(R.id.SPAnnee);
        txtTravailSol = findViewById(R.id.txtTravailSol);
        txtSemis = findViewById(R.id.txtSemis);
        txtCompost = findViewById(R.id.txtCompost);
        nbtxtN = findViewById(R.id.nbtxtN);
        nbtxtP = findViewById(R.id.nbtxtP);
        nbtxtK = findViewById(R.id.nbtxtK);
        nbtxtS = findViewById(R.id.nbtxtS);
        nbtxtCA = findViewById(R.id.nbtxtCA);
        txtPhytos = findViewById(R.id.txtPhytos);
        txtPhytos2 = findViewById(R.id.txtPhytos2);
        nbIFT = findViewById(R.id.nbIFT);
        nbCoupe1 = findViewById(R.id.nbCoupe1);
        nbCoupe2 = findViewById(R.id.nbCoupe2);
        nbCoupe3 = findViewById(R.id.nbCoupe3);
        nbCoupe4 = findViewById(R.id.nbCoupe4);
        txtTbotte = findViewById(R.id.txtTbotte);
        nbPoidsBotte = findViewById(R.id.nbPoidsBotte);
        txtKGTotal = findViewById(R.id.txtKGTotal);
        nbTauxMS = findViewById(R.id.nbTauxMS);
        txtMSR = findViewById(R.id.txtMSR);
        txtRMS = findViewById(R.id.txtRMS);
        affSurface = findViewById(R.id.affSurface);
        affTypeSol = findViewById(R.id.affTypeSol);
        affCulture = findViewById(R.id.affCulture);
        affTravailSol= findViewById(R.id.affTravailSol);
        affSemis= findViewById(R.id.affSemis);
        affCompost= findViewById(R.id.affCompost);
        affN= findViewById(R.id.affN);
        affP= findViewById(R.id.affP);
        affK= findViewById(R.id.affK);
        affS= findViewById(R.id.affS);
        affCA= findViewById(R.id.affCA);
        affPhytos= findViewById(R.id.affPhytos);
        affPhytos2= findViewById(R.id.affPhytos2);
        affIFT= findViewById(R.id.affIFT);
        affCoupe1= findViewById(R.id.affCoupe1);
        affCoupe2= findViewById(R.id.affCoupe2);
        affCoupe3= findViewById(R.id.affCoupe3);
        affCoupe4= findViewById(R.id.affCoupe4);
        affTBotte= findViewById(R.id.affTBotte);
        affPoidsBotte= findViewById(R.id.affPoidsBotte);
        affKGTotal= findViewById(R.id.affKGTotal);
        affTauxMS= findViewById(R.id.affTauxMS);
        affMSR= findViewById(R.id.affMSR);
        affRMS= findViewById(R.id.affRMS);


        ecouteCalculBotteT();
        ecouteCalculKGT();
        ecouteCalculMSR();
        ecouteCalculRMS();
        ecouteEnvoi();
        ecouteAffichage();
    }

    private void ecouteAffichage(){


        ((Button) findViewById(R.id.btnAffichage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String annee = SPAnnee(SPAnnee);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {//Démarrer l'écriture et la lecture des données avec l'URL

                            String[] field = new String[1];//Création d'un tableau pour les paramètres
                            field[0] = "annee";

                            String[] data = new String[1];//Création d un tableau pour les données
                            data[0] = annee;
                            PutData putData = new PutData("http://sc1chfl1498.universe.wf/Equ26K7z/LesAges/FishBrenne.php", "POST", field, data);

                            if (putData.startPut()) {//envoie de l année pour la requete

                                if (putData.onComplete()) {//si toute les donnée sont acquise

                                    String result = putData.getResult();//recupere le resultat cad le echo du php donc toute les données
                                    try {
                                        JSONArray array = new JSONArray(result);//Met les donées dans un tableau
                                        for (int i = 0; i<array.length(); i++){//Va jusqu a la derniere donnée de la bdd
                                            JSONObject object = array.getJSONObject(i);

                                            //prend la valeur qui lui correspond par rapport a la bdd
                                            String surface = object.getString("surface");
                                            String typeSol = object.getString("typeSol");
                                            String culture = object.getString("culture");
                                            String travailSol = object.getString("travailSol");
                                            String Semis = object.getString("Semis");
                                            String compost = object.getString("compost");
                                            String N = object.getString("N");
                                            String P = object.getString("P");
                                            String K = object.getString("K");
                                            String S = object.getString("S");
                                            String CA = object.getString("CA");
                                            String phytos = object.getString("phytos");
                                            String phytos2 = object.getString("phytos2");
                                            String IFT = object.getString("IFT");
                                            String coupe1 = object.getString("coupe1");
                                            String coupe2 = object.getString("coupe2");
                                            String coupe3 = object.getString("coupe3");
                                            String coupe4 = object.getString("coupe4");
                                            String botteT = object.getString("botteT");
                                            String poidsBotte = object.getString("poidsBotte");
                                            String kgTotal = object.getString("kgTotal");
                                            String tauxMS = object.getString("tauxMS");
                                            String MSR = object.getString("MSR");
                                            String RMS = object.getString("RMS");

                                            //affichage des données dans la derniere colonne
                                            affSurface.setText(surface);
                                            affTypeSol.setText(typeSol);
                                            affCulture.setText(culture);
                                            affTravailSol.setText(travailSol);
                                            affSemis.setText(Semis);
                                            affCompost.setText(compost);
                                            affN.setText(N);
                                            affP.setText(P);
                                            affK.setText(K);
                                            affS.setText(S);
                                            affCA.setText(CA);
                                            affPhytos.setText(phytos);
                                            affPhytos2.setText(phytos2);
                                            affIFT.setText(IFT);
                                            affCoupe1.setText(coupe1);
                                            affCoupe2.setText(coupe2);
                                            affCoupe3.setText(coupe3);
                                            affCoupe4.setText(coupe4);
                                            affTBotte.setText(botteT);
                                            affPoidsBotte.setText(poidsBotte);
                                            affKGTotal.setText(kgTotal);
                                            affTauxMS.setText(tauxMS);
                                            affMSR.setText(MSR);
                                            affRMS.setText(RMS);


                                        }
                                    }catch (Exception e){
                                        Toast.makeText(getApplicationContext(), "échec de la réception des données", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "échec", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });

            }
        });
    }

    private void ecouteEnvoi(){
        ((Button) findViewById(R.id.btnEnvoie)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                final String surface, botteT, typeSol, travailSol, Semis, N, P, K, S, CA, compost, phytos, phytos2, IFT, coupe1, coupe2, coupe3, coupe4, poidsBotte, kgTotal, tauxMS, MSR, RMS;
                final String annee = SPAnnee(spAnnee);
                final String culture =  SPCulture();
                final String nom = "Fish Brenne";

                //prend la valeur qui a ete ecrite dans l application
                surface = String.valueOf(NbSurface.getText());
                botteT = String.valueOf(txtTbotte.getText());
                typeSol = String.valueOf(txtTypeSol.getText());
                travailSol = String.valueOf(txtTravailSol.getText());
                Semis = String.valueOf(txtSemis.getText());
                compost = String.valueOf(txtCompost.getText());
                N = String.valueOf(nbtxtN.getText());
                P = String.valueOf(nbtxtP.getText());
                K = String.valueOf(nbtxtK.getText());
                S = String.valueOf(nbtxtS.getText());
                CA = String.valueOf(nbtxtCA.getText());
                phytos = String.valueOf(txtPhytos.getText());
                phytos2 = String.valueOf(txtPhytos2.getText());
                IFT = String.valueOf(nbIFT.getText());
                coupe1 = String.valueOf(nbCoupe1.getText());
                coupe2 = String.valueOf(nbCoupe2.getText());
                coupe3 = String.valueOf(nbCoupe3.getText());
                coupe4 = String.valueOf(nbCoupe4.getText());
                poidsBotte = String.valueOf(nbPoidsBotte.getText());
                kgTotal = String.valueOf(txtKGTotal.getText());
                tauxMS = String.valueOf(nbTauxMS.getText());
                MSR = String.valueOf(txtMSR.getText());
                RMS = String.valueOf(txtRMS.getText());


                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {//Démarrer l'écriture et la lecture des données avec l'URL

                            String[] field = new String[26];//Création d'un tableau pour les paramètres
                            field[0] = "surface";
                            field[1] = "botteT";
                            field[2] = "culture";
                            field[3] = "nom";
                            field[4] = "annee";
                            field[5] = "typeSol";
                            field[6] = "travailSol";
                            field[7] = "Semis";
                            field[8] = "compost";
                            field[9] = "N";
                            field[10] = "P";
                            field[11] = "K";
                            field[12] = "S";
                            field[13] = "CA";
                            field[14] = "phytos";
                            field[15] = "phytos2";
                            field[16] = "IFT";
                            field[17] = "coupe1";
                            field[18] = "coupe2";
                            field[19] = "coupe3";
                            field[20] = "coupe4";
                            field[21] = "poidsBotte";
                            field[22] = "kgTotal";
                            field[23] = "tauxMS";
                            field[24] = "MSR";
                            field[25] = "RMS";

                            String[] data = new String[26];//Création d un tableau pour les données
                            data[0] = surface;
                            data[1] = botteT;
                            data[2] = culture;
                            data[3] = nom;
                            data[4] = annee;
                            data[5] = typeSol;
                            data[6] = travailSol;
                            data[7] = Semis;
                            data[8] = compost;
                            data[9] = N;
                            data[10] = P;
                            data[11] = K;
                            data[12] = S;
                            data[13] = CA;
                            data[14] = phytos;
                            data[15] = phytos2;
                            data[16] = IFT;
                            data[17] = coupe1;
                            data[18] = coupe2;
                            data[19] = coupe3;
                            data[20] = coupe4;
                            data[21] = poidsBotte;
                            data[22] = kgTotal;
                            data[23] = tauxMS;
                            data[24] = MSR;
                            data[25] = RMS;

                            PutData putData = new PutData("http://sc1chfl1498.universe.wf/Equ26K7z/LesAges/envoieBrenne.php", "POST", field, data);
                            if (putData.startPut()) {//envoie de toute les données
                                if (putData.onComplete()) {//si toute les donnée sont acquise
                                    String result = putData.getResult();//recupere le resultat cad le echo du php
                                    if(result.equals("Envoi reussi")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });

            }

        });
    }


    private String SPAnnee(Spinner spinner) {

        String annee="";
        if (spinner.getSelectedItem().toString().equals("2021"))      annee = "2021";
        if (spinner.getSelectedItem().toString().equals("2022"))      annee = "2022";
        if (spinner.getSelectedItem().toString().equals("2023"))      annee = "2023";
        if (spinner.getSelectedItem().toString().equals("2024"))      annee = "2024";
        if (spinner.getSelectedItem().toString().equals("2025"))      annee = "2025";
        if (spinner.getSelectedItem().toString().equals("2026"))      annee = "2026";
        if (spinner.getSelectedItem().toString().equals("2027"))      annee = "2027";
        if (spinner.getSelectedItem().toString().equals("2028"))      annee = "2028";
        if (spinner.getSelectedItem().toString().equals("2029"))      annee = "2029";
        if (spinner.getSelectedItem().toString().equals("2030"))      annee = "2030";


        return annee;//renvoie l'annee sélectionner dans le spinner

    }

    private String SPCulture(){
        String culture="";
        if (spCulture.getSelectedItem().toString().equals("Luzerne"))        culture = "Luzerne";
        if (spCulture.getSelectedItem().toString().equals("Trèfle violet"))  culture = "Trèfle violet";
        if (spCulture.getSelectedItem().toString().equals("RGI"))            culture = "RGI";
        if (spCulture.getSelectedItem().toString().equals("Fétuque"))        culture = "Fétuque";
        if (spCulture.getSelectedItem().toString().equals("Autre prairie"))  culture = "Autre prairie";
        if (spCulture.getSelectedItem().toString().equals("Autre culture"))	 culture = "Autre culture";
        if (spCulture.getSelectedItem().toString().equals("Jachère"))        culture = "Jachère";

        return culture;//renvoie la culture sélectionner dans le spinner
    }


    private void ecouteCalculBotteT(){
        ((Button) findViewById(R.id.btnBotteT)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Integer coupe1 = 0;
                Integer coupe2 = 0;
                Integer coupe3 = 0;
                Integer coupe4 = 0;

                try {// récupération des données saisies
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

                try {// récupération des données saisies
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

                try {// récupération des données saisies
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

                try {// récupération des données saisies
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
}