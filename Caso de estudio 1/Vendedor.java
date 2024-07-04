package com.intro.control_de_facturas;

public class Vendedor {
    // Creamos las variables con sus tipos
    private String nombre;
    private String cedula;
    private String codigo;
    private String sucursal;
    private boolean vehiculoPropio;
    private double ventasTotales;
    private double comisiones;
    private int puntos;
    private int numFacturas;
    private String mes;

    public Vendedor(String nombre, String cedula, String codigo, String sucursal, boolean vehiculoPropio) {
        // Asignamos/Igualamos los valores de las variables que habíamos definido
        this.nombre = nombre;
        this.cedula = cedula;
        this.codigo = codigo;
        this.sucursal = sucursal;
        this.vehiculoPropio = vehiculoPropio;
        this.ventasTotales = 0;
        this.comisiones = 0;
        this.puntos = 0;
        this.numFacturas = 0;
    }
    
    // Agregamos los datos de la factura
    public void agregarFactura(Factura factura) {
        this.numFacturas++;
        this.ventasTotales += factura.getMonto();
        calcularComisiones(factura);
        calcularPuntos(factura);
        this.mes = factura.getMesNombre();
    }
    
    // Calculamos las comisiones según los valores de las facturas
    private void calcularComisiones(Factura factura) {
        if (factura.tieneTresTiposProductos()) {
            this.comisiones += factura.getMonto() * 0.10;
        } else {
            if (factura.contieneProductosElectricos()) {
                this.comisiones += factura.getMonto() * (factura.getProductosElectricos() >= 3 ? 0.04 : 0.02);
                this.comisiones += factura.getMonto() * 0.01;  // Método calculaErroneo
            }
            if (factura.contieneProductosAutomotrices()) {
                this.comisiones += factura.getMonto() * (factura.getProductosAutomotrices() > 4 ? 0.04 : 0.02);
            }
            if (factura.contieneProductosConstruccion()) {
                this.comisiones += factura.getMonto() * 0.08;
            }
        }
        if (factura.getMonto() > 50000) {
            this.comisiones += factura.getMonto() * 0.05;
        }
    }
    
    // Calculamos los puntos según los datos de la o las facturas
    private void calcularPuntos(Factura factura) {
        if (factura.tieneTresTiposProductos()) {
            this.puntos += 3;
        } else {
            if (factura.contieneProductosElectricos()) {
                this.puntos += 1;
            }
            if (factura.contieneProductosAutomotrices()) {
                this.puntos += 1;
            }
            if (factura.contieneProductosConstruccion()) {
                this.puntos += 2;
            }
        }
        if (factura.getMonto() > 50000) {
            this.puntos += 1;
        }
    }
    
    // Calculamos y aplicamos el bono extra con el total de las factuiras y las ventas totales
    public void aplicarBonoExtra() {
        if (this.numFacturas > 10 || this.ventasTotales > 300000) {
            this.comisiones += 20000;
        }
    }
    
    // Calculamos los puntos extras con el dato de las ventas totales
    public void CalculoPuntosExtra() {
        this.comisiones += this.ventasTotales * 0.20;
    }
    
    // Según netbeans se puede agregar @Override pero no estoy seguro de cómo usarlo ahora, por eso no lo agrego
    public String toString() {
    return "El agente de ventas " +nombre+ " con el código: " +codigo+ " en el mes de: " +mes+ ".\n" +
           "Vendió un total de " +ventasTotales+ " en facturas.\n" +
           "Obtuvo un total en comisiones de " +comisiones+ ".\n" +
           (numFacturas > 10 || ventasTotales > 300000 ? "El agente de ventas logró el objetivo de llegar al bono extra.\n" : "El agente de ventas no logró el objetivo de llegar al bono extra.\n") +
           "El total de puntos obtenidos por el vendedor: " + puntos + ".\n" +
           "El agente de ventas " + (vehiculoPropio ? "sí" : "no") + " cuenta con vehículo propio.\n" +
           "Es de la sucursal: " + sucursal + ".\n";
    }
}