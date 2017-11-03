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
public class Energy extends Card{
    private EnergyType energyType;

    public Energy(EnergyType EnergyType, int number, String name, String description) {
        super(number, name, description);
        this.energyType = EnergyType;
    }
    
    public String toString(){
        return this.toString()+this.energyType.toString();
    }
}
