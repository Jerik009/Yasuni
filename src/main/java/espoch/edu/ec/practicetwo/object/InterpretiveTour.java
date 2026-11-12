/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espoch.edu.ec.practicetwo.object;

/**
 *
 * @author aleja
 */
public class InterpretiveTour extends Tour {

    private float extraTime;

    public InterpretiveTour(float extraTime, String code, String title, Trail[] paths, float level) {
        super(code, title, paths, level);
        this.extraTime = extraTime;
    }

    
    

    public InterpretiveTour() {
    }

    public float getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(float extraTime) {
        this.extraTime = extraTime;
    }

    
}
