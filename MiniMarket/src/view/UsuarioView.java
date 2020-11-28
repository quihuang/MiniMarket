package view;

import controller.DashboardController;
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
import model.Table.Usuario;

public class UsuarioView extends JPanel {

    private JTableComponent tableList;

    JLabel LabelFiltro = new JLabel();

    JButton buttonCreateUsuario = new JButton();
    JButton buttonDeleteUsuario = new JButton();
    JButton buttonUpdateUsuario = new JButton();

    private JTableSearch fieldSearch;

    JLabel title = new JLabel();

    private final int x = 1500;
    private final int y = 1500;

    public UsuarioView(ArrayList<Usuario> result) {

        setSize(x, y);
        setLayout(null);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            title.setText("Gestionar Usuarios");
            title.setLocation(150, 120);

        } else if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            title.setText("Clientes");
            title.setLocation(50, 120);
        }

        title.setSize(850, 40);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));
        title.setHorizontalAlignment(CENTER);

        String columns[] = {"id", "T.I", "Identificación", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Celular", "Correo", "Rol", "Estado"};
        tableList = new JTableComponent(columns);
        tableList.getTable().getColumnModel().getColumn(1).setMaxWidth(40);
        tableList.getTable().getColumnModel().getColumn(8).setMinWidth(150);
        tableList.getTable().getColumnModel().getColumn(9).setMinWidth(50);
        tableList.getTable().getColumnModel().getColumn(10).setMaxWidth(50);

        tableList.getScrollTable().setLocation(360, 250);
        tableList.getScrollTable().setSize(1000, 500);

        for (int i = 0; i < result.size(); i++) {

            if (Integer.parseInt(result.get(i).getUsuIdentificacion()) != -1) {
                Object rs[] = {
                    result.get(i),
                    result.get(i).getTipNombre(),
                    result.get(i).getUsuIdentificacion(),
                    result.get(i).getUsuNombre1(),
                    result.get(i).getUsuNombre2(),
                    result.get(i).getUsuApellido1(),
                    result.get(i).getUsuApellido2(),
                    result.get(i).getUsuCelular(),
                    result.get(i).getUsuCorreo(),
                    result.get(i).getRolNombre(),
                    result.get(i).getEstEstado()

                };
                tableList.getModel().addRow(rs);
            }
        }

        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(1030, 200);
        fieldSearch.setSize(320, 30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));

        tableList.centerData(1);
        tableList.centerData(9);
        tableList.centerData(7);
        tableList.centerData(10);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            buttonCreateUsuario = new JButton("Crear Usuario");

        } else if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            buttonCreateUsuario = new JButton("Crear Cliente");
        }

        buttonCreateUsuario.setLocation(360, 800);
        buttonCreateUsuario.setSize(230, 30);
        buttonCreateUsuario.setBackground(orange);
        buttonCreateUsuario.setForeground(white);
        buttonCreateUsuario.setFocusable(false);
        buttonCreateUsuario.setBorder(null);
        buttonCreateUsuario.setFont(new Font("Arial", BOLD, 15));

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            buttonDeleteUsuario.setText("Eliminar Usuario");
            buttonDeleteUsuario.setLocation(890, 800);
            buttonDeleteUsuario.setSize(230, 30);
            buttonDeleteUsuario.setBackground(orange);
            buttonDeleteUsuario.setForeground(white);
            buttonDeleteUsuario.setFocusable(false);
            buttonDeleteUsuario.setBorder(null);
            buttonDeleteUsuario.setFont(new Font("Arial", BOLD, 15));

        }

        LabelFiltro.setLocation(950, 195);
        LabelFiltro.setSize(300, 40);
        LabelFiltro.setFont(new Font("Arial", BOLD, 20));
        LabelFiltro.setText("Filtro :");

        add(LabelFiltro);
        add(fieldSearch);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {

            buttonUpdateUsuario.setText("Actualizar Usuario");
            buttonUpdateUsuario.setLocation(600, 800);
            buttonUpdateUsuario.setSize(230, 30);
            buttonUpdateUsuario.setBackground(orange);
            buttonUpdateUsuario.setForeground(white);
            buttonUpdateUsuario.setFocusable(false);
            buttonUpdateUsuario.setBorder(null);
            buttonUpdateUsuario.setFont(new Font("Arial", BOLD, 15));

            add(buttonUpdateUsuario);
            add(buttonDeleteUsuario);
        }
        add(buttonCreateUsuario);
        add(tableList.getScrollTable());
        add(title);
    }

    public JButton getButtonCreateUsuario() {
        return buttonCreateUsuario;
    }

    public JButton getButtonDeleteUsuario() {
        return buttonDeleteUsuario;
    }

    public JButton getButtonUpdateUsuario() {
        return buttonUpdateUsuario;
    }

    public JTableComponent getTableList() {
        return tableList;
    }

}
