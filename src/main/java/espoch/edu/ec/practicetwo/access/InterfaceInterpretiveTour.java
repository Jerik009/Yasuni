package espoch.edu.ec.practicetwo.access;

import espoch.edu.ec.practicetwo.object.InterpretiveTour;
import espoch.edu.ec.practicetwo.object.RegularTour;
import espoch.edu.ec.practicetwo.object.Tour;

public interface InterfaceInterpretiveTour {

    public float totalTime(RegularTour regTour, InterpretiveTour interTour);

    public float distance(Tour excursion);

    public float simulate(Tour excursion);

    public float changeFactor(Tour excursion);

    public float ajustedTime(Tour excursion);

    public String closedTrail(Tour excursion);
}
