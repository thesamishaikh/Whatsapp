package com.android.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    FragmentContainerView fragmentContainerView;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainerView = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.tablayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //switch
                switch (tab.getPosition()){
                    case 0:
                        changeFragment(new CameraFragment());
                        break;
                    case 1:
                        changeFragment(new ChatsFragment());
                        break;
                    case 2:
                        changeFragment(new StatusFragment());
                        break;
                    case 3:
                        changeFragment(new CallFragment());
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentcontainer,fragment)
                .commit();
    }

}