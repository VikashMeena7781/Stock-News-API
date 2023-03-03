//package com.example.using_api;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.example.using_api.Adapter.NewsAdapter;
//import com.example.using_api.Model.News;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class MainActivity extends AppCompatActivity {
//    RecyclerView recyclerView;
//
//    Button getnews;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recycler_view);
//        getnews=findViewById(R.id.news);
//
//        getnews.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CompletableFuture<String> futureResult = null;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    futureResult = CompletableFuture.supplyAsync(() -> {
//                        try {
//                            Log.d("msg","Hello");
//                            return callFinanceAPI("https://mboum-finance.p.rapidapi.com/ne/news/?symbol=AAPL%2CMSFT");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            return null;
//                        }
//                    });
//                }
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
////                    futureResult.thenAcceptAsync(this::onResponse);
//                    futureResult.thenAcceptAsync(result -> {
//                        try {
//                            JSONObject resultJson = new JSONObject(result);
//                            List<News> newsList = new ArrayList<>();
//                            JSONArray jsonArray = resultJson.getJSONArray("item");
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                News news = new News();
//                                news.setTitle(jsonArray.getJSONObject(i).getString("title"));
//                                news.setDescription(jsonArray.getJSONObject(i).getString("description"));
//                                news.setPublish_date(jsonArray.getJSONObject(i).getString("pubDate"));
//                                newsList.add(news);
//                            }
//                            NewsAdapter newsAdapter = new NewsAdapter(newsList,getApplicationContext());
//                            recyclerView.setAdapter(newsAdapter);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(), "Oops!! something went wrong, please try again", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                }
//
//
//            }
//
//
//        });
//
////        recyclerView.
//    }
//
//    private String callFinanceAPI(String apiUrl) throws Exception {
//        URL url = new URL(apiUrl);
////        Log.d("msg","Hii");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        // set headers for the request
//        // set host name
//        connection.setRequestProperty("X-RapidAPI-Host", "mboum-finance.p.rapidapi.com");
//
//        // set the rapid-api key
////        Log.d("msg","Hii_2");
//        connection.setRequestProperty("X-RapidAPI-Key", "18c935d513msh8cff4fe15c38f82p17f7aejsnef2a8a9efb44");
//        connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
//        // set the request method - POST
//        connection.setRequestMethod("POST");
//        Log.d("msg","Hello_3");
//        Log.d("msg", String.valueOf(connection.getInputStream()));
//        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
//        Log.d("msg","Hii_5");
//
//
//
//        // read the response data
//        int data = inputStreamReader.read();
//        Log.d("msg","Hii_4");
//        StringBuilder result = new StringBuilder();
//        while (data != -1) {
//            char current = (char) data;
//            result.append(current);
//            data = inputStreamReader.read();
//        }
//        Log.d("msg",result.toString());
//        return result.toString();
//    }
//
//    private void onResponse(String result) {
//        try {
//            // convert the string to JSON object for better reading
//            JSONObject resultJson = new JSONObject(result);
//
//            // Initialize prediction text
////            String prediction = "Today's prediction \n";
////            prediction += this.sunSign + "\n";
//            List<News> newsList = new ArrayList<>();
//
//            JSONArray jsonArray = resultJson.getJSONArray("item");
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                News news = new News();
//                news.setTitle(jsonArray.getJSONObject(i).getString("title"));
//                news.setDescription(jsonArray.getJSONObject(i).getString("description"));
//                news.setPublish_date(jsonArray.getJSONObject(i).getString("pubDate"));
//                newsList.add(news);
//
//            }
//
//            NewsAdapter newsAdapter = new NewsAdapter(newsList,getApplicationContext());
//            recyclerView.setAdapter(newsAdapter);
//
////            News news = new News();
////            news.setTitle(resultJson.getString("title"));
////            news.setDescription(resultJson.getString("description"));
////            news.setPublish_date(resultJson.getString("pubDate"));
//
//
//
//            // Update text with various fields from response
////            prediction += resultJson.getString("current_date") + "\n\n";
////            prediction += resultJson.getString("description");
//
//
//            // Update the prediction to the view
////            setText(this.resultView, prediction);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
////            this.resultView.setText("Oops!! something went wrong, please try again");
//            Toast.makeText(this, "Oops!! something went wrong, please try again", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//
//}


package com.example.using_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.using_api.Adapter.NewsAdapter;
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

    Button getnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getnews=findViewById(R.id.news);

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

    }



}


