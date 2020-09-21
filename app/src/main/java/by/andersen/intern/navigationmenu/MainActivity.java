package by.andersen.intern.navigationmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //делает  кликбл  группы, в которых есть  итемы
        navigationView.bringToFront();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_additional, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Toast.makeText(this, "Settins clicked", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onOptionsItemSelected: settings clicked");

        } else if (item.getItemId() == R.id.help) {
            Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onOptionsItemSelected: help clicked");

        } else {
            return super.onOptionsItemSelected(item);

        }
        return true;

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_inbox:
                Toast.makeText(this, R.string.inbox, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: inbox clicked");
                break;

            case R.id.nav_outbox:
                Toast.makeText(this, R.string.outbox, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: outbox clicked");
                break;

            case R.id.nav_trash:
                Toast.makeText(this, R.string.trash, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: trash clicked");
                break;

            case R.id.nav_spam:
                Toast.makeText(this, R.string.spam, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: spam clicked");
                break;

            case R.id.nav_profile:
                Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: profile clicked");
                break;

            case R.id.nav_logout:
                Toast.makeText(this, R.string.logout, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: logout clicked");
                break;

            case R.id.nav_share:
                Toast.makeText(this, R.string.share, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: share clicked");
                break;

            case R.id.nav_rate_us:
                Toast.makeText(this, R.string.rate, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: rate clicked");
                break;

            case R.id.nav_about_us:
                Toast.makeText(this, R.string.about_us, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onNavigationItemSelected: about_us clicked");
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}