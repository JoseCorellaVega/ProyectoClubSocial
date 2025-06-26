
package club;
import java.util.ArrayList;
import club.Socio.Tipo;

public class Club
{

    public final static int MAXIMO_VIP = 3;

    private ArrayList<Socio> socios;

    public Club( )
    {
        socios = new ArrayList<Socio>( );
    }



    public ArrayList<Socio> darSocios( )
    {
        return socios;
    }

    public void afiliarSocio( String pCedula, String pNombre, Tipo pTipo )
    {

        // Revisar que no haya ya un socio con la misma c�dula
        Socio s = buscarSocio( pCedula );
        if( pTipo == Tipo.VIP && contarSociosVIP( ) == MAXIMO_VIP )
        {
            System.out.println("El club en el momento no acepta m�s socios VIP" );

        }
        // Revisar que no se haya alcanzado el l�mite de subscripciones VIP
        if( s == null )
        {
            // Se crea el objeto del nuevo socio (todav�a no se ha agregado al club)
            Socio nuevoSocio = new Socio( pCedula, pNombre, pTipo );
            // Se agrega el nuevo socio al club
            socios.add( nuevoSocio );
        }
        else
        {
            System.out.println( "El socio ya existe" );
        }
    }

    public Socio buscarSocio( String pCedulaSocio )
    {
        Socio elSocio = null;

        boolean encontre = false;
        int numSocios = socios.size( );
        for( int i = 0; i < numSocios && !encontre; i++ )
        {
            Socio s = socios.get( i );
            if( s.darCedula( ).equals( pCedulaSocio ) )
            {
                elSocio = s;
                encontre = true;
            }
        }

        return elSocio;
    }

    public int contarSociosVIP( )
    {
        int conteo = 0;
        for( Socio socio : socios )
        {
            if( socio.darTipo( ) == Tipo.VIP )
            {
                conteo++;
            }
        }
        return conteo;
    }

    public ArrayList<String> darAutorizadosSocio( String pCedulaSocio )
    {
        Socio s = buscarSocio( pCedulaSocio );
        ArrayList<String> autorizados = new ArrayList<String>( );

        autorizados.add( s.darNombre( ) );
        autorizados.addAll( s.darAutorizados( ) );

        return autorizados;
    }


    public void agregarAutorizadoSocio( String pCedulaSocio, String pNombreAutorizado )
    {
        Socio s = buscarSocio( pCedulaSocio );
        s.agregarAutorizado( pNombreAutorizado );

    }

    public void eliminarAutorizadoSocio( String pCedulaSocio, String pNombreAutorizado )
    {
        Socio s = buscarSocio( pCedulaSocio );
        s.eliminarAutorizado( pNombreAutorizado );
    }


    public void registrarConsumo( String pCedulaSocio, String pNombreCliente, String pConcepto, double pValor )
    {
        Socio s = buscarSocio( pCedulaSocio );
        s.registrarConsumo( pNombreCliente, pConcepto, pValor );
    }

    public ArrayList<Factura> darFacturasSocio( String pCedulaSocio )
    {
        return buscarSocio( pCedulaSocio ).darFacturas( );
    }

    public void pagarFacturaSocio( String pCedulaSocio, int pFacturaIndice )
    {
        Socio s = buscarSocio( pCedulaSocio );
        s.pagarFactura( pFacturaIndice );

    }

    public void aumentarFondosSocio( String pCedulaSocio, double pValor )
    {
        Socio s = buscarSocio( pCedulaSocio );
        s.aumentarFondos( pValor );
    }

    public String metodo1( )
    {
        return "respuesta1";
    }


    public String metodo2( )
    {
        return "respuesta2";
    }
}