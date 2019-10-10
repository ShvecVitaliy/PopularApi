package com.example.mostpopularapi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.mostpopularapi.Client.Client;
import com.example.mostpopularapi.Client.RecyclerViewAdapter;
import com.example.mostpopularapi.Interface.Interface;
import com.example.mostpopularapi.Model.Model;
import com.example.mostpopularapi.Model.Result;
import com.example.mostpopularapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button btn_Emailed, btn_Shared, btn_Viewed;
    private static String token = "2ofq7hEcNMFyRvMFBOT2NVFG0lLlrnUr";

    private LinearLayoutManager layoutManager;
    private List<Result> list = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_Emailed = findViewById(R.id.buttonEmailed);
        btn_Shared = findViewById(R.id.buttonShared);
        btn_Viewed = findViewById(R.id.buttonViewed);

        btn_Emailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmailed();
            }
        });

        btn_Shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getShared();
            }
        });

        btn_Viewed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewed();
            }
        });

    }
    Interface api = Client.getRetrofit().create(Interface.class);

    private void getViewed() {
        Call<Model> call = api.getViewed(token);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                list = response.body().getResults();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

                layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), list);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.v("onFailure", String.valueOf(t));
            }
        });
    }

    private void getShared() {
        Call<Model> call = api.getShared(token);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                list = response.body().getResults();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

                layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), list);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.v("onFailure", String.valueOf(t));
            }
        });
    }

    private void getEmailed() {
        Call<Model> call = api.getEmailed(token);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                list = response.body().getResults();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

                layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), list);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.v("onFailure", String.valueOf(t));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        menu.findItem(R.id.save).setVisible(false);
        menu.findItem(R.id.show_subtitle).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_subtitle:
                Intent intent = new Intent(MainActivity.this, FavouritActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

