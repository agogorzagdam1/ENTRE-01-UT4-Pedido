
/**
 * Modela un pedido realizado por un cliente en una determinada fecha
 * El pedido incluye dos líneas de pedido que describen a cada uno de los dos
 * productos comprados en el pedido
 */
public class Pedido
{
    private final double IVA = 0.21;  // iva a aplicar
    private Fecha fecha;
    private Cliente cliente;
    private LineaPedido linea1;
    private LineaPedido linea2;

    /**
     * Constructor  
     */
    public Pedido(Fecha fecha, Cliente cliente, LineaPedido linea1, LineaPedido linea2){
        this.cliente = cliente;
        this.fecha = fecha;
        this.linea1 = linea1;
        this.linea2 = linea2;
    }

    /**
     * accesor para la fecha del pedido
     */
    public String getFecha() {
        return fecha.toString();
    }

    /**
     * accesor para el cliente
     */
    public String getCliente() {
        return cliente.toString();
    }

    /**
     * calcular y devolver el importe total del pedido sin Iva
     */
    public double getImporteAntesIva() {
        Producto pro1 = linea1.getProducto();
        double pre1 = pro1.getPrecio() * linea1.getCantidad();
        Producto pro2 = linea2.getProducto();
        double pre2 = pro2.getPrecio() * linea2.getCantidad();
        return pre1 + pre2;
    }

    /**
     * calcular y devolver el iva a aplicar
     */ 
    public double getIva() {
        return (getImporteAntesIva() + (getImporteAntesIva() * IVA)) - getImporteAntesIva();
    }

    /**
     * calcular y devolver el importe total del pedido con Iva
     */
    public double getImporteTotal() {
        return getImporteAntesIva() +  getIva();
    }

    /**
     * Representación textual del pedido
     * (ver enunciado)
     */
    public String toString() {
        String sin="IMPOERTE SIN IVA";
        String v="IVA";
        String tot="IMPORTE TOTAL";
        return String.format("FECHA PEDIDO: %s\n%s\n \n****Artículos en el pedido****\n \n %s \n %s \n \n****A pagar****\n \n%20s: %8.2f € \n%20s: %8.2f € \n%20s: %8.2f €",
        fecha.toString(), cliente.toString(), linea1.toString(), linea2.toString() , sin, getImporteAntesIva(), v, getIva(), tot, getImporteTotal());
    }

    /**
    * devuelve true si el pedido actual es más antiguo que el recibido 
    * como parámetro
    */
    public boolean masAntiguoQue(Pedido otro) {
    Fecha otraF = otro.fecha;
    return otraF.antesQue(fecha);
    }

    /**
     * devuelve una referencia al pedido actual
     */
    public Pedido getPedidoActual() {
        Pedido pedido = new Pedido(fecha, cliente, linea1, linea2);
        return pedido;
    }

}
