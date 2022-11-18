package com.example.appmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.security.Provider;
import java.util.Objects;

public class Drawer extends AppCompatActivity  {
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawer = findViewById(R.id.drawer);
        nav = findViewById(R.id.nav);

        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment, new Home()).commit();
            nav.setCheckedItem(R.id.home);
        }

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment, new Home()).commit();
                        break;
                    case R.id.students:
                        getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment, new service()).commit();
                        break;
                    case R.id.team:
                        getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment, new Team()).commit();
                        break;
                    case R.id.contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment, new contact()).commit();
                        break;
                    case R.id.sett:
                        getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment, new Settings()).commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }

    }