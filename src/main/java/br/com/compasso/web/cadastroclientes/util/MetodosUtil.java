package br.com.compasso.web.cadastroclientes.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class MetodosUtil {

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
