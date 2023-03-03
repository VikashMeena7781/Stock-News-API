package com.example.using_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.using_api.Adapter.MainNewsAdapter;
import com.example.using_api.Adapter.NewsAdapter;
import com.example.using_api.Model.MainNews;
import com.example.using_api.Model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    NewsAdapter newsAdapter;
    MainNewsAdapter mainNewsAdapter;

    Button getnews;
    Button getMainNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getnews=findViewById(R.id.news);
        getMainNews=findViewById(R.id.mainNews);

        getnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://mboum-finance.p.rapidapi.com/ne/news/?symbol=AAPL%2CMSFT")
                        .get()
                        .addHeader("x-rapidapi-host", "mboum-finance.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "18c935d513msh8cff4fe15c38f82p17f7aejsnef2a8a9efb44")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (!response.isSuccessful()) {
                            throw new IOException("Unexpected code " + response);
                        }

                        String responseString = response.body().string();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject resultJson = new JSONObject(responseString);
                                    List<News> newsList = new ArrayList<>();
                                    JSONArray jsonArray = resultJson.getJSONArray("item");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        News news = new News();
                                        news.setTitle(jsonArray.getJSONObject(i).getString("title"));
                                        news.setDescription(jsonArray.getJSONObject(i).getString("description"));
                                        news.setPublish_date(jsonArray.getJSONObject(i).getString("pubDate"));
                                        newsList.add(news);
                                    }
                                    newsAdapter = new NewsAdapter(newsList,MainActivity.this);
                                    recyclerView.setAdapter(newsAdapter);
                                    Log.d("msg", String.valueOf(newsList.size()));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(getApplicationContext(), "Oops!! something went wrong, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }

        });

        getMainNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://mboum-finance.p.rapidapi.com/ne/news")
                        .get()
                        .addHeader("X-RapidAPI-Key", "b8457a3c19msh6b8f44d876294c3p1e11dbjsnb5f81e2e8e41")
                        .addHeader("X-RapidAPI-Host", "mboum-finance.p.rapidapi.com")
                        .build();

               client.newCall(request).enqueue(new Callback() {
                   @Override
                   public void onFailure(Call call, IOException e) {
                       e.printStackTrace();
                   }

                   @Override
                   public void onResponse(Call call,Response response) throws IOException {
                       if (!response.isSuccessful()) {
                           throw new IOException("Unexpected code " + response);
                       }
                       String responseString = response.body().string();

                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               try{
                                   JSONArray resultJson = new JSONArray(responseString);
                                   List<MainNews> mainNewsList = new ArrayList<>();
                                  // JSONArray jsonArray = resultJson.getJSONArray("item");
                                   for (int i = 0; i < resultJson.length(); i++){
                                       MainNews mainNews = new MainNews();
                                       mainNews.setTitle(resultJson.getJSONObject(i).getString("title"));
                                       mainNews.setLink(resultJson.getJSONObject(i).getString("link"));
                                       mainNews.setPubDate(resultJson.getJSONObject(i).getString("pubDate"));
                                       mainNews.setSource(resultJson.getJSONObject(i).getString("source"));
                                       mainNews.setGuid(resultJson.getJSONObject(i).getString("guid"));
                                       mainNewsList.add(mainNews);

                                   }
                                   mainNewsAdapter = new MainNewsAdapter(mainNewsList, MainActivity.this);
                                   recyclerView.setAdapter(mainNewsAdapter);
                                   Log.d("msg", String.valueOf(mainNewsList.size()));
                               } catch (JSONException e) {
                                   e.printStackTrace();
                                   Toast.makeText(getApplicationContext(), "Oops!! something went wrong, please try again", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                   }
               });
            }
        });

    }



}


