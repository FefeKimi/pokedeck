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
  }

  private ArrayList<String> ask_players_names() 
  { 
      return new ArrayList<>();
  }
  
  public void askPlayersMethod(ArrayList<String> playersNames){
      int i=1;
      System.out.print("Number of players : ");
      System.out.flush();
      int nbPlayers = this.console.nextInt();
      System.out.println();      
      this.console.nextLine();
      
      while(i<=nbPlayers){         
          System.out.print(i+"- player name: ");
          System.out.flush();
          String playerName = this.console.nextLine();
          System.out.println();
          playersNames.add(playerName);  
          i++;
      }
      
  }
  
  private void print_welcome_msg() 
  {
      System.out.println("S.T.A.R.T");
  }
  
}
