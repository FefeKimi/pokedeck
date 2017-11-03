/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

/**
 *
 * @author adminRAF
 */
public class EnergyAffinity 
{
    private EnergyType energyAffinityType;
    private int energyAffinityValue;
    private String energyAffinityName;
    
    public EnergyAffinity(EnergyType type, int value, String name)
    {
        this.energyAffinityType = type;
        this.energyAffinityValue = value;
        this.energyAffinityName = name;
    }
    
    public String toString(){
        return this.energyAffinityType.toString()+this.energyAffinityValue+" "+this.energyAffinityName+"\n";
    }
}
