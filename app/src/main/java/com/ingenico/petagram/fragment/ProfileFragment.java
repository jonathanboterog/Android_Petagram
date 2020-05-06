package com.ingenico.petagram.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingenico.petagram.R;
import com.ingenico.petagram.adapter.PetAdapter;
import com.ingenico.petagram.adapter.PetProfileAdapter;
import com.ingenico.petagram.pojo.Pet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    static private ArrayList<Pet> pets;
    private RecyclerView contactList;
    //    private RelativeLayout lyStar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);
        contactList = v.findViewById(R.id.rcvProfile);

        //Define form to show recyclerView
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(RecyclerView.VERTICAL);
        contactList.setLayoutManager(glm);

        InitContactList();
        InitAdapter();

        return v;
    }

    public void InitAdapter(){
        PetProfileAdapter adapter = new PetProfileAdapter(pets, getActivity());
        contactList.setAdapter(adapter);
    }

    public void InitContactList(){
        pets = new ArrayList<>();

        pets.add(new Pet(5, R.drawable.cateyes));
        pets.add(new Pet(0, R.drawable.cateyes));
        pets.add(new Pet(3, R.drawable.cateyes));
        pets.add(new Pet(10, R.drawable.cateyes));
        pets.add(new Pet(2, R.drawable.cateyes));
        pets.add(new Pet(3, R.drawable.cateyes));
        pets.add(new Pet(6, R.drawable.cateyes));
        pets.add(new Pet(13, R.drawable.cateyes));
        pets.add(new Pet(4, R.drawable.cateyes));
    }
}
