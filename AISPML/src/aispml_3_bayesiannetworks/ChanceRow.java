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
class ChanceRow
{
    private double chance;
    private VariBool[] variBoolArray;
    private int columnLength;

    public ChanceRow(ChanceRow other)
    {
        this.chance = other.chance;
        this.variBoolArray = other.variBoolArray;
        this.columnLength = other.columnLength;
    }
    
    public ChanceRow(Variable[] variables, double chance, int number)
    {
        columnLength = variables.length;
        this.variBoolArray = new VariBool[columnLength];
        this.chance = chance;
        
        for(int i = 0; i < columnLength; i++)
        {
            variBoolArray[i] = new VariBool(variables[i], (number % (2*((int) Math.pow(2, i)))) >= ((int) Math.pow(2, i)));
        }
    }
    
    public Boolean getBool(int number)
    {
        return variBoolArray[number].getBool();
    }
    
    public Variable getVar(int number)
    {
        return variBoolArray[number].getVar();
    }
    
    public double getChance()
    {
        return chance;
    }
    
    @Override
    public String toString()
    {
        String answer = "";
        for(int i = 0; i < columnLength; i++)
        {
            answer = answer + variBoolArray[i].toString() + "  ";
        }
        answer = answer + Double.toString(chance);
        return answer;
    }
}
