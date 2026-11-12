package espoch.edu.ec.practicetwo.data;

import espoch.edu.ec.practicetwo.access.InterfaceAssignment;
import espoch.edu.ec.practicetwo.object.Assignment;
import espoch.edu.ec.practicetwo.object.Device;
import espoch.edu.ec.practicetwo.object.Guide;
import espoch.edu.ec.practicetwo.object.Tour;
import espoch.edu.ec.practicetwo.object.Trail;

public class Assignments implements InterfaceAssignment {

    /*
    Daniela asigna un dispositivo de comunicación disponible y un guía disponible a cada excursión. 
Si la asignación se realiza con éxito, ambos pasan a estar no disponibles. 
Ningún dispositivo ni guía puede asignarse a dos excursiones durante la misma jornada laboral. 
El sistema debe indicar si la asignación ha sido aceptada o rechazada. 
Si alguno de los recursos no está disponible, la asignación dezbe rechazarse sin alterar el
estado de los recursos ni la asignación existente para la excursión.
     */
    @Override
    public boolean validate(Assignment allocation) {
        Tour[] tours = allocation.getTours();
        Guide[] guides = allocation.getGuides();
        Device[] devices = allocation.getDevices();

        Device chosenDevice = allocation.getSelectedDevice();
        Guide chosenGuide = allocation.getSelectedGuide();

        boolean accepted = false;
        int guideIndex = 0;
        int deviceIndex = 0;
        for (int i = 0; i < tours.length; i++) {
            for (int j = 0; j < guides.length; j++) {
                if (guides[j].isAvailableGuide() == true) {
                    chosenGuide.setAvailableGuide(false);
                    guides[j].setAvailableGuide(false);
                    guideIndex = j;
                    break;
                }
            }
            for (int k = 0; k < devices.length; k++) {
                if (devices[k].isAvailableDevice() == true) {
                    chosenDevice.setAvailableDevice(false);
                    devices[k].setAvailableDevice(false);
                    deviceIndex = k;
                    break;
                }
            }
        }
        if (chosenGuide.isAvailableGuide() == false && chosenDevice.isAvailableDevice() == false) {
            accepted = true;
        } else {
            Tour chosenTour = allocation.getSelectedTour();
            guides[guideIndex - 1].setAvailableGuide(true);
            devices[deviceIndex - 1].setAvailableDevice(true);
            chosenGuide.setAvailableGuide(true);
            chosenDevice.setAvailableDevice(true);
        }

        return accepted;
    }

    @Override
    public boolean orderRute(Assignment allocation) {
        Tour[] tours = allocation.getTours();

        if (allocation.isFirstTimeVisitor()) {
            for (int i = 0; i < tours.length; i++) {
                Trail[] paths = tours[i].getPaths();
                for (int j = 0; j < paths.length - 1; j++) {
                    for (int k = 0; k < paths.length - 1 - j; k++) {
                        if (paths[k].getExtent() > paths[k + 1].getExtent()) {
                            Trail swap = paths[k];
                            paths[k] = paths[k + 1];
                            paths[k + 1] = swap;
                        }
                    }
                }

            }

        } else if (allocation.isLimitedTime()) {
            for (int i = 0; i < tours.length; i++) {
                Trail[] paths = tours[i].getPaths();
                for (int j = 0; j < paths.length - 1; j++) {
                    for (int k = 0; k < paths.length - 1 - j; k++) {
                        if (paths[k].getExtent() > paths[k + 1].getExtent()) {
                            Trail swap = paths[k];
                            paths[k] = paths[k + 1];
                            paths[k + 1] = swap;
                        }
                    }
                }

            }
        }
        return true;
    }
}
