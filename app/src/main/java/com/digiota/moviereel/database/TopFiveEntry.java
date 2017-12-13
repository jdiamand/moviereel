package com.digiota.moviereel.database;

import android.arch.persistence.room.Ignore;

import java.util.ArrayList;

/**
 * Created by jdiamand on 11/25/17.
 */

public class TopFiveEntry {
    private int id;
    private int movieId;
    private int position ;
    private String movieTitle;
    private String date;
    private int weeksGross;
    private int totalGross;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeeksGross() {
        return weeksGross;
    }

    public void setWeeksGross(int weeksGross) {
        this.weeksGross = weeksGross;
    }

    public int getTotalGross() {
        return totalGross;
    }

    public void setTotalGross(int totalGross) {
        this.totalGross = totalGross;
    }


    @Ignore
    public TopFiveEntry(int movieId, String movieTitle, String date, int position, int weeklyGross, int totalGross  ) {
        this.movieTitle = movieTitle;
        this.date = date;
        this.position = position;
        this.weeksGross = weeklyGross;
        this.totalGross = totalGross;
    }

    public static ArrayList<TopFiveEntry> createTopFiveEntryList() {
        ArrayList<TopFiveEntry> entries = new ArrayList<TopFiveEntry>();

        for (int i = 0; i <  5; i++) {
            String movieTitle = "This is movie number " + i ;
            String date =  "Nov 1,2017" ;
            entries.add(new TopFiveEntry(
                    i + 1,
                     movieTitle,
                    date,
                    i +1 ,
                    (5-i)*10000,
                    (5-i)*90000));
        }

        return entries;
    }


}
