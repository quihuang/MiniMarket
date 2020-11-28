package view;

import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Table.TipoProducto;

public class CategoryView extends JPanel {

    JTextField fieldName = new JTextField();
    JComboBox fieldIva = new JComboBox();
    private JTableComponent tableList;

    JButton buttonCreateCategory = new JButton();
    JButton buttonDeleteCategory = new JButton();
    JButton buttonUpdateCategory = new JButton();
    JButton buttonCancelCategory = new JButton();

    JLabel labelName = new JLabel();
    JLabel title = new JLabel();
    JLabel shearch = new JLabel();
    private JTableSearch fieldSearch;

    private final int x = 1500;
    private final int y = 1500;

    public CategoryView(ArrayList<TipoProducto> result) {

        setSize(x, y);
        setLayout(null);

        title.setText("Gestionar Categorias");
        title.setLocation(0, 0);
        title.setSize(850, 45);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));

        labelName.setText("Nombre de la categoria");
        labelName.setLocation(90, 190);
        labelName.setSize(250, 30);
        labelName.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        fieldName.setLocation(90, 240);
        fieldName.setSize(230, 30);
        fieldName.setFont(new Font("Segoe UI Light", BOLD, 20));

        fieldIva = new JComboBox();
        fieldIva.setLocation(90, 290);
        fieldIva.setSize(230, 30);
        fieldIva.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        fieldIva.addItem("     Seleccionar IVA");

        buttonCreateCategory = new JButton("Crear Categoria");
        buttonCreateCategory.setLocation(90, 340);
        buttonCreateCategory.setSize(230, 30);
        buttonCreateCategory.setBackground(orange);
        buttonCreateCategory.setForeground(white);
        buttonCreateCategory.setFocusable(false);
        buttonCreateCategory.setBorder(null);
        buttonCreateCategory.setFont(new Font("Arial", BOLD, 15));

        buttonDeleteCategory.setText("Eliminar Categoria");
        buttonDeleteCategory.setLocation(90, 490);
        buttonDeleteCategory.setSize(230, 30);
        buttonDeleteCategory.setBackground(orange);
        buttonDeleteCategory.setForeground(white);
        buttonDeleteCategory.setFocusable(false);
        buttonDeleteCategory.setBorder(null);
        buttonDeleteCategory.setFont(new Font("Arial", BOLD, 15));

        buttonUpdateCategory.setText("Actualizar Categoria");
        buttonUpdateCategory.setLocation(90, 540);
        buttonUpdateCategory.setSize(230, 30);
        buttonUpdateCategory.setBackground(orange);
        buttonUpdateCategory.setForeground(white);
        buttonUpdateCategory.setFocusable(false);
        buttonUpdateCategory.setBorder(null);
        buttonUpdateCategory.setFont(new Font("Arial", BOLD, 15));

        buttonCancelCategory.setText("Cancelar");
        buttonCancelCategory.setLocation(90, 590);
        buttonCancelCategory.setSize(230, 30);
        buttonCancelCategory.setBackground(orange);
        buttonCancelCategory.setForeground(white);
        buttonCancelCategory.setFocusable(false);
        buttonCancelCategory.setBorder(null);
        buttonCancelCategory.setFont(new Font("Arial", BOLD, 15));
        buttonCancelCategory.setEnabled(false);
        buttonCancelCategory.setVisible(false);

        for (int i = 0; i <= 100; i++) {
            fieldIva.addItem(i);
        }

        String columns[] = {"id", "Nombre", "Iva"};
        tableList = new JTableComponent(columns);

        for (int i = 0; i < result.size(); i++) {
            Object rs[] = {result.get(i), result.get(i).getTipProNombre(), result.get(i).getTipProIva()};
            tableList.getModel().addRow(rs);
        }

        tableList.centerData(2);

        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(750, 110);
        fieldSearch.setSize(200, 30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));

        shearch.setText("Buscar : ");
        shearch.setLocation(650, 100);
        shearch.setSize(100, 40);
        shearch.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        tableList.getScrollTable().setLocation(450, 150);
        tableList.getScrollTable().setSize(500, 500);

        add(shearch);
        add(title);
        add(labelName);
        add(fieldName);
        add(fieldIva);
        add(buttonCreateCategory);
        add(fieldSearch);
        add(tableList.getScrollTable());
        add(buttonDeleteCategory);
        add(buttonUpdateCategory);
        add(buttonCancelCategory);

    }

    public CategoryView() {

    }

    public JTableComponent getTableList() {
        return tableList;
    }

    public JButton getButtonDeleteCategory() {
        return buttonDeleteCategory;
    }

    public JButton getButtonUpdateCategory() {
        return buttonUpdateCategory;
    }

    public JButton getButtonCreateCategory() {
        return buttonCreateCategory;
    }

    public JButton getButtonCancelCategory() {
        return buttonCancelCategory;
    }

    public JTextField getFieldName() {
        return fieldName;
    }

    public JComboBox getFieldIva() {
        return fieldIva;
    }

}
