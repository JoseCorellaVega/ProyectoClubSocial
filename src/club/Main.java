package club;

import java.util.Scanner;
import club.Socio.Tipo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int op;
        Club c = new Club(); //HOLA, PROBANDO EL PULL
        // jose novelero y vos tambien pedro

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
                    System.out.println("Usted escogio Afiliar un socio al club");

                }break;
                case 2:{
                    System.out.println("Usted escogio Registrar una persona");

                }break;
                case 3:{
                    System.out.println("Usted escogio Pagar una factura");

                }break;
                case 4:{
                    System.out.println("Usted escogio Registrar un consumo en la ceunta de un socio");

                }break;
                case 5:{
                    System.out.println("Usted escogio Aumentar fondos de la cuenta de un socio");

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