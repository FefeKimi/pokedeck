/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

import java.util.ArrayList;

/**
 *
 * @author adminRAF
 */
public class Attack 
{
    private String attackName;
    private int attackDamage;
    private ArrayList<EnergyType> attackRequiredEnergy;
    //private SpecialConditions attackSpecialConditions;
    private String attackDamageText;
    
    public Attack(String attackName, int attackDamage,ArrayList<EnergyType> requiredEnergy, String attackDamageText){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        //this.attackSpecialConditions = attackSpecialConditions;
        this.attackDamageText = attackDamageText;
        this.attackRequiredEnergy = requiredEnergy;
    }
}
