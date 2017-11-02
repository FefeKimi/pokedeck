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
    
    public Card(int number, String name,String description)
    {
        this.cardNumber = number;
        this.cardName = name;
        this.cardDescription = description;
    }
}
