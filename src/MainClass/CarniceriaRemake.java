/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainClass;

import CarpetaClases.CatalogoProductos;
import CarpetaClases.Cliente;
import CarpetaClases.Cortes;
import CarpetaClases.Fecha;
import CarpetaClases.Pedido;
import CarpetaClases.Producto;
import DAO.ClienteDAO;
import DAO.CortesDAO;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author garca
 */
public class CarniceriaRemake extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Fecha fecha1 = new Fecha();
        LocalDate hoy = LocalDate.now();
        fecha1.setFecha(hoy);

         Probar ventas
       Venta v = new Venta();
       v.setTotal(100);
       v.setMedioDePago("Efectivo");
       v.setFecha(fecha1);
       
       VentaDAO ventadao = new VentaDAO();
       ventadao.agregarVenta(v);
        Cliente cliente = new Cliente();
        cliente.setNombre("Facundo");
        cliente.setApellido("Garnica");
        cliente.setTelefono("2216272337");
        ClienteDAO clientedao = new ClienteDAO();
        clientedao.agregarCliente(cliente);

        CatalogoProductos catalogo1 = new CatalogoProductos();
        catalogo1.setTipo("Carnes");

        Producto producto1 = new Producto();
        producto1.setCodigo(10);
        producto1.setNombre("Carne de Res");
        producto1.setPrecio(100.50f);  // El precio es un float
        producto1.setCatalogo(catalogo1);

        Pedido pedido1 = new Pedido();
        /*  private Cliente Cliente;
    private LocalDate FechaPedido;
    private String retirado;
    private double Senia;*/
        
        /*pedido1.setCliente(cliente);
        pedido1.setFechaPedido(hoy);
        pedido1.setRetiro("no");
        pedido1.setSenia(1500.00);
        
        DetallePedido detalle1 = new DetallePedido();
        detalle1.setCantidad(5);
        detalle1.setProducto(producto1);
        detalle1.setPedido(pedido1);
        detalle1.setUnidadmedida("Kilos");
        
        ProductoDAO productodao = new ProductoDAO();
        productodao.agregarProducto(producto1);
        DetallePedidoDAO detalledao = new DetallePedidoDAO();
        detalledao.agregarDetallePedido(detalle1);*/

        /*BoletaCarne boleta1 = new BoletaCarne();
        boleta1.setProveedor("Belgrano");
        boleta1.setTotal(900000);
        BoletaCarneDAO boletadao = new BoletaCarneDAO();
        boletadao.agregarBoletaCarne(boleta1);
        */
        
        /*Cortes corte = new Cortes();
        corte.setPeso(9);
        corte.setNombreCorte("Paleta");
        CortesDAO cortedao = new CortesDAO();
        cortedao.agregarCortes(corte);*/
        launch(args); 
        
        //System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Parametros para el MenuPrincipal
        Parent root = FXMLLoader.load(getClass().getResource("/MenuPrincipal/MenuPrincipal.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
       // stage.setMaximized(true);
        stage.show();
    }

}
