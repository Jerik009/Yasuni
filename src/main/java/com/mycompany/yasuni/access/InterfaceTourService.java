package com.mycompany.yasuni.access;

import com.mycompany.yasuni.enumeration.SortCriterion;
import com.mycompany.yasuni.object.Tour;
import com.mycompany.yasuni.object.CommunicationDevice;
import com.mycompany.yasuni.object.Guide;


public interface InterfaceTourService {

    void assignResources(Tour tour, CommunicationDevice device, Guide guide);

    void sortTours(Tour[] tours, SortCriterion criterion);

    void simulateDifficulty(Tour tour);

    void closeTrail(Tour tour, String trailName);

    String showTour(Tour tour);

    double calculateTotalDistance(Tour tour);

    int calculateTotalDuration(Tour tour);
}
