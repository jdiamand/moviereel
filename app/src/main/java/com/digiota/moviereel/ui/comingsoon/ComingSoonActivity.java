package com.digiota.moviereel.ui.comingsoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.TextView;

import com.digiota.moviereel.R;
import com.digiota.moviereel.application.MainActivity;
import com.digiota.moviereel.ui.nowplaying.NowPlayingActivity;
import com.digiota.moviereel.ui.topfive.TopFiveActivity;
import com.digiota.moviereel.ui.topfive.TopFiveActivityViewModel;

/**
 * Created by jdiamand on 11/24/17.
 */



public class ComingSoonActivity extends MainActivity {

    final static int CURRENT_NAVIGATION_MENU_INDEX = 2;

    //private ComingSoonActivityViewModel mViewModel;

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

        setSubTitle("Coming Soon");
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
            // Handle the camera action
            intent = new Intent(this,NowPlayingActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.from_right_in, R.anim.from_right_out);
        } else if (id == R.id.coming_soon) {
                // this activity, do nothing
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
