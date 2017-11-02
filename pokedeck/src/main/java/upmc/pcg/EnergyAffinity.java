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
public class EnergyAffinity 
{
    private Energy energyAffinityType;
    private int energyAffinityValue;
    private String energyAffinityName;
    
    public EnergyAffinity(Energy type, int value, String name)
    {
        this.energyAffinityType = type;
        this.energyAffinityValue = value;
        this.energyAffinityName = name;
    }
}
