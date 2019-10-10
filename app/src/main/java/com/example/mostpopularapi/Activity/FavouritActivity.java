package com.example.mostpopularapi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.mostpopularapi.Client.RecyclerViewAdapter;
import com.example.mostpopularapi.Data.DatabaseHandler;
import com.example.mostpopularapi.Model.Result;
import com.example.mostpopularapi.R;

import java.util.List;

public class FavouritActivity extends AppCompatActivity {
    DatabaseHandler databaseHandler = new DatabaseHandler(this);
    private String url;
    private String title;
    private String kay;

    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourit);

        List<Result> resultsList = databaseHandler.getAllResult();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(FavouritActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), resultsList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        menu.findItem(R.id.save).setVisible(false);
        menu.findItem(R.id.show_subtitle).setVisible(false);
        return true;
    }
}
