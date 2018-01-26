package com.example.architgoyal.peacocksolar;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.rd.PageIndicatorView;

public class SignUpActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PageIndicatorView pageIndicatorView;
    AppBarLayout ab;
    Toolbar toolbar;
    TabLayout tabLayout;
    private LinearLayout CONTACT_US;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.overridePendingTransition(R.anim.animation_leave,
                R.anim.animation_enter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            this.getWindow().setStatusBarColor(
                    getResources().getColor(R.color.statusbarcolor));
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Personal Details");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        CONTACT_US=navigationView.findViewById(R.id.contact_us);
        CONTACT_US.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this,ContactUS.class);
                startActivity(intent);
            }
        });
        mViewPager = (ViewPager) findViewById(R.id.pager);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(3);
        pageIndicatorView.setSelection(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    toolbar.setTitle("Personal Details");
                    pageIndicatorView.setSelection(0);
                }
                else if(position==1){
                    toolbar.setTitle("Installation Address");
                    pageIndicatorView.setSelection(1);
                }
                else{
                    toolbar.setTitle("Rooftop & Bill Information");
                    pageIndicatorView.setSelection(2);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(new SamplePagerAdapter(
                getSupportFragmentManager()));
    }

    /** Defining a FragmentPagerAdapter class for controlling the fragments to be shown when user swipes on the screen. */
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            if (position == 0) {
                return new PersonalDetailsFragment();
            } else if(position == 1) {
                return new InstallationAddressFragment();
            } else {
                return new BillInfoFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public void setCurrentItem (int item, boolean smoothScroll) {
        mViewPager.setCurrentItem(item, smoothScroll);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_exit){
            startActivity(new Intent(SignUpActivity.this,MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
