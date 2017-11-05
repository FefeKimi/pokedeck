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
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }
    
    public String getCardName(){
        return this.cardName;
    }
    
    public int getCardNumber(){
        return this.cardNumber;
    }
    
    public String toString(){
        return this.cardNumber+" "+this.cardName+"\n\nDescrition :\n"+this.cardDescription+"\n\n";
    }
}
