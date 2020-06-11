package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.g1cafetinues.Adaptadores.AdaptadorProductos;
import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Producto;
import com.example.g1cafetinues.clases.ProductoApi;
import com.example.g1cafetinues.clases.Usuario;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.DatosFactura;
import com.example.g1cafetinues.interfaces.DatosUsuarioActivo;
import com.example.g1cafetinues.interfaces.Facturas;
import com.example.g1cafetinues.interfaces.LocalSeleccionado;
import com.example.g1cafetinues.interfaces.UrlApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElegirProductosFragment extends Fragment implements DatosFactura {


    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Retrofit retrofit;

    //categoria
    ImageView bebidas;
    ImageView comida;
    ImageView cafe;
    ImageView otrosproductos;

    //simulando el arraylist
    ArrayList<ProductoApi> productos=new ArrayList<ProductoApi>();
    //pantallas
    LinearLayout pantallaCategoria;
    LinearLayout pantallaProducto;
    //botones
    Button aceptar;
    Button irCategorias;
    //Factura listenerFactura;
    ArrayList<Producto> detalleFactura= new ArrayList<Producto>();







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String idselecionado= LocalSeleccionado.Idlocal.toString();
        Toast.makeText(requireActivity(), idselecionado, Toast.LENGTH_SHORT).show();
        /* datos quemados
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
        */
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_elegir_productos, container, false);
        irCategorias=vista.findViewById(R.id.button_verCategoria);
        aceptar=vista.findViewById(R.id.button_aceptar_productos);
        recycler=vista.findViewById(R.id.Recycler_productos);

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
                DatosUsuarioActivo.categoria="bebidas";
                ConsultarProductos();


            }
        });
        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);
                DatosUsuarioActivo.categoria="comida";
                ConsultarProductos();
            }
        });
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);
                DatosUsuarioActivo.categoria="cafe";
                ConsultarProductos();
            }
        });
        otrosproductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cuando se tenga los ws aqui se debe de hacer la consulta solo a bebidas

                //jugar con las visibilidades
                pantallaProducto.setVisibility(View.VISIBLE);
                pantallaCategoria.setVisibility(View.GONE);
                DatosUsuarioActivo.categoria="otrosproductos";
                ConsultarProductos();
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



//    @Override
//    public void addDatos() {
//
//        Toast.makeText(requireActivity(), "me estan agregando", Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void addDatos(String idproducto,String nombre, Float precio, Integer cantidad) {
          Producto producto=new Producto(LocalSeleccionado.Idlocal.toString(),idproducto,nombre,precio,cantidad,(precio*cantidad));

          detalleFactura.add(producto);
            Facturas.detalleFactura=detalleFactura;
    }
    public void mostrarRecycler(){
        //llamar recyclerview//

        recycler.setHasFixedSize(true);
        //grip es para poder ponerle columnas
        //layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorProductos(productos,this);
        recycler.setAdapter(mAdapter);
        //FIN DE RECYCLER//
    }
    public void ConsultarProductos(){
        ApiServices service = retrofit.create(ApiServices.class);
        Integer idcategoria=0;
        switch(DatosUsuarioActivo.categoria) {
            case "bebidas":
                idcategoria=1;
                // code block
                break;
            case "otrosproductos":
                // code block
                idcategoria=2;
                break;
            case "cafe":
                // code block
                idcategoria=3;
                break;
            case "comida":
                // code block
                idcategoria=4;
                break;

        }
        Call<ArrayList<ProductoApi>> Productos= service.ObtenerProductosLocal(LocalSeleccionado.Idlocal.toString(),
                idcategoria.toString());
        Productos.enqueue(new Callback<ArrayList<ProductoApi>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductoApi>> call, Response<ArrayList<ProductoApi>> response) {
                if(response.isSuccessful()){
                    productos=response.body();
                    mostrarRecycler();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<ProductoApi>> call, Throwable t) {
                Toast.makeText(getActivity(),"fallo ws",Toast.LENGTH_LONG).show();
            }
        });

    }
}
