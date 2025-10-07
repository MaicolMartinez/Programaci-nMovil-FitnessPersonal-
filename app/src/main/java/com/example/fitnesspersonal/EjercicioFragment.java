package com.example.fitnesspersonal;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class EjercicioFragment extends Fragment {

    public EjercicioFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ejercicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txt = view.findViewById(R.id.txtTitulo);
        ImageButton btnVolver = view.findViewById(R.id.btnVolver);
        Button btnIniciarRutina = view.findViewById(R.id.btnIniciarRutina);
        VideoView videoView = view.findViewById(R.id.videoView);

        // Configurar el MediaController (controles de reproducción)
        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Obtener la URI del video local
        Uri videoUri = Uri.parse("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.ejer);
        videoView.setVideoURI(videoUri);

        // Botón volver
        btnVolver.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        // Botón iniciar rutina
        btnIniciarRutina.setOnClickListener(v -> {
            txt.setText(txt.getText() + " - ¡Rutina iniciada!");
            videoView.start(); // Reproduce el video solo cuando se presione el botón
        });
    }
}
