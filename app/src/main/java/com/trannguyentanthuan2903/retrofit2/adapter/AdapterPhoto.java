package com.trannguyentanthuan2903.retrofit2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.trannguyentanthuan2903.retrofit2.R;
import com.trannguyentanthuan2903.retrofit2.models.Photo;

import java.util.List;

/**
 * Created by Administrator on 12/28/2017.
 */

public class AdapterPhoto extends RecyclerView.Adapter<AdapterPhoto.ViewHolder>  {

    private Context mContext;
    private LayoutInflater inflater;
    private List<Photo> arrayPhoto;

    public AdapterPhoto(Context mContext, List<Photo> arrayPhoto) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.arrayPhoto = arrayPhoto;
    }

    @Override
    public AdapterPhoto.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_photo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPhoto.ViewHolder holder, int position) {
        Picasso.with(mContext).load(arrayPhoto.get(position).getImageUrl()).error(R.drawable.no_image).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return arrayPhoto.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public ViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
