package com.example.cardetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private List<App> apps;
    public CustomAdapter(Context context, List<App> apps){
        this.context =  context;
        this.apps = apps;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView carname;
        ImageView carimage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carname =itemView.findViewById(R.id.name);
            carimage= itemView.findViewById(R.id.image);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        App app = apps.get(position);
        holder.carname.setText(app.getName());
        holder.carimage.setImageResource(app.getImage());
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

}
