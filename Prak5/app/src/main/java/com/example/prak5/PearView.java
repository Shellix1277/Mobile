package com.example.prak5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class PearView extends RecyclerView.Adapter<PearView.ItemViewHolder> {
    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textView;
        public ItemViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById((R.id.text_view));

        }
        public void  bind(String item)
        {
         textView.setText(item);
        }

    }
    private Context mContext;
    private ArrayList<String> mPearList;

    public PearView(Context context, ArrayList<String> pearList) {
        mContext = context;
        mPearList = pearList;
    }

    @NonNull
    @Override
    public PearView.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pear_view, parent, false);
        return new PearView.ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String pearName = mPearList.get(position);
        holder.textView.setText(pearName);
        holder.bind(mPearList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPearList.size();
    }


}
