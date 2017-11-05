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
    private EnergyType energyAffinityType;
    private int energyAffinityValue;
    
    public EnergyAffinity(EnergyType type, int value)
    {
        this.energyAffinityType = type;
        this.energyAffinityValue = value;
    }
    
    public String toString()
    {
        return this.energyAffinityType.toString()+this.energyAffinityValue+"\n";
    }
}
