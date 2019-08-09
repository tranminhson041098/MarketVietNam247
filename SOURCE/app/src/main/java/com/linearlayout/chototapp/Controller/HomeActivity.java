package com.linearlayout.chototapp.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.linearlayout.chototapp.AccountFragment;
import com.linearlayout.chototapp.HomeFragment;
import com.linearlayout.chototapp.NotificationFragment;
import com.linearlayout.chototapp.PostFragment;
import com.linearlayout.chototapp.R;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }


    void init()

    {
        HomeFragment homeFragment = new HomeFragment();
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,homeFragment);

        fragmentTransaction.commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.nav_trangchu:
                        {
                            HomeFragment homeFragment = new HomeFragment();
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container,homeFragment);
                            fragmentTransaction.commit();

                            break;
                        }
                    case R.id.nav_baidang:
                        {
                            PostFragment postFragment = new PostFragment();
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container,postFragment);
                            fragmentTransaction.commit();


                            break;
                        }
                    case R.id.nav_thongbao:
                        {
                            NotificationFragment notificationFragment = new NotificationFragment();
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container,notificationFragment);
                            fragmentTransaction.commit();

                            break;
                        }
                    case R.id.nav_taikhoan:
                        {
                            AccountFragment accountFragment = new AccountFragment();
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container,accountFragment);
                            fragmentTransaction.commit();

                            break;

                        }

                }
                return true;
            }
        });
    }
}
