package com.example.projectproposal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.projectproposal.ItemModel;
import java.util.List;
import com.example.projectproposal.R;

public class ItemAdapter extends ArrayAdapter<ItemModel> {
    Context context;
    int layoutResourceId;
    List<ItemModel> item = null;

    public ItemAdapter(Context context, int resource, List<ItemModel> objects) {
        super(context, 0, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.item = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  LayoutInflater.from(getContext());
        convertView = inflater.inflate(layoutResourceId, parent, false);
        TextView title = convertView.findViewById(R.id.name);
        TextView gre = convertView.findViewById(R.id.gre);
        TextView tofle = convertView.findViewById(R.id.tofle);
        TextView rate = convertView.findViewById(R.id.rate);
        TextView url = convertView.findViewById(R.id.url);
        TextView type = convertView.findViewById(R.id.type);
        TextView location = convertView.findViewById(R.id.location);
        ItemModel itemModel = item.get(position);
        title.setText(itemModel.getName());
        gre.setText(itemModel.getGre());
        rate.setText(itemModel.getRate());
        tofle.setText(itemModel.getTofle());
        url.setText(itemModel.getUrl());
        type.setText(itemModel.getType());
        location.setText(itemModel.getLocation());
        return convertView;
    }
}
