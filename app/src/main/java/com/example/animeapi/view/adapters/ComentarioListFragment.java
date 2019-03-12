package com.example.animeapi.view.adapters;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animeapi.R;
import com.example.animeapi.model.Comentario;
import com.example.animeapi.view.activities.ComentarioViewModel;

import java.util.List;

public abstract class ComentarioListFragment extends Fragment {

    public ComentarioListFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comentario_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.comentarioList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final ComentarioRecyclerAdapter comentarioRecyclerAdapter = new ComentarioRecyclerAdapter();
        recyclerView.setAdapter(comentarioRecyclerAdapter);

        ComentarioViewModel comentarioViewModel = ViewModelProviders.of(this).get(ComentarioViewModel.class);
        comentarioViewModel.getAllPoemsOrderedBy(setOrder()).observe(this, new Observer<List<Comentario>>() {
            @Override
            public void onChanged(@Nullable List<Comentario> comentarios) {
                comentarioRecyclerAdapter.setList(comentarios);
                comentarioRecyclerAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public abstract String setOrder();
}






