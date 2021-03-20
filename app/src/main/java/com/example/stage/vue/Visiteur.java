package com.example.stage.vue;

import android.os.Bundle;

import com.example.stage.R;
import com.example.stage.controleur.PutData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Visiteur extends AppCompatActivity {

    private TextView VisiSurface, VisiTypeSol, VisiCulture, VisiTravailSol, VisiSemis, VisiCompost, VisiN, VisiP, VisiK, VisiS, VisiCA, VisiPhytos, VisiPhytos2, VisiIFT, VisiCoupe1, VisiCoupe2, VisiCoupe3, VisiCoupe4, VisiTBotte, VisiPoidsBotte, VisiKGTotal, VisiTauxMS, VisiMSR, VisiRMS;
    private Spinner spinnerNom, spinnerAnnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiteur);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        ecouteAffichage();

    }

    private void init() {
        VisiSurface = findViewById(R.id.VisiSurface);
        VisiTypeSol = findViewById(R.id.VisiTypeSol);
        VisiCulture = findViewById(R.id.VisiCulture);
        VisiTravailSol = findViewById(R.id.VisiTravailSol);
        VisiSemis = findViewById(R.id.VisiSemis);
        VisiCompost = findViewById(R.id.VisiCompost);
        VisiN = findViewById(R.id.VisiN);
        VisiP = findViewById(R.id.VisiP);
        VisiK = findViewById(R.id.VisiK);
        VisiS = findViewById(R.id.VisiS);
        VisiCA = findViewById(R.id.VisiCA);
        VisiPhytos = findViewById(R.id.VisiPhytos);
        VisiPhytos2 = findViewById(R.id.VisiPhytos2);
        VisiIFT = findViewById(R.id.VisiIFT);
        VisiCoupe1 = findViewById(R.id.VisiCoupe1);
        VisiCoupe2 = findViewById(R.id.VisiCoupe2);
        VisiCoupe3 = findViewById(R.id.VisiCoupe3);
        VisiCoupe4 = findViewById(R.id.VisiCoupe4);
        VisiTBotte = findViewById(R.id.VisiTBotte);
        VisiPoidsBotte = findViewById(R.id.VisiPoidsBotte);
        VisiKGTotal = findViewById(R.id.VisiKGTotal);
        VisiTauxMS = findViewById(R.id.VisiTauxMS);
        VisiMSR = findViewById(R.id.VisiMSR);
        VisiRMS = findViewById(R.id.VisiRMS);
        spinnerNom = findViewById(R.id.spinnerNom);
        spinnerAnnee = findViewById(R.id.spinnerAnnee);
    }

    private void ecouteAffichage(){


        ((Button) findViewById(R.id.btnVisiteur)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nom = SPNom();
                final String annee = SPAnnee();

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {//Démarrer l'écriture et la lecture des données avec l'URL

                        String[] field = new String[2];//Création d'un tableau pour les paramètres
                        field[0] = "annee";
                        field[1] = "nom";


                        String[] data = new String[2];//Création d un tableau pour les données
                        data[0] = annee;
                        data[1] = nom;


                        PutData putData = new PutData("http://sc1chfl1498.universe.wf/Equ26K7z/LesAges/visiteur.php", "POST", field, data);

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
                                        VisiSurface.setText(surface);
                                        VisiTypeSol.setText(typeSol);
                                        VisiCulture.setText(culture);
                                        VisiTravailSol.setText(travailSol);
                                        VisiSemis.setText(Semis);
                                        VisiCompost.setText(compost);
                                        VisiN.setText(N);
                                        VisiP.setText(P);
                                        VisiK.setText(K);
                                        VisiS.setText(S);
                                        VisiCA.setText(CA);
                                        VisiPhytos.setText(phytos);
                                        VisiPhytos2.setText(phytos2);
                                        VisiIFT.setText(IFT);
                                        VisiCoupe1.setText(coupe1);
                                        VisiCoupe2.setText(coupe2);
                                        VisiCoupe3.setText(coupe3);
                                        VisiCoupe4.setText(coupe4);
                                        VisiTBotte.setText(botteT);
                                        VisiPoidsBotte.setText(poidsBotte);
                                        VisiKGTotal.setText(kgTotal);
                                        VisiTauxMS.setText(tauxMS);
                                        VisiMSR.setText(MSR);
                                        VisiRMS.setText(RMS);


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

    private String SPAnnee() {

        String annee="";
        if (spinnerAnnee.getSelectedItem().toString().equals("2021"))      annee = "2021";
        if (spinnerAnnee.getSelectedItem().toString().equals("2022"))      annee = "2022";
        if (spinnerAnnee.getSelectedItem().toString().equals("2023"))      annee = "2023";
        if (spinnerAnnee.getSelectedItem().toString().equals("2024"))      annee = "2024";
        if (spinnerAnnee.getSelectedItem().toString().equals("2025"))      annee = "2025";
        if (spinnerAnnee.getSelectedItem().toString().equals("2026"))      annee = "2026";
        if (spinnerAnnee.getSelectedItem().toString().equals("2027"))      annee = "2027";
        if (spinnerAnnee.getSelectedItem().toString().equals("2028"))      annee = "2028";
        if (spinnerAnnee.getSelectedItem().toString().equals("2029"))      annee = "2029";
        if (spinnerAnnee.getSelectedItem().toString().equals("2030"))      annee = "2030";


        return annee;//renvoie l'annee sélectionner dans le spinner

    }

    private String SPNom() {

        String nom="";
        if (spinnerNom.getSelectedItem().toString().equals("La Talle"))         nom = "La Talle";
        if (spinnerNom.getSelectedItem().toString().equals("Les Classes"))      nom = "Les Classes";
        if (spinnerNom.getSelectedItem().toString().equals("Le Triangle"))      nom = "Le Triangle";
        if (spinnerNom.getSelectedItem().toString().equals("Le Hangar"))        nom = "Le Hangar";
        if (spinnerNom.getSelectedItem().toString().equals("Fish Brenne"))      nom = "Fish Brenne";
        if (spinnerNom.getSelectedItem().toString().equals("Vieille Fétuque"))  nom = "Vieille Fetuque";
        if (spinnerNom.getSelectedItem().toString().equals("Le Rocher"))        nom = "Le Rocher";
        if (spinnerNom.getSelectedItem().toString().equals("Petit Bassin"))     nom = "Petit Bassin";
        if (spinnerNom.getSelectedItem().toString().equals("Aérodrome"))        nom = "Aerodrome";
        if (spinnerNom.getSelectedItem().toString().equals("Lacombe"))          nom = "Lacombe";


        return nom;//renvoie le nom sélectionner dans le spinner

    }


}