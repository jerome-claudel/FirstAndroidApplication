package controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testapplication.R;

public class MainActivity extends AppCompatActivity {

    private String[] tableau = {"ItemA","ItemC","ItemD","ItemE","ItemF"};
    private Spinner spinner;
    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, tableau);
        spinner.setAdapter(adapter);
        textview = findViewById(R.id.id_Texte);
    }

    public void cliqueCombo(View w){
        textview.setText(spinner.getSelectedItem().toString());
    }

    public void clique_Bouton2(View w){
        Intent intent= new Intent(this,pageSuivante.class);
        intent.putExtra("param1",585);
        startActivity(intent);
    }
}
