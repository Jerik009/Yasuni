package espoch.edu.ec.practicetwo.data;

import espoch.edu.ec.practicetwo.object.InterpretiveTour;
import espoch.edu.ec.practicetwo.object.RegularTour;
import espoch.edu.ec.practicetwo.object.Tour;
import espoch.edu.ec.practicetwo.object.Trail;
import java.util.Scanner;

public abstract class Tours {

    Scanner input = new Scanner(System.in);

    public abstract float totalTime(RegularTour regTour, InterpretiveTour interTour);

    public float distance(Tour excursion) {
        float total = 0.0f;
        Trail[] paths = excursion.getPaths();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].isEnabledTrail() == true) {
                total += paths[i].getExtent();
            }

        }
        return total;
    }

    public float simulate(Tour excursion) {
        System.out.println("Ingrese el nuevo factor de conversión: ");
        float newFactor = input.nextFloat();
        return (newFactor + excursion.getLevel());
    }

    public float changeFactor(Tour excursion) {
        float proposed = simulate(excursion);
        System.out.println("Desea combiar el factor?");
        boolean answer = input.nextBoolean();

        if (true) {
            excursion.setLevel(proposed);
        }
        return excursion.getLevel();
    }

    public float ajustedTime(Tour excursion) {
        Trail[] paths = excursion.getPaths();
        float sumTime = 0.0f;

        for (int i = 0; i < paths.length; i++) {
            sumTime += paths[i].getDuration();
        }
        return sumTime * excursion.getLevel();
    }

    public String closedTrail(Tour excursion) {
        Trail[] paths = excursion.getPaths();
        System.out.println("Que sendero desea deshabilitar?");
        int option = input.nextInt();
        while (option > paths.length) {
            System.out.println("Fuera de rango");
            System.out.println("Que sendero desea deshabilitar?");
            option = input.nextInt();
        }
        paths[option - 1].setEnabledTrail(false);
        return ("El sendero " + (option - 1) + " ha sido deshabilitado " + paths[option - 1].isEnabledTrail());
    }

}
