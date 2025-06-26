package club;
import java.util.ArrayList;

public class Socio
{

    public enum Tipo
    {

        VIP,

        REGULAR
    }

    public final static double FONDOS_INICIALES_REGULARES = 50;

    public final static double FONDOS_INICIALES_VIP = 100;


    public final static double MONTO_MAXIMO_REGULARES = 1000;


    public final static double MONTO_MAXIMO_VIP = 5000;


    private String cedula;

    private String nombre;


    private double fondos;


    private Tipo tipoSubscripcion;


    private ArrayList<Factura> facturas;

    private ArrayList<String> autorizados;

    public Socio( String pCedula, String pNombre, Tipo pTipo )
    {
        cedula = pCedula;
        nombre = pNombre;
        tipoSubscripcion = pTipo;

        switch( tipoSubscripcion )
        {
            case VIP:
                fondos = FONDOS_INICIALES_VIP;
                break;
            default:
                fondos = FONDOS_INICIALES_REGULARES;
        }

        facturas = new ArrayList<Factura>( );
        autorizados = new ArrayList<String>( );
    }


    public String darNombre( )
    {
        return nombre;
    }


    public String darCedula( )
    {
        return cedula;
    }


    public double darFondos( )
    {
        return fondos;
    }


    public Tipo darTipo( )
    {
        return tipoSubscripcion;
    }


    public ArrayList<Factura> darFacturas( )
    {
        return facturas;
    }


    public ArrayList<String> darAutorizados( )
    {
        return autorizados;
    }


    private boolean existeAutorizado( String pNombreAutorizado )
    {
        boolean encontro = false;

        for( int i = 0; i < autorizados.size( ) && !encontro; i++ )
        {
            String a = autorizados.get( i );
            if( a.equals( pNombreAutorizado ) )
            {
                encontro = true;
            }
        }
        return encontro;
    }
    

    private boolean tieneFacturaAsociada( String pNombreAutorizado)
    {
        boolean tiene = false;
        for( int i = 0; i < facturas.size( ) && !tiene; i++ )
        {
            Factura factura = facturas.get( i );
            if( factura.darNombre( ).equals( pNombreAutorizado ) )
            {
                tiene = true;
            }
        }
        
        return tiene;
    }


    public void aumentarFondos( double pFondos )
    {
        if( tipoSubscripcion == Tipo.VIP && pFondos + fondos > MONTO_MAXIMO_VIP )
        {
            System.out.println("Con este monto se exceder�an los fondos m�ximos de un socio VIP, ingrese una cantidad menor" );


        }
        else if( tipoSubscripcion == Tipo.REGULAR && pFondos + fondos > MONTO_MAXIMO_REGULARES )
        {
            System.out.println( "Con este monto se exceder�an los fondos m�ximos de un socio regular, ingrese una cantidad menor" );
        }
        else
        {
            fondos = fondos + pFondos;
        }
    }


    public void registrarConsumo( String pNombre, String pConcepto, double pValor )
    {

        if( pValor > fondos )
        {
            System.out.println( "El socio no posee fondos suficientes para este consumo" );
        }
        else
        {
            Factura nuevaFactura = new Factura( pNombre, pConcepto, pValor );
            facturas.add( nuevaFactura );
        }
    }


    public void agregarAutorizado( String pNombreAutorizado )
    {
        // Verificar que el nombre del socio no es el mismo del que se quiere autorizar
        if( pNombreAutorizado.equals( darNombre( ) ) )
        {
            System.out.println( "No puede agregar el socio como autorizado." );
        }

        // Verificar que el socio posee fondos para financiar un nuevo autorizado
        if( fondos == 0 )
        {
            System.out.println( "El socio no tiene fondos para financiar un nuevo autorizado." );
        }
        // Si el nombre no exist�a entonces lo agregamos
        if( !existeAutorizado( pNombreAutorizado ) )
        {
            autorizados.add( pNombreAutorizado );
        }
        else
        {
            System.out.println("El autorizado ya existe." );
        }
    }


    public void eliminarAutorizado( String pNombreAutorizado )
    {
        boolean encontro = false;
        int numAutorizados = autorizados.size( );
        if(tieneFacturaAsociada( pNombreAutorizado )){
            System.out.println( pNombreAutorizado + " tiene una factura sin pagar.");
        }
        for( int i = 0; i < numAutorizados && !encontro; i++ )
        {
            String a = autorizados.get( i );
            if( a.equals( pNombreAutorizado ) )
            {
                encontro = true;
                autorizados.remove( i );
            }
        }
    }


    public void pagarFactura( int pIndiceFactura )
    {
        Factura factura = facturas.get( pIndiceFactura );
        if( factura.darValor( ) > fondos )
        {
            System.out.println( "El socio no posee fondos suficientes para pagar esta factura" );
        }
        else
        {
            fondos = fondos - factura.darValor( );
            facturas.remove( pIndiceFactura );
        }
    }

    public String toString( )
    {
        String socio = cedula + " - " + nombre;
        return socio;
    }

}