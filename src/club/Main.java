package club;

import java.util.Scanner;
import club.Socio.Tipo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        Club c = new Club();

        do {
            System.out.println("1. Afiliar un socio al club.");
            System.out.println("2. Registrar una persona autorizada por un socio.");
            System.out.println("3. Pagar una factura.");
            System.out.println("4. Registrar un consumo en la cuenta de un socio");
            System.out.println("5. Aumentar fondos de la cuenta de un socio");
            System.out.println("6. Consultar total de consumos por cédula");
            System.out.println("7. Verificar si se puede eliminar un socio");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opcion: ");
            op = Integer.parseInt(sc.next());
            try {
                switch (op) {
                    case 1: {
                        System.out.print("Ingrese nombre del socio: ");
                        String nombre = sc.next();
                        System.out.print("Ingrese cédula del socio: ");
                        String cedula = sc.next();
                        System.out.print("Ingrese tipo de socio (VIP o REGULAR): ");
                        Tipo tipo = Tipo.valueOf(sc.next().toUpperCase());
                        c.afiliarSocio(nombre, cedula, tipo);
                        System.out.println("Socio afiliado exitosamente.");
                    } break;
                    case 2: {
                        System.out.print("Ingrese cédula del socio: ");
                        String cedula = sc.next();
                        System.out.print("Ingrese nombre del autorizado: ");
                        String nombreAut = sc.next();
                        c.registrarAutorizado(cedula, nombreAut);
                        System.out.println("Autorizado registrado exitosamente.");
                    } break;
                    case 3: {
                        System.out.print("Ingrese número de factura: ");
                        int numero = sc.nextInt();
                        c.pagarFactura(numero);
                        System.out.println("Factura pagada exitosamente.");
                    } break;
                    case 4: {
                        System.out.print("Ingrese cédula del socio: ");
                        String cedula = sc.next();
                        System.out.print("Ingrese descripción del consumo: ");
                        String desc = sc.next();
                        System.out.print("Ingrese valor del consumo: ");
                        double valor = sc.nextDouble();
                        c.registrarConsumo(cedula, desc, valor);
                        System.out.println("Consumo registrado exitosamente.");
                    } break;
                    case 5: {
                        System.out.print("Ingrese cédula del socio: ");
                        String cedula = sc.next();
                        System.out.print("Ingrese monto a aumentar: ");
                        double monto = sc.nextDouble();
                        c.aumentarFondos(cedula, monto);
                        System.out.println("Fondos aumentados exitosamente.");
                    } break;
                    case 6:
                        System.out.print("Ingrese cédula del socio: ");
                        String cedulaConsumo = sc.nextLine();
                        try {
                            double total = club.obtenerTotalConsumos(cedulaConsumo);
                            System.out.println("Total de consumos: $" + total);
                        } catch (SocioNoExisteException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 7:
                        System.out.print("Ingrese cédula del socio: ");
                        String cedulaEliminar = sc.nextLine();
                        try {
                            boolean puedeEliminarse = club.sePuedeEliminarSocio(cedulaEliminar);
                            if (puedeEliminarse) {
                                System.out.println("El socio **puede ser eliminado**.");
                            } else {
                                System.out.println("El socio **no puede ser eliminado** por alguna restricción.");
                            }
                        } catch (SocioNoExisteException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 8:
                        System.out.println("Gracias!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (ValorInvalido | SocioNoEncontrado | FacturaNoEncontrada e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (op != 6);
    }
}
