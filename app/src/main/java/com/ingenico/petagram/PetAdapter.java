package com.ingenico.petagram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ContactViewHolder> {

    private ArrayList<Pet> pets;
    private Activity activity;

    //Construye lista de contactos
    public PetAdapter(ArrayList<Pet> pets, Activity activity){
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //da vida al layout. Inflar el layout y lo pasara a viewholder para que el obtenga los views.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactViewHolder contactViewHolder, int position) {
        //Donde se pasa lista de contactos. Asocia cada elemento de nuestra lista a cada view.
        final Pet pet = pets.get(position);
        contactViewHolder.imgContactPhoto.setImageResource(pet.getPhoto());
        contactViewHolder.tvName.setText(pet.getName());
        contactViewHolder.tvRating.setText(String.valueOf(pet.getRating()));

        contactViewHolder.imgContactPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contact.getName(), Toast.LENGTH_SHORT).show();
//                Snackbar.make(v, pet.getName(), Snackbar.LENGTH_SHORT).show();
//                Intent intent = new Intent(activity, PetHistorical.class);
//                intent.putExtra(activity.getResources().getString(R.string.pname), pet.getName());
//                intent.putExtra(activity.getResources().getString(R.string.prating), pet.getRating());
//                intent.putExtra(activity.getResources().getString(R.string.pimage), pet.getPhoto());
//                activity.startActivity(intent);
            }
        });

        contactViewHolder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pet.setRating(pet.getRating() + 1);
                contactViewHolder.tvRating.setText(String.valueOf(pet.getRating()));
            }
        });
    }

    @Override
    public int getItemCount() {
        //retorna cantidad de elementos de nuestra lista
        return pets.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        //Will be defined all views of card-view layout
        private ImageView imgContactPhoto;
        private TextView tvName;
        private TextView tvRating;
        private ImageView imgLike;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            imgContactPhoto = itemView.findViewById(R.id.imgContactPhoto);
            tvName = itemView.findViewById(R.id.tvName);
            tvRating = itemView.findViewById(R.id.tvRating);
            imgLike = itemView.findViewById(R.id.imgLike);
        }
    }
}
