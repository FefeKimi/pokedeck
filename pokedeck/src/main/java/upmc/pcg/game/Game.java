// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg.game;

import java.util.*;
import upmc.pcg.Card;
import upmc.pcg.Pokedeck;
import upmc.pcg.ui.GameUI;

public class Game {
    public HashMap<String, Pokedeck> pokedecks = new HashMap<String, Pokedeck>();
    private ArrayList<String> players_name;
    private ArrayList<Card> pokedeckContent;
    private String currentPlayer;
    private Pokedeck currentPokedeck;
    private boolean boolQuitGame;
    
  public Game() {
  }
  public void initialize(ArrayList<String> players_name) {
    currentPlayer = players_name.get(0);
    Pokedeck pokedeckPlayer = new Pokedeck(currentPlayer,pokedeckContent);
    pokedecks.put(currentPlayer, pokedeckPlayer);
    currentPokedeck = pokedecks.get(currentPlayer);
    
    
  }
  public void play() {
    int menuChoice = 0;
    
    while(!boolQuitGame){
        menuChoice = GameUI.main_menu(currentPlayer);
        main_menu_choice(menuChoice);
    }
  }
  
  private void main_menu_choice(int menuChoice){
      switch(menuChoice){
          case 1:
              currentPokedeck.add_card(GameUI.add_card_menu());
              break;
      }
  }
}
