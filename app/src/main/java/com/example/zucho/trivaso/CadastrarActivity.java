package com.example.zucho.trivaso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CadastrarActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCadastrar = null;
    private Button btnCancelar = null;
    private float lat = 0;
    private float lon = 0;

    private RatingBar ratingBar = null;
    private EditText edtNome = null;
    private EditText edtDescricao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        init_componets();

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCadastrar:
                botaoCadastrar();
                break;

            case R.id.btnCancelar:
                botaoCancelar();
                break;

            default:
                break;
        }

    }

    public void botaoCadastrar() {
        Banheiro banheiro = new Banheiro();

        banheiro.setNome(edtNome.getText().toString());
        banheiro.setDescricao(edtDescricao.getText().toString());
        banheiro.setMedia(ratingBar.getRating());
        banheiro.setLat(lat);
        banheiro.setLon(lon);



    }

    private void botaoCancelar() {
        finish();
    }


    public void init_componets() {
        btnCadastrar = (Button) (findViewById(R.id.btnCadastrar));
        btnCadastrar.setOnClickListener(this);

        btnCancelar = (Button) (findViewById(R.id.btnCancelar));
        btnCancelar.setOnClickListener(this);

        ratingBar = (RatingBar) (findViewById(R.id.ratingBar));

        edtNome = (EditText) (findViewById(R.id.edtNome));
        edtDescricao = (EditText) (findViewById(R.id.edtDescricao));
    }
}