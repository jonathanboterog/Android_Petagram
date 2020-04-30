package com.ingenico.petagram;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static private ArrayList<Pet> pets;
    private RecyclerView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.incActionbar);
        setSupportActionBar(toolbar);

        contactList = findViewById(R.id.rcvContacts);

        //Define form to show recyclerView
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        contactList.setLayoutManager(llm);

/*
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        contactList.setLayoutManager(glm);
*/
/*
        StaggeredGridLayoutManager sgl = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        contactList.setLayoutManager(sgl);
*/
        InitContactList();
        InitAdapter();
    }

    public void InitAdapter(){
        PetAdapter adapter = new PetAdapter(pets, this);
        contactList.setAdapter(adapter);
    }

    public void InitContactList(){
        pets = new ArrayList<>();

        pets.add(new Pet("Eyes", 0, R.drawable.cateyes));
        pets.add(new Pet("Fight", 0, R.drawable.catfight));
        pets.add(new Pet("Moustache", 0, R.drawable.catmoustache));
        pets.add(new Pet("Grumpy", 0, R.drawable.catgrumpy));
        pets.add(new Pet("Tied", 0, R.drawable.cattied));
    }

    public void ClickStar(View view) {
        Intent intent = new Intent(this, PetHistorical.class);

        Bundle args = new Bundle();
        args.putSerializable(getString(R.string.ppets), pets);
        intent.putExtra(getString(R.string.pbundle),args);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }
}
