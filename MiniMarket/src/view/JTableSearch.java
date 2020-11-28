package view;

import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.RowFilter.regexFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class JTableSearch extends JTextField implements DocumentListener {

    private final JTable tableList;
    private TableRowSorter sorter;

    public JTableSearch(JTable tableList) {
        super();
        this.tableList = tableList;
        sorter = new TableRowSorter<>(tableList.getModel());

        tableList.setRowSorter(sorter);
        super.getDocument().addDocumentListener((DocumentListener) this);

    }

    public void insertUpdate(DocumentEvent e) {
        search(this.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        search(this.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        search(this.getText());
    }

    public void search(String str) {

        if (str.length() == 0) {
            sorter.setRowFilter(null);
        } else {

            sorter.setRowFilter(regexFilter("(?i)" + str));
        }

    }

}
