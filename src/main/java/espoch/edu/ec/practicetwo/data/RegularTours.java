package espoch.edu.ec.practicetwo.data;

import espoch.edu.ec.practicetwo.access.InterfaceRegularTour;
import espoch.edu.ec.practicetwo.object.InterpretiveTour;
import espoch.edu.ec.practicetwo.object.RegularTour;
import espoch.edu.ec.practicetwo.object.Tour;
import espoch.edu.ec.practicetwo.object.Trail;

public class RegularTours extends Tours implements InterfaceRegularTour {

    @Override
    public float totalTime(RegularTour regTour, InterpretiveTour interTour) {
        float total = 0.0f;
        Trail[] paths = regTour.getPaths();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].isEnabledTrail() == true) {
                total += paths[i].getDuration();
            }
        }
        return total;
    }

    @Override
    public float distance(Tour excursion) {
        return super.distance(excursion);
    }

    @Override
    public float simulate(Tour excursion) {
        return super.simulate(excursion);
    }

    @Override
    public float changeFactor(Tour excursion) {
        return super.changeFactor(excursion);
    }

    @Override
    public float ajustedTime(Tour excursion) {
        return super.ajustedTime(excursion);
    }

    @Override
    public String closedTrail(Tour excursion) {
        return "";
    }

}
