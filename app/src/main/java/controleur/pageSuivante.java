package controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapplication.R;
import com.example.testapplication.page3;

import modele.Controleur;
import modele.Personne;

public class pageSuivante extends AppCompatActivity {
    //Variables
    private EditText txtNom;
    private RadioButton rdMonSexe;
    private Controleur monControleur;
    private EditText monAge;
    private TextView txtMonRes;
    private ImageView monImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_suivante);
        //On lance l'initialisation de la fenêtre
        initialisation();
        //On récupère l'instance du controleur
        this.monControleur = Controleur.getMonInstance();
    }
    //Méthodes
    private void initialisation() {
        //Récupère les objets de la fenêtre
        rdMonSexe = findViewById(R.id.id_RadioHomme);
        txtNom = findViewById(R.id.id_Name);
        monAge = findViewById(R.id.id_Age);
        txtMonRes = findViewById(R.id.id_TxtRes);
        monImage = findViewById(R.id.id_image);
        monImage.setVisibility(View.INVISIBLE);
        //On créé le listener sur le boutonclaudel
        ecouterBouton();
        Intent thisIntent = getIntent();
        txtMonRes.setText(thisIntent.getExtras().getString("param1"));
    }

    private void ecouterBouton() {
        //On récupère le bouton de la fenêtre
        Button bouton = findViewById(R.id.id_Valider);
        //On ajoute le listener au bouton puis la méthode anonyme sur le click du bouton
        bouton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View w) {
                clickBouton();
            }
        });
    }

    private void clickBouton() {
        String leNom = txtNom.getText().toString();
        int lage = Integer.parseInt(monAge.getText().toString());
        int sexe = 0;
        if (rdMonSexe.isChecked()) {
            sexe = 1;
        }
        affichage(sexe, leNom, lage);

    }



    public void affichage(int sexe, String nom, int age) {
        this.monControleur.creerPersonne(sexe, nom, age);
        txtMonRes.setText(monControleur.getMaPersonne().getStrMessage());
        monImage.setVisibility(View.VISIBLE);
        monImage.setImageResource(monControleur.getMaPersonne().getI_image());
    }

    public void click_ok(View v){
        String leNom = txtNom.getText().toString();
        int lage = Integer.parseInt(monAge.getText().toString());
        int sexe = 0;
        if (rdMonSexe.isChecked()) {
            sexe = 1;
        }
        this.monControleur.creerPersonne(sexe, leNom, lage);

        Intent intent2= new Intent(this, page3.class);
        startActivity(intent2);
    }
}
