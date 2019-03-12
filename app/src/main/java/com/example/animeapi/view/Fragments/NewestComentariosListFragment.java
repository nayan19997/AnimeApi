package com.example.animeapi.view.Fragments;

import com.example.animeapi.view.adapters.ComentarioListFragment;

public class NewestComentariosListFragment extends ComentarioListFragment {
    @Override
    public String setOrder() {
        return "date";
    }

}
