package com.ingenico.petagram.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ingenico.petagram.PetHistorical;
import com.ingenico.petagram.R;
import com.ingenico.petagram.adapter.PetAdapter;
import com.ingenico.petagram.pojo.Pet;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragment extends Fragment {

    static private ArrayList<Pet> pets;
    private RecyclerView contactList;
//    private RelativeLayout lyStar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v =  inflater.inflate(R.layout.fragment_recyclerview, container, false);
        contactList = v.findViewById(R.id.rcvContacts);

        //Define form to show recyclerView
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        contactList.setLayoutManager(llm);

        InitContactList();
        InitAdapter();

        return v;
    }

    public void InitAdapter(){
        PetAdapter adapter = new PetAdapter(pets, getActivity());
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

}
