package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.g1cafetinues.interfaces.DatosFactura;
import com.example.g1cafetinues.interfaces.Factura;
import com.example.g1cafetinues.interfaces.Facturas;

import java.util.ArrayList;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElegirProductosFragment extends Fragment implements DatosFactura {


    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //categoria
    ImageView bebidas;
    ImageView comida;
    ImageView cafe;
    ImageView otrosproductos;

    //simulando el arraylist
    ArrayList<String> productos=new ArrayList<String>();
    //pantallas
    LinearLayout pantallaCategoria;
    LinearLayout pantallaProducto;
    //botones
    Button aceptar;
    Button irCategorias;
    //Factura listenerFactura;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String producto1="COCA COLA 1.25LTS";
        String producto2="PEPSI 1.25LTS";
        String producto3="COCOA";
        String producto4="CHOCOBANANO";
        String producto5="CARNE ASADA";
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto1);
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_elegir_productos, container, false);
        irCategorias=vista.findViewById(R.id.button_verCategoria);
        aceptar=vista.findViewById(R.id.button_aceptar_productos);
        //llamar recyclerview//
        recycler=vista.findViewById(R.id.Recycler_productos);
        recycler.setHasFixedSize(true);
        //grip es para poder ponerle columnas
        //layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorProductos(productos,this);
        recycler.setAdapter(mAdapter);
        //FIN DE RECYCLER//

        //visibilidad al entrar
        pantallaCategoria=vista.findViewById(R.id.pantalla_categoria);
        pantallaProducto=vista.findViewById(R.id.pantalla_productos);
        pantallaProducto.setVisibility(View.GONE);
        pantallaCategoria.setVisibility(View.VISIBLE);
        /*  */

        //logica de las categorias
        bebidas=vista.findViewById(R.id.imageView_bebidas);
        cafe=vista.findViewById(R.id.imageView_Cafe);
        comida=vista.findViewById(R.id.imageView_comida);
        otrosproductos=vista.findViewById(R.id.imageView_otrosproductos);
        bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);


            }
        });
        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);

            }
        });
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);

            }
        });
        otrosproductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);

            }
        });
        irCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaProducto.setVisibility(View.GONE);
                pantallaCategoria.setVisibility(View.VISIBLE);

            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mandar a llamar el otro fragmento donde se detallara los productos
                //listenerFactura.enviarFactura();
                Facturas.prueba="cambiado";
                findNavController(v).navigate(R.id.action_elegirProductosFragment2_to_facturaFragment);


            }
        });


        return vista;
    }



    @Override
    public void addDatos() {

        Toast.makeText(requireActivity(), "me estan agregando", Toast.LENGTH_SHORT).show();
    }


}
