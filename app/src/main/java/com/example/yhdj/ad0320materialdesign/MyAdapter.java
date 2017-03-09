package com.example.yhdj.ad0320materialdesign;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yhdj on 2017/3/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<animal> list = new ArrayList<>();
    public MyAdapter(ArrayList<animal> list ){
        this.list = list;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(),AnimalActivity.class);
                int position = holder.getAdapterPosition();
                animal a= list.get(position);
                intent.putExtra(AnimalActivity.ANIMAL_NAME,a.getName());
                intent.putExtra(AnimalActivity.ANIMAL_IAMGE_ID,a.getImage());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        animal a = list.get(position);
        holder.mImageView.setImageResource(a.getImage());
        holder.mTextView.setText(a.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
        private CardView mCardView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mTextView = (TextView) itemView.findViewById(R.id.name);
            mCardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
