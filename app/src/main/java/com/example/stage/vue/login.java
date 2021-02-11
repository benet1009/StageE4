package com.example.stage.vue;

import android.content.Intent;
import android.os.Bundle;
import com.example.stage.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
                String nom, mdp;
                //recupere les valeurs ecrite sur l application
                nom = String.valueOf(txtNom.getText());
                mdp = String.valueOf(txtMdp.getText());

                if (nom.equals("LESAGES") && mdp.equals("dac36")) {
                    Toast.makeText(getApplicationContext(), "Authentification réussi", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, carte.class);
                    startActivity(intent);
                }
                else if (nom.equals("LESAGESPARCELLE") && mdp.equals("@ges")){
                    Toast.makeText(getApplicationContext(), "Authentification réussi", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, Visiteur.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "échec", Toast.LENGTH_SHORT).show();
                }
            }
    });
}
}



