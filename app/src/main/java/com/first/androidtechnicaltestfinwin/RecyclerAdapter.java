package com.first.androidtechnicaltestfinwin;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Details> arrayList = new ArrayList<>();
    Integer idd = 0;

    public RecyclerAdapter(ArrayList<Details> arrayList)
    {
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.turl.setText(arrayList.get(position).getTurl());
        holder.tthumburl.setText(arrayList.get(position).getThumburl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = position+1;
                Intent intent = new Intent(view.getContext(),Seperate.class);
                intent.putExtra("pos",id);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,turl,tthumburl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ttitle);
            turl = (TextView) itemView.findViewById(R.id.turl);
            tthumburl = (TextView) itemView.findViewById(R.id.thumburl);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                 Intent intent = new Intent(view.getContext(),Seperate.class);
//
//                 view.getContext().startActivity(intent);
//                }
//            });
        }
    }
}
