package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class AdapterCat extends RecyclerView.Adapter<AdapterCat.ViewHolder> {

    private List<Integer> mImgs;
    private List<String> mNomes;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
        AdapterCat(Context context, List<Integer> Img, List<String> NomeCat) {
        this.mInflater = LayoutInflater.from(context);
        this.mImgs = Img;
        this.mNomes = NomeCat;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_categoria_adapter, parent, false);
        return new ViewHolder(view);
    }
    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int img = mImgs.get(position);
        String nome = mNomes.get(position);
        holder.ImgCat.setImageResource(img);
        holder.NomeCat.setText(nome);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mNomes.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        de.hdodenhof.circleimageview.CircleImageView ImgCat;
        TextView NomeCat;

        ViewHolder(View itemView) {
            super(itemView);
            ImgCat = itemView.findViewById(R.id.CatImg);
            NomeCat = itemView.findViewById(R.id.CatNome);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mNomes.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
