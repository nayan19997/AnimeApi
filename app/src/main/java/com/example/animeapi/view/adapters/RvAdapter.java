package com.example.animeapi.view.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.animeapi.R;
import com.example.animeapi.model.Peli;
import com.example.animeapi.view.Fragments.PeliculasFragment;
import com.example.animeapi.view.activities.PelisActivity;
import com.example.animeapi.view.activities.PelisDesciptoinActivity;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions options ;
    private PeliculasFragment mContext ;
    private List<Peli> mData ;


    public RvAdapter(PeliculasFragment mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

    }

    public RvAdapter(PelisActivity pelisActivity, List<Peli> lst) {
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        final View view ;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.item_pelis,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(parent.getContext(),PelisDesciptoinActivity.class);
                intent.putExtra("peli_id",mData.get(viewHolder.getAdapterPosition()).getId());
                intent.putExtra("pelis_name",mData.get(viewHolder.getAdapterPosition()).getTitle());
                intent.putExtra("pelis_director",mData.get(viewHolder.getAdapterPosition()).getDirector());
                intent.putExtra("pelis_producer",mData.get(viewHolder.getAdapterPosition()).getProducer());
                intent.putExtra("pelis_release_date",mData.get(viewHolder.getAdapterPosition()).getRelease_date());
                intent.putExtra("pelis_description",mData.get(viewHolder.getAdapterPosition()).getDescription());

                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_id.setText(mData.get(position).getId());
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_director.setText(mData.get(position).getDirector());
        holder.tv_producer.setText(mData.get(position).getProducer());
        holder.tv_release_date.setText(mData.get(position).getRelease_date());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id,tv_title,tv_director,tv_producer,tv_release_date;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container= itemView.findViewById(R.id.container);
            tv_id = itemView.findViewById(R.id.id);
            tv_title = itemView.findViewById(R.id.title);
            tv_director = itemView.findViewById(R.id.director);
            tv_producer = itemView.findViewById(R.id.producer);
            tv_release_date = itemView.findViewById(R.id.release_date);


        }
    }


}