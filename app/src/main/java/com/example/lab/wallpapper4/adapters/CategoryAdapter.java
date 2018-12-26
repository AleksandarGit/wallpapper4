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
import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter <CategoryAdapter.ViewHolder> {

    private List<Category> categories;
    private Context activity;

    public CategoryAdapter(Context context, List<Category> list){
        categories = list;
        activity = context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCat;
        TextView tvName;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameCard);
            ivCat = itemView.findViewById(R.id.imageCard);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    activity.onItemClicked(categories.indexOf((Category) v.getTag()));
//                }
//            });
        }
    }
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout_element, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(categories.get(i));
        viewHolder.tvName.setText(categories.get(i).getName());
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(viewHolder.itemView.getContext())
                .setDefaultRequestOptions(defaultOptions)
                .load(categories.get(i).getImagePath())
                .into(viewHolder.ivCat);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
