 package com.example.vamsi.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

 public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_navigation_bar);
        frameLayout = findViewById(R.id.main_frame);

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        accountFragment= new AccountFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home:
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_notification:
                        setFragment(notificationFragment);
                        return true;

                    case R.id.nav_account:
                        setFragment(accountFragment);
                        return true;

                        default:
                          return true;

                }

            }
        });
    }

     private void setFragment(Fragment fragment) {

         FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.replace(R.id.main_frame,fragment);
         fragmentTransaction.commit();
     }
 }
