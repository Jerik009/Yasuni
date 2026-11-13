package com.mycompany.yasuni;

import com.mycompany.yasuni.access.InterfaceTourService;
import com.mycompany.yasuni.development.InterpretiveTourServices;
import com.mycompany.yasuni.development.RegularTourServices;
import com.mycompany.yasuni.development.TourServices;
import com.mycompany.yasuni.enumeration.SortCriterion;
import com.mycompany.yasuni.object.CommunicationDevice;
import com.mycompany.yasuni.object.Guide;
import com.mycompany.yasuni.object.InterpretiveTour;
import com.mycompany.yasuni.object.RegularTour;
import com.mycompany.yasuni.object.Tour;
import com.mycompany.yasuni.object.Trail;
import java.util.Arrays;
import java.util.Scanner;



public class Yasuni {

    private static InterfaceTourService regularService;
    private static InterfaceTourService interpretiveService;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        regularService = new RegularTourServices();
        interpretiveService = new InterpretiveTourServices();

        demo();
        menu();
    }

    static void demo() {
        System.out.println("========================================");
        System.out.println("DEMO AUTOMATICO - Yasuni Explora");
        System.out.println("========================================");

        Trail[] t1Trails = {new Trail("Sendero A", 3.5, 60), new Trail("Sendero B", 2.0, 40)};
        Trail[] t2Trails = {new Trail("Sendero C", 5.0, 90), new Trail("Sendero D", 1.5, 30), new Trail("Sendero E", 2.5, 50)};
        Trail[] t3Trails = {new Trail("Sendero F", 4.0, 70), new Trail("Sendero G", 3.0, 55)};

        Tour tour1 = new RegularTour("T001", "Tour Regular Orellana", t1Trails, 2, 1.2);
        Tour tour2 = new RegularTour("T002", "Tour Regular Napo", t2Trails, 3, 1.5);
        Tour tour3 = new InterpretiveTour("T003", "Tour Interpretivo Yasuni", t3Trails, 2, 1.1, 30);

        ((TourServices) regularService).saveTour(tour1);
        ((TourServices) regularService).saveTour(tour2);
        ((TourServices) regularService).saveTour(tour3);

        CommunicationDevice d1 = new CommunicationDevice("D001", "Radio VHF");
        CommunicationDevice d2 = new CommunicationDevice("D002", "Telefono satelital");
        CommunicationDevice d3 = new CommunicationDevice("D003", "GPS");

        Guide g1 = new Guide("G001", "Carlos Perez");
        Guide g2 = new Guide("G002", "Maria Gomez");
        Guide g3 = new Guide("G003", "Luis Rodriguez");

        ((TourServices) regularService).saveDevice(d1);
        ((TourServices) regularService).saveDevice(d2);
        ((TourServices) regularService).saveDevice(d3);
        ((TourServices) regularService).saveGuide(g1);
        ((TourServices) regularService).saveGuide(g2);
        ((TourServices) regularService).saveGuide(g3);

        System.out.println("\n--- Tours iniciales ---");
        System.out.println(regularService.showTour(tour1));
        System.out.println(regularService.showTour(tour2));
        System.out.println(interpretiveService.showTour(tour3));

        System.out.println("\n--- Asignacion exitosa (T001 + D001 + G001) ---");
        regularService.assignResources(tour1, d1, g1);

        System.out.println("\n--- Asignacion rechazada (T002 + D002 + G001, guia ya asignado) ---");
        regularService.assignResources(tour2, d2, g1);

        System.out.println("\n--- Asignacion rechazada (T002 + D001 + G002, dispositivo no disponible) ---");
        regularService.assignResources(tour2, d1, g2);

        System.out.println("\n--- Asignacion exitosa (T002 + D002 + G002) ---");
        regularService.assignResources(tour2, d2, g2);

        System.out.println("\n--- Ordenamiento por DISTANCIA ---");
        Tour[] allTours = getAllTours();
        regularService.sortTours(allTours, SortCriterion.DISTANCE);
        for (Tour t : allTours) {
            System.out.println("  " + t.getCode() + " distancia=" + regularService.calculateTotalDistance(t) + " km");
        }

        System.out.println("\n--- Ordenamiento por DURACION TOTAL ---");
        regularService.sortTours(allTours, SortCriterion.TOTAL_DURATION);
        for (Tour t : allTours) {
            System.out.println("  " + t.getCode() + " duracion=" + regularService.calculateTotalDuration(t) + " min");
        }

        System.out.println("\n--- Cerrando sendero 'Sendero A' del tour T001 ---");
        regularService.closeTrail(tour1, "Sendero A");

        System.out.println("\n--- Tour T001 tras cierre de sendero ---");
        System.out.println(regularService.showTour(tour1));

        System.out.println("\nDemo finalizada.\n");
    }

    private static Tour[] getAllTours() {
        return ((TourServices) regularService).tours;
    }

    static void menu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n========================================");
            System.out.println("MENU PRINCIPAL - Yasuni Explora");
            System.out.println("========================================");
            System.out.println("1. Listar tours");
            System.out.println("2. Asignar recursos a un tour");
            System.out.println("3. Ordenar tours");
            System.out.println("4. Simular dificultad de un tour");
            System.out.println("5. Cerrar un sendero");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    listarTours();
                    break;
                case "2":
                    asignarRecursos();
                    break;
                case "3":
                    ordenarTours();
                    break;
                case "4":
                    simularDificultad();
                    break;
                case "5":
                    cerrarSendero();
                    break;
                case "6":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    static void listarTours() {
        Tour[] tours = getAllTours();
        int count = ((TourServices) regularService).tourCount;
        if (count == 0) {
            System.out.println("No hay tours registrados.");
            return;
        }
        System.out.println("\n--- Lista de tours ---");
        for (int i = 0; i < count; i++) {
            Tour t = tours[i];
            System.out.println(regularService.showTour(t));
            System.out.println("---------------------");
        }
    }

    static void asignarRecursos() {
        System.out.print("Codigo del tour: ");
        String tourCode = sc.nextLine();
        Tour tour = ((TourServices) regularService).findTourByCode(tourCode);
        if (tour == null) {
            System.out.println("Tour no encontrado.");
            return;
        }

        System.out.print("Codigo del dispositivo: ");
        String devCode = sc.nextLine();
        CommunicationDevice device = ((TourServices) regularService).findDeviceByCode(devCode);
        if (device == null) {
            System.out.println("Dispositivo no encontrado.");
            return;
        }

        System.out.print("Cedula del guia: ");
        String guideId = sc.nextLine();
        Guide guide = ((TourServices) regularService).findGuideByNationalId(guideId);
        if (guide == null) {
            System.out.println("Guia no encontrado.");
            return;
        }

        if (tour instanceof InterpretiveTour) {
            interpretiveService.assignResources(tour, device, guide);
        } else {
            regularService.assignResources(tour, device, guide);
        }
    }

    static void ordenarTours() {
        Tour[] tours = getAllTours();
        int count = ((TourServices) regularService).tourCount;
        if (count == 0) {
            System.out.println("No hay tours registrados.");
            return;
        }
        Tour[] copy = Arrays.copyOf(tours, count);
        System.out.println("Seleccione criterio de ordenamiento:");
        System.out.println("1. Distancia");
        System.out.println("2. Duracion total");
        System.out.print("Opcion: ");
        String op = sc.nextLine();
        SortCriterion criterion;
        if (op.equals("2")) {
            criterion = SortCriterion.TOTAL_DURATION;
        } else {
            criterion = SortCriterion.DISTANCE;
        }
        regularService.sortTours(copy, criterion);
        System.out.println("\n--- Tours ordenados ---");
        for (Tour t : copy) {
            System.out.println("  " + t.getCode() + " - " + t.getName()
                    + " | distancia=" + regularService.calculateTotalDistance(t) + " km"
                    + " | duracion=" + regularService.calculateTotalDuration(t) + " min");
        }
    }

    static void simularDificultad() {
        System.out.print("Codigo del tour: ");
        String tourCode = sc.nextLine();
        Tour tour = ((TourServices) regularService).findTourByCode(tourCode);
        if (tour == null) {
            System.out.println("Tour no encontrado.");
            return;
        }
        if (tour instanceof InterpretiveTour) {
            interpretiveService.simulateDifficulty(tour);
        } else {
            regularService.simulateDifficulty(tour);
        }
    }

    static void cerrarSendero() {
        System.out.print("Codigo del tour: ");
        String tourCode = sc.nextLine();
        Tour tour = ((TourServices) regularService).findTourByCode(tourCode);
        if (tour == null) {
            System.out.println("Tour no encontrado.");
            return;
        }
        System.out.print("Nombre del sendero a cerrar: ");
        String trailName = sc.nextLine();
        if (tour instanceof InterpretiveTour) {
            interpretiveService.closeTrail(tour, trailName);
        } else {
            regularService.closeTrail(tour, trailName);
        }
    }
}
