package com.ingenico.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class PetHistorical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pet_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.incActionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra(getString(R.string.pbundle));
        ArrayList<Pet> pets = (ArrayList<Pet>)  args.getSerializable(getString(R.string.ppets));
    }
}
