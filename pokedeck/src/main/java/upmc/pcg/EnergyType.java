/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

/**
 *
 * @author sena-
 */
public class EnergyType 
{
    private String EnergyTypeName;
    private int EnergyTypeId;

    public EnergyType(int EnergyTypeId,String EnergyTypeName) 
    {
        this.EnergyTypeName = EnergyTypeName;
        this.EnergyTypeId = EnergyTypeId;
    }
    
    public String toString()
    {
        return this.EnergyTypeId+"Energy type : "+this.EnergyTypeName+"\n";
    }
}
