package com.giosfx.aluraviagens.util;

public class DiasUtil {
    public static String formatarDias(int dias){
        if (dias > 1) {
            return dias + " dias";
        } else {
            return dias + " dia";
        }
    }
}
