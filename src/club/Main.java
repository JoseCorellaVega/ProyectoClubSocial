import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Club club = new Club();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar socio");
            System.out.println("2. Eliminar socio");
            System.out.println("3. Agregar fondo");
            System.out.println("4. Registrar consumo");
            System.out.println("5. Mostrar información socio");
            System.out.println("6. Autorizar persona");
            System.out.println("7. Mostrar resumen del club");
            System.out.println("8. Consultar total consumos por cédula");
            System.out.println("9. Verificar si un socio puede ser eliminado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Cédula: ");
                        String cedula = sc.nextLine();
                        System.out.print("VIP (true/false): ");
                        boolean vip = sc.nextBoolean();
                        sc.nextLine();
                        club.registrarSocio(nombre, cedula, vip);
                        break;

                    case 2:
                        System.out.print("Cédula del socio a eliminar: ");
                        String cedEliminar = sc.nextLine();
                        club.eliminarSocio(cedEliminar);
                        break;

                    case 3:
                        System.out.print("Cédula del socio: ");
                        String cedFondo = sc.nextLine();
                        System.out.print("Monto: ");
                        double monto = sc.nextDouble();
                        sc.nextLine();
                        club.agregarFondo(cedFondo, monto);
                        break;

                    case 4:
                        System.out.print("Cédula del socio: ");
                        String cedConsumo = sc.nextLine();
                        System.out.print("Descripción: ");
                        String desc = sc.nextLine();
                        System.out.print("Monto: ");
                        double montoC = sc.nextDouble();
                        sc.nextLine();
                        club.registrarConsumo(cedConsumo, desc, montoC);
                        break;

                    case 5:
                        System.out.print("Cédula: ");
                        String cedInf = sc.nextLine();
                        System.out.println(club.mostrarInformacionSocio(cedInf));
                        break;

                    case 6:
                        System.out.print("Cédula del socio: ");
                        String cedSocio = sc.nextLine();
                        System.out.print("Nombre de autorizado: ");
                        String autorizado = sc.nextLine();
                        club.autorizarPersona(cedSocio, autorizado);
                        break;

                    case 7:
                        System.out.println(club.resumenClub());
                        break;

                    case 8:
                        System.out.print("Cédula del socio: ");
                        String cedConsTotal = sc.nextLine();
                        double total = club.totalConsumosSocio(cedConsTotal);
                        System.out.println("Total de consumos: $" + total);
                        break;

                    case 9:
                        System.out.print("Cédula del socio: ");
                        String cedVerif = sc.nextLine();
                        boolean puedeEliminarse = club.sePuedeEliminarSocio(cedVerif);
                        System.out.println(puedeEliminarse ?
                                "Sí se puede eliminar." : "No se puede eliminar.");
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (SocioNoExisteException | SocioNoEliminableException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 0);
    }
}
