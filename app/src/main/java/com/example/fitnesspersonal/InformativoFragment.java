package com.example.fitnesspersonal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

public class InformativoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informativo, container, false);

        // Toolbar con botón que abre el menú lateral
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).abrirMenu();
            }
        });

        // Tarjetas de enlaces
        MaterialCardView cardArticulos = view.findViewById(R.id.card_articulos);
        MaterialCardView cardPodcast = view.findViewById(R.id.card_podcast);
        MaterialCardView cardGuias = view.findViewById(R.id.card_guias);

        cardArticulos.setOnClickListener(v -> abrirEnlace("https://www.who.int/es/news-room/fact-sheets/detail/physical-activity"));
        cardPodcast.setOnClickListener(v -> abrirEnlace("https://www.youtube.com/watch?v=r0dbUGIiiSE"));
        cardGuias.setOnClickListener(v -> abrirEnlace("https://share.google/tQDqw8NXlFA4Imfs7"));

        return view;
    }

    private void abrirEnlace(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
