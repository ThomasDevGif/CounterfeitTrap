package com.example.thomastournoux.counterfeittrap.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.fragment.HomeFragment;
import com.example.thomastournoux.counterfeittrap.fragment.RolexFragment;
import com.example.thomastournoux.counterfeittrap.fragment.TradeFragment;
import com.example.thomastournoux.counterfeittrap.fragment.TraderFragment;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
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

    // Fragment
    private HomeFragment mHomeFragment;
    private RolexFragment mRolexFragment;
    private TraderFragment mTraderFragment;
    private TradeFragment mTradeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbar();
        initializeFragment();
        initializeDrawer();
    }

    /**
     * Initialize toolbar
     */
    private void initializeToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    /**
     * Instantiate fragments
     */
    private void initializeFragment() {
        mHomeFragment = HomeFragment.newInstance();
        mRolexFragment = RolexFragment.newInstance();
        mTraderFragment = TraderFragment.newInstance();
        mTradeFragment = TradeFragment.newInstance();
    }

    /**
     * Initialize drawer menu
     */
    private void initializeDrawer() {
        mProfileDrawerItem = new ProfileDrawerItem()
                .withName("EPSI Workshop")
                .withIdentifier(100);

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
                .withIdentifier(2).withName(R.string.rolex)
                .withIcon(GoogleMaterial.Icon.gmd_watch);
        final PrimaryDrawerItem itemTrader = new PrimaryDrawerItem()
                .withIdentifier(3).withName(R.string.trader)
                .withIcon(GoogleMaterial.Icon.gmd_group);
        final PrimaryDrawerItem itemTrade = new PrimaryDrawerItem()
                .withIdentifier(4).withName(R.string.trade)
                .withIcon(GoogleMaterial.Icon.gmd_share);

        // Create the drawer and remember the `Drawer` result object
        mMaterialDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(mAccountHeader)
                .addDrawerItems(
                        itemHome,
                        itemRolex,
                        itemTrader,
                        itemTrade
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Do something with the clicked item
                        Long id = drawerItem.getIdentifier();
                        switch (Integer.valueOf(id.intValue())) {
                            case 1:
                                fragmentTransaction.replace(R.id.fragment_container,
                                        mHomeFragment);
                                fragmentTransaction.commit();
                                break;
                            case 2:
                                fragmentTransaction.replace(R.id.fragment_container,
                                        mRolexFragment);
                                fragmentTransaction.commit();
                                break;
                            case 3:
                                fragmentTransaction.replace(R.id.fragment_container,
                                        mTraderFragment);
                                fragmentTransaction.commit();
                                break;
                            case 4:
                                fragmentTransaction.replace(R.id.fragment_container,
                                        mTradeFragment);
                                fragmentTransaction.commit();
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
