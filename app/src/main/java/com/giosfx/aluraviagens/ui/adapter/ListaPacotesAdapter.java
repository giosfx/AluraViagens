package com.giosfx.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.giosfx.aluraviagens.R;
import com.giosfx.aluraviagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pacote> pacotes;

    public ListaPacotesAdapter(Context context, List<Pacote> pacotes) {
        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        definirLocal(viewCriada, pacote);
        definirImagem(viewCriada, pacote);
        definirDias(viewCriada, pacote);
        definirPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void definirPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = obterMoedaLocal(pacote);
        preco.setText(moedaBrasileira);
    }

    private String obterMoedaLocal(Pacote pacote) {
        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat formatoBrasileiro = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro.format(precoDoPacote);
        return moedaBrasileira;
    }

    private void definirDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int quantidadeDias = pacote.getDias();
        if (quantidadeDias > 1) {
            dias.setText(quantidadeDias + " dias");
        } else {
            dias.setText(quantidadeDias + " dia");
        }
    }

    private void definirImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawable = obterDrawable(pacote);
        imagem.setImageDrawable(drawable);
    }

    private Drawable obterDrawable(Pacote pacote) {
        int identifier = context.getResources()
                .getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = context.getDrawable(identifier);
        return drawable;
    }

    private void definirLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
