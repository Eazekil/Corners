package com.nokhrin.corners.levels.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.database.ReadDb;
import com.nokhrin.corners.levels.view.ActivityLevels;
import com.nokhrin.corners.levels.view.ButtonLevel;

import java.util.ArrayList;

public class ButtonsAdapter extends ArrayAdapter<ButtonLevel> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<ButtonLevel> buttonsList;
    private int numberLevel;
    private ActivityLevels activity;

    public ButtonsAdapter(Context context, int resource, ArrayList<ButtonLevel> products) {
        super(context, resource, products);
        activity = (ActivityLevels) context;
        this.buttonsList = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ButtonLevel buttonLevel = buttonsList.get(position);

        String s1 = Integer.toString(buttonLevel.getNumberLevel());
        String s2 = Integer.toString(buttonLevel.getNumberLevel() + 1);
        String s3 = Integer.toString(buttonLevel.getNumberLevel() + 2);
        viewHolder.btLevelLeft.setText(s1);
        viewHolder.btLevelCenter.setText(s2);
        viewHolder.btLevelRight.setText(s3);

        viewHolder.btLevelLeft.setOnClickListener(v -> {
            numberLevel = position*3+1;
            System.out.println(numberLevel);
            returnLevel();
        });
        viewHolder.btLevelCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberLevel = position*3+2;
                System.out.println(numberLevel);
                returnLevel();
            }
        });
        viewHolder.btLevelRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberLevel = position*3+3;
                System.out.println(numberLevel);
                returnLevel();
            }
        });

        return convertView;
    }


    private class ViewHolder {
        final Button btLevelLeft, btLevelCenter, btLevelRight;
        final ListView productList;
        View view;

        //final TextView nameView, countView;
        ViewHolder(View view) {
            this.view = view;
            btLevelLeft = (Button) view.findViewById(R.id.buttonLevelLeft);
            btLevelCenter = (Button) view.findViewById(R.id.buttonLevelCenter);
            btLevelRight = (Button) view.findViewById(R.id.buttonLevelRight);
            productList = (ListView) view.findViewById(R.id.buttonList);/*
            System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
            System.out.println(productList == null);*/

            /*nameView = (TextView) view.findViewById(R.id.nameView);
            countView = (TextView) view.findViewById(R.id.countView);*/
        }

    }

    private void returnLevel(){
        activity.setCreateNumberLevel(numberLevel);
        //onTouchListener.setNumberLevel(numberLevel);
    }

   /* public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }*/
}
