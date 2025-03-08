
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarpetaClases;

import java.util.ArrayList;

/**
 *
 * @author garca
 */
public class Producto {

    private int id;
    private int codigo;
    private String Nombre;
    private Float Precio;
    private CatalogoProductos catalogo;
    ArrayList<DetalleVenta> DetalleVenta;
    ArrayList<DetallePedido> DetallePedido;
    Cortes corte;
    Stock stock;
    public Producto (){
        DetalleVenta = new ArrayList();
        DetallePedido = new ArrayList();
    }

    public ArrayList<DetalleVenta> getDetalleVenta() {
        return DetalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> DetalleVenta) {
        this.DetalleVenta = DetalleVenta;
    }

    public ArrayList<DetallePedido> getDetallePedido() {
        return DetallePedido;
    }

    public void setDetallePedido(ArrayList<DetallePedido> DetallePedido) {
        this.DetallePedido = DetallePedido;
    }
    
    

    public void adddetalles(DetalleVenta detalle){
        DetalleVenta.add(detalle);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public CatalogoProductos getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(CatalogoProductos catalogo) {
        this.catalogo = catalogo;
    }

    public Cortes getCorte() {
        return corte;
    }

    public void setCorte(Cortes corte) {
        this.corte = corte;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
}
