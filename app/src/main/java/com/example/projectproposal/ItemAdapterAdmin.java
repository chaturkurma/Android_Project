package com.example.projectproposal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ItemAdapterAdmin extends ArrayAdapter<ItemModelAdmin> {
    Context context;
    int layoutResourceId;
    List<ItemModelAdmin> item = null;

    public ItemAdapterAdmin(Context context, int resource, List<ItemModelAdmin> objects) {
        super(context, 0, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.item = objects;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  LayoutInflater.from(getContext());
        convertView = inflater.inflate(layoutResourceId, parent, false);
        TextView title = convertView.findViewById(R.id.name);
        TextView objId = convertView.findViewById(R.id.objId);
        final ItemModelAdmin itemModel = item.get(position);
        title.setText(itemModel.getName());
        objId.setText(itemModel.getObjId());
        Button delete = convertView.findViewById(R.id.deleteBtn);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                item.remove(position);
                ParseQuery<ParseObject> query = ParseQuery.getQuery("university");
                query.getInBackground(itemModel.getObjId(), new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if(e==null) {
                            try {
                                object.delete();
                                object.saveInBackground();
                                Toast.makeText(context, "University Deleted", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();

                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }
                });
            }
        });
        return convertView;
    }
}
