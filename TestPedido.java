
/**
 *  Clase para probar el resto de clases
 *  
 */
public class TestPedido
{
    private Pedido pedido1; 
    private Pedido pedido2; 

    /**
     * Constructor  
     */
    public TestPedido()    {
        // crear pedido1
        Fecha fecha1 = new Fecha( 4, 9, 2019);
        Cliente cliente1 = new Cliente("Juan Soto", "Avda. Pio XII", "Pamplona", "Navarra");
        Producto primerProducto1 = new Producto("Rotulador Fosforescente", 6.70);
        Producto segundoProducto1 = new Producto("Memoria USB 64GB", 14.80);
        LineaPedido linea1 = new LineaPedido(primerProducto1, 20);
        LineaPedido linea2 = new LineaPedido(segundoProducto1, 10);
        pedido1 = new Pedido(fecha1, cliente1, linea1, linea2);
        // crear pedido2
        Fecha fecha2 = new Fecha( 8, 10, 2019);
        Cliente cliente2 = new Cliente("Elisa Nuin", "C/ Río Alzania 7", "Pamplona", "Navarra");
        Producto primerProducto2 = new Producto("Sacapuntas Manual", 16.64);
        Producto segundoProducto2 = new Producto("Corrector Tippex", 5.99);
        LineaPedido linea3 = new LineaPedido(primerProducto2, 8);
        LineaPedido linea4 = new LineaPedido(segundoProducto2, 20);
        pedido2 = new Pedido(fecha2, cliente2, linea3, linea4);
    }

    /**
     * Muestra la información de los dos pedidos (ver enunciado)
     */
    public void mostrarPedidos() {
        System.out.println("Pedido 1\n--------------------------------\n"  + pedido1.toString());
        System.out.println("Pedido 2\n--------------------------------\n"  + pedido2.toString());
        if (pedido1.masAntiguoQue(pedido2)){
            System.out.println("\nEl pedido 2 ha sido realizado antes que el pedido 1");
        } else {
            System.out.println("\nEl pedido 1 ha sido realizado antes que el pedido 2");

        }
    }
}
