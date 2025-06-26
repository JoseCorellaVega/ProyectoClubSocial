package club;

import java.util.ArrayList;

public class Club {
    private ArrayList<Socio> socios = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();

    public void afiliarSocio(String nombre, String cedula, Socio.Tipo tipo) throws ValorInvalido {
        if (nombre.isEmpty() || cedula.isEmpty()) throw new ValorInvalido("Nombre o cédula vacíos");
        socios.add(new Socio(nombre, cedula, tipo));
    }

    public void registrarAutorizado(String cedula, String nombre) throws SocioNoEncontrado, ValorInvalido {
        Socio socio = buscarSocio(cedula);
        socio.agregarAutorizado(nombre);
    }

    public void pagarFactura(int numeroFactura) throws FacturaNoEncontrada, ValorInvalido {
        Factura factura = buscarFactura(numeroFactura);
        factura.pagar();
    }

    public void registrarConsumo(String cedula, String descripcion, double valor) throws SocioNoEncontrado, ValorInvalido {
        Socio socio = buscarSocio(cedula);
        Factura f = new Factura(descripcion, valor, socio);
        facturas.add(f);
        socio.agregarFactura(f);
    }

    public void aumentarFondos(String cedula, double monto) throws SocioNoEncontrado, ValorInvalido {
        Socio socio = buscarSocio(cedula);
        socio.aumentarFondos(monto);
    }

    private Socio buscarSocio(String cedula) throws SocioNoEncontrado {
        for (Socio s : socios) {
            if (s.getCedula().equals(cedula)) return s;
        }
        throw new SocioNoEncontrado("Socio no encontrado: " + cedula);
    }

    private Factura buscarFactura(int numero) throws FacturaNoEncontrada {
        for (Factura f : facturas) {
            if (f.getNumero() == numero) return f;
        }
        throw new FacturaNoEncontrada("Factura no encontrada: " + numero);
    }

    public double obtenerTotalConsumos(String cedula) throws SocioNoExisteException {
        for (Socio s : socios) {
            if (s.getCedula().equals(cedula)) {
                double total = 0;
                for (Factura f : s.getFacturas()) {
                    total += f.getValor();
                }
                return total;
            }
        }
        throw new SocioNoExisteException("Socio no existe con cédula: " + cedula);
    }

    public boolean sePuedeEliminarSocio(String cedula) throws SocioNoExisteException {
        for (Socio s : socios) {
            if (s.getCedula().equals(cedula)) {
                if (s.getTipo() == Socio.Tipo.VIP) return false;
                if (s.getAutorizados().size() > 1) return false;
                for (Factura f : s.getFacturas()) {
                    if (!f.estaPagada()) return false;
                }
                return true;
            }
        }
        throw new SocioNoExisteException("Socio no existe con cédula: " + cedula);
    }
}
