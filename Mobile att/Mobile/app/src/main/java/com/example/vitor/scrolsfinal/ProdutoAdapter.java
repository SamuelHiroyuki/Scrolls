package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    private ArrayList<Integer> mpImagens;
    private  ArrayList<String> mpNomes;
    private  ArrayList<String> mpPreco;
    private Context context;


    ProdutoAdapter(Context context, ArrayList<Integer> img, ArrayList<String> nome, ArrayList<String> preco){
        this.context = context;
        this.mpImagens = img;
        this.mpNomes = nome;
        this.mpPreco = preco;
    }

    @Override
    public int getCount() {
        return mpImagens.size();
    }

    @Override
    public Object getItem(int i) {
        return mpNomes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder holder;

        if( convertView == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.produto_adapter_layout, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
       holder.imageView.setImageResource(mpImagens.get(i));
        holder.nome.setText(mpNomes.get(i));
        holder.preco.setText(mpPreco.get(i));

        return view;

    }


    public class ViewHolder {

        final TextView nome;
        final TextView preco;
        final ImageView imageView;

        public ViewHolder(View view) {
            nome = (TextView) view.findViewById(R.id.ProdNomelyt);
            preco = (TextView) view.findViewById(R.id.ProdPrecolyt);
            imageView = (ImageView) view.findViewById(R.id.ProdImagemlyt);
        }

    }
}

