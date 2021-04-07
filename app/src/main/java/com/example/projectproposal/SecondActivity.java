package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private Button BTN;
    private TextView tit;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    ListView itemGridview;
    ItemAdapter itemAdapter;
    public ArrayList<ItemModel> dataList = new ArrayList();
    private String qLocation;
    private String qType;
    private String qClimate;
    public String locationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        TextView tv = (TextView) findViewById(R.id.univ1);
//        TextView tv1 = (TextView) findViewById(R.id.univ2);
//        tv2 = findViewById(R.id.textView8);
//        tv3 = findViewById(R.id.textView10);
//        tv4 = findViewById(R.id.textView11);
        BTN = (Button) findViewById(R.id.BTNnext);
        qLocation="";
        TextView tit = (TextView)findViewById(R.id.titleUniv);
        Intent intent = getIntent();
        if(intent.hasExtra("a1")){
         qLocation = intent.getStringExtra("a1");
         qType = intent.getStringExtra("a2");
         qClimate = intent.getStringExtra("a3");
        System.out.println(qLocation+qType+qClimate);}else {
            qLocation="";
            qType="";
            qClimate="";
        }
        itemGridview = findViewById(R.id.university_list);
        itemAdapter = new ItemAdapter(getApplicationContext(), R.layout.activity_listview, dataList);


        ParseQuery<ParseObject> query = new ParseQuery<>("university");

        if(!qLocation.equalsIgnoreCase("")){
            query.whereContains("location", qLocation.toLowerCase());
        }
        if(!qClimate.equalsIgnoreCase("")){
            query.whereContains("climate", qClimate.toLowerCase());
        }
        if(!qType.equalsIgnoreCase("")){
            query.whereContains("type", qType.toLowerCase());
        }
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){
                    for (int i = 0; i < objects.size(); i++) {
                        final String title = objects.get(i).getString("name");
                        final String gre = objects.get(i).getString("gre");
                        final String tofle = objects.get(i).getString("tofle");
                        final String rate = objects.get(i).getString("rate");
                        final String url = objects.get(i).getString("url");
                        final String location = objects.get(i).getString("location");
                        final String type = objects.get(i).getString("type");
                        final String locationString = objects.get(i).getString("locationString");
                        boolean match = true;
//                        if(qLocation.equalsIgnoreCase("")
//                                && qType.equalsIgnoreCase("")
//                                && qLocation.equalsIgnoreCase("")){
//
//                            ItemModel itemModel = new ItemModel(title.toUpperCase(), gre, tofle, rate, url, type,location);
//                            dataList.add(itemModel);
//                            itemGridview.setAdapter(itemAdapter);
//                            itemAdapter.notifyDataSetChanged();
//                        }else {
//                            if((!qClimate.equalsIgnoreCase("") && location.toLowerCase().contains(qClimate.toLowerCase())) ||
//                                    (!qType.equalsIgnoreCase("") && type.toLowerCase().contains(qType.toLowerCase())) ||
//                                    (!qLocation.equalsIgnoreCase("") && location.toLowerCase().contains(qLocation.toLowerCase()))
//
//                            ){
//                                ItemModel itemModel = new ItemModel(title.toUpperCase(), gre, tofle, rate, url, type,location);
//                                dataList.add(itemModel);
//                                itemGridview.setAdapter(itemAdapter);
//                                itemAdapter.notifyDataSetChanged();
//                            }
//                        }

                                ItemModel itemModel = new ItemModel(title.toUpperCase(), gre, tofle, rate, url, type,location,locationString);
                                dataList.add(itemModel);
                                itemGridview.setAdapter(itemAdapter);
                                itemAdapter.notifyDataSetChanged();


                    }
                }
            }
        });

        itemGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = view.findViewById(R.id.name);
                TextView gre = view.findViewById(R.id.gre);
                TextView tofle = view.findViewById(R.id.tofle);
                TextView rate = view.findViewById(R.id.rate);
                TextView url = view.findViewById(R.id.url);
                TextView location = view.findViewById(R.id.location);
                TextView type = view.findViewById(R.id.type);
                Intent productIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                productIntent.putExtra("gre", gre.getText().toString());
                productIntent.putExtra("name", name.getText().toString());
                productIntent.putExtra("tofle", tofle.getText().toString());
                productIntent.putExtra("rate", rate.getText().toString());
                productIntent.putExtra("url", url.getText().toString());
                productIntent.putExtra("location", location.getText().toString());
                productIntent.putExtra("type", type.getText().toString());
                productIntent.putExtra("locationString",dataList.get(position).getLocationString());
                startActivity(productIntent);
            }
        });
//        dataList.add(new ItemModel(("Northwest")));
//        dataList.add(new ItemModel(("Northwest1")));
//        dataList.add(new ItemModel(("Northwest2")));
//        itemGridview.setAdapter(itemAdapter);
//        itemAdapter.notifyDataSetChanged();
//        tv.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent ini = new Intent(SecondActivity.this,ThirdActivity.class);
//                startActivity(ini);
//
//            }
//
//        });
//
//
//        tv1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent ini = new Intent(SecondActivity.this,fourthActivity.class);
//                startActivity(ini);
//
//            }
//
//        });
//
//
//
//        tv2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent ini = new Intent(SecondActivity.this,FifthUniversity.class);
//                startActivity(ini);
//
//            }
//
//        });
//
//        tv3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent ini = new Intent(SecondActivity.this,SixthUniversity.class);
//                startActivity(ini);
//
//            }
//
//        });
//
//        tv4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent ini = new Intent(SecondActivity.this,SeventhActivity.class);
//                startActivity(ini);
//
//            }
//
//        });





        BTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(SecondActivity.this, feedback.class);
                startActivity(ini);


            }
        });
    }
    }
