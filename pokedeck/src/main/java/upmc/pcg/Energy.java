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
public class Energy extends Card
{
    private EnergyType energyType;

    public Energy(EnergyType EnergyType, int number, String name) 
    {
        super(number, name);
        this.energyType = EnergyType;
    }

    public Energy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String toString()
    {
        return this.toString()+this.energyType.toString();
    }
}
