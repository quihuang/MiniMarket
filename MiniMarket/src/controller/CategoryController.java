package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Table.TipoProducto;
import model.TipoProductoModel;
import view.Resource;

public class CategoryController implements ActionListener {

    private view.CategoryView vista;
    private TipoProductoModel model;
    private boolean stateButtonUpdate;
    private ArrayList<TipoProducto> categ;

    public CategoryController() {

        model = new TipoProductoModel();
        categ = model.getAll();
        vista = new view.CategoryView(categ);
        vista.getButtonCreateCategory().addActionListener(this);
        vista.getButtonDeleteCategory().addActionListener(this);
        vista.getButtonUpdateCategory().addActionListener(this);
        vista.getButtonCancelCategory().addActionListener(this);
        stateButtonUpdate = false;

    }

    public view.CategoryView getVista() {
        return vista;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.getButtonCreateCategory())) {

            if (vista.getFieldName().getText().equals("") || vista.getFieldIva().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                TipoProducto p = new TipoProducto();
                System.out.println(vista.getFieldIva().getSelectedItem());
                p.setTipProIva(vista.getFieldIva().getSelectedItem().toString());
                p.setTipProNombre(vista.getFieldName().getText());

                p = model.create(p);
                if (p != null) {
                    Object rs[] = {p, p.getTipProNombre(), p.getTipProIva()};
                    vista.getTableList().getModel().addRow(rs);
                    vista.getFieldName().setText("");
                    vista.getFieldIva().setSelectedIndex(0);
                    categ.add(p);

                    JOptionPane.showMessageDialog(null, "Se ha creado la categoria de manera correcta");
                } else {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
                }
            }
        } else if (e.getSource().equals(vista.getButtonUpdateCategory())) {

            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {

                TipoProducto tp = (TipoProducto) vista.getTableList().getObject();
                if (stateButtonUpdate == false) {
                    vista.getButtonCreateCategory().setEnabled(false);
                    vista.getButtonDeleteCategory().setEnabled(false);
                    vista.getButtonCancelCategory().setEnabled(true);
                    vista.getButtonCancelCategory().setVisible(true);
                    vista.getTableList().getTable().setEnabled(false);

                    stateButtonUpdate = true;

                    vista.getFieldName().setText(tp.getTipProNombre());
                    Resource.setSelectedCombobox(vista.getFieldIva(), tp.getTipProIva());

                } else {

                    if (vista.getFieldName().getText().equals("") || vista.getFieldIva().getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        tp.setTipProNombre(vista.getFieldName().getText());
                        tp.setTipProIva(vista.getFieldIva().getSelectedItem().toString());
                        if (model.update(tp)) {
                            vista.getButtonCreateCategory().setEnabled(true);
                            vista.getButtonDeleteCategory().setEnabled(true);
                            vista.getButtonCancelCategory().setEnabled(false);
                            vista.getButtonCancelCategory().setVisible(false);
                            vista.getTableList().getTable().setEnabled(true);
                            vista.getFieldIva().setSelectedIndex(0);
                            vista.getFieldName().setText("");
                            stateButtonUpdate = false;

                            vista.getTableList().getModel().setValueAt(tp, vista.getTableList().getTable().getSelectedRow(), 0);
                            vista.getTableList().getModel().setValueAt(tp.getTipProNombre(), vista.getTableList().getTable().getSelectedRow(), 1);
                            vista.getTableList().getModel().setValueAt(tp.getTipProIva(), vista.getTableList().getTable().getSelectedRow(), 2);

                            JOptionPane.showMessageDialog(null, "Se ha actualizado el tipo de producto correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la actualizacion", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }

            }

        } else if (e.getSource().equals(vista.getButtonDeleteCategory())) {

            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                TipoProducto tp = (TipoProducto) vista.getTableList().getObject();
                tp.setTblEstado_EstId("2");
                int valDelete = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (valDelete == JOptionPane.YES_NO_OPTION) {
                    if (model.update(tp)) {

                        vista.getTableList().getModel().removeRow(vista.getTableList().getTable().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Se ha Eliminado el tipo de producto correctamente");

                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Eliminacion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        } else if (e.getSource().equals(vista.getButtonCancelCategory())) {
            vista.getButtonCancelCategory().setVisible(false);
            vista.getButtonCancelCategory().setEnabled(false);
            vista.getButtonCreateCategory().setEnabled(true);
            vista.getButtonDeleteCategory().setEnabled(true);
            vista.getTableList().getTable().setEnabled(true);
            vista.getTableList().getTable().clearSelection();
            stateButtonUpdate = false;
            vista.getFieldIva().setSelectedIndex(0);
            vista.getFieldName().setText("");
        }
    }

}
