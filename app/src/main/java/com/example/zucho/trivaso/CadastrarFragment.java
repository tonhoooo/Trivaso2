package com.example.zucho.trivaso;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastrarFragment extends Fragment {

    private Button btnCadastrar;
    private Button btnCancelar;
    private float lat;
    private float lon;

    private RatingBar ratingBar;
    private EditText edtNome;
    private EditText edtDescricao;


    public CadastrarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_conta, container, false);

        btnCadastrar = (Button) view.findViewById(R.id.btnCadastrar);
        btnCancelar = (Button) view.findViewById(R.id.btnCancelar);
        edtNome = (EditText) view.findViewById(R.id.edtNome);
        edtDescricao = (EditText) view.findViewById(R.id.edtDescricao);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        return view;
    }
}
