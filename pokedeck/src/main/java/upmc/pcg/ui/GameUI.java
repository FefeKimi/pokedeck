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
import upmc.pcg.Card;
import upmc.pcg.Pokedeck;
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
        int nbPlayers = this.console.nextInt();
        System.out.println();
        this.console.nextLine();
      
        while(i<=nbPlayers)
        {
            System.out.print(i+"- player name: ");
            System.out.flush();
            String playerName = this.console.nextLine();
            System.out.println();
            playersNames.add(playerName);
            i++;
        }
  }
    public int isNumber()
    {
        int choice=0;
        try{
            choice = console.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("You must enter a number");
            console.nextLine();
        }
        return choice;      
    }
    
    public int menu_isCorrectChoice(int choice, String options, int limMax, int limMin)
    {
        System.out.println("1 - Display my collection\n 2 - Search specific card\n 3 - Create a card\n 4 - Quit");
        choice = ask_menu_choice(choice);
        while(!(choice>limMin && choice<limMax)){
            System.out.println("Error! Please make a choice between "+limMin+"-"+limMax);
            choice = ask_menu_choice(choice);
        }
        return choice;
    }
    
    public int ask_menu_choice(int choice)
    {
        choice= isNumber();
        return choice;
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
                choice = menu_isCorrectChoice(choice,"1 - Search card by name\n 2 - Search card by number\n 3 - Return",1,2);
                if(choice==1){
                    this.console.nextLine();
                    System.out.println("Card name :");
                    String name = this.console.nextLine();
                    Card cardSearch = p.getCardByName(name);
                    update_card(p,cardSearch);
                }else if(choice==2){
                    System.out.println("Card number :");
                    int number = this.console.nextInt();
                    Card cardSearch = p.getCardByNumber(number);
                    update_card(p,cardSearch);
                }else if(choice==3){   
                    //retour
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
        System.out.println("Make your choice");     
    }
    
    private void display_type_card()
    {
        System.out.println("1 - Pokemon");
        System.out.println("2 - Trainer");
        System.out.println("3 - Energy");
    }
 
    private void update_card(Pokedeck p,Card c)
    { 
        this.console.nextInt();
        int choice = 0;
        choice = menu_isCorrectChoice(choice,"1 - Update this card\n 2- Delete this card\n 3 - Return",1,2);
        
        if(choice == 1)
        {
            String description = "";
            System.out.println("Card number :");
            int number = this.console.nextInt();
            
            this.console.nextLine();
            System.out.println("Card number :");
            String name = this.console.nextLine();
            
            this.console.nextInt();            
            choice = menu_isCorrectChoice(choice,"Do you want to add description ?\n\n 1 - Yes\n 2 - No",1,2);
            if(choice==1){
                this.console.nextLine();
                System.out.println("Card description :");
                description = this.console.nextLine();
                c.updateCard(number,name,description);
            }else {
                c.updateCard(number,name,description);
            }
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
  
}
