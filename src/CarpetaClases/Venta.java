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
public class Venta {

    private int id;  // ID de la venta
    private ArrayList<Producto> productos;  // Lista de productos asociados a la venta
    private int total;  // Total de la venta
    private String MedioDePago;
    private Fecha Fecha;

    public Fecha getFecha() {
        return Fecha;
    }

    public void setFecha(Fecha Fecha) {
        this.Fecha = Fecha;
    }

    
    public Venta(){
        productos = new ArrayList();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMedioDePago() {
        return MedioDePago;
    }

    public void setMedioDePago(String MedioDePago) {
        this.MedioDePago = MedioDePago;
    }



}