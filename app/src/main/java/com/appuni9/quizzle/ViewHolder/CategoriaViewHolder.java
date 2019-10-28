package com.appuni9.quizzle.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appuni9.quizzle.Interface.ItemCLickListener;
import com.appuni9.quizzle.R;

public class CategoriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView categoria_nome;
    public ImageView categoria_imagem;

    public ItemCLickListener itemClickListener;

    public CategoriaViewHolder(@NonNull View itemView) {
        super(itemView);
        categoria_imagem = (ImageView)itemView.findViewById(R.id.categoria_imagem);
        categoria_nome = (TextView)itemView.findViewById(R.id.categoria_nome);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemCLickListener itemCLickListener){
        this.itemClickListener = itemCLickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
