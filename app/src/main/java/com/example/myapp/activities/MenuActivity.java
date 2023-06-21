package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.myapp.R;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        username = intent.getStringExtra("email");
        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        //setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_student_profile:
                Intent studentProfile = new Intent(this, ProfiliActivity.class);
                studentProfile.putExtra("userEmail",username);
                startActivity(studentProfile);
                break;

            case R.id.nav_afatet:
                Intent afatet = new Intent(this, AfateActivity.class);
                startActivity(afatet);
                break;

            case R.id.nav_kalendari:
                Intent kalendari = new Intent(this, CalendarActivity.class);
                startActivity(kalendari);
                break;

            case R.id.nav_mensa:
                Intent menzat = new Intent(this, MensaMapsActivity.class);
                startActivity(menzat);
                break;

            case R.id.nav_logout:
                Intent loginScreen = new Intent(this, LoginActivity.class);
                loginScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(loginScreen);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}