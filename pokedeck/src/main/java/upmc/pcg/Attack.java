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

//Delete attribute SpecialConditions because this class isn't useful for now, she represents an condition that an attack can apply to another pokemon
public class Attack 
{
    private String attackName;
    private int attackDamage;
    private ArrayList<EnergyType> attackRequiredEnergy;
    //private SpecialConditions attackSpecialConditions;
    private String attackDamageText;
    private String attackDescription;
    
    public Attack(String attackName, int attackDamage, ArrayList<EnergyType> attackRequiredEnergy,String attackDamageText, String attackDescription){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        //this.attackSpecialConditions = attackSpecialConditions;
        this.attackDamageText = attackDamageText;
        this.attackDescription = attackDamageText;
        this.attackRequiredEnergy = attackRequiredEnergy;
    }
}
