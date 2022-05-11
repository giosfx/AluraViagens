package com.giosfx.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.giosfx.aluraviagens.R;
import com.giosfx.aluraviagens.model.Pacote;
import com.giosfx.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote(
                "São Paulo",
                "sao_paulo_sp",
                2,
                new BigDecimal("243.99"));

        definirPreco(pacote);

    }

    private void definirPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preço);
        preco.setText(MoedaUtil.formatarMoedaLocal(pacote.getPreco()));
    }
}