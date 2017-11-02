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
public class Pokemon 
{
   private Energy pokemonType;
   private EnergyAffinity pokemonWeakness;
   private EnergyAffinity pokemonResistance;
   private int pokemonHeathPoint;
   private Pokemon pokemonPreviousStage; 
   private String pokemonSpecialAbility;
   private ArrayList<Attack> pokemonAttackList;
   private ArrayList<Energy> pokemonRetreatCoat;
   private ArrayList<SpecialConditions> pokemonStade;

   public Pokemon(Energy type, EnergyAffinity weakness,EnergyAffinity resistance, int point, Pokemon pokemon)
   {
       this.pokemonType = type;
       this.pokemonWeakness = weakness;
       this.pokemonResistance = resistance;
       this.pokemonHeathPoint = point;
       this.pokemonPreviousStage = pokemon;
       this.pokemonAttackList = new ArrayList<Attack>();
       this.pokemonRetreatCoat = new ArrayList<Energy>();
       this.pokemonStade = new ArrayList<SpecialConditions>();
   }
}
