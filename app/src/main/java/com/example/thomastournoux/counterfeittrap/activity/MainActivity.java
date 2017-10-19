package com.example.thomastournoux.counterfeittrap.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomastournoux.counterfeittrap.R;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    // Drawer
    private Toolbar toolbar;
    private Drawer mMaterialDrawer;
    private AccountHeader mAccountHeader;
    private ProfileDrawerItem mProfileDrawerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbar();
        initializeDrawer();
    }

    /**
     * Initialize toolbar
     */
    private void initializeToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initializeDrawer() {
        mProfileDrawerItem = new ProfileDrawerItem().withName("")
                .withEmail("test@test.com")
                .withIdentifier(100);

        Drawable drawableFont = new IconicsDrawable(getApplicationContext())
                .icon(GoogleMaterial.Icon.gmd_highlight_off)
                .color(getResources().getColor(R.color.white));

        // Create the AccountHeader
        mAccountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withSelectionListEnabled(false)
                .withSelectionListEnabledForSingleProfile(true)
                .withSelectionSecondLineShown(true)
                .withHeaderBackground(R.drawable.img_header)
                .addProfiles(
                        mProfileDrawerItem
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        // Add items and adding some functionality=
        final PrimaryDrawerItem itemHome = new PrimaryDrawerItem()
                .withIdentifier(1).withName(R.string.home)
                .withIcon(GoogleMaterial.Icon.gmd_home);
        final PrimaryDrawerItem itemRolex = new PrimaryDrawerItem()
                .withIdentifier(1).withName(R.string.rolex)
                .withIcon(GoogleMaterial.Icon.gmd_watch);
        final PrimaryDrawerItem itemTrader = new PrimaryDrawerItem()
                .withIdentifier(2).withName(R.string.trader)
                .withIcon(GoogleMaterial.Icon.gmd_person);

        // Create the drawer and remember the `Drawer` result object
        mMaterialDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(mAccountHeader)
                .addDrawerItems(
                        itemHome,
                        itemRolex,
                        itemTrader
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        // Do something with the clicked item
                        Long id = drawerItem.getIdentifier();
                        switch (Integer.valueOf(id.intValue())) {
                            case 1:
                                break;
                        }

                        return false;
                    }
                })
                .withCloseOnClick(true)
                .withFireOnInitialOnClick(true)
                .withSelectedItem(1)
                .build();

        mMaterialDrawer.setSelectionAtPosition(1);
    }
}
