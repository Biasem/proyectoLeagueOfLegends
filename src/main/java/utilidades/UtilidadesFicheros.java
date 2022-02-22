package utilidades;

import com.opencsv.CSVReader;
import modelos.Personaje;


import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilidadesFicheros {


    public UtilidadesFicheros() {
    }

    public static final char SEPARATOR=';';
    public static final char QUOTE='"';

    public static List<Personaje>  leerFicheroCoches() throws IOException {

        List<Personaje> coches = new ArrayList<>();
        CSVReader reader = null;
        try {                                            //"E:\\java proyect 2\\src\\main\\java\\Coche.csv"
            reader = new CSVReader(new FileReader("E:\\java proyect 2\\src\\main\\java\\Coche.csv"),SEPARATOR,QUOTE);
            String[] nextLine= null ;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if(count >0) {
                    String[] valores = nextLine[0].toString().split(",");
                    Personaje p = new Personaje();
                    p.setId(Integer.parseInt(valores[0]));
                    p.setFechaMatriculacion(LocalDate.parse(valores[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    p.setColor(Color.valueOf(valores[2]));
                    coches.add(c);
                }
                count++;
            }

        } catch (Exception e) {
            throw e;
        }

        reader.close();

        return  coches;
    }

}
