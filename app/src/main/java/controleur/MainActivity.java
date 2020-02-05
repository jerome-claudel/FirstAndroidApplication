package controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapplication.R;

public class MainActivity extends AppCompatActivity {

    private String[] tableau = {"ItemA", "ItemC", "ItemD", "ItemE", "ItemF"};
    private Spinner spinner;
    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, tableau);
        spinner.setAdapter(adapter);
        textview = findViewById(R.id.id_Texte);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cliqueCombo(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void cliqueCombo(View w) {
        textview.setText(spinner.getSelectedItem().toString());
    }

    public void clique_Bouton2(View w) {
        Intent intent = new Intent(this, pageSuivante.class);
        String value1 = spinner.getSelectedItem().toString();
        intent.putExtra("param1", value1);
        startActivity(intent);
    }
}
