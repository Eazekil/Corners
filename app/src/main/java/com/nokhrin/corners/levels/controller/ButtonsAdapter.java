package com.nokhrin.corners.levels.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.view.ButtonLevel;

import java.util.ArrayList;

public class ButtonsAdapter extends ArrayAdapter<ButtonLevel> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<ButtonLevel> buttonsList;
    private int number;

    public ButtonsAdapter(Context context, int resource, ArrayList<ButtonLevel> products) {
        super(context, resource, products);
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
        final ButtonLevel product = buttonsList.get(position);

        String s1 = Integer.toString(product.getNumberLevel());
        String s2 = Integer.toString(product.getNumberLevel() + 1);
        String s3 = Integer.toString(product.getNumberLevel() + 2);
        viewHolder.btLevelLeft.setText(s1);
        viewHolder.btLevelCenter.setText(s2);
        viewHolder.btLevelRight.setText(s3);

        viewHolder.btLevelLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = position*3+1;
                System.out.println(number);
            }
        });
        viewHolder.btLevelCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = position*3+2;
                System.out.println(number);
            }
        });
        viewHolder.btLevelRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = position*3+3;
                System.out.println(number);
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

    public int getNumber() {
        return number;
    }
}
