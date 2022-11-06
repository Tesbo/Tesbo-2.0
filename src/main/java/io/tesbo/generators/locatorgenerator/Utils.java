package io.tesbo;

import java.util.Locale;

public class Utils {


    public String getFormattedTextName(String name) {

        String formattedTextName = name.replace("?", "_").replace(" ", "_").toLowerCase(Locale.ROOT);

        return formattedTextName;
    }
}
