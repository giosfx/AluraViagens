package com.giosfx.aluraviagens.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static Drawable obterDrawable(Context context, String imagem) {
        int identifier = context.getResources()
                .getIdentifier(imagem, "drawable", context.getPackageName());
        return context.getDrawable(identifier);
    }
}
