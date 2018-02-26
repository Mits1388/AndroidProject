package com.example.mits16.myfirstproject.homework6;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.mits16.myfirstproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mizz8 on 25.02.2018.
 */

public class HomeWork6Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<String> list;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);

        String text = "json.json";
        byte[] buffer = null;
        InputStream inputStream;
        try {
            inputStream = getAssets().open(text);
            int size = inputStream.available();
            buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = new String(buffer);

       Log.e("ssss",json);


        list = new ArrayList<>();
       // parseJson(assetsJson());
        parseJson(json);

        myAdapter = new MyAdapter();
        myAdapter.setItems(list);

       for(int i = 0; i < list.size(); i++){
            Log.e("ssss",list.get(i));
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }


  /*  private String assetsJson(){
        String text = "json.json";
        byte[] buffer = null;
        InputStream is;
        try {
            is = getAssets().open(text);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = new String(buffer);
        return json;
    }*/


    private void parseJson(String json){
        try {
            JSONObject object = new JSONObject(json);
            /*String string = object.getString("name");
            String gender = object.getString("gender");
            String date = object.getString("date");
              list.add(string);
              list.add(gender);
              list.add(date);*/
           JSONArray people = object.getJSONArray("people");
            for (int i = 0; i < people.length(); i++ ) {
                JSONObject arrObject = people.getJSONObject((i));
                String id = arrObject.getString("id");
                String name = arrObject.getString("name");
                String surname = arrObject.getString("surname");
                String age = arrObject.getString("age");
                String isDegree = arrObject.getString("isDegree");
                list.add(String.valueOf(id));
                list.add(name);
                list.add(surname);
                list.add(String.valueOf(age));
                list.add(String.valueOf(isDegree));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
