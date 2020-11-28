package model.Table;

public class Pedido {

    private String PedId;
    private String PedFecha;
    private String TblUsuario_UsuIdentificacion;
    private String TblMetodoPago_MetId;

    public String getPedId() {
        return PedId;
    }

    public void setPedId(String PedId) {
        this.PedId = PedId;
    }

    public String getPedFecha() {
        return PedFecha;
    }

    public void setPedFecha(String PedFecha) {
        this.PedFecha = PedFecha;
    }

    public String getTblUsuario_UsuIdentificacion() {
        return TblUsuario_UsuIdentificacion;
    }

    public void setTblUsuario_UsuIdentificacion(String TblUsuario_UsuIdentificacion) {
        this.TblUsuario_UsuIdentificacion = TblUsuario_UsuIdentificacion;
    }

    public String getTblMetodoPago_MetId() {
        return TblMetodoPago_MetId;
    }

    public void setTblMetodoPago_MetId(String TblMetodoPago_MetId) {
        this.TblMetodoPago_MetId = TblMetodoPago_MetId;
    }

}
