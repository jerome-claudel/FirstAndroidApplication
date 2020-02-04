package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import modele.Controleur;

public class page3 extends AppCompatActivity {
    private TextView txtMonRes2;
    private ImageView monImage2;
    private Controleur monControleur2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        this.monControleur2 = Controleur.getMonInstance();
        txtMonRes2 = findViewById(R.id.id_Texte2);
       monImage2 = findViewById(R.id.id_Image2);
        txtMonRes2.setText(monControleur2.getMaPersonne().getStrMessage());

       monImage2.setImageResource(monControleur2.getMaPersonne().getI_image());
        Toast.makeText(getBaseContext(), "Bienvenue",Toast.LENGTH_SHORT).show();
    }
}
