package com.digiota.moviereel.ui.topfive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.digiota.moviereel.R;
import com.digiota.moviereel.application.MainActivity;
import com.digiota.moviereel.database.TopFiveEntry;
import com.digiota.moviereel.ui.comingsoon.ComingSoonActivity;
import com.digiota.moviereel.ui.nowplaying.NowPlayingActivity;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jdiamand on 11/24/17.
 */

public class TopFiveActivity extends MainActivity implements TopFiveAdapter.TopFiveAdapterOnItemClickHandler{

    final static int CURRENT_NAVIGATION_MENU_INDEX = 0;

    private TopFiveActivityViewModel mViewModel;
    private TopFiveAdapter mTopFiveAdapter;
    private RecyclerView mRecyclerView;

    ArrayList<TopFiveEntry> topFiveEntries;

    @Override
    protected void onResume() {
        super.onResume();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        String s = getSubTitle( getSelectedItem(bottomNavigationView));
        setSubTitle(s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topfive);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        String s = getSubTitle( getSelectedItem(bottomNavigationView));

        onCreateSupport();

        //TODO
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.getMenu().getItem(CURRENT_NAVIGATION_MENU_INDEX).setChecked(true);

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(
                        Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(
                        Stetho.defaultInspectorModulesProvider(this))
                .build());

        //TODO

        mRecyclerView = findViewById(R.id.recyclerview_topfive);

        topFiveEntries = TopFiveEntry.createTopFiveEntryList();
        mTopFiveAdapter = new TopFiveAdapter(this, this, topFiveEntries);
        mRecyclerView.setAdapter(mTopFiveAdapter);

        LinearLayoutManager layoutManager =
             new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        //mRecyclerView.smoothScrollToPosition(0);
        mRecyclerView.setHasFixedSize(true);



        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        setSubTitle(getSubTitle(item) );
                        clearCheckedItem(bottomNavigationView ) ;
                        item.setChecked(true) ;
                        return true;
                    }
                });


    }

    private void clearCheckedItem(BottomNavigationView bottomNavigationView ){
        Menu menu = bottomNavigationView.getMenu();
        for (int i=0;i<bottomNavigationView.getMenu().size();i++){
            MenuItem menuItem = menu.getItem(i);
            menuItem.setChecked(false);
        }

    }


    private MenuItem getSelectedItem(BottomNavigationView bottomNavigationView){
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        for (int i=0;i<bottomNavigationView.getMenu().size();i++){
             menuItem = menu.getItem(i);
            if (menuItem.isChecked()){
                 return menuItem ;
            }
        }
        return menuItem;
    }

    String getSubTitle( MenuItem item) {
        int tabIndx = item.getItemId() ;
        String subTitle ;
        switch (tabIndx) {
            case R.id.action_top5_current:
                subTitle = "BoxOffice WeekEnd Nov 17" ;
                break;
            case R.id.action_top5_last_week:
                subTitle = "BoxOffice WeekEnd Nov 12" ;
                break;
            case R.id.action_top5_2_weeks_ago:
                subTitle = "BoxOffice WeekEnd Nov 5" ;
                break;
            case R.id.action_top5_3_weeks_ago:
                subTitle = "BoxOffice WeekEnd Oct 29" ;
                break;
            default :
                subTitle = "" ;
        }

        return subTitle ;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.top_five) {
            // this activity
        } else if (id == R.id.now_playing) {
            intent = new Intent(this, NowPlayingActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.from_right_in, R.anim.from_right_out);
        } else if (id == R.id.coming_soon) {
            intent = new Intent(this, ComingSoonActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.from_right_in, R.anim.from_right_out);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(Date date) {
       // Intent weatherDetailIntent = new Intent(MainActivity.this, DetailActivity.class);
       // long timestamp = date.getTime();
      //  weatherDetailIntent.putExtra(DetailActivity.WEATHER_ID_EXTRA, timestamp);
      //  startActivity(weatherDetailIntent);
    }
}
