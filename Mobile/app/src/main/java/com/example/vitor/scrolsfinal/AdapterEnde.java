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

public class AdapterEnde extends RecyclerView.Adapter<AdapterEnde.ViewHolder> {

    public List<String> mNomes;
    public List<String> mNumeros;
    public List<String> mCeps;
    public List<String> mCidades;
    public List<String> mBairros;
    public List<String> mUfs;
    public Context mContext;
    public LayoutInflater mInflater;

    AdapterEnde (Context context,List<String> Nomes,List<String> Numeros,List<String> Ceps,List<String> Cidades,List<String> Bairros,List<String> Ufs){
        this.mNomes = Nomes;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mNumeros = Numeros;
        this.mCeps = Ceps;
        this.mBairros = Bairros;
        this.mCidades = Cidades;
        this.mUfs = Ufs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.layout_categoria_adapter, viewGroup, false);
        return new AdapterEnde.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String Nome = mNomes.get(i);
        String Num = mNumeros.get( i);
        String Cep = mCeps.get(i);
        String Bairro = mBairros.get(i);
        String Cidade = mCidades.get(i);
        String Uf = mUfs.get(i);

        viewHolder.txtEnde.setText(Nome);
        viewHolder.txtUf.setText(Uf);
        viewHolder.txtNume.setText(Num);
        viewHolder.txtCidade.setText(Cidade);
        viewHolder.txtCep.setText(Cep);
        viewHolder.txtBairro.setText(Bairro);
        viewHolder.imgLixo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //codigo pra confirmar se quer apagar
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCeps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtEnde,txtNume,txtCep,txtBairro,txtCidade,txtUf;
        private ImageView imgLixo;
        private AdapterCat.ItemClickListener listener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBairro = (TextView) itemView.findViewById(R.id.BairroEndereço);
            txtCep = (TextView) itemView.findViewById(R.id.CepEndereço);
            txtCidade = (TextView) itemView.findViewById(R.id.CidadeEndereço);
            txtEnde = (TextView) itemView.findViewById(R.id.NomeEndereco);
            txtNume = (TextView) itemView.findViewById(R.id.NumeroEndereço);
            txtUf = (TextView)itemView.findViewById(R.id.UfEndereço);
            imgLixo = (ImageView) itemView.findViewById(R.id.LixoEndereco);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
        public String getItem(int id) {
            return mCeps.get(id);
        }

        public void setItemClickListener(AdapterCat.ItemClickListener itemClickListener ) {
            this.listener = itemClickListener;
        }

    }
    public interface ItemClickListener {
        void onClick(View view, int position);
    }
    }
