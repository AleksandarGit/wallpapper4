package com.example.lab.wallpapper4.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Wallpaper;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter <WallpaperAdapter.ViewHolder> {

    private List<Wallpaper> wallpapers;
    Context activity;


    public WallpaperAdapter(Context context, List<Wallpaper> list){
        wallpapers = list;
        activity = context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivGridElem;
        TextView tvGridElem;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvGridElem = itemView.findViewById(R.id.tvGridElem);
            ivGridElem = itemView.findViewById(R.id.ivGridElem);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    activity.onItemClicked(wallpapers.indexOf((Wallpaper) v.getTag()));
//                }
//            });
        }
    }
    @NonNull
    @Override
    public WallpaperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_element, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(wallpapers.get(i));
        viewHolder.tvGridElem.setText(wallpapers.get(i).getImageName());
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(viewHolder.itemView.getContext())
                .setDefaultRequestOptions(defaultOptions)
                .load(wallpapers.get(i).getImagePath())
                .into(viewHolder.ivGridElem);
    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }
}
