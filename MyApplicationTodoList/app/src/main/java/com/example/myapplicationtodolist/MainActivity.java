package com.example.myapplicationtodolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAddTask;
    String msg_tache, msg_priority;
    TextView tw_titre;
    private static final int REQUEST_CODE_EXO_4 = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btAddTask = findViewById(R.id.Bt_Add);
        btAddTask.setOnClickListener(this);
        tw_titre = findViewById(R.id.Tv_titre);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Bt_Add:
                AddTache();
                break;
            case R.id.Bt_Clear:
                ClearListe();
                break;

            default:
                throw new RuntimeException("Bouton non implementé !");
        }
    }

    private void ClearListe() {
    }

    private void AddTache() {


        // Créer un intent pour l'activité
        Intent intent = new Intent(getApplicationContext(), MainActivityAjouterTache.class);

        // Démarre l'activté de l'exo 03 en attendant sa réponse
        //  -> Ne pas faire de fini de cette activité
        startActivityForResult(intent, REQUEST_CODE_EXO_4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case REQUEST_CODE_EXO_4:
                if(resultCode == RESULT_OK && data != null && data.hasExtra(MainActivityAjouterTache.EXTRA_FIRSTNAME) && data.hasExtra(MainActivityAjouterTache.EXTRA_PRIORITY)) {
                    msg_tache = data.getStringExtra(MainActivityAjouterTache.EXTRA_FIRSTNAME);
                    msg_priority = data.getStringExtra(MainActivityAjouterTache.EXTRA_PRIORITY);
                    tw_titre.setText(msg_tache + msg_priority);
                }

        }
    }
}
