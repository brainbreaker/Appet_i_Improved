package com.sunshine.bbreaker.appet_i;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

//import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageDownloader;
import com.heinrichreimersoftware.materialdrawer.DrawerActivity;
import com.heinrichreimersoftware.materialdrawer.DrawerFrameLayout;
import com.heinrichreimersoftware.materialdrawer.DrawerView;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerHeaderItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;

import materialtabs.MainActivity;


public class Home extends DrawerActivity
        {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    //     NavigationDrawerFragment mNavigationDrawerFragment;

    //    private CharSequence mTitle;
    info.hoang8f.widget.FButton ShopNow;
    private Toolbar toolbar;
    private DrawerView drawer;
    private ActionBarDrawerToggle drawerToggle;
            String name;
            String url;
            String picId;
    private Bitmap bmp;
            BitmapDrawable bmpg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerView) findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
//        url = intent.getStringExtra("url");
//        picId = intent.getStringExtra("picid");
//        Drawable profile = ;
        Bitmap bmp = (Bitmap) getIntent().getParcelableExtra("bitmap");

        if(bmp==null) {
            bmpg = (BitmapDrawable) getResources().getDrawable(R.drawable.appeti);
        }else {
            bmpg= new BitmapDrawable(getResources(), bmp);
        }

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
//        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.appeti_dull_yellow));
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.closeDrawer(drawer);

        drawer.addItem(new DrawerItem()
                        .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.home))
                        .setTextPrimary(getString(R.string.title_section1))
        );
        drawer.addItem(new DrawerItem()
                        .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.muffin))
                        .setTextPrimary(getString(R.string.title_section2))
        );
        addDivider();

        drawer.addItem(new DrawerHeaderItem().setTitle(getString(R.string.title_section3)));

        addDivider();

        drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.sweets))
        );

        drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.snacks))
        );

        drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.mouthfreshner))
        );

        drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.beverage))
        );
        drawer.addItem(new DrawerItem()
                        .setTextPrimary(getString(R.string.bakery))
        );

        addDivider();
        drawer.addItem(new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.appeti))
                        .setTextPrimary(getString(R.string.aboutus))
        );

        drawer.addFixedItem(new DrawerItem()
                        .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.appeti), DrawerItem.SMALL_AVATAR)
                        .setTextPrimary(getString(R.string.account))
        );

        drawer.addFixedItem(new DrawerItem()
                        .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.settingsfood), DrawerItem.SMALL_AVATAR)
                        .setTextPrimary(getString(R.string.settings))
        );

        drawer.setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectItem(position);
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), flavours.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        drawer.setOnFixedItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectFixedItem(position);
                Toast.makeText(Home.this, "Clicked fixed item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        drawer.addProfile(
                new DrawerProfile()
                        .setId(1)
                        .setRoundedAvatar(bmpg)
                                        .setBackground(getResources().getDrawable(R.drawable.ghewar))
                                        .setName(getString(R.string.welcome))
                                        .setDescription(name)
                        .setOnProfileClickListener(new DrawerProfile.OnProfileClickListener() {
                            @Override
                            public void onClick(DrawerProfile drawerProfile, long id) {
                                Toast.makeText(Home.this, "Clicked profile #" + id, Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(getApplicationContext(), login.class);
                                startActivity(login);

                            }
                        })
                        );


        Toast.makeText(Home.this, "..........Scroll Down..........", Toast.LENGTH_SHORT).show();

        ShopNow = (info.hoang8f.widget.FButton) findViewById(R.id.shopnow);
        ShopNow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent openrs = new Intent(getApplicationContext(), Regional_Specialities.class);
                startActivity(openrs);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }
    }

            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
                drawerToggle.onConfigurationChanged(newConfig);
            }


            @Override
            protected void onPostCreate(Bundle savedInstanceState) {
                super.onPostCreate(savedInstanceState);
                drawerToggle.syncState();
            }
}


