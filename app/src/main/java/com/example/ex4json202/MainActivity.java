package com.example.ex4json202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ls;
    ArrayList<Etudiant> etds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etds = getAllEtudaints();
        ArrayList<String> noms = new ArrayList<>();
        ls = findViewById(R.id.lst);

        for(Etudiant e : etds)
            noms.add(e.getIdent() + " - " + e.getNom());

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,noms);
        ls.setAdapter(ad);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(MainActivity.this, DetailEtudiant.class);
                in.putExtra("et",etds.get(i));
                startActivity(in);
            }
        });

    }

    public String LoadJsonFromRaw(int resId){
        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<Etudiant> getAllEtudaints(){
        try {
            ArrayList<Etudiant> ets = new ArrayList<>();
            JSONArray arr = new JSONArray(LoadJsonFromRaw(R.raw.resultats));

            for(int i=0;i<arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);

                Etudiant e = new Etudiant();
                e.setIdent(obj.getString("ident"));
                e.setNom(obj.getString("nom"));
                e.setDateNaissance(obj.getString("naissance"));
                e.setVille(obj.getString("ville"));
                e.setNoteFR(obj.getJSONObject("resultat").getDouble("fr"));
                e.setNoteHist(obj.getJSONObject("resultat").getDouble("hist"));
                e.setNotePhys(obj.getJSONObject("resultat").getDouble("phys"));
                e.setNoteMath(obj.getJSONObject("resultat").getDouble("math"));

                ets.add(e);
            }

            return ets;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}