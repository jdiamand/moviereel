package com.digiota.moviereel.ui.topfive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.digiota.moviereel.R;
import com.digiota.moviereel.database.TopFiveEntry;

import java.util.Date;
import java.util.List;

/**
 * Created by jdiamand on 11/24/17.
 */

public class TopFiveAdapter extends RecyclerView.Adapter<TopFiveAdapter.TopFiveAdapterViewHolder>{

    private final Context mContext;
    private List<TopFiveEntry> mTopFiveEntries;
    private final TopFiveAdapterOnItemClickHandler mClickHandler;


    TopFiveAdapter(@NonNull Context context, TopFiveAdapterOnItemClickHandler clickHandler,
                   List<TopFiveEntry> topFiveEntries) {
        mContext = context;
        mClickHandler = clickHandler;
        mTopFiveEntries = topFiveEntries ;

    }


    public interface TopFiveAdapterOnItemClickHandler {
        void onItemClick(Date date);
    }



    @Override
    public int getItemCount() {

        if (null == mTopFiveEntries) return 0;

        return mTopFiveEntries.size();


    }

    @Override
    public TopFiveAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        int layoutId =  R.layout.topfive_list_item;

        View view = LayoutInflater.from(mContext).inflate(layoutId, viewGroup, false);
        view.setFocusable(true);

        return new TopFiveAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopFiveAdapterViewHolder topFiveAdapterViewHolder, int position) {


        TopFiveEntry topFiveEntry = mTopFiveEntries.get(position);


        TextView movieTitle = topFiveAdapterViewHolder.movieTitle;
        movieTitle.setText(topFiveEntry.getMovieTitle());
        //
        ImageView poster  = topFiveAdapterViewHolder.moviePoster;
        poster.setImageResource(R.drawable.starwars);
        //
        TextView weeklyPostion = topFiveAdapterViewHolder.weeklyPosition ;
        weeklyPostion.setText( mContext.getString(R.string.weekly_position) + " " + topFiveEntry.getPosition());
        //
        TextView releaseDate = topFiveAdapterViewHolder.releaseDate ;
        releaseDate.setText(mContext.getString(R.string.release_date) + " " + topFiveEntry.getDate());
        //
        TextView weeksGross = topFiveAdapterViewHolder.weeksGross ;
        weeksGross.setText(mContext.getString(R.string.weeks_gross) +  topFiveEntry.getWeeksGross());
        //
        TextView totalGross = topFiveAdapterViewHolder.totalGross ;
        totalGross.setText(mContext.getString(R.string.total_gross) +  topFiveEntry.getTotalGross());
    }







    class TopFiveAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView movieTitle ;
        final ImageView moviePoster;
        final TextView weeklyPosition ;
        final TextView releaseDate ;
        final TextView weeksGross ;
        final TextView totalGross ;

        TopFiveAdapterViewHolder(View view) {
            super(view);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            weeklyPosition = (TextView) itemView.findViewById(R.id.weekly_position);
            releaseDate = (TextView) itemView.findViewById(R.id.release_date);
            weeksGross = (TextView) itemView.findViewById(R.id.weekly_gross);
            totalGross = (TextView) itemView.findViewById(R.id.total_gross);
            view.setOnClickListener(this);
        }







        /**
         * This gets called by the child views during a click. We fetch the date that has been
         * selected, and then call the onItemClick handler registered with this adapter, passing that
         * date.
         *
         * @param v the View that was clicked
         */
        @Override
        public void onClick(View v) {
            /*
            int adapterPosition = getAdapterPosition();
            Date date = mForecast.get(adapterPosition).getDate();
            mClickHandler.onItemClick(date);
            */
        }
    }
}
