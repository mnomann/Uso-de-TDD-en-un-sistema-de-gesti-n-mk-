package com.mk;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PersonajeService service = new PersonajeService(new PersonajeRepository());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            limpiarConsola();
            System.out.println("=== Mortal Kombat - Gestor de Personajes ===");
            System.out.println("\n1. Agregar personaje");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Filtrar por poder (>= MEDIO)");
            System.out.println("5. Ordenar por salud");
            System.out.println("6. Eliminar personaje");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1: {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Salud máxima: ");
                    int salud = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nivel de poder (BAJO, MEDIO, ALTO): ");
                    NivelPoder nivel = NivelPoder.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Ingresa los movimientos especiales separados por coma (ej: Dragon Punch, Teleport, Fireball):");
                    List<String> movimientos = Arrays.asList(scanner.nextLine().split(",\\s*"));

                    service.agregar(nombre, salud, nivel, movimientos);
                    System.out.println("✔ Personaje agregado.");
                    pausar(scanner);
                    break;
                }
                case 2: {
                    service.listarTodos().forEach(Main::mostrar);
                    pausar(scanner);
                    break;
                }
                case 3: {
                    System.out.print("Buscar por nombre: ");
                    String filtro = scanner.nextLine();
                    service.buscarPorNombre(filtro).forEach(Main::mostrar);
                    pausar(scanner);
                    break;
                }
                case 4: {
                    service.filtrarPorNivelMedioOAlto().forEach(Main::mostrar);
                    pausar(scanner);
                    break;
                }
                case 5: {
                    service.ordenarPorSaludDesc().forEach(Main::mostrar);
                    pausar(scanner);
                    break;
                }
                case 6: {
                    System.out.print("ID del personaje a eliminar: ");
                    long id = Long.parseLong(scanner.nextLine());
                    service.eliminar(id);
                    System.out.println("✔ Eliminado si existía.");
                    pausar(scanner);
                    break;
                }
                case 0: {
                    System.out.println("Saliendo...");
                    return;
                }
                default: {
                    System.out.println("Opción inválida.");
                    pausar(scanner);
                    break;
                }
            }
        }
    }

    private static void mostrar(Personaje p) {
        System.out.println("ID: " + p.getId() +
                ", Nombre: " + p.getNombre() +
                ", Salud: " + p.getSaludMaxima() +
                ", Nivel: " + p.getNivel() +
                ", Movimientos: " + p.getMovimientos());
    }

    private static void limpiarConsola() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    private static void pausar(Scanner scanner) {
        System.out.print("\nPresiona ENTER para continuar...");
        scanner.nextLine();
    }
}
