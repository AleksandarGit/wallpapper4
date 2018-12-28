package com.example.lab.wallpapper4.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab.wallpapper4.ImageSolo;
import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Wallpaper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.MyViewHolder> {
    private List<Wallpaper> wallpapers;
    private Context activity;


    public WallpaperAdapter(Context context, List<Wallpaper> list) {
        wallpapers = list;
        activity = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGridElem;
        TextView tvGridElem;
        CardView cardView;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvGridElem = itemView.findViewById(R.id.tvGridElem);
            ivGridElem = itemView.findViewById(R.id.ivGridElem);
            cardView = itemView.findViewById(R.id.card_view_grid);
        }
    }

    @NonNull
    @Override
    public WallpaperAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.grid_element, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperAdapter.MyViewHolder viewHolder, final int i) {
        viewHolder.tvGridElem.setText(wallpapers.get(i).getImageName());
        Picasso.with(viewHolder.cardView.getContext()).load(wallpapers.get(i).getImagePath()).into(viewHolder.ivGridElem);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ImageSolo.class);
                intent.putExtra("Value1", wallpapers.get(i).getImagePath());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }

}
