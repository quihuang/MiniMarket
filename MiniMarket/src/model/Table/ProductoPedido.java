package model.Table;

public class ProductoPedido {

    private String ProPedId;
    private String TblProducto_ProRef;
    private String TblPedido_PedId;
    private String ProPedCantidad;

    public String getProPedCantidad() {
        return ProPedCantidad;
    }

    public void setProPedCantidad(String ProPedCantidad) {
        this.ProPedCantidad = ProPedCantidad;
    }

    public String getProPedId() {
        return ProPedId;
    }

    public void setProPedId(String ProPedId) {
        this.ProPedId = ProPedId;
    }

    public String getTblProducto_ProRef() {
        return TblProducto_ProRef;
    }

    public void setTblProducto_ProRef(String TblProducto_ProRef) {
        this.TblProducto_ProRef = TblProducto_ProRef;
    }

    public String getTblPedido_PedId() {
        return TblPedido_PedId;
    }

    public void setTblPedido_PedId(String TblPedido_PedId) {
        this.TblPedido_PedId = TblPedido_PedId;
    }

}
