package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterPedidos extends RecyclerView.Adapter<AdapterPedidos.ViewHolder> {

private List<Integer> mImgs;
private List<String> mNomes;
private List<String> mPreco;
private List<String> mQuant;
private LayoutInflater mInflater;
private Context mContect;

        // data is passed into the constructor
        AdapterPedidos(Context context, List<Integer> Img, List<String> NomeProd, List<String> PrecoProd, List<String> quantidades) {
            this.mContect = context;
        this.mInflater = LayoutInflater.from(context);
        this.mImgs = Img;
        this.mNomes = NomeProd;
        this.mPreco = PrecoProd;
        this.mQuant = quantidades;
        }

// inflates the row layout from xml when needed
@Override
@NonNull
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_pedido_adapter, parent, false);
        return new ViewHolder(view);
        }
// binds the data to the view and textview in each row
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int img = mImgs.get(position);
        String nome = mNomes.get(position);
        String preco = mPreco.get(position);
        String quant = mQuant.get(position);
        holder.ImgPrd.setImageResource(img);
        holder.NomeProd.setText(nome);
        holder.PrecoProd.setText(preco);

        }

// total number of rows
@Override
public int getItemCount() {
        return mNomes.size();
        }

// stores and recycles views as they are scrolled off screen

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView ImgPrd;
    TextView NomeProd;
    TextView PrecoProd;
    TextView QuantProd;
    ItemClickListener listener;

    ViewHolder(View itemView) {
        super(itemView);
        ImgPrd = itemView.findViewById(R.id.ImagePedidos);
        NomeProd = itemView.findViewById(R.id.NomePedidos);
        PrecoProd = itemView.findViewById(R.id.PrecoPedidos);
        QuantProd = itemView.findViewById(R.id.QuantPedidos);
        itemView.setOnClickListener(this);

    }
        public void setItemClickListener(ItemClickListener itemClickListener ) {
            this.listener = itemClickListener;
        }

    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition());
    }

    }

    public String getItem(int id) {
        return mNomes.get(id);
    }


public interface ItemClickListener {
    void onClick(View view, int position);
}
}

