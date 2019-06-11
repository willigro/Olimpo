package com.rittamann.oappack.format;

import java.math.BigDecimal;
import java.text.Normalizer;

public class OFormat {

    public static String removeAccents(String text) {
        return text == null ? null :
                Normalizer.normalize(text, Normalizer.Form.NFD)
                        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static String twoDecimalHouses(double value) {
        return new BigDecimal(value).setScale(2, BigDecimal.ROUND_DOWN).toString();
    }
}
