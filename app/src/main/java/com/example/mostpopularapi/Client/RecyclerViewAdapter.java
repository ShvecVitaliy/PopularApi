package com.example.mostpopularapi.Client;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mostpopularapi.Activity.DetailActivity;
import com.example.mostpopularapi.Model.Result;
import com.example.mostpopularapi.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    private List<Result> item;
    private Context context;


    public RecyclerViewAdapter(Context context, List<Result> item) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");

            View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Log.i("autolog", "onBindViewHolder");

            holder.title.setText(item.get(position).getTitle());
            holder.url.setText(item.get(position).getUrl());



    }

    @Override
    public int getItemCount() {
        Log.i("autolog", "getItemCount");
        return item.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView url, title, id;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);

                    intent.putExtra("title",  title.getText());
                    intent.putExtra("url",  url.getText());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);
                }
            });
            Log.i("autolog", "ViewHolder");
            title = (TextView) itemView.findViewById(R.id.titleTextView);
            url = (TextView) itemView.findViewById(R.id.urlTextView);
        }
    }
    }

