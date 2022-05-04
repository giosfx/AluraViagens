package com.giosfx.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {
    public static String formatarMoedaLocal(BigDecimal preco) {
        NumberFormat formatoBrasileiro = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        return formatoBrasileiro.format(preco);
    }
}
