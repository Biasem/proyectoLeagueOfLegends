package utilidades;

import com.opencsv.CSVReader;
import modelos.Coche;
import modelos.Color;

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

    public static List<Coche>  leerFicheroCoches() throws IOException {

        List<Coche> coches = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\ficheros\\archivos\\Coche.csv"),SEPARATOR,QUOTE);
            String[] nextLine= null ;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if(count >0) {
                    String[] valores = nextLine[0].toString().split(",");
                    Coche c = new Coche();
                    c.setMatricula(valores[0]);
                    c.setFechaMatriculacion(LocalDate.parse(valores[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    c.setColor(Color.valueOf(valores[2]));
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
