package com.example.mits16.myfirstproject.homework6;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mits16.myfirstproject.R;
import java.util.ArrayList;



/**
 * Created by mizz8 on 25.02.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

   private ArrayList<People> itemList = new ArrayList<>();


    public void setItems (ArrayList<People> arrayList){
        this.itemList.clear();
        this.itemList.addAll(arrayList);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder myHolder = (Holder)holder;
        final People people = itemList.get(position);

        myHolder.idTextView.setText("Id: "+people.getId());
        myHolder.nameTextView.setText(people.getName());
        myHolder.surnameTextView.setText(people.getSurname());
        myHolder.ageTextView.setText("Age: "+people.getAge());
        myHolder.isDegreeTextView.setText("Degree: "+people.getIsDegree());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class Holder extends RecyclerView.ViewHolder{

        TextView nameTextView;
        TextView  surnameTextView;
        TextView idTextView;
        TextView ageTextView;
        TextView isDegreeTextView;


        public Holder(View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.idTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
            isDegreeTextView = itemView.findViewById(R.id.isDegreeTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surnameTextView = itemView.findViewById(R.id.surnameTextView);
        }
    }

    public void filterList(ArrayList<People> filter) {
        this.itemList = filter;
        notifyDataSetChanged();
    }
}
