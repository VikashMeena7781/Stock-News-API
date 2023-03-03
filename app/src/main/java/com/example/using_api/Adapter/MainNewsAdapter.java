package com.example.using_api.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.using_api.Model.MainNews;
import com.example.using_api.Model.News;
import com.example.using_api.R;

import java.util.List;

public class MainNewsAdapter extends RecyclerView.Adapter<MainNewsAdapter.ViewHolder> {

    private List<MainNews> mainNews;
    private Context context;

    public MainNewsAdapter(List<MainNews> mainNews ,Context context){
        this.mainNews=mainNews;
        this.context=context;
    }
    @NonNull
    @Override
    public MainNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_news_item,parent,false);
        return new ViewHolder(view);
    }



    public void onBindViewHolder(@NonNull  MainNewsAdapter.ViewHolder holder, int position) {
        final MainNews mainNews1 = mainNews.get(position);

        holder.title1.setText(mainNews1.getTitle());
        holder.link1.setText(mainNews1.getLink());
        holder.pubDate1.setText(mainNews1.getPubDate());
        holder.source1.setText(mainNews1.getSource());
        holder.guid1.setText(mainNews1.getGuid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Get more news", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainNews.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title1,link1,pubDate1,source1,guid1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1=itemView.findViewById(R.id.title1);
            link1=itemView.findViewById(R.id.link1);
            pubDate1=itemView.findViewById(R.id.pubDate1);
            source1=itemView.findViewById(R.id.source1);
            guid1=itemView.findViewById(R.id.guid1);

        }
    }
}
