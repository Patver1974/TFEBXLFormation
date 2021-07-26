package com.example.myapplicationtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAjouterTache extends AppCompatActivity {
    public static final String EXTRA_FIRSTNAME = "name";
    public static final String EXTRA_PRIORITY = "priority";
EditText ed_tache; EditText ed_priority;
Button btValider;
Spinner sp_priority;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ajouter_tache);
        sp_priority = findViewById(R.id.sp_Priority);
        ed_tache= findViewById(R.id.Ed_New_tache);


        btValider = findViewById(R.id.Bt_Valider);
         String msg_tache, msg_priority;
        // Définition du Spinner

        List<String> categoryChoices = new ArrayList<>();
        categoryChoices.add(getString(R.string.choice_priority_high));
        categoryChoices.add(getString(R.string.choice_priority_bas));
        categoryChoices.add(getString(R.string.choice_priority_moy));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                categoryChoices
        );

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_priority.setAdapter(spinnerAdapter);

        btValider.setOnClickListener(v -> {
String msg1 = sp_priority.getSelectedItem().toString();
            // -> Cette intent sert de "stockage" de donnée pour accompagner le resultat
            Intent intentData = new Intent();
            intentData.putExtra(EXTRA_FIRSTNAME, ed_tache.getText().toString().trim());
            intentData.putExtra(EXTRA_PRIORITY, msg1);

            setResult(RESULT_OK, intentData);


            finish();
        });


    }
}