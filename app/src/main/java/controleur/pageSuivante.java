package controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapplication.R;
import com.example.testapplication.page3;

import modele.Controleur;

public class pageSuivante extends AppCompatActivity {
    //Variables
    private EditText txtNom;
    private RadioButton rdMonSexe;
    private Controleur monControleur;
    private EditText monAge;
    private TextView txtMonRes;
    private ImageView monImage;
    private String erreurMessage;
    private String str_Nom;
    private String str_Age;
    private int i_Age;
    private int i_Sexe;

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
        recupereValeurs();
        affichage(i_Sexe, str_Nom, i_Age);
    }
    public void affichage(int sexe, String nom, int age) {
            this.monControleur.creerPersonne(sexe, nom, age);
            if(!this.monControleur.getErreurMessage().equals("")){
                Toast.makeText(getBaseContext(),monControleur.getErreurMessage(),Toast.LENGTH_SHORT).show();
                monImage.setVisibility(View.INVISIBLE);
                txtMonRes.setText("");
            }else{
                txtMonRes.setText(monControleur.getMaPersonne().getStrMessage());
                monImage.setVisibility(View.VISIBLE);
                monImage.setImageResource(monControleur.getMaPersonne().getI_image());
            }
    }

    public void click_ok(View v) {
        recupereValeurs();
        this.monControleur.creerPersonne(i_Sexe, str_Nom, i_Age);
        if(!this.monControleur.getErreurMessage().equals("")){
            Toast.makeText(getBaseContext(),monControleur.getErreurMessage(),Toast.LENGTH_SHORT).show();
        }else{
            Intent intent2 = new Intent(this, page3.class);
            startActivity(intent2);
        }
    }

    private void recupereValeurs(){
        this.monControleur.setErreurMessage("");
        str_Nom = txtNom.getText().toString();
        str_Age = monAge.getText().toString();
        try {
            i_Age = Integer.parseInt(str_Age);
        } catch (Exception e) {
                i_Age = 0;
        }
        i_Sexe = 0;
        if (rdMonSexe.isChecked()) {
            i_Sexe = 1;
        }
    }
}
