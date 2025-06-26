package club;

import java.util.ArrayList;

public class Socio {
    public enum Tipo { VIP, REGULAR }

    private String nombre;
    private String cedula;
    private Tipo tipo;
    private double fondos;
    private ArrayList<String> autorizados = new ArrayList<>();
    private ArrayList<Factura> facturas = new ArrayList<>();

    public Socio(String nombre, String cedula, Tipo tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipo = tipo;
        this.fondos = tipo == Tipo.VIP ? 100 : 50;
    }

    public String getCedula() {
        return cedula;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public ArrayList<String> getAutorizados() {
        return autorizados;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void agregarAutorizado(String nombre) throws ValorInvalido {
        if (nombre.isEmpty()) throw new ValorInvalido("Nombre de autorizado inválido");
        autorizados.add(nombre);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public void aumentarFondos(double monto) throws ValorInvalido {
        if (monto <= 0) throw new ValorInvalido("Monto inválido para aumentar fondos");
        fondos += monto;
    }

    public void descontarFondos(double monto) throws ValorInvalido {
        if (monto > fondos) throw new ValorInvalido("Fondos insuficientes");
        fondos -= monto;
    }
}
