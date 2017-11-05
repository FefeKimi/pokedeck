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

    public EnergyType(String EnergyTypeName, int EnergyTypeId) 
    {
        this.EnergyTypeName = EnergyTypeName;
        this.EnergyTypeId = EnergyTypeId;
    }

    public EnergyType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEnergyTypeName() {
        return EnergyTypeName;
    }
    
    public String toString()
    {
        return this.EnergyTypeId+"Energy type : "+this.EnergyTypeName+"\n";
    }
}
