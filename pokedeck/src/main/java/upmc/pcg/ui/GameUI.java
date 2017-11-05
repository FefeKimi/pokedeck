// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg.ui;

import java.util.*;
import upmc.pcg.Attack;
import upmc.pcg.Card;
import upmc.pcg.Energy;
import upmc.pcg.EnergyAffinity;
import upmc.pcg.EnergyType;
import upmc.pcg.Pokemon;
import upmc.pcg.Trainer;
import upmc.pcg.game.Game;

public class GameUI {
  private final Game game = new Game();
  private static final Scanner console = new Scanner(System.in);

  public void start() {
    print_welcome_msg();
    ArrayList<String> names = ask_players_names();
    game.initialize(names);
    game.play();
  }

  private ArrayList<String> ask_players_names() {
    ArrayList<String> names = new ArrayList<String>();
    boolean isAskingName=true;
    while(isAskingName){
        names.add(ask_name());
        isAskingName = ask_friend();
    }
    System.out.println("Ok, hope you're ready to discover the PokeWorld !");
    return names;
  }
  
  private String ask_name(){
      String playerName = "";
      while(playerName.equals("")){
          System.out.println("Please, tell your name");
          playerName = console.nextLine();
      }
      System.out.println("So your name is "+playerName+", fine ! ");
      return playerName;
  }
  
  private boolean ask_friend(){
      boolean isOtherPlayer = false;
      String response = "";
      while (response.equals("") || (!response.equals("y") && !response.equals("n"))) {
          System.out.println("Do you have any friend who wants to join us ? (y/n)");
          response = console.nextLine();
       }
      
      if(response.equals("y")){
          isOtherPlayer = true;
      }
      return isOtherPlayer;
  }

  private void print_welcome_msg() {
      System.out.println("POKEDECK");
      System.out.println("Welcome in the pokedeck !");
      System.out.println("It allows you to create your own cards,");
      System.out.println("You can also modify, consult, and manage your collection !");
  }
  
  public static int main_menu(String playerName){
        int choice = 0;
        display_main_menu(playerName);
        choice = ask_choice_main_menu();
        return choice;
    }
    
    public static void display_main_menu(String playerName){
        System.out.println(playerName+"'s Deck");
        System.out.println("What do you want to do ?");
        System.out.println("1 - Add Card");
        System.out.println("2 - Remove Card");
        System.out.println("3 - Update Card");
        System.out.println("4 - Show your collection");
        System.out.println("5 - Search cards in your collection");
        System.out.println("6 - Quit the game");
    }
    
    public static int ask_choice_main_menu(){
        int choice = 0;
        do{
            try{
                System.out.println("Enter your choice");
                choice = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        while(choice<1 && choice>6);
        return choice;
    }
    
    public static Card add_card_menu(){
        Card newCard = null;
        newCard = menu_type_card();
        return newCard;
    }
    
    public static Card menu_type_card(){
        String choiceType = "";
        Card card = null;
        choiceType = choice_type_card();
        switch(choiceType){
            case "Pokemon":
                card = new Pokemon();
                break;
            case "Trainer":
                card = new Trainer();
                break;
            case "Energy":
                card = new Energy();
                break;
        }
        return card;
    }
    
    public static String choice_type_card(){
        String choiceType = "";
        int choice=0;
        display_menu_type_card();
        while(choice<1 && choice>3){
            try{
                System.out.println("Enter your choice");
                choice = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        switch(choice){
            case 1:
                choiceType = "Pokemon";
                break;
            case 2:
                choiceType = "Trainer";
                break;
            case 3:
                choiceType = "Energy";
                break;
        }
        return choiceType;
    }
    
    public static void display_menu_type_card(){
        System.out.println("You are about to create a card");
        System.out.println("First, choose the card you want to create");
        System.out.println("1 - Pokemon");
        System.out.println("2 - Trainer");
        System.out.println("3 - Energy");
    }
    
    public static void display_energy_menu(){
        System.out.println("1 - Grass");
        System.out.println("2 - Fire");
        System.out.println("3 - Water");
        System.out.println("4 - Lightning");
        System.out.println("5 - Psychic");
        System.out.println("6 - Fighting");
        System.out.println("7 - Darkness");
        System.out.println("8 - Metal");
        System.out.println("9 - Fairy");
        System.out.println("10 - Dragon");
        System.out.println("11 - Colorless");
    }
    
    public static void display_trainerType_menu(){
        System.out.println("1 - Item");
        System.out.println("2 - Supporter");
        System.out.println("3 - Stadium");
        System.out.println("4 - Technical Machine");
        System.out.println("5 - Ace Spec");
        System.out.println("6 - Rocket's Secret Machine");
        System.out.println("7 - Goldenrod Game Corner");
    }
    
    
    
    public static EnergyType choice_energy(){
       System.out.println("Choose between all the Energy");
       EnergyType energy=null;
       int choice=0;
       display_energy_menu();
       while(choice<1 && choice>11){
            try{
                System.out.println("Enter your choice");
                choice = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
       switch(choice){
           case 1:
               energy = new EnergyType("Grass",choice);
               break;
           case 2:
               energy = new EnergyType("Fire",choice);
               break;
           case 3:
               energy = new EnergyType("Water",choice);
               break;
           case 4:
               energy = new EnergyType("Lightning",choice);
               break;
           case 5:
               energy = new EnergyType("Psychic",choice);
               break;
           case 6:
               energy = new EnergyType("Fighting",choice);
               break;
           case 7:
               energy = new EnergyType("Darkness",choice);
               break;
           case 8:
               energy = new EnergyType("Metal",choice);
               break;
           case 9:
               energy = new EnergyType("Fairy",choice);
               break;
           case 10:
               energy = new EnergyType("Dragon",choice);
               break;
           case 11:
               energy = new EnergyType("Colorless",choice);
               break;
       }
       return energy;        
    }
    
    public static String choice_trainerType(){
        System.out.println("Choose between all the Trainer type");
        String trainerType = "";
        int choice = 0;
        display_trainerType_menu();
        while(choice<1 && choice>7){
            try{
                System.out.println("Enter your choice");
                choice = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        switch(choice){
            case 1 :
                trainerType="Item";
                break;
            case 2 :
                trainerType="Supporter";
                break;
            case 3 :
                trainerType="Stadium";
                break;
            case 4:
                trainerType="Technical Machine";
                break;
            case 5:
                trainerType="Ace Spec";
                break;
            case 6:
                trainerType="Rocket's Secret Machine";
                break;
            case 7:
                trainerType="Goldenrod Game Corner";
                break;
        }
        return trainerType;
    }
    
    public static HashMap<String, Object> ask_pokemon_attributes(){
        HashMap<String,Object> attributesMap = new HashMap<>();
        attributesMap.put("name",ask_card_name());
        attributesMap.put("number",ask_card_number());
        attributesMap.put("description","");
        attributesMap.put("pokemonType",ask_energy_type());
        attributesMap.put("weakness",ask_pokemon_weakness());
        attributesMap.put("resistance",ask_pokemon_resistance());
        attributesMap.put("hp",ask_pokemon_HP());
        attributesMap.put("stage",ask_pokemon_stage());
        attributesMap.put("specialAbility",ask_pokemon_specialAbility());
        attributesMap.put("attackList", ask_pokemon_attackList());
        attributesMap.put("retreatCost",ask_pokemon_retreatCost());
        
        return attributesMap;
    }
    
    public static HashMap<String, Object> ask_trainer_attributes(){
        HashMap<String, Object> attributesMap = new HashMap<>();
        attributesMap.put("name",ask_card_name());
        attributesMap.put("number",ask_card_number());
        attributesMap.put("description","");
        attributesMap.put("type",ask_trainer_type());
        attributesMap.put("textBox",ask_trainer_textBox());
        attributesMap.put("rule",ask_trainer_rule());
        
        return attributesMap;
    }
    
    public static HashMap<String, Object> ask_energy_attributes(){
        HashMap<String, Object> attributesMap = new HashMap<>();
        attributesMap.put("name",ask_card_name());
        attributesMap.put("number",ask_card_number());
        attributesMap.put("description","");
        attributesMap.put("EnergyType",ask_energy_type());
        
        return attributesMap;
    }
    
    public static String ask_card_name(){
        String name="Undefined";
        do{
            System.out.println("Enter the name the card");
            name = console.nextLine();
        }
        while(name.equals(""));
        return name;
    }
    
    public static int ask_card_number(){
        int number=0;
        do{
            try{
                System.out.println("Enter the number of the card");
                number = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            } 
        }
        while(number<=0);
        return number;
    }
    
    public static EnergyType ask_energy_type(){
        EnergyType Type = null;
        Type = choice_energy();
        return Type;
    }
    
    public static int ask_pokemon_HP(){
        int hp=0;
        do{
            try{
                System.out.println("Enter the Health Point (hp) of your Pokemon");
                hp = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        while(hp<=0);
        return hp;
    }
    
    public static int ask_pokemon_stage(){
        int stage=0;
        do{
            try{
                System.out.println("Enter the current stage of your pokemon");
                stage = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        while(stage<0);
        return stage;
    }
    
    public static EnergyAffinity ask_pokemon_weakness(){
        EnergyAffinity weakness=null;
        EnergyType energy=null;
        int strength=0;
        System.out.println("Choose the weakness of your pokemon");
        energy = choice_energy();
        System.out.println("Choose the strength of the weakness");
        while(strength<1){
            try{
                System.out.println("Enter your choice");
                strength = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        weakness = new EnergyAffinity(energy,strength);
        return weakness;
    }
    
    public static EnergyAffinity ask_pokemon_resistance(){
        EnergyAffinity resistance=null;
        EnergyType energy=null;
        int strength=0;
        System.out.println("Choose the resistance of your pokemon");
        energy = choice_energy();
        System.out.println("Choose the strength of the resistance");
        while(strength<1){
            try{
                System.out.println("Enter your choice");
                strength = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        resistance = new EnergyAffinity(energy,strength);
        return resistance;
    }
    
    public static String ask_pokemon_specialAbility(){
        String text="Undefined";
        do{
            System.out.println("Write the specialAbility of your Pokemon");
            console.nextLine();
        }
        while(text.equals(""));
        return text;
    }
    
    public static String ask_attack_name(){
        String attackName="Undefined";
        do{
            System.out.println("Enter the name of your attack");
            console.nextLine();
        }
        while(attackName.equals(""));
        return attackName;
    }
    
    public static int ask_attack_damage(){
        int attackDamage=0;
        while(attackDamage<1){
            try{
                System.out.println("How many damage your attack deal ?");
                attackDamage = console.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must enter a number");
            }
        }
        return attackDamage;
    }
    
    public static ArrayList<EnergyType> ask_attack_required_energy(){
        ArrayList<EnergyType> EnergyList=new ArrayList<>();
        EnergyType newEnergy = null;
        String otherEnergy = "";
        do{
            newEnergy = choice_energy();
            EnergyList.add(newEnergy);
            do{
                System.out.println("Do your attack need more energy ? (y/n)");
                otherEnergy = console.nextLine();
            }
            while(!otherEnergy.equals("y") && !otherEnergy.equals("n"));
        }
        while(otherEnergy.equals("y"));
        return EnergyList;
    }
    
    public static String ask_attack_damage_text(){
        String text="Undefined";
        do{
            System.out.println("Write the attack damage text");
            text = console.nextLine();
        }
        while(text.equals(""));
        return text;
    }
    
    public static Attack ask_attack(){
        String attackName=ask_attack_name();
        int attackDamage=ask_attack_damage();
        ArrayList<EnergyType> attackRequiredEnergy = ask_attack_required_energy();
        String attackDamageText=ask_attack_damage_text();
        Attack newAttack= new Attack(attackName,attackDamage,attackRequiredEnergy,attackDamageText);
        return newAttack;
    }
    
    public static ArrayList<Attack> ask_pokemon_attackList(){
        ArrayList<Attack> AttackList = new ArrayList<>();
        Attack newAttack = null;
        String otherAttack = "";
        do{
            newAttack = ask_attack();
            AttackList.add(newAttack);
            do{
                System.out.println("Do your pokemon possess others attacks ? (y/n)");
                otherAttack = console.nextLine();
            }
            while(!otherAttack.equals("n") && !otherAttack.equals("n"));
        }
        while(otherAttack.equals("y"));
        return AttackList;
    }
    
    public static ArrayList<EnergyType> ask_pokemon_retreatCost(){
        ArrayList<EnergyType> retreatCost = new ArrayList<>();
        EnergyType newEnergy=null;
        String otherEnergy = "";
        do{
            System.out.println("Choose the energy that corresponds to the retreat cost");
            newEnergy=choice_energy();
            do{
                System.out.println("Is there more energy in your retreat cost ? (y/n)");
                otherEnergy=console.nextLine();
            }
            while(!otherEnergy.equals("n") && !otherEnergy.equals("y"));
        }
        while(otherEnergy.equals("y"));
        return retreatCost;
    }
    
    
    public static String ask_trainer_type(){
        String trainerType = "Undefined";
        trainerType = choice_trainerType();
        return trainerType;
    }
    
    public static String ask_trainer_textBox(){
        String textBox = "Undefined";
        do{
            System.out.println("Enter the textbox of your trainer card");
            textBox = console.nextLine();
        }
        while(textBox.equals(""));
        return textBox;
    }
    
    public static String ask_trainer_rule(){
        String rule = "Undefined";
        do{
            System.out.println("Enter the rule of your trainer card");
            rule = console.nextLine();
        }
        while(rule.equals(""));
        return rule;
    }
    
    public static String confirm_delete(String cardName){
        String confirm = "";
        while(confirm.equals("") || (!confirm.equals("y") && !confirm.equals("n"))){
            System.out.println("Do you confirm that you want to delete : "+cardName+" ? (y/n)");
            confirm = console.nextLine();
        }
        return confirm;
    }
    
    
    
    
    
}
