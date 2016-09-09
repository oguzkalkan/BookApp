package com.asktroapp.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.asktroapp.myapplication.Fragments.AddBookDialogFragment;
import com.asktroapp.myapplication.Fragments.BooksFragment;
import com.asktroapp.myapplication.Fragments.FriendsFragment;
import com.asktroapp.myapplication.Fragments.HomepageFragment;
import com.asktroapp.myapplication.Fragments.NotificationsFragment;
import com.asktroapp.myapplication.Fragments.ProfileFragment;
import com.asktroapp.myapplication.Fragments.RecAddedBooksDialogFragment;
import com.asktroapp.myapplication.Fragments.SearchFragment;
import com.asktroapp.myapplication.Fragments.SettingsFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
        {
            private static String TAG = MainActivity.class.getSimpleName();

            private FirebaseAuth auth;
    Button btn1;
    Fragment fr;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();

      //  Fragment home = new HomepageFragment();
      // fm.beginTransaction().replace(R.id.flContent, home).commit();

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       SearchView search = (SearchView) findViewById(R.id.search_view);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        auth = FirebaseAuth.getInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddBookDialogFragment dialogFragment = new AddBookDialogFragment();
                dialogFragment.show(fm,"AddBook");

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);

            invalidateOptionsMenu();
        }

            @Override
            public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            Log.d(TAG, "onDrawerClosed: " + getTitle());

            invalidateOptionsMenu();
        }
        };

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


            @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /*
      @Override
      public boolean onOptionsItemSelected(MenuItem item) {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          int id = item.getItemId();

          //noinspection SimplifiableIfStatement
          if (id == R.id.action_settings) {
              return true;
          }

          return super.onOptionsItemSelected(item);
      }
  */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        item.setChecked(true);
       FragmentManager fm = getSupportFragmentManager();

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_homepage:
                HomepageFragment fr1 = new HomepageFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, fr1);
                fragmentTransaction.addToBackStack("addHome");
                fragmentTransaction.commit();
                break;

            case R.id.nav_profile:
                fr = new ProfileFragment();
                fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, fr);
                fragmentTransaction.addToBackStack("addProfile");
                fragmentTransaction.commit();
                break;

            case R.id.nav_books:
                BooksFragment fr3 = new BooksFragment();
                fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, fr3);
                fragmentTransaction.addToBackStack("addBooks");
                fragmentTransaction.commit();
                break;

            case R.id.nav_friends:
                fr = new FriendsFragment();
                fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, fr);
                fragmentTransaction.addToBackStack("addFriends");
                fragmentTransaction.commit();
                break;

            case R.id.nav_notifications:
                NotificationsFragment frn = new NotificationsFragment();
                fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, frn);
                fragmentTransaction.addToBackStack("addNotifications");
                fragmentTransaction.commit();
                break;

            case R.id.nav_settings:
                fr = new SettingsFragment();
                fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flContent, fr);
                fragmentTransaction.addToBackStack("addSettings");
                fragmentTransaction.commit();
                break;

            case R.id.nav_logout:
                auth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }



        }
