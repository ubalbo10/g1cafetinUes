package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g1cafetinues.interfaces.Factura;
import com.example.g1cafetinues.interfaces.Facturas;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FacturaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FacturaFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recycler;
    TextView totalfactura;
    Button aceptar;
    Button cancelar;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public FacturaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FacturaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FacturaFragment newInstance(String param1, String param2) {
        FacturaFragment fragment = new FacturaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer tamano=Facturas.detalleFactura.size();
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), tamano.toString(),Toast.LENGTH_LONG).show();
        View vista=inflater.inflate(R.layout.fragment_factura, container, false);

        recycler=vista.findViewById(R.id.recycler_factura);
        recycler.setHasFixedSize(true);
        //grip es para poder ponerle columnas
        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        //layoutManager = new GridLayoutManager(getActivity(),1);
        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorFactura(Facturas.detalleFactura);
        recycler.setAdapter(mAdapter);

        totalfactura=vista.findViewById(R.id.factura_total_pagar);
        aceptar=vista.findViewById(R.id.button_fac_aceptar);
        cancelar=vista.findViewById(R.id.button_fac_cancelar);
        Float sumaTotalFactura=0f;
        for (int i=0;i<Facturas.detalleFactura.size();i++) {
            sumaTotalFactura=sumaTotalFactura + Facturas.detalleFactura.get(i).getTotal();

        }
        totalfactura.setText(sumaTotalFactura.toString());


        return vista;
    }

}
