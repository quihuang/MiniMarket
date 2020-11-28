package view;

import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import model.Table.HistorialPedido;

public class HistorialPedidoView extends JPanel {

    private JTableComponent tableList;
    private JButton buttonVerPedido;

    private JLabel LabelFiltro = new JLabel();

    private JTableSearch fieldSearch;

    private JLabel title = new JLabel();

    private final int x = 1500;
    private final int y = 1500;

    public HistorialPedidoView(ArrayList<HistorialPedido> result) {

        setSize(x, y);
        setLayout(null);

        title.setText("Historial de pedidos");
        title.setLocation(150, 120);
        title.setSize(850, 40);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));
        title.setHorizontalAlignment(CENTER);

        String columns[] = {"id", "N° Factura", "Identificación", "Primer Nombre", "Primer Apellido", "Fecha"};
        tableList = new JTableComponent(columns);
        buttonVerPedido = new JButton();
        buttonVerPedido.setText("Ver Pedido");
        buttonVerPedido.setLocation(360, 800);
        buttonVerPedido.setSize(180, 30);
        buttonVerPedido.setBackground(orange);
        buttonVerPedido.setForeground(white);
        buttonVerPedido.setFocusable(false);
        buttonVerPedido.setBorder(null);
        buttonVerPedido.setFont(new Font("Arial", BOLD, 15));

        tableList.getScrollTable().setLocation(360, 250);
        tableList.getScrollTable().setSize(1000, 500);

        for (int i = 0; i < result.size(); i++) {

            if (Integer.parseInt(result.get(i).getUsuIdentificacion()) != -1) {
                Object rs[] = {
                    result.get(i),
                    result.get(i).getPedId(),
                    result.get(i).getUsuIdentificacion(),
                    result.get(i).getUsuNombre1(),
                    result.get(i).getUsuApellido1(),
                    Resource.transformFecha(result.get(i).getPedFecha()),};
                tableList.getModel().addRow(rs);

            } else {

                Object rs[] = {
                    result.get(i),
                    result.get(i).getPedId(),
                    result.get(i).getUsuNombre1() + " " + result.get(i).getUsuApellido1(),
                    "",
                    "",
                    Resource.transformFecha(result.get(i).getPedFecha()),};
                tableList.getModel().addRow(rs);

            }
        }

        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(1040, 200);
        fieldSearch.setSize(310, 30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));

        tableList.centerData();

        LabelFiltro.setLocation(950, 195);
        LabelFiltro.setSize(300, 40);
        LabelFiltro.setFont(new Font("Arial", BOLD, 20));
        LabelFiltro.setText("Buscar :");

        add(LabelFiltro);
        add(fieldSearch);
        add(tableList.getScrollTable());
        add(buttonVerPedido);
        add(title);
    }

    public JTableComponent getTableList() {
        return tableList;
    }

    public JButton getButtonVerPedido() {
        return buttonVerPedido;
    }

}
