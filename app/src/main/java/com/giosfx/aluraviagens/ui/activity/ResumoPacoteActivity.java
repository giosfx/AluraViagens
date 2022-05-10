package com.giosfx.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.giosfx.aluraviagens.util.DataUtil;
import com.giosfx.aluraviagens.util.DiasUtil;
import com.giosfx.aluraviagens.util.MoedaUtil;
import com.giosfx.aluraviagens.R;
import com.giosfx.aluraviagens.util.ResourceUtil;
import com.giosfx.aluraviagens.model.Pacote;

import java.math.BigDecimal;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote(
                "São Paulo",
                "sao_paulo_sp",
                2,
                new BigDecimal("243.99"));

        definirLocal(pacote);
        definirImagem(pacote);
        definirDias(pacote);
        definirPreco(pacote);
        definirData(pacote);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
    }

    private void definirData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatada = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void definirPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        preco.setText(MoedaUtil.formatarMoedaLocal(pacote.getPreco()));
    }

    private void definirDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText(DiasUtil.formatarDias(pacote.getDias()));
    }

    private void definirImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDePacote = ResourceUtil.obterDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDePacote);
    }

    private void definirLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}