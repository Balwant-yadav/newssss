package com.example.newssss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter extends  RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    ArrayList<modem> list;

    public adapter(Context context, ArrayList<modem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list,parent,false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        modem mod=list.get(position);
        holder.tv.setText(mod.getTitle());
        Picasso.get().load(mod.getUrlToImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            tv=itemView.findViewById(R.id.tv);
        }
    }

}
