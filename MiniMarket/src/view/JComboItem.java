package view;

public class JComboItem {

    private String name;
    private String id;

    public JComboItem(String id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id);
    }
}
