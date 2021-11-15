package com.example.eshop;

import android.content.Intent;
import android.os.Bundle;

//import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.eshop.ui.main.SectionsPagerAdapter;
import com.example.eshop.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //login state
    //public Boolean state = false;

    //private ActivityMainBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    //PagerAdapter pagerAdapter;
    TabItem register, checkout, purchase;


    //FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);
        register = findViewById(R.id.register);
        checkout = findViewById(R.id.checkout);
        purchase = findViewById(R.id.purchase);




        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), getLifecycle(), tabLayout.getTabCount());
        //ViewPager2.setAdapter(pagerAdapter);
        viewPager2.setAdapter( pagerAdapter);

        viewPager2.registerOnPageChangeCallback( new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab( tabLayout.getTabAt( position ) );
            }
        } );

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

//    @Override
//    protected void onStart(){
//        super.onStart();
//        //FirebaseUser user = mAuth.getCurrentUser();
//        Intent intent = getIntent();
//        Boolean state;
//
                //state = intent.getStringExtra("username");

//        if(state){
//            startActivity(new Intent(MainActivity.this, MainActivity.class));
//        }
//        else{
//            startActivity(new Intent(MainActivity.this, login.class));
//            finish();
//        }
    //}
}