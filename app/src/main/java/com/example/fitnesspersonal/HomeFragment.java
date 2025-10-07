package com.example.fitnesspersonal;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflamos el layout fragment_home.xml
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Referencias a los botones
        Button btnIniciar = view.findViewById(R.id.btnIniciarRutina);
        Button btnYoga = view.findViewById(R.id.btnYoga);
        Button btnCardio = view.findViewById(R.id.btnCardio);

        // Acción para abrir MainActivity
        View.OnClickListener abrirMain = v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        };

        btnIniciar.setOnClickListener(abrirMain);
        btnYoga.setOnClickListener(abrirMain);
        btnCardio.setOnClickListener(abrirMain);

        return view;
    }
}
