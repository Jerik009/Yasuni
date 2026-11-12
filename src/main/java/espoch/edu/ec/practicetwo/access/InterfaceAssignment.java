package espoch.edu.ec.practicetwo.access;

import espoch.edu.ec.practicetwo.object.Assignment;
import espoch.edu.ec.practicetwo.object.Tour;
import espoch.edu.ec.practicetwo.object.Trail;

public interface InterfaceAssignment {

    public boolean validate(Assignment allocation);

    public boolean orderRute(Assignment allocation);
}
