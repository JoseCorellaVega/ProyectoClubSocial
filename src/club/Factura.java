package club;

public class Factura {
    private static int contador = 1;
    private int numero;
    private String descripcion;
    private double valor;
    private boolean pagada;
    private Socio socio;

    public Factura(String descripcion, double valor, Socio socio) throws ValorInvalido {
        if (valor <= 0) throw new ValorInvalido("Valor de factura inválido");
        this.numero = contador++;
        this.descripcion = descripcion;
        this.valor = valor;
        this.pagada = false;
        this.socio = socio;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    public boolean estaPagada() {
        return pagada;
    }

    public void pagar() throws ValorInvalido {
        if (pagada) throw new ValorInvalido("Factura ya está pagada");
        socio.descontarFondos(valor);
        pagada = true;
    }
}
