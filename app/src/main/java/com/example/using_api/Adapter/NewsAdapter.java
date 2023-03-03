package com.example.using_api.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.using_api.Model.News;
import com.example.using_api.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> news;
    private Context context;

    public NewsAdapter(List<News> news ,Context context){
        this.news=news;
        this.context=context;
    }


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        return new NewsAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        final News news1 = news.get(position);

        holder.title.setText(news1.getTitle());
        holder.Description.setText(news1.getDescription());
        holder.publish_date.setText(news1.getPublish_date());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Get more news", Toast.LENGTH_SHORT).show();
            }
        });


    }



    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,Description , publish_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            Description=itemView.findViewById(R.id.description);
            publish_date=itemView.findViewById(R.id.publish_date);
        }
    }
}
