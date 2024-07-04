package com.intro.control_de_facturas;

import javax.swing.JOptionPane;

public class ControlDeFacturas {
    public static void main(String[] args) {
        String nombreVendedor = JOptionPane.showInputDialog("Ingrese el nombre del agente de ventas:");
        String cedulaVendedor = JOptionPane.showInputDialog("Ingrese la cédula del agente de ventas:");
        String codigoVendedor = JOptionPane.showInputDialog("Ingrese el código del agente de ventas:");
        String sucursalVendedor = JOptionPane.showInputDialog("Ingrese la sucursal a la que pertenece el agente de ventas:");
        boolean vehiculoPropio = JOptionPane.showConfirmDialog(null, "¿Tiene vehículo propio?", "Vehículo Propio", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        Vendedor vendedor = new Vendedor(nombreVendedor, cedulaVendedor, codigoVendedor, sucursalVendedor, vehiculoPropio);

        while (true) {
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String cedulaCliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
            String codigoFactura = JOptionPane.showInputDialog("Ingrese el código de la factura:");
            double montoFactura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de la factura:"));
            int mesFactura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del mes (1-12):"));

            boolean productosElectricos = JOptionPane.showConfirmDialog(null, "¿La factura contiene productos eléctricos?", "Productos Eléctricos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            boolean productosAutomotrices = JOptionPane.showConfirmDialog(null, "¿La factura contiene productos automotrices?", "Productos Automotrices", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            boolean productosConstruccion = JOptionPane.showConfirmDialog(null, "¿La factura contiene productos de construcción?", "Productos Construcción", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            int totalProductosElectricos = 0;
            int totalProductosAutomotrices = 0;
            int totalProductosConstruccion = 0;

            if (productosElectricos) {
                totalProductosElectricos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos eléctricos:"));
            }
            if (productosAutomotrices) {
                totalProductosAutomotrices = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos automotrices:"));
            }
            if (productosConstruccion) {
                totalProductosConstruccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos de construcción:"));
            }

            Factura factura = new Factura(nombreCliente, cedulaCliente, codigoFactura, montoFactura, mesFactura, productosElectricos, productosAutomotrices, productosConstruccion, totalProductosElectricos, totalProductosAutomotrices, totalProductosConstruccion);

            vendedor.agregarFactura(factura);

            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra factura?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (continuar == JOptionPane.NO_OPTION) {
                break;
            }
        }

        vendedor.aplicarBonoExtra();
        vendedor.CalculoPuntosExtra();

        JOptionPane.showMessageDialog(null, vendedor.toString());
    }
}
