package com.example.mits16.myfirstproject.homework6;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private ArrayList<String> itemList = new ArrayList<>();


    public void setItems (ArrayList<String> arrayList){
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

        //myHolder.nameTextView.setText(itemList.get(position).getName());
       // myHolder.surnameTextView.setText((CharSequence) itemList.get(position).getSurname());

       myHolder.nameTextView.setText(itemList.toString());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class Holder extends RecyclerView.ViewHolder{
      //  ImageView imageView;
        TextView nameTextView;
        TextView  surnameTextView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter","Holder");
          //  imageView = itemView.findViewById(R.id.imageView);
            nameTextView =(TextView) itemView.findViewById(R.id.nameTextView);
            surnameTextView = (TextView) itemView.findViewById(R.id.surnameTextView);
        }
    }

}
