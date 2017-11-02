/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

/**
 *
 * @author adminRAF
 */
public class SpecialConditions 
{
    private String specialConditionsName;
    private boolean conditionsDisableRetreat;
    private boolean specialConditionalsMarker;
    
    public SpecialConditions(String conditionsName, boolean cd, boolean cm)
    {
        this.specialConditionsName = conditionsName;
        this.conditionsDisableRetreat = cd;
        this.specialConditionalsMarker = cm;
    }
}
