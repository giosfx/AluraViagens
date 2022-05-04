package com.giosfx.aluraviagens.util;

import android.icu.text.SimpleDateFormat;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Locale;

public class DataUtil {

    public static final String DIA_E_MES = "dd/mm";

    @NonNull
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasil = new SimpleDateFormat(DIA_E_MES, new Locale("pt", "br"));
        String dataFormatadaIda = formatoBrasil.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasil.format(dataVolta.getTime());
        String dataFormatada = dataFormatadaIda +
                " - " +
                dataFormatadaVolta +
                " de " +
                dataVolta.get(Calendar.YEAR);
        return dataFormatada;
    }
}
