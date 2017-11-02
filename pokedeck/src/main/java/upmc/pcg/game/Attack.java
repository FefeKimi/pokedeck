/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.ArrayList;

/**
 *
 * @author adminRAF
 */
public class Attack 
{
    private String attackName;
    private int attackDamage;
    private ArrayList<Energy> attackRequiredEnergy;
    private SpecialConditions attackSpecialConditions;
    private String attackDamageText;
    private String attackDescription;
    
    public Attack(String attackName, int attackDamage, SpecialConditions attackSpecialConditions, String attackDamageText, String attackDescription){
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        this.attackSpecialConditions = attackSpecialConditions;
        this.attackDamageText = attackDamageText;
        this.attackDescription = attackDamageText;
        this.attackRequiredEnergy = new ArrayList<Energy>();
    }
}
