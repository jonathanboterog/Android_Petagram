package com.ingenico.petagram;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.ingenico.petagram.adapter.PageAdapter;
import com.ingenico.petagram.fragment.ProfileFragment;
import com.ingenico.petagram.fragment.RecyclerViewFragment;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout lyStar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.incActionbarMain);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        lyStar = findViewById(R.id.lyStar);
        //registerForContextMenu(lyStar);

        SetUpViewPager();
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());

        return fragments;
    };

    public void SetUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_tab);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile_tab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_contact:
                Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content),
                        R.string.contact, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.action_about:
                Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content),
                        R.string.about, Snackbar.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void ClickStar(View view) {
        Intent intent = new Intent(this, PetHistorical.class);

//        Bundle args = new Bundle();
//        args.putSerializable(getString(R.string.ppets), pets);
//        intent.putExtra(getString(R.string.pbundle),args);

        startActivity(intent);
    }
}
