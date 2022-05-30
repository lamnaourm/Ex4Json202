package com.example.ex4json202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailEtudiant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_etudiant);

        Etudiant e = (Etudiant) getIntent().getExtras().get("et");
    }
}