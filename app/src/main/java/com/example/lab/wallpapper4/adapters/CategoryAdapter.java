package com.example.lab.wallpapper4.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.example.lab.wallpapper4.ImageGrid;
import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Category;

import java.util.List;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private final List<Category> categories;
    private Context mContext;
    private RequestManager glide;

    public CategoryAdapter(List<Category> categories, Context cContext, RequestManager glide) {
        this.categories = categories;
        this.mContext = cContext;
        this.glide = glide;
    }

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        LayoutInflater mInflater =  LayoutInflater.from(mContext);
        v = mInflater.inflate(R.layout.row_layout_element, parent, false);
        return new MyViewHolder(v);
    }

    @Override public void onBindViewHolder(MyViewHolder holder,final int position) {

        //holder.name.setText(categories.get(position).getName());
        RequestOptions myOptions = new RequestOptions()
                .placeholder(R.color.colorPrimaryLight)
                .error(R.color.chart_grey)
                .format(PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .signature(new ObjectKey(System.currentTimeMillis() / (24 * 60 * 60 * 1000)));
        glide
                .load(categories.get(position).getImagePath())
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.1f)
                .apply(myOptions)
                .into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(mContext, ImageGrid.class);
                intent.putExtra("Value1", categories.get(position).getImagePath());
                mContext.startActivity(intent);
            }
        });
    }

    @Override public int getItemCount() {
        return categories.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;
        private CardView cardView;

        MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNameCard);
            image = itemView.findViewById(R.id.imageCard);
            cardView = itemView.findViewById(R.id.card_view_row);
        }

    }
}