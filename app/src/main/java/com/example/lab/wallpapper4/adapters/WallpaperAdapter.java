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

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.example.lab.wallpapper4.ImageSolo;
import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Wallpaper;

import java.util.List;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.MyViewHolder> {
    private List<Wallpaper> wallpapers;
    private Context activity;
    private RequestManager glide;


    public WallpaperAdapter(Context context, RequestManager glide, List<Wallpaper> list) {
        wallpapers = list;
        activity = context;
        this.glide = glide;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGridElem;
        CardView cardView;

         MyViewHolder(@NonNull final View itemView) {
            super(itemView);
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
        RequestOptions myOptions = new RequestOptions()
                .placeholder(R.color.colorPrimaryLight)
                .error(R.color.chart_grey)
                .format(PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .signature(new ObjectKey(System.currentTimeMillis() / (24 * 60 * 60 * 1000)));
        glide
                .load(wallpapers.get(i).getImagePath())
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.1f)
                .apply(myOptions)
                .into(viewHolder.ivGridElem);
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
