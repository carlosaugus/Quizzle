package com.appuni9.quizzle.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appuni9.quizzle.Interface.ItemCLickListener;
import com.appuni9.quizzle.Model.Categoria;
import com.appuni9.quizzle.R;
import com.appuni9.quizzle.ViewHolder.CategoriaViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class CategoriaFragment extends Fragment {
    View fragment;

    RecyclerView listCategoria;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Categoria, CategoriaViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference categorias;

    public static CategoriaFragment newInstance(){
        CategoriaFragment categoriaFragment = new CategoriaFragment();
        return categoriaFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        categorias = database.getReference("Categorias");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragment = inflater.inflate(R.layout.fragment_categoria, container, false);

        listCategoria = (RecyclerView)fragment.findViewById(R.id.listCategoria);
        listCategoria.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listCategoria.setLayoutManager(layoutManager);

        loadCategoria();

        return fragment;
    }

    private void loadCategoria() {
        adapter = new FirebaseRecyclerAdapter<Categoria, CategoriaViewHolder>(
                Categoria.class,
                R.layout.categoria_layout,
                CategoriaViewHolder.class,
                categorias
        ) {
            @Override
            protected void populateViewHolder(CategoriaViewHolder viewHolder, final Categoria categoria, int i) {
                viewHolder.categoria_nome.setText(categoria.getNome());
                Picasso.with(getActivity()).load(categoria.getImagem()).into(viewHolder.categoria_imagem);
                viewHolder.setItemClickListener(new ItemCLickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        super.onClick(view, position, isLongClick);
                        Intent gameActivity = new Intent(getActivity(), GameActivity.class);
                        gameActivity.putExtra("categoriaId", position);
                        getActivity().startActivity(gameActivity);
                    }
                });
            }
        };

        adapter.notifyDataSetChanged();
        listCategoria.setAdapter(adapter);

    }
}
