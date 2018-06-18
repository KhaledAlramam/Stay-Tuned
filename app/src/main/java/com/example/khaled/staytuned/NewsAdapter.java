package com.example.khaled.staytuned;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khaled.staytuned.model.Field;
import com.example.khaled.staytuned.model.GlideApp;
import com.example.khaled.staytuned.model.Results;

import java.util.List;

/**
 * Created by khaled on 6/17/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {


    private List<Results> news;
    private Context context;
    CustomItemClickListener listener;

    public NewsAdapter(List<Results> news,CustomItemClickListener listener){
        this.news=news;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,myViewHolder.getAdapterPosition());
            }
        });
        context=parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Results result=news.get(position);
        Field field=result.getField();
        String url=result.getWebUrl();
        String thumbnailLink=field.getThumbnail();
        holder.newsTitle.setText(result.getWebTitle());
        GlideApp
                .with(context)
                .load(thumbnailLink)
                .centerCrop()
                .into(holder.newsThumbnail);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView newsTitle;
        ImageView newsThumbnail;
        public MyViewHolder(View view){
            super(view);
            newsThumbnail=view.findViewById(R.id.news_thumbnail);
            newsTitle=view.findViewById(R.id.news_title);
        }
    }
}
