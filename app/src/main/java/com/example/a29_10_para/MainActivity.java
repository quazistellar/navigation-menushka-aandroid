package com.example.a29_10_para;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
        setFragment(new First());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.f1) {
                setFragment(new First());
                return true;
            } else if (itemId == R.id.f2) {
                setFragment(new SecondFragment());
                return true;
            } else if (itemId == R.id.f3) {
                setFragment(new Third());
                return true;
            }
            return false;
        });


        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_item1) {
                setFragment(new First());
                Toast.makeText(MainActivity.this, "First fragment", Toast.LENGTH_SHORT).show();
                return true;

            } else if (itemId == R.id.nav_item2) {
                setFragment(new SecondFragment());
                Toast.makeText(MainActivity.this, "Second fragment", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.nav_item3) {
                setFragment(new Third());
                Toast.makeText(MainActivity.this, "Third fragment", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings chosen", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.frag_first) {
            setFragment(new First());
            return true;
        } else if (id == R.id.frag_two) {
            setFragment(new SecondFragment());
            return true;
        } else if (id == R.id.frag_thrid) {
            setFragment(new Third());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.selectedMenu, fragment, null).commit();
    }
}
