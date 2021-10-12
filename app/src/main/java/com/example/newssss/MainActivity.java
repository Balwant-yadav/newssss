package com.example.newssss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        update();
    }
    void update(){
        try {
            makecall("https://newsapi.org/v2/top-headlines?country=in&apiKey=486f0919e70248f2a6d76e6ce6dc7a37");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void makecall(String url) throws IOException {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String res=response.body().string();
                Gson gson=new Gson();
                api appi=gson.fromJson(res,api.class);
                final  adapter gad=new adapter(getBaseContext(),appi.getArticles());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv.setAdapter(gad);
                        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    }
                });
            }
        });
    }
}