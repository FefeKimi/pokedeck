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

    public int saisieInt()
    {
        this.console.nextInt();
        int saisie = saisieInt();
        return saisie;
    }   
    public String saisieText()
    {
        this.console.nextLine();
        String saisie = this.console.nextLine();
        return saisie;
    }
    
    public void start() 
    {
        print_welcome_msg();
        ArrayList<String> names = ask_players_names();
        askPlayersMethod(names);
        game.initialize(names);
        game.play();
        menu(game.getPokedecks().get(0));
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
        int nbPlayers = saisieInt();
        System.out.println();
        
      
        while(i<=nbPlayers)
        {
            System.out.print(i+"- player name: ");
            System.out.flush();
            String playerName = saisieText();
            System.out.println();
            playersNames.add(playerName);
            i++;
        }
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
    
    public EnergyType ask_choice_energyType(){
        String name = "Undefined";
        int choice = 0;
        String energyString = "1 - Grass\n 2 - Fire\n 3 - Water\n 4 - Lightning\n 5 - Psychic\n 6 - Fighting\n 7 - Darkness\n 8 - Metal\n 9 - Fairy\n 10 - Dragon\n 11 - Colorless";
        choice = menu_isCorrectChoice(choice,energyString,1,11);
        test_choice_energy(choice);
        EnergyType energy = new EnergyType(name,choice);
        return energy;
    }
    
    public EnergyAffinity ask_choice_energyAffinity(){
        EnergyType type = ask_choice_energyType();
        int choice = 0;
        int value = menu_isCorrectChoice(choice,"Please select a value between 1-5 for the strength of the affinity",1,5);
        EnergyAffinity affinity = new EnergyAffinity(type,value);
        return affinity;
    }
    
    public int ask_choice_healthPoint(){
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"Please select a value between 10-200 for the health of your pokemon",10,200);
        return choice;
    }
    
    public int ask_choice_stage(){
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"Please select a value between 1-5 for the stage of your pokemon",1,5);
        return choice;
    }
    
    //TODO
    public ArrayList<Energy> ask_choice_retreatCost(){
        return new ArrayList<Energy>();
    }
    //TODO
    public ArrayList<SpecialConditions> ask_choice_stade(){
        return new ArrayList<SpecialConditions>();
    }
    
    //TODO
    public ArrayList<Attack> ask_choice_attack(){
        return new ArrayList<Attack>();
    }
  
    /*pas encore fonctionnelle car non finie*/
    public void menu(Pokedeck p)
    {
        System.out.println("-- Menu --");
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"1 - Display my collection\n 2 - Search specific card\n 3 - Create a card\n 4 - Quit",1,4);
      
        switch(choice){
            case 1:
                p.displayCollection();
            break;
            case 2:
                choice = menu_isCorrectChoice(choice,"1 - Search card by name\n 2 - Search card by number\n 3 - Return",1,3);
                if(choice==1)
                { 
                    System.out.println("Card name :");
                    String name = saisieText();
                    Card cardSearch = p.getCardByName(name);
                    update_card(p,cardSearch);
                }else if(choice==2)
                {
                    System.out.println("Card number :");
                    int number = saisieInt();
                    Card cardSearch = p.getCardByNumber(number);
                    update_card(p,cardSearch);
                }else if(choice==3)
                {   
                    //retour
                    break;
                }
                
            break;
            case 3:
                System.out.println("You will create a card");
                create_card();
                break;
            case 4:
                System.out.print("End game.");
            ;          
        }
  }
    
    private void create_card()
    {
        System.out.println("What kind of card do you want create ?");
        display_type_card();
        choice_type_card();
        
    }
    
    private void display_type_card()
    {
        System.out.println("1 - Pokemon");
        System.out.println("2 - Trainer");
        System.out.println("3 - Energy");
    }
    
    private void choice_type_card(){
        System.out.println("Make your choice");
        int choice = 0;
        Card newCard = null;
        choice = menu_isCorrectChoice(choice,"1 - Pokemon\n 2 - Trainer\n 3 - Energy\n",1,3);
        switch(choice){
            case 1 :
                ask_pokemon_attributes();
                newCard = new Pokemon();
                break;
            case 2 :
                ask_trainer_attributes();
                newCard = new Trainer();
                break;
            case 3 :
                ask_energy_attributes();
                newCard = new Energy();
                break;
        }
    }
    
    private Card ask_card_generality(){
        Card card =null;
        int choice = 0;
        String description = "";
        
        System.out.println("Card number :");
        int number = saisieInt();
            
        System.out.println("Card name :");
        String name = saisieText();
        
        card = new Card(number,name);
        
                    
        choice = menu_isCorrectChoice(choice,"Do you want to add description ?\n\n 1 - Yes\n 2 - No",1,2);
        if(choice==1){
            System.out.println("Card description :");
            description = saisieText();
            card.addDescription(description);    
        }
        
        return card;
        
    }
    
    private void ask_pokemon_attributes(Pokedeck p){
        System.out.println("You choose to create a Pokemon\n Please enter his name: ");
        Card c = ask_card_generality();
        EnergyType type = ask_choice_energyType();
        EnergyAffinity weakness  = ask_choice_energyAffinity();
        EnergyAffinity resistance = ask_choice_energyAffinity();
        int healthPoint = ask_choice_healthPoint();
        int stage = ask_choice_stage();
        System.out.println("Pokemon previous stage :");
        Pokemon pokemonprevioustage = null;
        System.out.print("Ability :");
        String ability = saisieText();
        ArrayList<Energy> retreatCost = ask_choice_retreatCost();
        ArrayList<SpecialConditions> stade = ask_choice_stade();
        ArrayList<Attack> attacks = ask_choice_attack();
        p.getPokedeckContent().add(
                new Pokemon(c.getCardNumber(),c.getCardName(),type,weakness,resistance,healthPoint,stage,ability,attacks,retreatCost,stade)
        );
        //ajout description
    }
    
    private void ask_trainer_attributes(){
        
    }
    
    private void ask_energy_attributes(){
        
    }
 
    private void update_card(Pokedeck p,Card c)
    { 
        
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"1 - Update this card\n 2- Delete this card\n 3 - Return",1,2);
        
        if(choice == 1)
        {
            Card card = ask_card_generality();
            c.updateCard(card.getCardNumber(),card.getCardName(),card.getCardDescription());
        }else{
            choice = menu_isCorrectChoice(choice,"Are you sure to delete this card?\n\n 1 - Yes\n 2 - No",1,2);
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
