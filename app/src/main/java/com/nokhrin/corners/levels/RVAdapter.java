package com.nokhrin.corners.levels;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.view.ActivityLevels;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.LevelViewHolder> {

    public static class LevelViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView numberLevel;
        ImageView ivButtonsLevel;

        LevelViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.emptyLayout);
            numberLevel =(TextView) itemView.findViewById(R.id.tvNumberLevel);
            ivButtonsLevel = (ImageView) itemView.findViewById(R.id.iv_buttons_level);
        }
    }

    List<Level> levels;
    private ActivityLevels activity;

    public RVAdapter(List<Level> levels) {
        this.levels = levels;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public LevelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        LevelViewHolder pvh = new LevelViewHolder(v);
        return pvh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(LevelViewHolder levelViewHolder, int i) {
        int stars = levels.get(i).getCountStars();
        String text = String.valueOf(levels.get(i).getNumberLevel());
        levelViewHolder.numberLevel.setText(text);
        if(stars == 0) levelViewHolder.ivButtonsLevel.setImageResource(R.drawable.button_star_0);
        if(stars == 1) levelViewHolder.ivButtonsLevel.setImageResource(R.drawable.button_star_1);
        if(stars == 2) levelViewHolder.ivButtonsLevel.setImageResource(R.drawable.button_star_2);
        if(stars == 3) levelViewHolder.ivButtonsLevel.setImageResource(R.drawable.button_star_3);

        levelViewHolder.ivButtonsLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setCreateNumberLevel(levels.get(i).getNumberLevel());
            }
        });
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    public void setActivity(ActivityLevels activity) {
        this.activity = activity;
    }
}