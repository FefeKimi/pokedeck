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
import upmc.pcg.Pokedeck;
import upmc.pcg.Pokemon;
import upmc.pcg.SpecialConditions;
import upmc.pcg.Trainer;
import upmc.pcg.game.Game;

public class GameUI 
{
    private final Game game = new Game();
    private final Scanner console = new Scanner(System.in);
 
    public void start() 
    {
        print_welcome_msg();
        ArrayList<String> names = ask_players_names();
        askPlayersMethod(names);
        game.initialize(names);
        game.play();
        this.menu(game.getPokedecks().get(0));
    }
    
    public int menu_isCorrectChoice(int choice, String options, int limMax, int limMin)
    {
        System.out.println(options);
        choice = ask_choice_int();
        while(!(choice<limMin && choice>limMax)){
            System.out.println("Error! Please make a choice between "+limMin+"-"+limMax);
            choice = ask_choice_int();
        }
        return choice;
    }

    public String test_choice_energy(int choice){
        String name = "";
        switch(choice){
            case 1:
                name = "Grass";
                break;
            case 2:
                name = "Fire";
                break;
            case 3:
                name = "Water";
                break;
            case 4:
                name = "Lightning";;
                break;
            case 5:
                name = "Psychic";
                break;
            case 6:
                name = "Fighting";
                break;
            case 7:
                name = "Darkness";
                break;
            case 8:
                name = "Metal";
                break;
            case 9:
                name = "Fairy";
                break;
            case 10:
                name = "Dragon";
                break;
            case 11:
                name = "Colorless";
                break;
        }
        return name;
    }
  
    /*pas encore fonctionnelle car non finie*/
    public void menu(Pokedeck p)
    {
        int choice = 0;
        while(choice != 4) 
        {
            System.out.println("\n\n-- Menu --");
            choice = menu_isCorrectChoice(choice," 1 - Display my collection\n 2 - Search specific card\n 3 - Create a card\n 4 - Quit",0,5);

            switch(choice){
                case 1:
                    if(p.getPokedeckContent().isEmpty()){
                        System.out.print("Collection is empty.");
                        choice=menu_isCorrectChoice(choice,"1 - Retour",0,2);
                        if(choice==1)
                          this.menu(p);                        
                    }else{
                        p.displayCollection();
                        choice=menu_isCorrectChoice(choice,"1 - Retour",0,2);
                        if(choice==1)
                          this.menu(p);                        
                    }
                break;
                case 2:
                    if(p.getPokedeckContent().isEmpty()){
                        System.out.print("Collection is empty. Please create card(s).");
                        choice=menu_isCorrectChoice(choice,"1 - Return",0,2);
                        if(choice==1)
                          this.menu(p);
                    }else{
                        choice = menu_isCorrectChoice(choice,"1 - Search card by name\n 2 - Search card by number\n 3 - Return",0,4);
                        if(choice==1)
                        {               
                            System.out.println("Card name :");
                            String name = ask_choice_text();
                            Card cardSearch = p.getCardByName(name);
                            update_card(p,cardSearch);
                            choice=menu_isCorrectChoice(choice,"1 - Return",0,2);
                            if(choice==1)
                               this.menu(p);
                        }else if(choice==2)
                        {
                            System.out.println("Card number :");
                            int number = ask_choice_int();
                            Card cardSearch = p.getCardByNumber(number);
                            update_card(p,cardSearch);
                            choice=menu_isCorrectChoice(choice,"1 - Return",0,2);
                            if(choice==1)
                               this.menu(p);                            
                        }
                        else if(choice==3)
                        {                          
                            this.menu(p);
                        }
                    }
                break;
                case 3:
                    System.out.println("You will create a card");
                    create_card(p);
                    choice=menu_isCorrectChoice(choice,"1 - Retour",0,2);
                    if(choice==1)
                        this.menu(p);                    
                break;                
            }
        }
        if(choice == 4)
            System.out.print("End game. Goodbye ~");
    }
    

    public int ask_choice_int()
    {
        int choice = 0;
        try{
            choice = console.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("You must enter a number");
            console.nextLine();
        }
        return choice;  
    }
    
    public String ask_choice_text()
    {
        this.console.nextLine();
        String choice = this.console.nextLine();
        return choice;
    }
    
    private ArrayList<String> ask_players_names() 
    { 
      return new ArrayList<>();
    }
  
    public void askPlayersMethod(ArrayList<String> playersNames)
    {
        int i=1;
        System.out.print("Number of players : ");
        System.out.flush();
        int nbPlayers = ask_choice_int();
        System.out.println();

        while(i<=nbPlayers)
        {
            System.out.print(i+"- player name: ");
            System.out.flush();          
            String playerName = ask_choice_text();
            System.out.println();
            playersNames.add(playerName);
            i++;
        }
    }
    
    public EnergyType ask_choice_energyType(){
        String name = "Undefined";
        int choice = 0;
        String energyString = " 1 - Grass\n 2 - Fire\n 3 - Water\n 4 - Lightning\n 5 - Psychic\n 6 - Fighting\n 7 - Darkness\n 8 - Metal\n 9 - Fairy\n 10 - Dragon\n 11 - Colorless";
        choice = menu_isCorrectChoice(choice,energyString,0,12);
        test_choice_energy(choice);
        EnergyType energy = new EnergyType(choice,name);
        return energy;
    }
    
    /*5 energy affinity ou 11 ?*/
    public EnergyAffinity ask_choice_energyAffinity(){
        EnergyType type = ask_choice_energyType();
        int choice = 0;
        int value = menu_isCorrectChoice(choice,"Please select a value between 1-5 for the strength of the affinity",0,6);
        EnergyAffinity affinity = new EnergyAffinity(type,value);
        return affinity;
    }
    
    public int ask_choice_healthPoint(){
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"Please select a value between 10-200 for the health of your pokemon",9,201);
        return choice;
    }
    
    public int ask_choice_stage(){
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"Please select a value between 1-5 for the stage of your pokemon",0,6);
        return choice;
    }
    
    
    public ArrayList<EnergyType> ask_choice_retreatCost(){
        int choice = 0;
        ArrayList<EnergyType> retreatCost = ask_choice_energyList();
        return retreatCost;
    }

    public ArrayList<EnergyType> ask_choice_energyList(){
        int choice = 0;
        ArrayList<EnergyType> requiredEnergy = new ArrayList();
        choice = menu_isCorrectChoice(choice,"Please select a value between 1-5 to choose how many energy are required",0,6);
        for(int i=0;i<=choice;i++){
            EnergyType energy = ask_choice_energyType();
            requiredEnergy.add(energy);
        }
        return requiredEnergy;
    }
    
    public Attack ask_choice_attack(){
        String name = "Undefined";
        String damageText = "Undefined";
        String description = "Undefined";
        int choice = 0;
        int damage = menu_isCorrectChoice(choice,"Please select a value between 10-100 for the damage dealt by the attack",9,101);
        ArrayList<EnergyType> requiredEnergy = ask_choice_energyList();
        System.out.println("Please write the damage text of your attack");
        damageText = ask_choice_text();
        System.out.println("Please write the description of your attack");
        description = ask_choice_text();
        Attack attack = new Attack(name,damage,requiredEnergy,damageText,description);
        return attack;
    }
    
    
    public ArrayList<Attack> ask_choice_attackList(){
        int choice = 0;
        ArrayList<Attack> attacks =new ArrayList<Attack>();
        choice = menu_isCorrectChoice(choice,"Please select a value between 1-5 to choose the number of attack",0,6);
        for(int i=0;i<=choice;i++){
            Attack attack = ask_choice_attack();
            attacks.add(attack);
        }
        return attacks ;
    }
    
    private Card ask_card_generality(){
        Card card =null;
        int choice = 0;
        String description = "";
        
        System.out.println("Card number :");
        int number = ask_choice_int();
            
        System.out.println("Card name :");
        String name = ask_choice_text();
        
        card = new Card(number,name);
        
                    
        choice = menu_isCorrectChoice(choice,"Do you want to add description ?\n\n 1 - Yes\n 2 - No",0,3);
        if(choice==1){
            System.out.println("Card description :");
            description = ask_choice_text();
            card.addDescription(description);    
        }
        
        return card;
        
    }
    
    private void ask_pokemon_attributes(Pokedeck p){
        System.out.println("You choose to create a Pokemon: ");
        Card c = ask_card_generality();
        
        System.out.print("Energy :\n");
        EnergyType type = ask_choice_energyType();
        
        System.out.print("Weakness :\n");
        EnergyAffinity weakness  = ask_choice_energyAffinity();
        
        System.out.print("Resistance :\n");
        EnergyAffinity resistance = ask_choice_energyAffinity();
        
        System.out.println("Pokemon health point :");
        int healthPoint = ask_choice_healthPoint();
        System.out.println();

        System.out.println("Pokemon previous stage :");
        int stage = ask_choice_stage();
        System.out.println();
        
        System.out.print("Ability :");
        String ability = ask_choice_text();
        System.out.println();
        
        ArrayList<EnergyType> retreatCost = ask_choice_retreatCost();
        ArrayList<Attack> attacks = ask_choice_attackList();
        
        Pokemon pokemonAdd = new Pokemon(c.getCardNumber(),c.getCardName(),type,weakness,resistance,healthPoint,stage,ability,attacks,retreatCost);
        pokemonAdd.addDescription(c.getCardDescription());
        p.getPokedeckContent().add(pokemonAdd);
    }
    
    private void ask_trainer_attributes(Pokedeck p){
        System.out.println("Trainer: ");
        
        Card c = ask_card_generality();
                
        System.out.print("Type: ");
        String trainerType = ask_choice_text();
        System.out.println();
        
        System.out.print("Text box: ");
        String trainerTextBox = ask_choice_text();
        System.out.println();
        
        System.out.print("Rule: ");
        String trainerRule = ask_choice_text();
        System.out.println();
        
        Trainer trainerAdd = new Trainer(c.getCardNumber(),c.getCardName(),trainerType,trainerTextBox,trainerRule);
        trainerAdd.addDescription(c.getCardDescription());
        p.getPokedeckContent().add(trainerAdd);
    }
    
    private void ask_energy_attributes(Pokedeck p){
        System.out.println("Energy: ");
        
        Card c = ask_card_generality();

        System.out.print("Energy type id: ");
        int energyTypeId = ask_choice_int();
        System.out.println();
        
        System.out.print("Energy type name: ");
        String energyTypeName = ask_choice_text();
        System.out.println();
        
        EnergyType energyType = new EnergyType(energyTypeId,energyTypeName);
        Energy energyAdd = new Energy(c.getCardNumber(),c.getCardName(),energyType);
        energyAdd.addDescription(c.getCardDescription());
        p.getPokedeckContent().add(energyAdd);
    }
 
    
    private void create_card(Pokedeck p)
    {
        System.out.println("What kind of card do you want create ?");
        choice_type_card(p);       
    }
    
    private void choice_type_card(Pokedeck p){
        int choice = 0;
        Card newCard = null;
        choice = menu_isCorrectChoice(choice," 1 - Pokemon\n 2 - Trainer\n 3 - Energy\n",0,4);
        switch(choice){
            case 1 :
                ask_pokemon_attributes(p);
                break;
            case 2 :
                ask_trainer_attributes(p);
                break;
            case 3 :
                ask_energy_attributes(p);
                break;
        }
    }
    
    private void update_card(Pokedeck p,Card c)
    { 
        
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"1 - Update this card\n 2- Delete this card\n 3 - Return",0,3);
        
        if(choice == 1)
        {
            Card card = ask_card_generality();
            c.updateCard(card.getCardNumber(),card.getCardName(),card.getCardDescription());
        }else{
            choice = menu_isCorrectChoice(choice,"Are you sure to delete this card?\n\n 1 - Yes\n 2 - No",0,3);
            if(choice == 1)
            {
                p.deleteCard(c);    
            }else{
            //retour
            }
        }
      
    }
  
    private void print_welcome_msg() 
    {
        System.out.println("S.T.A.R.T");
    }
    
    public static void main(String[]argz){
        GameUI g = new GameUI();
        g.start();
    }
}
