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
import model.Table.Producto;
import model.Table.TipoProducto;
import model.TipoProductoModel;

public class ProductoView extends JPanel {

    JNumberField fieldPrecio = new JNumberField(true);
    JTextField fieldName = new JTextField();
    JDatePicker fieldFechaVencimiento = new JDatePicker();

    JComboBox fieldStock = new JComboBox();
    JComboBox fieldCategoria = new JComboBox();

    JLabel labelName = new JLabel();
    JLabel title = new JLabel();
    JLabel labelPrecio = new JLabel();
    JLabel labelFechaVencimiento = new JLabel();

    JButton buttonCreateProduct = new JButton();
    JButton buttonDeleteProduct = new JButton();
    JButton buttonUpdateProduct = new JButton();
    JButton buttonCancelProduct = new JButton();
    JTableComponent tableList;

    JLabel shearch = new JLabel();
    private JTableSearch fieldSearch;

    private final int x = 1500;
    private final int y = 1500;

    public ProductoView(ArrayList<Producto> result) {

        setSize(x, y);
        setLayout(null);

        title.setText("Gestionar producto");
        title.setLocation(0, 0);
        title.setSize(850, 40);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));

        labelName.setText("  Nombre del Producto");
        labelName.setLocation(90, 140);
        labelName.setSize(250, 30);
        labelName.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        fieldName.setLocation(90, 190);
        fieldName.setSize(230, 30);
        fieldName.setFont(new Font("Segoe UI Light", BOLD, 20));

        labelPrecio.setText("    Precio del producto");
        labelPrecio.setLocation(90, 240);
        labelPrecio.setSize(250, 30);
        labelPrecio.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        fieldPrecio.setLocation(90, 290);
        fieldPrecio.setSize(230, 30);
        fieldPrecio.setFont(new Font("Segoe UI Light", BOLD, 20));

        labelFechaVencimiento.setText("  Fecha de Vencimiento");
        labelFechaVencimiento.setLocation(90, 340);
        labelFechaVencimiento.setSize(250, 30);
        labelFechaVencimiento.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        fieldFechaVencimiento.setLocation(90, 390);
        fieldFechaVencimiento.setSize(230, 30);
        fieldFechaVencimiento.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 18));

        fieldCategoria.setLocation(90, 440);
        fieldCategoria.setSize(230, 30);
        fieldCategoria.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 18));
        fieldCategoria.addItem("Seleccionar Categoria");
        ArrayList<TipoProducto> categoria = new TipoProductoModel().getAll();

        fieldStock.setLocation(90, 490);
        fieldStock.setSize(230, 30);
        fieldStock.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 18));
        fieldStock.addItem("Seleccionar Stock");

        for (int i = 0; i <= 50; i++) {
            fieldStock.addItem(i);
        }

        buttonCreateProduct = new JButton("Crear Producto");
        buttonCreateProduct.setLocation(90, 550);
        buttonCreateProduct.setSize(230, 30);
        buttonCreateProduct.setBackground(orange);
        buttonCreateProduct.setForeground(white);
        buttonCreateProduct.setFocusable(false);
        buttonCreateProduct.setBorder(null);
        buttonCreateProduct.setFont(new Font("Arial", BOLD, 15));

        buttonCancelProduct = new JButton("Cancelar");
        buttonCancelProduct.setLocation(90, 600);
        buttonCancelProduct.setSize(230, 30);
        buttonCancelProduct.setBackground(orange);
        buttonCancelProduct.setForeground(white);
        buttonCancelProduct.setFocusable(false);
        buttonCancelProduct.setBorder(null);
        buttonCancelProduct.setFont(new Font("Arial", BOLD, 15));
        buttonCancelProduct.setVisible(false);
        for (int i = 0; i < categoria.size(); i++) {
            fieldCategoria.addItem(new JComboItem(categoria.get(i).getTipProId(), categoria.get(i).getTipProNombre()));
        }

        String columns[] = {"id", "Nombre", "Stock", "Precio", "Fecha Vencimiento", "Categoria"};
        tableList = new JTableComponent(columns);
        tableList.getTable().getColumnModel().getColumn(1).setMinWidth(100);
        tableList.getTable().getColumnModel().getColumn(2).setMaxWidth(50);
        tableList.getTable().getColumnModel().getColumn(3).setMaxWidth(60);

        for (int i = 0; i < result.size(); i++) {
            Object rs[] = {result.get(i), result.get(i).getProNombre(), result.get(i).getProStock(), "$ "
                + result.get(i).getProPrecio(), Resource.transformFecha(result.get(i).getProFechaVencimiento()), result.get(i).getTipProNombre()};
            tableList.getModel().addRow(rs);
        }

        tableList.centerData(2);
        tableList.centerData(3);
        tableList.centerData(4);
        tableList.centerData(5);

        tableList.getScrollTable().setLocation(450, 150);
        tableList.getScrollTable().setSize(500, 500);

        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(750, 110);
        fieldSearch.setSize(200, 30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));

        shearch.setText("Buscar : ");
        shearch.setLocation(670, 100);
        shearch.setSize(100, 40);
        shearch.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        buttonDeleteProduct = new JButton("Eliminar Producto");
        buttonDeleteProduct.setLocation(450, 670);
        buttonDeleteProduct.setSize(230, 30);
        buttonDeleteProduct.setBackground(orange);
        buttonDeleteProduct.setForeground(white);
        buttonDeleteProduct.setFocusable(false);
        buttonDeleteProduct.setBorder(null);
        buttonDeleteProduct.setFont(new Font("Arial", BOLD, 15));

        buttonUpdateProduct = new JButton("Actualizar Producto");
        buttonUpdateProduct.setLocation(720, 670);
        buttonUpdateProduct.setSize(230, 30);
        buttonUpdateProduct.setBackground(orange);
        buttonUpdateProduct.setForeground(white);
        buttonUpdateProduct.setFocusable(false);
        buttonUpdateProduct.setBorder(null);
        buttonUpdateProduct.setFont(new Font("Arial", BOLD, 15));

        add(title);

        add(shearch);
        add(fieldSearch);

        add(buttonCancelProduct);
        add(buttonDeleteProduct);
        add(buttonUpdateProduct);

        add(labelName);
        add(fieldName);

        add(fieldCategoria);
        add(labelPrecio);
        add(fieldPrecio);

        add(fieldStock);

        add(labelFechaVencimiento);
        add(fieldFechaVencimiento);

        add(buttonCreateProduct);
        add(tableList.getScrollTable());

        setVisible(true);

    }

    public JComboBox getFieldStock() {
        return fieldStock;
    }

    public JTextField getFieldPrecio() {
        return fieldPrecio;
    }

    public JTextField getFieldName() {
        return fieldName;
    }

    public JDatePicker getFieldFechaVencimiento() {
        return fieldFechaVencimiento;
    }

    public JComboBox getFieldCategoria() {
        return fieldCategoria;
    }

    public JButton getButtonCreateProduct() {
        return buttonCreateProduct;
    }

    public JButton getButtonDeleteProduct() {
        return buttonDeleteProduct;
    }

    public JButton getButtonUpdateProduct() {
        return buttonUpdateProduct;
    }

    public JButton getButtonCancelProduct() {
        return buttonCancelProduct;
    }

    public JTableComponent getTableList() {
        return tableList;
    }

}
