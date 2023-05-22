package com.example.proiectandroid;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Item> list;
    private OnItemClickListener onItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(int index);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public Adapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item currentItem = list.get(position);
        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikes();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likeCount);
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener != null){
                        int index = getAdapterPosition();
                        if(index != RecyclerView.NO_POSITION){
                            onItemClickListener.onItemClick(index);
                        }
                    }
                }
            });

        }
    }
}
