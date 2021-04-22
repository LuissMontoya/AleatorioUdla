
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Luiss Montoya
 */
public class Ventana extends JFrame implements Runnable, ActionListener {

    JPanel izquierda = new JPanel();
    JPanel derecha = new JPanel();
    static JLabel aleatorio = new JLabel("00");
    JLabel img = new JLabel();
    static Font fuente1 = new Font("Tahoma", Font.BOLD, 90);
    static Font fuente2 = new Font("Tahoma", Font.BOLD, 20);
    static int label = 0;
    static JTextArea texto = new JTextArea();
    JScrollPane scroll = new JScrollPane(texto);
    static boolean corre = true;
    Proceso xx = new Proceso(aleatorio, texto);
    JButton calcular = new JButton("Iniciar");
    JButton parar = new JButton("Parar");
    static int ale = (int) Math.floor(Math.random() * (99) + 1);

    Ventana() {
        super("Cronómetro");
        setSize(600, 660);
        setLayout(new GridLayout(1, 2));
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("img/01.png"));
        Image Image = ImageIcon.getImage();
        this.setIconImage(Image);

        izquierda.setLayout(new GridLayout(3, 1));
        izquierda.add(new JLabel());
        JPanel panellabel = new JPanel();
        panellabel.add(aleatorio);
        FlowLayout flow = new FlowLayout();
        flow.setHgap(12);
        flow.setVgap(70);
        panellabel.setLayout(flow);
        izquierda.add(panellabel);
        JPanel panelboton = new JPanel();
        panelboton.add(calcular);
        panelboton.add(parar);
        parar.addActionListener(this);
        calcular.addActionListener(this);
        izquierda.add(panelboton);
        derecha.setLayout(new GridLayout(3, 1));
        JLabel texto1 = new JLabel("Números Conseguidos: ");
        texto1.setFont(fuente2);
        derecha.add(texto1);
        derecha.add(scroll);
        String path = "img/logoudla.gif";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        img.setIcon(icon);
        derecha.add(img);
        texto.setEditable(false);

        add(izquierda);
        add(derecha);

    }

    @Override
    public void run() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            try {
                corre = true;
                xx.start();

            } catch (java.lang.IllegalThreadStateException bb) {
            }
            if (corre) {
                xx.resume();
            }
        }
        if (e.getSource() == parar) {
            corre = false;
            xx.suspend();
            texto.setText(texto.getText() + "\t" + aleatorio.getText() + "\n");
        }
    }
}
