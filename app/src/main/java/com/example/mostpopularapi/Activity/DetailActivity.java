package com.example.mostpopularapi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.mostpopularapi.Data.DatabaseHandler;
import com.example.mostpopularapi.Model.Result;
import com.example.mostpopularapi.R;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
       private String url;
       private String title;
       private String id;
    DatabaseHandler databaseHandler = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null){
         title = intent.getStringExtra("title");
            url = intent.getStringExtra("url");
            WebView myWebView = findViewById(R.id.myWebView);
            myWebView.loadUrl(url);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.save:
            databaseHandler.addResult(new Result(title,url));
                List<Result> resultsList = databaseHandler.getAllResult();

            for (Result result : resultsList ){
                Log.d("ResultInfo: ", "ID:"+ result.getId() + ", title" + result.getTitle()+
                        ", url"+ result.getUrl());

            }
                return true;
            case R.id.show_subtitle:
                Intent intent = new Intent(DetailActivity.this, FavouritActivity.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
