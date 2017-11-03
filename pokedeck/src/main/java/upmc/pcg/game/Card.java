/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

/**
 *
 * @author adminRAF
 */
public class Card 
{
    private int cardNumber;
    private String cardName;
    private String cardDescription;
    
    public Card(int number, String name)
    {
        this.cardNumber = number;
        this.cardName = name;
        this.cardDescription = "";
    }
    
    public void addDescription(String description)
    {
        this.cardDescription = description;
    }

    public void updateCard(int cardNumber,String cardName,String cardDescription){
    	//T'es sûr qu'on a besoin de cette methode? Pour moi une carte reste fixe une foid créer
    }
    
    
    public String toString(){
        return this.cardNumber+" "+this.cardName+"\n\nDescrition :\n"+this.cardDescription+"\n\n";
    }
}
