package com.example.administrator.searchview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 4/12/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder>
{
    ArrayList<Country>arrayList=new ArrayList<>();
    RecyclerAdapter(ArrayList<Country>arrayList)
    {
        this.arrayList=arrayList;
    }


    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowe_layout,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position)
    {
        holder.imageView.setImageResource(arrayList.get(position).getFlagid());
        holder.textView.setText(arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyviewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;


        public MyviewHolder(View itemView)
        {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.india);
            textView=(TextView) itemView.findViewById(R.id.text);
        }
    }
    public void setFilter(ArrayList<Country>newlist)
    {
        arrayList=new ArrayList<>();
        arrayList.addAll(newlist);
        notifyDataSetChanged();
    }
}
