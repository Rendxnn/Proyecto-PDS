import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Persistencia {




    public static void anadirTexto() throws IOException {
        File archivo = new File("Persistencia.txt");
        FileWriter escribir = new FileWriter(archivo, true);
        escribir.write("Cantidad total de entradas: " + Main.contHistorico);
        escribir.write("\r\n");
        escribir.close();
    }

}
