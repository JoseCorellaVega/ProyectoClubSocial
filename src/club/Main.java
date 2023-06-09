package club;

import java.util.Scanner;
import club.Socio.Tipo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int op;
        Club c = new Club();
        String cedula, nombre;
        int tipoS;
       Tipo tipo;
        do{
            System.out.println("1. Afiliar un socio al club.");
            System.out.println("2. Registrar una persona autorizada por un socio.");
            System.out.println("3. Pagar una factura.");
            System.out.println("4. Registrar un consumo en la cuenta de un socio");
            System.out.println("5. Aumentar fondos de la cuenta de un socio");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            op = Integer.parseInt(sc.next());
            switch (op){
                case 1:{
                    System.out.println("Ingrese cedula");
                    cedula = sc.next();

                    System.out.println("Ingrese nombre");
                    nombre = sc.next();

                    do{
                        System.out.println("Ingrese 1 para tipo VIP y 2 para regular");
                        tipoS = Integer.parseInt(sc.next());
                    }while(tipoS < 1 || tipoS > 2);
                    if(tipoS == 1)
                        tipo = Socio.Tipo.VIP;
                    else tipo = Socio.Tipo.REGULAR;
                    c.afiliarSocio(cedula,nombre,tipo);



                }break;
                case 2:{

                }break;
                case 3:{

                }break;
                case 4:{

                }break;
                case 5:{

                }break;
                case 6:{
                    System.out.println("Gracias!");
                }break;
                default:
                    System.out.println("opcion invalida");
            }

        }while(op!=6);


    }
}