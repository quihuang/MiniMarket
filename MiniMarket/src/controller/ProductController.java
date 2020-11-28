package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ProductoModel;
import model.Table.Producto;
import view.ProductoView;
import view.Resource;

public class ProductController implements ActionListener {

    private ProductoView vista;
    private ProductoModel model;
    private ArrayList<Producto> pro;
    private boolean stateButtonUpdate;

    public ProductController() {

        model = new ProductoModel();
        pro = model.getAll();
        vista = new ProductoView(pro);
        vista.getButtonCreateProduct().addActionListener(this);
        vista.getButtonDeleteProduct().addActionListener(this);
        vista.getButtonCancelProduct().addActionListener(this);
        vista.getButtonUpdateProduct().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonCreateProduct())) {

            if (vista.getFieldName().getText().equals("") || vista.getFieldPrecio().getText().equals("")
                    || vista.getFieldStock().getSelectedItem().equals("Seleccionar Stock")
                    || vista.getFieldCategoria().getSelectedItem().equals("Seleccionar Categoria")
                    || vista.getFieldFechaVencimiento().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                Producto p = new Producto();

                p.setProNombre(vista.getFieldName().getText());
                p.setProPrecio(vista.getFieldPrecio().getText());
                p.setProFechaVencimiento(vista.getFieldFechaVencimiento().getDate());
                p.setTblTipoProducto_TipId(String.valueOf(vista.getFieldCategoria().getSelectedItem().hashCode()));
                p.setProStock(vista.getFieldStock().getSelectedItem().toString());

                p = model.create(p);
                if (p != null) {
                    Object rs[] = {p, p.getProNombre(), p.getProStock(), "$ " + p.getProPrecio(), Resource.transformFecha(p.getProFechaVencimiento()), p.getTipProNombre()};
                    vista.getTableList().getModel().addRow(rs);
                    vista.getFieldName().setText("");
                    vista.getFieldPrecio().setText("");
                    vista.getFieldFechaVencimiento().setDefaultText();
                    vista.getFieldCategoria().setSelectedIndex(0);
                    vista.getFieldStock().setSelectedIndex(0);
                    pro.add(p);

                    JOptionPane.showMessageDialog(null, "Se ha creado el producto de manera correcta");
                } else {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
                }
            }
        } else if (e.getSource().equals(vista.getButtonDeleteProduct())) {
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                Producto p = (Producto) vista.getTableList().getObject();

                p.setTblEstado_EstId("2");
                int valDelete = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (valDelete == JOptionPane.YES_NO_OPTION) {
                    if (model.update(p)) {

                        vista.getTableList().getModel().removeRow(vista.getTableList().getTable().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Se ha Eliminado el producto correctamente");

                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Eliminacion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        } else if (e.getSource().equals(vista.getButtonUpdateProduct())) {
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                Producto p = (Producto) vista.getTableList().getObject();
                if (stateButtonUpdate == false) {
                    vista.getButtonCreateProduct().setEnabled(false);
                    vista.getButtonDeleteProduct().setEnabled(false);
                    vista.getButtonCancelProduct().setEnabled(true);
                    vista.getButtonCancelProduct().setVisible(true);
                    vista.getTableList().getTable().setEnabled(false);
                    stateButtonUpdate = true;
                    vista.getFieldName().setText(p.getProNombre());

                    double iva = (Double.parseDouble(p.getProPrecio()) - ((Double.parseDouble(p.getProPrecio()) * Integer.parseInt(p.getTblTipoProducto_TipProIva())) / 100));
                    int i = (int) (iva + 1);

                    System.out.println(i);
                    vista.getFieldPrecio().setText(String.valueOf(i));
                    vista.getFieldFechaVencimiento().setDate(p.getProFechaVencimiento());
                    Resource.setSelectedCombobox(vista.getFieldCategoria(), p.getTipProNombre());

                    Resource.setSelectedCombobox(vista.getFieldCategoria(), p.getTipProNombre());
                    Resource.setSelectedCombobox(vista.getFieldStock(), p.getProStock());

                } else {
                    if (vista.getFieldName().getText().equals("") || vista.getFieldCategoria().getSelectedIndex() == 0
                            || vista.getFieldStock().getSelectedIndex() == 0 || vista.getFieldPrecio().getText().equals("")
                            || vista.getFieldFechaVencimiento().getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {

                        p.setProNombre(vista.getFieldName().getText());
                        p.setProPrecio(vista.getFieldPrecio().getText());
                        p.setProStock(vista.getFieldStock().getSelectedItem().toString());
                        p.setProFechaVencimiento(vista.getFieldFechaVencimiento().getDate());
                        p.setTblTipoProducto_TipId(String.valueOf(vista.getFieldCategoria().getSelectedItem().hashCode()));

                        if (model.update(p)) {
                            vista.getButtonCreateProduct().setEnabled(true);
                            vista.getButtonDeleteProduct().setEnabled(true);
                            vista.getButtonCancelProduct().setEnabled(false);
                            vista.getButtonCancelProduct().setVisible(false);
                            vista.getTableList().getTable().setEnabled(true);
                            vista.getFieldName().setText("");
                            vista.getFieldPrecio().setText("");
                            vista.getFieldFechaVencimiento().setDefaultText();

                            stateButtonUpdate = false;

                            vista.getTableList().getModel().setValueAt(p, vista.getTableList().getTable().getSelectedRow(), 0);
                            vista.getTableList().getModel().setValueAt(p.getProNombre(), vista.getTableList().getTable().getSelectedRow(), 1);
                            vista.getTableList().getModel().setValueAt(p.getProStock(), vista.getTableList().getTable().getSelectedRow(), 2);
                            vista.getTableList().getModel().setValueAt("$ " + p.getProPrecio(), vista.getTableList().getTable().getSelectedRow(), 3);
                            vista.getTableList().getModel().setValueAt(Resource.transformFecha(p.getProFechaVencimiento()), vista.getTableList().getTable().getSelectedRow(), 4);
                            vista.getTableList().getModel().setValueAt(vista.getFieldCategoria().getSelectedItem().toString(), vista.getTableList().getTable().getSelectedRow(), 5);

                            JOptionPane.showMessageDialog(null, "Se ha actualizado el tipo de producto correctamente");

                            vista.getFieldStock().setSelectedIndex(0);
                            vista.getFieldCategoria().setSelectedIndex(0);

                        } else {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la actualizacion", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
            }

        } else if (e.getSource().equals(vista.getButtonCancelProduct())) {
            vista.getButtonCancelProduct().setVisible(false);
            vista.getButtonCancelProduct().setEnabled(false);
            vista.getButtonCreateProduct().setEnabled(true);
            vista.getButtonDeleteProduct().setEnabled(true);
            vista.getTableList().getTable().setEnabled(true);
            vista.getTableList().getTable().clearSelection();
            stateButtonUpdate = false;
            vista.getFieldCategoria().setSelectedIndex(0);
            vista.getFieldStock().setSelectedIndex(0);

            vista.getFieldName().setText("");
            vista.getFieldPrecio().setText("");
            vista.getFieldFechaVencimiento().setDefaultText();

        }
    }

    public ProductoView getVista() {
        return vista;
    }

}
