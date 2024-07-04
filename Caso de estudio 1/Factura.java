package com.intro.control_de_facturas;

public class Factura {
    // Creamos las variables privadas con sus tipos
    private String nombreCliente;
    private String cedulaCliente;
    private String codigoFactura;
    private double monto;
    private int mes;
    private boolean productosElectricos;
    private boolean productosAutomotrices;
    private boolean productosConstruccion;
    private int totalProductosElectricos;
    private int totalProductosAutomotrices;
    private int totalProductosConstruccion;

    
    public Factura(String nombreCliente, String cedulaCliente, String codigoFactura, double monto, int mes, boolean productosElectricos, boolean productosAutomotrices, boolean productosConstruccion, int cantidadProductosElectricos, int cantidadProductosAutomotrices, int cantidadProductosConstruccion) {
        // Igualamos las variables que ya habíamos definido
        this.nombreCliente = nombreCliente;
        this.cedulaCliente = cedulaCliente;
        this.codigoFactura = codigoFactura;
        this.monto = monto;
        this.mes = mes;
        this.productosElectricos = productosElectricos;
        this.productosAutomotrices = productosAutomotrices;
        this.productosConstruccion = productosConstruccion;
        this.totalProductosElectricos = totalProductosElectricos;
        this.totalProductosAutomotrices = totalProductosAutomotrices;
        this.totalProductosConstruccion = totalProductosConstruccion;
    }
    
    // Con este método podemos definir el monto de la factura
    public double getMonto() {
        return monto;
    }
    // Con este método podemos definir los tipos de de productos en la factura
    public boolean tieneTresTiposProductos() {
        return productosElectricos && productosAutomotrices && productosConstruccion;
    }
    // Con este método podemos definir si contiene productos eléctricos
    public boolean contieneProductosElectricos() {
        return productosElectricos;
    }
    // Con este método podemos definir si contiene productos automotrices
    public boolean contieneProductosAutomotrices() {
        return productosAutomotrices;
    }
    // Con este método podemos definir si contiene productos de construcción
    public boolean contieneProductosConstruccion() {
        return productosConstruccion;
    }
    // Con este método podemos pedir el total de productos eléctricos
    public int getProductosElectricos() {
        return totalProductosElectricos;
    }
    // Con este método podemos pedir el total de productos automotrices
    public int getProductosAutomotrices() {
        return totalProductosAutomotrices;
    }
    // Con este método podemos pedir el total de productos de construcción
    public int getProductosConstruccion() {
        return totalProductosConstruccion;
    }
    // Acá agrego el switch para que me dé el mes según el número que se ingresa    
    public String getMesNombre() {
      switch (mes) {
          case 1: return "Enero";
          case 2: return "Febrero";
          case 3: return "Marzo";
          case 4: return "Abril";
          case 5: return "Mayo";
          case 6: return "Junio";
          case 7: return "Julio";
          case 8: return "Agosto";
          case 9: return "Septiembre";
          case 10: return "Octubre";
          case 11: return "Noviembre";
          case 12: return "Diciembre";
          default: return "Mes inválido";
      }
    }  
}

