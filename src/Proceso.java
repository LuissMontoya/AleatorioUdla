
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Luiss Montoya
 */
public class Proceso extends Thread {

    JLabel crono;
    JTextArea cae;
    int tiempo;
    static int con;
//    

    public Proceso(JLabel eti, JTextArea caet) {// Contructor porque la clase es heredada 
        super();
        crono = eti;
        crono.setFont(Ventana.fuente1);
        cae = caet;
        cae.setFont(Ventana.fuente2);
//        this.start();
    }

    public void run() {
        con = 0;
//        while (Ventana.corre) {
            for (int i = 0; i < 5000; i++) {
                try {//si ocurre un error al dormir el proceso(sleep(999))
                    con = (int) Math.floor(Math.random() * (99) + 1);
                    esperarXsegundos(2);
                    Thread.sleep(86);
                    EjecutarHilo(Ventana.ale);
                    Ventana.aleatorio.setText(con + "");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());//Imprima el error
                }
            }
//        }

    }

    private void EjecutarHilo(int x) {
        Ventana.label++;

    }

    public void esperarXsegundos(int segundos) {
        this.tiempo = segundos;
    }

}
