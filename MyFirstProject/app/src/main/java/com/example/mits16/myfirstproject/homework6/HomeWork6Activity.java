package com.example.mits16.myfirstproject.homework6;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import com.example.mits16.myfirstproject.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by mizz8 on 25.02.2018.
 */

public class HomeWork6Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<People> list;
    private InputStream inputStream;
    private JSONObject object;
    private EditText search;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        search = (EditText)findViewById(R.id.editSearch);


        list = new ArrayList<>();
        parseJson(assetsJson());

        myAdapter = new MyAdapter();
        myAdapter.setItems(list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

         for(int i = 0; i < list.size(); i++){
            Log.e("check",list.toString());
        }
    }


    private void filter(String text) {

        ArrayList<People> filter = new ArrayList<>();
        for (People s : list) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                filter.add(s);
            }else if(s.getSurname().toLowerCase().contains(text.toLowerCase())){
                filter.add(s);
            }else if(s.getAge().toLowerCase().contains(text.toLowerCase())){
                filter.add(s);
            }else if(s.getIsDegree().toLowerCase().contains(text.toLowerCase())){
                filter.add(s);
            }else if(s.getId().toLowerCase().contains(text.toLowerCase())){
                filter.add(s);
            }
        }
        myAdapter.filterList(filter);
    }


    private String assetsJson(){
        String text = "json.json";
        byte[] buffer = null;
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
        return json;
    }


    private void parseJson(String json){
        try {
            object = new JSONObject(json);
          /*  String string = object.getString("name");
            String gender = object.getString("gender");
            String date = object.getString("date");*/
           JSONArray people = object.getJSONArray("people");
            for (int i = 0; i < people.length(); i++) {
                JSONObject arrObject = people.getJSONObject((i));
                String id = arrObject.getString("id");
                String name = arrObject.getString("name");
                String surname = arrObject.getString("surname");
                String age = arrObject.getString("age");
                String isDegree = arrObject.getString("isDegree");
                list.add(new People(id,name,surname,age,isDegree));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
