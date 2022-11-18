package com.example.appmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle Toggle;
    private NavigationView nav;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        drawer = findViewById(R.id.drawerlayout);
        nav=findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);





            Toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(Toggle);
        Toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (Toggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Home()).commit();
                break;
            case R.id.service:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new service()).commit();
                break;
            case R.id.team:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Team()).commit();
                break;
            case R.id.set:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Settings()).commit();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;


       }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);

    }
    super.onBackPressed();
}}