package com.mycompany.yasuni.development;

import com.mycompany.yasuni.access.InterfaceTourService;
import com.mycompany.yasuni.enumeration.SortCriterion;
import com.mycompany.yasuni.object.CommunicationDevice;
import com.mycompany.yasuni.object.Guide;
import com.mycompany.yasuni.object.InterpretiveTour;
import com.mycompany.yasuni.object.Tour;
import com.mycompany.yasuni.object.Trail;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public abstract class TourServices implements InterfaceTourService {

    public Tour[] tours = new Tour[10];
    public int tourCount = 0;
    public CommunicationDevice[] devices = new CommunicationDevice[10];
    public int deviceCount = 0;
    public Guide[] guides = new Guide[10];
    public int guideCount = 0;

    public void saveTour(Tour tour) {
        if (tourCount == tours.length) {
            tours = Arrays.copyOf(tours, tours.length * 2);
        }
        tours[tourCount++] = tour;
    }

    public Tour findTourByCode(String code) {
        for (int i = 0; i < tourCount; i++) {
            if (tours[i].getCode().equals(code)) {
                return tours[i];
            }
        }
        return null;
    }

    public void saveDevice(CommunicationDevice device) {
        if (deviceCount == devices.length) {
            devices = Arrays.copyOf(devices, devices.length * 2);
        }
        devices[deviceCount++] = device;
    }

    public CommunicationDevice findDeviceByCode(String code) {
        for (int i = 0; i < deviceCount; i++) {
            if (devices[i].getCode().equals(code)) {
                return devices[i];
            }
        }
        return null;
    }

    public void saveGuide(Guide guide) {
        if (guideCount == guides.length) {
            guides = Arrays.copyOf(guides, guides.length * 2);
        }
        guides[guideCount++] = guide;
    }

    public Guide findGuideByNationalId(String nationalId) {
        for (int i = 0; i < guideCount; i++) {
            if (guides[i].getNationalId().equals(nationalId)) {
                return guides[i];
            }
        }
        return null;
    }

    @Override
    public double calculateTotalDistance(Tour tour) {
        double total = 0;
        for (int i = 0; i < tour.getTrailCount(); i++) {
            Trail t = tour.getTrails()[i];
            if (t.isEnabled()) {
                total += t.getLengthKm();
            }
        }
        return total;
    }

    public int calculateBaseWalkingTime(Tour tour) {
        int total = 0;
        for (int i = 0; i < tour.getTrailCount(); i++) {
            Trail t = tour.getTrails()[i];
            if (t.isEnabled()) {
                total += t.getEstimatedMinutes();
            }
        }
        return total;
    }

    @Override
    public int calculateTotalDuration(Tour tour) {
        return (int) (calculateBaseWalkingTime(tour) * tour.getDifficultyFactor());
    }

    @Override
    public void assignResources(Tour tour, CommunicationDevice device, Guide guide) {
        if (tour.getDevice() != null || tour.getGuide() != null) {
            System.out.println("Rechazado: el tour " + tour.getCode()
                    + " ya tiene recursos asignados. No se realizan cambios.");
            return;
        }

        boolean deviceOk = device.isAvailable();
        boolean guideOk = guide.isAvailable();

        if (!deviceOk || !guideOk) {
            System.out.println("Rechazado: no se pueden asignar recursos al tour " + tour.getCode());
            if (!deviceOk) {
                System.out.println("  - Dispositivo no disponible: " + device.getCode());
            }
            if (!guideOk) {
                System.out.println("  - Guia no disponible: " + guide.getNationalId());
            }
            System.out.println("  Estado de recursos sin cambios.");
            return;
        }

        tour.setDevice(device);
        tour.setGuide(guide);
        device.setAvailable(false);
        guide.setAvailable(false);
        System.out.println("Recursos asignados correctamente al tour " + tour.getCode()
                + " (dispositivo: " + device.getCode() + ", guia: " + guide.getNationalId() + ").");
    }

    @Override
    public void sortTours(Tour[] tours, SortCriterion criterion) {
        Comparator<Tour> comparator;
        if (criterion == SortCriterion.DISTANCE) {
            comparator = Comparator.comparingDouble(t -> calculateTotalDistance(t));
        } else {
            comparator = Comparator.comparingInt(t -> calculateTotalDuration(t));
        }
        Arrays.sort(tours, comparator);
        System.out.println("Tours ordenados por " + criterion + " (ascendente).");
    }

    @Override
    public void simulateDifficulty(Tour tour) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Simulacion de dificultad para el tour: " + tour.getCode() + " ---");
        System.out.println("Factor actual de dificultad: " + tour.getDifficultyFactor());

        double porcentaje = -1;
        while (porcentaje < 0) {
            System.out.print("Ingrese el porcentaje de aumento (>= 0): ");
            if (!sc.hasNextDouble()) {
                System.out.println("Entrada invalida. Ingrese un numero.");
                sc.next();
                continue;
            }
            porcentaje = sc.nextDouble();
            if (porcentaje < 0) {
                System.out.println("El porcentaje debe ser mayor o igual a 0.");
            }
        }

        double nuevoFactor = tour.getDifficultyFactor() * (1 + porcentaje / 100.0);

        double factorAnterior = tour.getDifficultyFactor();
        tour.setDifficultyFactor(nuevoFactor);
        int distanciaSimulada = (int) calculateTotalDistance(tour);
        int tiempoCaminataSimulado = (int) (calculateBaseWalkingTime(tour) * nuevoFactor);
        int duracionTotalSimulada = calculateTotalDuration(tour);
        tour.setDifficultyFactor(factorAnterior);

        System.out.println("Distancia simulada: " + distanciaSimulada + " km");
        System.out.println("Tiempo de caminata simulado: " + tiempoCaminataSimulado + " min");
        System.out.println("Duracion total simulada: " + duracionTotalSimulada + " min");
        System.out.println("(El tiempo educativo no cambia)");

        System.out.print("Acepta el nuevo factor? (s/n): ");
        String respuesta = sc.next();
        if (respuesta.equalsIgnoreCase("s")) {
            tour.setDifficultyFactor(nuevoFactor);
            System.out.println("Factor actualizado a: " + nuevoFactor);
        } else {
            System.out.println("Factor original mantenido: " + factorAnterior);
        }
    }

    @Override
    public void closeTrail(Tour tour, String trailName) {
        boolean encontrado = false;
        for (int i = 0; i < tour.getTrailCount(); i++) {
            Trail t = tour.getTrails()[i];
            if (t.getName().equalsIgnoreCase(trailName)) {
                t.setEnabled(false);
                encontrado = true;
                System.out.println("Sendero cerrado: " + trailName);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Sendero no encontrado: " + trailName);
        }
    }

    @Override
    public String showTour(Tour tour) {
        StringBuilder sb = new StringBuilder();
        sb.append("Tour: ").append(tour.getCode()).append(" - ").append(tour.getName()).append("\n");
        sb.append("  Tipo: ").append(tour.getClass().getSimpleName()).append("\n");
        sb.append("  Distancia total: ").append(calculateTotalDistance(tour)).append(" km\n");
        sb.append("  Duracion total: ").append(calculateTotalDuration(tour)).append(" min\n");
        sb.append("  Factor de dificultad: ").append(tour.getDifficultyFactor()).append("\n");
        sb.append("  Senderos:\n");
        for (int i = 0; i < tour.getTrailCount(); i++) {
            Trail t = tour.getTrails()[i];
            sb.append("    - ").append(t.getName())
                    .append(" (").append(t.getLengthKm()).append(" km, ")
                    .append(t.getEstimatedMinutes()).append(" min, habilitado=").append(t.isEnabled()).append(")\n");
        }
        sb.append("  Dispositivo: ")
                .append(tour.getDevice() != null ? tour.getDevice().getCode() : "ninguno").append("\n");
        sb.append("  Guia: ")
                .append(tour.getGuide() != null ? tour.getGuide().getNationalId() : "ninguno").append("\n");
        return sb.toString();
    }
}
