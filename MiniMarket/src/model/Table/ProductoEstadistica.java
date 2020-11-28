/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

/**
 *
 * @author pc-standard
 */
public class ProductoEstadistica {
    
    private String TblProducto_ProRef;
    private String ProNombre;
    private String ProPedCantidad;
    private String TotalSinIVA;
    private String TotalConIVA;
    private String Promedio;

    public String getTotalSinIVA() {
        return TotalSinIVA;
    }

    public void setTotalSinIVA(String TotalSinIVA) {
        this.TotalSinIVA = TotalSinIVA;
    }

    public String getTotalConIVA() {
        return TotalConIVA;
    }

    public void setTotalConIVA(String TotalConIVA) {
        this.TotalConIVA = TotalConIVA;
    }

    public String getPromedio() {
        return Promedio;
    }

    public void setPromedio(String Promedio) {
        this.Promedio = Promedio;
    }

    public String getTblProducto_ProRef() {
        return TblProducto_ProRef;
    }

    public void setTblProducto_ProRef(String TblProducto_ProRef) {
        this.TblProducto_ProRef = TblProducto_ProRef;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }

    public String getProPedCantidad() {
        return ProPedCantidad;
    }

    public void setProPedCantidad(String ProPedCantidad) {
        this.ProPedCantidad = ProPedCantidad;
    }
        
}
