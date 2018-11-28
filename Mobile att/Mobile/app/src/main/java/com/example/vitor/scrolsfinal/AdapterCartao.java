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

public class AdapterCartao extends RecyclerView.Adapter<AdapterCartao.ViewHolder> {
    private List<String> mNomes;
    private List<String> mEmpresa;
    private List<String> mNumeros;
    private LayoutInflater mInflater;
    private Context mContext;

     AdapterCartao(Context context,List<String> nomes, List<String> empresa, List<String> numeros) {
         this.mInflater = LayoutInflater.from(context);
         this.mContext = context;
         this.mEmpresa = empresa;
         this.mNomes = nomes;
         this.mNumeros = numeros;
     }


    @NonNull
    @Override
    public AdapterCartao.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View view = mInflater.inflate(R.layout.layout_cartao, viewGroup, false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCartao.ViewHolder viewHolder, int i) {
         String nome = mNomes.get(i);
         String empresa = mEmpresa.get(i);
         String numero = mNumeros.get(i);

         viewHolder.txtNum.setText(numero);
         viewHolder.txtEmp.setText(empresa);
         viewHolder.txtNome.setText(nome);

         viewHolder.lixo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //codigo posterior para aparecer se o cara quer mesmo deletar esse cartão
             }
         });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNome,txtNum,txtEmp;
        AdapterCartao.ItemClickListener listener;
        ImageView lixo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.NomeCartão);
            txtEmp = (TextView) itemView.findViewById(R.id.EmpresaCartão);
            txtNum = (TextView) itemView.findViewById(R.id.NumCartão);
            lixo = (ImageView) itemView.findViewById(R.id.ImgLixo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }

        public String getItem(int id) {
            return mNomes.get(id);
        }

        public void setItemClickListener(AdapterCartao.ItemClickListener itemClickListener ) {
            this.listener = itemClickListener;
        }
    }
    public interface ItemClickListener {
        void onClick(View view, int position);
    }
}
