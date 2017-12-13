package com.digiota.moviereel.ui.nowplaying;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.TextView;

import com.digiota.moviereel.R;
import com.digiota.moviereel.application.MainActivity;
import com.digiota.moviereel.ui.comingsoon.ComingSoonActivity;
import com.digiota.moviereel.ui.topfive.TopFiveActivity;
import com.digiota.moviereel.ui.topfive.TopFiveActivityViewModel;

/**
 * Created by jdiamand on 11/24/17.
 */

public class NowPlayingActivity extends MainActivity{

        final static int CURRENT_NAVIGATION_MENU_INDEX = 1;

        //private TopFiveActivityViewModel mViewModel;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            onCreateSupport() ;
            //TODO
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(CURRENT_NAVIGATION_MENU_INDEX).setChecked(true);

        }
    @Override
    protected void onResume() {
        super.onResume();

        setSubTitle("Now PLaying");
    }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();
            Intent intent;
            if (id == R.id.top_five) {
                // Handle the camera action
                intent = new Intent(this, TopFiveActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.from_right_in, R.anim.from_right_out);
            } else if (id == R.id.now_playing) {

                // this activity

            } else if (id == R.id.coming_soon) {
                // Handle the camera action
                intent = new Intent(this, ComingSoonActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.from_right_in, R.anim.from_right_out);

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

}
