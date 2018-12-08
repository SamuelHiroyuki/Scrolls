package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterFinalizar extends RecyclerView.Adapter<AdapterFinalizar.ViewHolder> {

private List<Integer> mImgs;
private List<String> mNomes;
private List<Integer> mPreco;
private LayoutInflater mInflater;
private Context mContect;

        // data is passed into the constructor
        AdapterFinalizar(Context context, List<Integer> Img, List<String> NomeProd, List<Integer> PrecoProd) {
            this.mContect = context;
        this.mInflater = LayoutInflater.from(context);
        this.mImgs = Img;
        this.mNomes = NomeProd;
        this.mPreco = PrecoProd;
        }

// inflates the row layout from xml when needed
@Override
@NonNull
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.produto_adapter_layout, parent, false);
        return new ViewHolder(view);
        }
// binds the data to the view and textview in each row
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int img = mImgs.get(position);
        final String nome = mNomes.get(position);
        String preco = mPreco.get(position).toString();
        holder.ImgPrd.setImageResource(img);
        holder.NomeProd.setText(nome);
        holder.PrecoProd.setText(preco);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(mContect, ProdutoInfoActivity.class);
                intent.putExtra("NomeProd",nome);
                mContect.startActivity(intent);
            }

        });
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
    ItemClickListener listener;
    EditText edtQuant;

    ViewHolder(View itemView) {
        super(itemView);
        ImgPrd = itemView.findViewById(R.id.ProdImagemlyt);
        NomeProd = itemView.findViewById(R.id.ProdNomelyt);
        PrecoProd = itemView.findViewById(R.id.ProdPrecolyt);
        itemView.setOnClickListener(this);
        edtQuant = itemView.findViewById(R.id.ProdQuantlyt);

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

public List<Integer> retornaQuant(int i){
            List<Integer> resp = new ArrayList<>();
            return resp;
}
}

