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
public class Pokemon extends Card
{
   private EnergyType pokemonType;
   private EnergyAffinity pokemonWeakness;
   private EnergyAffinity pokemonResistance;
   private int pokemonHeathPoint;
   private Pokemon pokemonPreviousStage; 
   private String pokemonSpecialAbility;
   private ArrayList<Attack> pokemonAttackList;
   private ArrayList<Energy> pokemonRetreatCoat;
   private ArrayList<SpecialConditions> pokemonStade;

    public Pokemon(EnergyType pokemonType, EnergyAffinity pokemonWeakness, EnergyAffinity pokemonResistance, int pokemonHeathPoint, Pokemon pokemonPreviousStage, String pokemonSpecialAbility, ArrayList<Attack> pokemonAttackList, ArrayList<Energy> pokemonRetreatCoat, ArrayList<SpecialConditions> pokemonStade, int number, String name, String description) {
        super(number, name, description);
        this.pokemonType = pokemonType;
        this.pokemonWeakness = pokemonWeakness;
        this.pokemonResistance = pokemonResistance;
        this.pokemonHeathPoint = pokemonHeathPoint;
        this.pokemonPreviousStage = pokemonPreviousStage;
        this.pokemonSpecialAbility = pokemonSpecialAbility;
        this.pokemonAttackList = pokemonAttackList;
        this.pokemonRetreatCoat = pokemonRetreatCoat;
        this.pokemonStade = pokemonStade;
    }




}
