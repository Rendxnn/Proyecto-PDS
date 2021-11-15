import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ventana extends JFrame {

    protected int cantAforo;
    protected int ent1;
    protected int sal1;
    protected int ent2;
    protected int sal2;
    protected JPanel panel = new JPanel();
    protected JLabel aforo = new JLabel();
    protected JPanel panel2= new JPanel();
    protected JPanel indicador= new JPanel();
    protected JButton entrada1=new JButton("Entrada");
    protected JButton salida1= new JButton("Salida");
    protected JButton entrada2=new JButton("Entrada");
    protected JButton salida2=new JButton("Salida");
    protected JButton guardar = new JButton("Guardar");

    public Ventana() {

        // Valores iniciales de la Ventana
        this.setSize(700, 700);
        setTitle("Control de aforo Restaurante 1");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 700));
        this.getContentPane().setBackground(Color.WHITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);// Termina el programa cuando cierra la ventana
    }

    protected void iniciarComponenetes(int cantAforo){
        iniciarPaneles();
        iniciarEtiquetas();
        iniciarBotones();
        iniciarLogo();
        cambiarAforo(cantAforo);
    }

    protected void iniciarPaneles(){
        // Elementos del panel
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.darkGray);

        //Elementos de la franja blanca del titulo
        panel2.setBounds(0,0,700,80);
        panel2.setBackground(Color.white);
        panel.add(panel2);

        //Elementos del panel indicador
        indicador.setBounds(550,90,100,100);
        panel.add(indicador);
    }

    protected void iniciarEtiquetas(){
        //Creación y elementos de la etiqueta titulo
        JLabel titulo=new JLabel("Control de Aforo Restaurante");
        titulo.setBounds(50,100,180,25);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);

        //Elementos de la etiqueta aforo
        aforo.setBounds(50,150,280,25);
        aforo.setForeground(Color.WHITE);
        panel.add(aforo);

        // Elementos de la etiqueta senalInd
        JLabel senalInd= new JLabel("Indicador de Aforo:");
        senalInd.setBounds(425, 95,115,25);
        senalInd.setForeground(Color.WHITE);
        panel.add(senalInd);
    }

    protected void iniciarBotones(){

        //Elementos del primer ingreso

        entrada1.setBounds(80, 455,150,75);
        entrada1.setBackground(new Color(8,28,83));
        entrada1.setForeground(Color.WHITE);
        panel.add(entrada1);


        salida1.setBounds(80,375,150,75);
        salida1.setBackground(new Color(8,28,83));
        salida1.setForeground(Color.WHITE);
        panel.add(salida1);


        //Elementos del segundo ingreso

        entrada2.setBounds(470, 455,150,75);
        entrada2.setBackground(new Color(8,28,83));
        entrada2.setForeground(Color.WHITE);
        panel.add(entrada2);


        salida2.setBounds(470,375,150,75);
        salida2.setBackground(new Color(8,28,83));
        salida2.setForeground(Color.WHITE);
        panel.add(salida2);


        guardar.setBounds(470, 575, 150, 50);
        guardar.setBackground(new Color(8, 28, 83));
        guardar.setForeground(Color.white);
        panel.add(guardar);
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persistencia.anadirTexto();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        guardar.addActionListener(accion);
    }

    protected void guardarInfo() throws IOException {

    }

    protected int ingresoEntrada1(){

        ActionListener in1=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ent1=1;
            }
        };
        entrada1.addActionListener(in1);
        return ent1;
    }

    protected int ingresoSalida1(){
        ActionListener out1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sal1=1;
            }
        };
        salida1.addActionListener(out1);
        return sal1;
    }

    protected int ingresoEntrada2(){

        ActionListener in2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ent2=1;
            }
        };
        entrada2.addActionListener(in2);
        return ent2;
    }

    protected int ingresoSalida2(){
        ActionListener out2= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sal2=1;
            }
        };
        salida2.addActionListener(out2);
        return sal2;
    }


    protected void iniciarLogo(){
        JLabel imagen= new JLabel();
        imagen.setIcon(new ImageIcon("logo_eafit.png"));
        imagen.setBounds(500,1,181,74);
        panel2.add(imagen);

    }

    protected void cambiarAforo(int cantAforo){
        this.cantAforo= cantAforo;
        aforo.setText("La cantidad de personas dentro del resinto es: "+ cantAforo);
    }

    protected void cambiarIndicador(int conta){

        if(conta<50){
            indicador.setBackground(Color.GREEN);
        }else{
            if(conta<80){
                indicador.setBackground(Color.orange);
            }else{
                indicador.setBackground(Color.red);
            }
        }
    }
}
