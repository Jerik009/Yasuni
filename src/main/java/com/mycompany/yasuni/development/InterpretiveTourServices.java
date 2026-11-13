package com.mycompany.yasuni.development;

import com.mycompany.yasuni.object.InterpretiveTour;
import com.mycompany.yasuni.object.Tour;

public class InterpretiveTourServices extends TourServices {

    public InterpretiveTourServices() {
        super();
    }

    @Override
    public int calculateTotalDuration(Tour tour) {

        int base = super.calculateTotalDuration(tour);
        if (tour instanceof InterpretiveTour) {
            base += ((InterpretiveTour) tour).getEducationalMinutes();
        }
        return base;
    }
}
