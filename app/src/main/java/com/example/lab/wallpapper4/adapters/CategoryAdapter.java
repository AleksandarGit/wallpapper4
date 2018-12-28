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

import com.example.lab.wallpapper4.ImageGrid;
import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private final List<Category> categorys;
    private Context mContext;

    public CategoryAdapter(List<Category> categorys,  Context cContext) {
        this.categorys = categorys;
        this.mContext = cContext;
    }

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        LayoutInflater mInflater =  LayoutInflater.from(mContext);
        v = mInflater.inflate(R.layout.row_layout_element, parent, false);
        return new MyViewHolder(v);
    }

    @Override public void onBindViewHolder(MyViewHolder holder,final int position) {

        holder.name.setText(categorys.get(position).getName());
        Picasso.with(holder.cardView.getContext()).load(categorys.get(position).getImagePath()).into(holder.image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(mContext, ImageGrid.class);
                intent.putExtra("Value1", categorys.get(position).getImagePath());
                mContext.startActivity(intent);
            }
        });
    }

    @Override public int getItemCount() {
        return categorys.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvNameCard);
            image = (ImageView) itemView.findViewById(R.id.imageCard);
            cardView = (CardView) itemView.findViewById(R.id.card_view_row);
        }

    }
}
//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;