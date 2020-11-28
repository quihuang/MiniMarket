package model.Table;

public class Producto {

    private String ProRef;
    private String ProNombre;
    private String ProPrecio;
    private String ProStock;
    private String TblEstado_EstId;
    private String ProFechaVencimiento;
    private String TblTipoProducto_TipId;
    private String TipProNombre;
    private String TblEstado_EstEstado;
    private String cantidad;
    private String TblTipoProducto_TipProIva;

    public String getTblEstado_EstEstado() {
        return TblEstado_EstEstado;
    }

    public void setTblEstado_EstEstado(String TblEstado_EstEstado) {
        this.TblEstado_EstEstado = TblEstado_EstEstado;
    }

    public String getProRef() {
        return ProRef;
    }

    public void setProRef(String ProRef) {
        this.ProRef = ProRef;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }

    public String getProPrecio() {
        return ProPrecio;
    }

    public void setProPrecio(String ProPrecio) {
        this.ProPrecio = ProPrecio;
    }

    public String getProStock() {
        return ProStock;
    }

    public void setProStock(String ProStock) {
        this.ProStock = ProStock;
    }

    public String getTblEstado_EstId() {
        return TblEstado_EstId;
    }

    public void setTblEstado_EstId(String TblEstado_EstId) {
        this.TblEstado_EstId = TblEstado_EstId;
    }

    public String getProFechaVencimiento() {
        return ProFechaVencimiento;
    }

    public void setProFechaVencimiento(String ProFechaVencimiento) {
        this.ProFechaVencimiento = ProFechaVencimiento;
    }

    public String getTblTipoProducto_TipId() {
        return TblTipoProducto_TipId;
    }

    public void setTblTipoProducto_TipId(String TblTipoProducto_TipId) {
        this.TblTipoProducto_TipId = TblTipoProducto_TipId;
    }

    public String getTipProNombre() {
        return TipProNombre;
    }

    public void setTipProNombre(String TipProNombre) {
        this.TipProNombre = TipProNombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTblTipoProducto_TipProIva() {
        return TblTipoProducto_TipProIva;
    }

    public void setTblTipoProducto_TipProIva(String TblTipoProducto_TipProIva) {
        this.TblTipoProducto_TipProIva = TblTipoProducto_TipProIva;
    }

}
