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

public class Game 
{
    private ArrayList<Pokedeck> listPokedeck;
 
    public Game() 
    {
        this.listPokedeck = new ArrayList<Pokedeck>();
    }

    public void initialize(ArrayList<String> players_name) 
    {
        for(int i=0;i<players_name.size();i++){
            this.listPokedeck.add(new Pokedeck(players_name.get(i),new ArrayList<Card>()));
        }
    }
  
    public ArrayList<Pokedeck> getPokedecks()
    {
        return this.listPokedeck;
    }
  
    public void play() 
    {
    
    }

    public void menu() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
