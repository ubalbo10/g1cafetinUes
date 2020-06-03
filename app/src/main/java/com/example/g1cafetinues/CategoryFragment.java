package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    ImageView bebidas;
    ImageView comida;
    ImageView cafe;
    ImageView otrosproductos;
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(),"me estoy creando",Toast.LENGTH_LONG).show();
    }



        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_category, container, false);
        bebidas=vista.findViewById(R.id.imageView_bebidas);
        cafe=vista.findViewById(R.id.imageView_Cafe);
        comida=vista.findViewById(R.id.imageView_comida);
        otrosproductos=vista.findViewById(R.id.imageView_otrosproductos);
//        bebidas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                findNavController(v).navigate(R.id.action_categoryFragment_to_elegirProductosFragment2);
//            }
//        });
//        comida.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                findNavController(v).navigate(R.id.action_categoryFragment_to_elegirProductosFragment2);
//            }
//        });
//        cafe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                findNavController(v).navigate(R.id.action_categoryFragment_to_elegirProductosFragment2);
//            }
//        });
//        otrosproductos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                findNavController(v).navigate(R.id.action_categoryFragment_to_elegirProductosFragment2);
//            }
//        });
        return vista;
    }
}
