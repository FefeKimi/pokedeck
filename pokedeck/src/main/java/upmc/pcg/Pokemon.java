/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

import upmc.pcg.EnergyType;
import upmc.pcg.EnergyAffinity;
import upmc.pcg.Energy;
import upmc.pcg.Attack;
import java.util.ArrayList;

/**
 *
 * @author adminRAF
 */

//Delete the attribute pokemonState because it's not useful now, the SpecialConditions class is represent the side effect after getting attacked by another pokemon
public class Pokemon extends Card
{
   private EnergyType pokemonType;
   private EnergyAffinity pokemonWeakness;
   private EnergyAffinity pokemonResistance;
   private int pokemonHeathPoint;
   private int pokemonPreviousStage; 
   private String pokemonSpecialAbility;
   private ArrayList<Attack> pokemonAttackList;
   private ArrayList<EnergyType> pokemonRetreatCost;
// private ArrayList<SpecialConditions> pokemonState;

    public Pokemon
        (
            int number, 
            String name,
            EnergyType pokemonType, 
            EnergyAffinity pokemonWeakness, 
            EnergyAffinity pokemonResistance, 
            int pokemonHeathPoint, 
            int pokemonPreviousStage, 
            String pokemonSpecialAbility, 
            ArrayList<Attack> pokemonAttackList, 
            ArrayList<EnergyType> pokemonRetreatCost
//          ArrayList<SpecialConditions> pokemonState     
        ) 
    {
        super(number, name);
        this.pokemonType = pokemonType;
        this.pokemonWeakness = pokemonWeakness;
        this.pokemonResistance = pokemonResistance;
        this.pokemonHeathPoint = pokemonHeathPoint;
        this.pokemonPreviousStage = pokemonPreviousStage;
        this.pokemonSpecialAbility = pokemonSpecialAbility;
        this.pokemonAttackList = pokemonAttackList;
        this.pokemonRetreatCost = pokemonRetreatCost;
//      this.pokemonState = pokemonState;
    }
    
    /*Return elements of list in String*/
    public String getElementsListText(ArrayList list)
    {
        String elementsListText = "";
        for(int i=0;i<list.size();i++){
            elementsListText = elementsListText+list.get(i)+"\n";
        }
        return elementsListText;
    }
    
    /*TODO
     *Les attributs que j'ai pas affiché
     *pokemonPreviousStage
     *pokemonRetreatCost
     */
    public String toString()
    {
        String pokemonAttackList = getElementsListText(this.pokemonAttackList);
       
        return this.toString()+"Heath point: "+this.pokemonHeathPoint+"Attacks :\n"+pokemonAttackList;
    }


}
