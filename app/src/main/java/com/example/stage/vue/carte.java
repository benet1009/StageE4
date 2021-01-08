package com.example.stage.vue;

import android.content.Intent;
import android.os.Bundle;

import com.example.stage.MainActivity;
import com.example.stage.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class carte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        ecouteAccueil((Button)findViewById(R.id.btnLaTalle), TabLaTalle.class);
        ecouteAccueil((Button)findViewById(R.id.btnLesClasses), MainActivity.class);

    }
    private void ecouteAccueil(Button btn, final Class classe){
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(carte.this, classe);
                startActivity(intent);
            }
        });

    }
}