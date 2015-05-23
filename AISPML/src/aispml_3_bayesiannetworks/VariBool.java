/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aispml_3_bayesiannetworks;

/**
 *
 * @author harmbrand
 */
public class VariBool
{
    private Variable var;
    private boolean bool;
    
    public VariBool(Variable var, boolean bool)
    {
        this.var = var;
        this.bool = bool;
    }
    
    
    public boolean getBool()
    {
        return this.bool;
    }
    
    public Variable getVar()
    {
        return this.var;
    }
    
    @Override
    public String toString()
    {
        if(bool)
            return "1";
        else
            return "0";
    }
}
