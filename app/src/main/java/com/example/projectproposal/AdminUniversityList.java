package com.example.projectproposal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class AdminUniversityList extends AppCompatActivity {
    private Button viewRequestBtn;
    private Button BTN1;
    private TextView tit;
    ListView itemGridview;
    ItemAdapterAdmin itemAdapter;
    public ArrayList<ItemModelAdmin> dataList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_university_list);
        Button addBtn = findViewById(R.id.addBtn);
        viewRequestBtn = findViewById(R.id.viewRequestBtn);
        itemGridview = findViewById(R.id.university_list_admin);
        itemAdapter = new ItemAdapterAdmin(getApplicationContext(), R.layout.activity_listview_admin, dataList);

        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ini = new Intent(AdminUniversityList.this, AddUniversity.class);
                startActivity(ini);


            }
        });

        viewRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ParseQuery<ParseObject> query = new ParseQuery<>("university");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){
                    for (int i = 0; i < objects.size(); i++) {
                        final String title = objects.get(i).getString("name");
                        final String objId = objects.get(i).getObjectId();
                        System.out.println("Object ID"+objId);
                        boolean match = true;

                        ItemModelAdmin itemModel = new ItemModelAdmin(title.toUpperCase(), objId);
                        dataList.add(itemModel);
                        itemGridview.setAdapter(itemAdapter);
                        itemAdapter.notifyDataSetChanged();


                    }
                }
            }
        });



    }


}
