package com.devandroid.clucle.recyclerview_tutor.view.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.devandroid.clucle.recyclerview_tutor.R;
import com.devandroid.clucle.recyclerview_tutor.view.item.Item;

import java.util.ArrayList;

public class SanaAdapter extends RecyclerView.Adapter<SanaAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Item> mItems;

    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    public SanaAdapter(ArrayList<Item> items, Context mContext)
    {
        mItems = items;
        context = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sana, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView_ITEM_SANA.setImageResource(mItems.get(position).getImage());
        holder.textView_ITEM_SANA.setText(mItems.get(position).getImageTitle());
        setAnimation(holder.layout_ITEM_SANA, position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_ITEM_SANA;
        TextView textView_ITEM_SANA;
        ConstraintLayout layout_ITEM_SANA;
        ViewHolder(View view) {
            super(view);
            layout_ITEM_SANA = (ConstraintLayout) itemView.findViewById(R.id.layout_ITEM_SANA);
            imageView_ITEM_SANA = (ImageView) itemView.findViewById(R.id.imageView_ITEM_SANA);
            textView_ITEM_SANA = (TextView) itemView.findViewById(R.id.textView_ITEM_SANA);
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
