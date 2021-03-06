import java.io.File;
import java.io.IOException;

public class Main {

    static int contHistorico = 0;

    public static void main(String[] args) throws InterruptedException, IOException {


        int conta=0;


        Sensor S1= new Sensor();

        Ventana v1= new Ventana();
        v1.setVisible(true);

        //Inicia todos los componentes de la interfaz grafica
        v1.iniciarComponenetes(conta);

        //Iniciar la etiqueta con valor 0
        v1.cambiarAforo(conta);

        while(true){
            Thread.sleep(600);
            if(v1.ingresoEntrada1()==v1.ingresoSalida1()){
                conta=conta;
            }else{
                if(S1.entrada(v1.ingresoEntrada1(), v1.ingresoSalida1())){
                    conta++;
                    contHistorico++;
                }else{
                    if(S1.salida(v1.ingresoEntrada1(), v1.ingresoSalida1())){
                        conta--;
                    }
                }
            }

            //Establecimiento de valores para no hacer una suma infinita
            v1.ent1 =0;
            v1.sal1=0;

            if(v1.ingresoEntrada2()==v1.ingresoSalida2()){
                conta=conta;
            }else{
                if(S1.entrada(v1.ingresoEntrada2(), v1.ingresoSalida2())){
                    conta++;
                }else{
                    if(S1.salida(v1.ingresoEntrada2(), v1.ingresoSalida2())){
                        conta--;
                    }
                }
            }

            //Establecimiento de valores para no hacer una suma infinita
            v1.ent2=0;
            v1.sal2=0;

            //Aplicación de los cambios dentro de la interfaz grafica
            v1.cambiarAforo(conta);
            v1.cambiarIndicador(conta);
        }
    }
}
