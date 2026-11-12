package espoch.edu.ec.practicetwo;

import espoch.edu.ec.practicetwo.access.InterfaceAssignment;
import espoch.edu.ec.practicetwo.data.Assignments;
import espoch.edu.ec.practicetwo.object.Assignment;
import espoch.edu.ec.practicetwo.object.Device;
import espoch.edu.ec.practicetwo.object.Guide;
import espoch.edu.ec.practicetwo.object.RegularTour;
import espoch.edu.ec.practicetwo.object.Tour;
import espoch.edu.ec.practicetwo.object.Trail;

public class PracticeTwo {

    public static void main(String[] args) {

        
        
        
        Trail[] pathsOrellana = new Trail[3];
        pathsOrellana[0] = new Trail("Loreto", 1234.0f, 60.0f, true);
        pathsOrellana[1] = new Trail("Coca", 14.0f, 20.0f, true);
        pathsOrellana[2] = new Trail("Huaticocha", 12.0f, 28.0f, true);

        Trail[] pathsNapo = new Trail[3];
        pathsNapo[0] = new Trail("Tena", 234.0f, 30.0f, true);
        pathsNapo[1] = new Trail("Cotapino", 14.0f, 20.0f, true);
        pathsNapo[2] = new Trail("Ahuano", 12.0f, 28.0f, true);

        Trail[] pathsSpain = new Trail[3];
        pathsSpain[0] = new Trail("Valencia", 1234.0f, 60.0f, true);
        pathsSpain[1] = new Trail("Madrid", 14.0f, 20.0f, true);
        pathsSpain[2] = new Trail("Barcelona", 12.0f, 28.0f, true);

        Tour[] tourList = new RegularTour[3];
        tourList[0] = new RegularTour("111", "Tour 1", pathsOrellana, 1.0f);
        tourList[1] = new RegularTour("222", "Tour 2", pathsNapo, 1.0f);
        tourList[2] = new RegularTour("333", "Tour 3", pathsSpain, 1.0f);

        Guide[] guideList = new Guide[3];
        guideList[0] = new Guide("2200650102", " Jostin", true);
        guideList[1] = new Guide("1258645378", " Alveiro", true);
        guideList[2] = new Guide("3437613676", " Edwin", true);
        Device[] deviceList = new Device[3];
        deviceList[0] = new Device("Window", "Computer", true);
        deviceList[1] = new Device("Android", "Sansung S26", true);
        deviceList[2] = new Device("IOS", "Iphone 17", true);

        Assignment allocation = new Assignment();
        allocation.setTours(tourList);
        allocation.setGuides(guideList);
        allocation.setDevices(deviceList);

        allocation.setSelectedGuide(guideList[0]);
        allocation.setSelectedDevice(deviceList[0]);
        allocation.setSelectedTour(tourList[0]);

        allocation.setFirstTimeVisitor(true);
        allocation.setLimitedTime(false);

        InterfaceAssignment allocator = new Assignments();
        // --- PROBAR Y VERIFICAR VALIDATE ---
        System.out.println("=== PROBANDO VALIDATE ===");
        System.out.println("Estado inicial guía 0 (disponible): " + guideList[0].isAvailableGuide());
        System.out.println("Estado inicial dispositivo 0 (disponible): " + deviceList[0].isAvailableDevice());

        boolean validated = allocator.validate(allocation);
        System.out.println("Validate: " + validated);

        // Comprobamos si cambiaron a false tras la asignación exitosa
        System.out.println("Estado guía 0 después de validate: " + guideList[0].isAvailableGuide());
        System.out.println("Estado dispositivo 0 después de validate: " + deviceList[0].isAvailableDevice());

        // --- PROBAR Y VERIFICAR ORDER RUTE ---
        System.out.println("\n=== PROBANDO ORDER RUTE ===");
        System.out.println("Senderos del Tour 1 antes de ordenar (por longitud):");
        for (int i =0;i< pathsOrellana.length;i++) {
            System.out.println(" - " + pathsOrellana[i].getExtent()+ " (Longitud: " + pathsOrellana[i].getExtent()+ ")");
        }

        boolean ordered = allocator.orderRute(allocation);
        System.out.println("OrderRute: " + ordered);

        System.out.println("Senderos del Tour 1 después de ordenar:");
        for (int i =0;i< pathsOrellana.length;i++) {
            System.out.println(" - " + pathsOrellana[i].getExtent()+ " (Longitud: " + pathsOrellana[i].getExtent()+ ")");
        }
    }
}
