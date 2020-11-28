package view;

import java.awt.Color;
import static java.awt.Color.orange;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

public class EstadisticaView extends JPanel {

    JPanel uno = new JPanel();
    JPanel dos = new JPanel();
    JPanel tres = new JPanel();
    JPanel cuatro = new JPanel();
    JPanel cinco = new JPanel();

    JLabel title = new JLabel();

    JLabel rectangulo1 = new JLabel();
    JLabel rectangulo2 = new JLabel();
    JLabel rectangulo3 = new JLabel();
    JLabel rectangulo4 = new JLabel();
    JLabel rectangulo5 = new JLabel();

    JLabel Picmasvendio = new JLabel();
    JLabel LabelMasVendido = new JLabel();
    JLabel resultadoMasVendido = new JLabel();

    JLabel PicMenosvendio = new JLabel();
    JLabel LabelMenosVendido = new JLabel();
    JLabel resultadoMenosVendido = new JLabel();

    JLabel PicVentaTotal = new JLabel();
    JLabel LabelVentaTotal = new JLabel();
    JLabel resultadoVentaTotal = new JLabel();

    JLabel PicPromedio = new JLabel();
    JLabel LabelPromedio = new JLabel();
    JLabel resultadoPromedio = new JLabel();

    JLabel PicGanancia = new JLabel();
    JLabel LabelGanancia = new JLabel();
    JLabel resultadoGanancia = new JLabel();

    private final int x = 1500;
    private final int y = 1500;

    public EstadisticaView() {

        setSize(x, y);
        setLayout(null);

        title.setText("Estadisticas");
        title.setLocation(75, 120);
        title.setSize(850, 40);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 36));
        title.setHorizontalAlignment(CENTER);

        // Producto mas vendido 
        rectangulo1.setSize(420, 150);
        rectangulo1.setLocation(400, 230);
        ImageIcon imageR1 = new ImageIcon(getClass().getResource("/imagenes/rectan2.png"));
        Icon iconR1 = new ImageIcon(imageR1.getImage().getScaledInstance(rectangulo1.getWidth(), rectangulo1.getHeight(), SCALE_DEFAULT));
        rectangulo1.setIcon(iconR1);

        Picmasvendio.setSize(100, 100);
        Picmasvendio.setLocation(420, 255);
        ImageIcon imageMasvendio = new ImageIcon(getClass().getResource("/imagenes/mejor.png"));
        Icon iconMasvendio = new ImageIcon(imageMasvendio.getImage().getScaledInstance(Picmasvendio.getWidth(), Picmasvendio.getHeight(), SCALE_DEFAULT));
        Picmasvendio.setIcon(iconMasvendio);

        LabelMasVendido.setForeground(Color.black);
        LabelMasVendido.setSize(300, 40);
        LabelMasVendido.setLocation(540, 250);
        LabelMasVendido.setFont(new Font("Arial", BOLD, 20));
        LabelMasVendido.setText("Producto más vendido");

        resultadoMasVendido.setForeground(Color.GREEN);
        resultadoMasVendido.setSize(300, 40);
        resultadoMasVendido.setLocation(0, 0);
        resultadoMasVendido.setFont(new Font("Arial", BOLD, 20));
        resultadoMasVendido.setText("Arroz Diana");
        resultadoMasVendido.setHorizontalAlignment(CENTER);

        uno.setSize(300, 40);
        uno.setLocation(500, 300);
        uno.setLayout(null);

        // Producto Menos vendido
        rectangulo2.setSize(420, 150);
        rectangulo2.setLocation(880, 230);
        ImageIcon imageR2 = new ImageIcon(getClass().getResource("/imagenes/rectan2.png"));
        Icon iconR2 = new ImageIcon(imageR2.getImage().getScaledInstance(rectangulo2.getWidth(), rectangulo2.getHeight(), SCALE_DEFAULT));
        rectangulo2.setIcon(iconR2);

        PicMenosvendio.setSize(100, 100);
        PicMenosvendio.setLocation(900, 255);
        ImageIcon imageMenosvendio = new ImageIcon(getClass().getResource("/imagenes/menos.png"));
        Icon iconMenosvendio = new ImageIcon(imageMenosvendio.getImage().getScaledInstance(PicMenosvendio.getWidth(), PicMenosvendio.getHeight(), SCALE_DEFAULT));
        PicMenosvendio.setIcon(iconMenosvendio);

        LabelMenosVendido.setForeground(Color.black);
        LabelMenosVendido.setSize(300, 40);
        LabelMenosVendido.setLocation(1020, 250);
        LabelMenosVendido.setFont(new Font("Arial", BOLD, 20));
        LabelMenosVendido.setText("Producto menos vendido");

        resultadoMenosVendido.setForeground(Color.GREEN);
        resultadoMenosVendido.setSize(300, 40);
        resultadoMenosVendido.setLocation(0, 0);
        resultadoMenosVendido.setFont(new Font("Arial", BOLD, 20));
        resultadoMenosVendido.setText("Aceite Mediano");
        resultadoMenosVendido.setHorizontalAlignment(CENTER);

        dos.setSize(300, 40);
        dos.setLocation(990, 300);
        dos.setLayout(null);

        // Dinero total obtenido por las ventas
        rectangulo3.setSize(420, 150);
        rectangulo3.setLocation(400, 420);
        ImageIcon imageR3 = new ImageIcon(getClass().getResource("/imagenes/rectan2.png"));
        Icon iconR3 = new ImageIcon(imageR3.getImage().getScaledInstance(rectangulo3.getWidth(), rectangulo3.getHeight(), SCALE_DEFAULT));
        rectangulo3.setIcon(iconR3);

        PicVentaTotal.setSize(100, 100);
        PicVentaTotal.setLocation(420, 450);
        ImageIcon imageVentaTotal = new ImageIcon(getClass().getResource("/imagenes/total.png"));
        Icon iconVentaTotal = new ImageIcon(imageVentaTotal.getImage().getScaledInstance(PicVentaTotal.getWidth(), PicVentaTotal.getHeight(), SCALE_DEFAULT));
        PicVentaTotal.setIcon(iconVentaTotal);

        LabelVentaTotal.setForeground(Color.black);
        LabelVentaTotal.setSize(300, 40);
        LabelVentaTotal.setLocation(573, 450);
        LabelVentaTotal.setFont(new Font("Arial", BOLD, 20));
        LabelVentaTotal.setText("Total de ventas");

        resultadoVentaTotal.setForeground(Color.GREEN);
        resultadoVentaTotal.setSize(300, 40);
        resultadoVentaTotal.setLocation(0, 0);
        resultadoVentaTotal.setFont(new Font("Arial", BOLD, 20));
        resultadoVentaTotal.setText("$ 20.352.600");
        resultadoVentaTotal.setHorizontalAlignment(CENTER);

        tres.setSize(300, 40);
        tres.setLocation(495, 500);
        tres.setLayout(null);

        // Promedio
        rectangulo4.setSize(420, 150);
        rectangulo4.setLocation(880, 420);
        ImageIcon imageR4 = new ImageIcon(getClass().getResource("/imagenes/rectan2.png"));
        Icon iconR4 = new ImageIcon(imageR4.getImage().getScaledInstance(rectangulo4.getWidth(), rectangulo4.getHeight(), SCALE_DEFAULT));
        rectangulo4.setIcon(iconR4);

        PicPromedio.setSize(100, 100);
        PicPromedio.setLocation(900, 445);
        ImageIcon imagePicPromedio = new ImageIcon(getClass().getResource("/imagenes/promedio.png"));
        Icon iconPicPromedioo = new ImageIcon(imagePicPromedio.getImage().getScaledInstance(PicPromedio.getWidth(), PicPromedio.getHeight(), SCALE_DEFAULT));
        PicPromedio.setIcon(iconPicPromedioo);

        LabelPromedio.setForeground(Color.black);
        LabelPromedio.setSize(300, 40);
        LabelPromedio.setLocation(1035, 450);
        LabelPromedio.setFont(new Font("Arial", BOLD, 20));
        LabelPromedio.setText("Promedio de ventas");

        resultadoPromedio.setForeground(Color.GREEN);
        resultadoPromedio.setSize(300, 40);
        resultadoPromedio.setLocation(0, 0);
        resultadoPromedio.setFont(new Font("Arial", BOLD, 20));
        resultadoPromedio.setText("$ 2.252.600");
        resultadoPromedio.setHorizontalAlignment(CENTER);

        cuatro.setSize(300, 40);
        cuatro.setLocation(975, 500);
        cuatro.setLayout(null);

        //total aganancias
        rectangulo5.setSize(420, 150);
        rectangulo5.setLocation(640, 610);
        ImageIcon imageR5 = new ImageIcon(getClass().getResource("/imagenes/rectan2.png"));
        Icon iconR5 = new ImageIcon(imageR5.getImage().getScaledInstance(rectangulo5.getWidth(), rectangulo5.getHeight(), SCALE_DEFAULT));
        rectangulo5.setIcon(iconR5);

        PicGanancia.setSize(100, 100);
        PicGanancia.setLocation(660, 630);
        ImageIcon imagePicGanancia = new ImageIcon(getClass().getResource("/imagenes/ganancias.png"));
        Icon iconPicGanancia = new ImageIcon(imagePicGanancia.getImage().getScaledInstance(PicGanancia.getWidth(), PicGanancia.getHeight(), SCALE_DEFAULT));
        PicGanancia.setIcon(iconPicGanancia);

        LabelGanancia.setForeground(Color.black);
        LabelGanancia.setSize(300, 40);
        LabelGanancia.setLocation(835, 640);
        LabelGanancia.setFont(new Font("Arial", BOLD, 20));
        LabelGanancia.setText("Ganancias");

        resultadoGanancia.setForeground(Color.GREEN);
        resultadoGanancia.setSize(300, 40);
        resultadoGanancia.setLocation(0, 0);
        resultadoGanancia.setFont(new Font("Arial", BOLD, 20));
        resultadoGanancia.setText("$ 15.552.600");
        resultadoGanancia.setHorizontalAlignment(CENTER);

        cinco.setSize(300, 40);
        cinco.setLocation(735, 690);
        cinco.setLayout(null);

        add(LabelGanancia);
        add(PicGanancia);
        add(LabelPromedio);
        add(PicPromedio);
        add(LabelVentaTotal);
        add(PicVentaTotal);
        add(LabelMenosVendido);
        add(PicMenosvendio);
        add(LabelMasVendido);
        add(Picmasvendio);
        add(rectangulo5);
        add(rectangulo4);
        add(rectangulo3);
        add(rectangulo2);
        add(rectangulo1);
        add(title);

        cinco.add(resultadoGanancia);
        add(cinco);

        cuatro.add(resultadoPromedio);
        add(cuatro);

        tres.add(resultadoVentaTotal);
        add(tres);

        dos.add(resultadoMenosVendido);
        add(dos);

        uno.add(resultadoMasVendido);
        add(uno);

    }

    public JLabel getResultadoMasVendido() {
        return resultadoMasVendido;
    }

    public void setResultadoMasVendido(String resultadoMasVendido) {
        this.resultadoMasVendido.setText(resultadoMasVendido);
    }

    public JLabel getResultadoMenosVendido() {
        return resultadoMenosVendido;
    }

    public void setResultadoMenosVendido(String resultadoMenosVendido) {
        this.resultadoMenosVendido.setText(resultadoMenosVendido);
    }

    public JLabel getResultadoVentaTotal() {
        return resultadoVentaTotal;
    }

    public void setResultadoVentaTotal(String resultadoVentaTotal) {
        this.resultadoVentaTotal.setText(resultadoVentaTotal);
    }

    public JLabel getResultadoPromedio() {
        return resultadoPromedio;
    }

    public void setResultadoPromedio(String resultadoPromedio) {
        this.resultadoPromedio.setText(resultadoPromedio);
    }

    public JLabel getResultadoGanancia() {
        return resultadoGanancia;
    }

    public void setResultadoGanancia(String resultadoGanancia) {
        this.resultadoGanancia.setText(resultadoGanancia);
    }

}
