package com.example.fitnesspersonal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class RutinasFragment extends Fragment {

    public RutinasFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        return inflater.inflate(R.layout.fragment_rutinas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 🔹 Botón "Atrás" que ahora abre el menú lateral
        ImageButton btnBack = view.findViewById(R.id.btnBackRutinas);
        btnBack.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).abrirMenu();
            }
        });

        // 🔹 IDs de las imágenes de las rutinas
        int[] imageIds = {
                R.id.btnImgRutina1, R.id.btnImgRutina2, R.id.btnImgRutina3,
                R.id.btnImgRutina4, R.id.btnImgRutina5, R.id.btnImgRutina6
        };

        // 🔹 Descripciones (tooltips simulados)
        String[] descripciones = {
                "Entrenamiento con pelota y mancuernas para todo el cuerpo",
                "Rutina de yoga en pareja para mejorar flexibilidad y concentración",
                "Ejercicios con mancuernas para fortalecer brazos y espalda",
                "Rutina de estiramiento ideal para después del entrenamiento",
                "Rutina con bandas elásticas para tonificar y ganar fuerza",
                "Ejercicio con cuerda para mejorar resistencia y coordinación"
        };

        // 🔹 Mostrar descripción (tipo tooltip) al tocar la imagen
        for (int i = 0; i < imageIds.length; i++) {
            final int index = i;
            View img = view.findViewById(imageIds[i]);
            img.setOnClickListener(v -> {
                Toast.makeText(getContext(), descripciones[index], Toast.LENGTH_SHORT).show();
            });
        }

        // 🔹 Recursos de imágenes y títulos para pasar al fragmento de ejercicios
        int[] imgIds = {
                R.drawable.rutina1, R.drawable.rutina2, R.drawable.rutina3,
                R.drawable.rutina4, R.drawable.rutina5, R.drawable.rutina6
        };

        String[] titulos = {
                "Ejercicio en casa con pelota y mancuerna",
                "Ejercicio de yoga en pareja",
                "Ejercicio en casa con mancuernas",
                "Ejercicio de estiramiento",
                "Ejercicio en casa con bandas",
                "Ejercicio en casa con cuerda"
        };

        // 🔹 Botones para iniciar cada rutina
        int[] iniciarIds = {
                R.id.btnIniciarRutina1, R.id.btnIniciarRutina2, R.id.btnIniciarRutina3,
                R.id.btnIniciarRutina4, R.id.btnIniciarRutina5, R.id.btnIniciarRutina6
        };

        // 🔹 Acción de navegación al fragmento de ejercicio
        for (int i = 0; i < iniciarIds.length; i++) {
            final int index = i;
            Button iniciarBtn = view.findViewById(iniciarIds[i]);
            iniciarBtn.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("imagen", imgIds[index]);
                bundle.putString("titulo", titulos[index]);
                Navigation.findNavController(v)
                        .navigate(R.id.action_rutinasFragment_to_ejercicioFragment, bundle);
            });
        }
    }
}
