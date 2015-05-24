/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aispml_3_bayesiannetworks;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author harmbrand
 */
class Factor
{
    private ChanceRow[] rowArray;
    private int columnLength;
    private Variable[] variables;
    
    
    /*
    public Factor(Node node)
    {
        rowList = new ArrayList<>();
        
        int nrOfRows = (int) Math.pow(2, 1+node.getParents().size());
        for (Node nodelol: node.getParents())
        {
            
        }
    }
    */
    
    
    
    public Factor(Variable[] rvariables, double[] chances)
    {
        variables = rvariables;
        columnLength = variables.length;
        rowArray = new ChanceRow[(int) Math.pow(2, variables.length)];
        
        for(int i=0 ; i<rowArray.length ;  i++)
        {
            rowArray[i] =(new ChanceRow(variables, chances[i], i));
        }
    }
    
    
    
    @Override
    public String toString()
    {
        String answer = "";
        for(Variable var: variables)
        {
            switch(var)
            {
                case A: answer = answer + "A";
                        break;
                case B: answer = answer + "B";
                        break;
                case C: answer = answer + "C";
                        break;
                case D: answer = answer + "D";
                        break;
                case E: answer = answer + "E";
                        break;
                case F: answer = answer + "F";
                        break;
                case G: answer = answer + "G";
                        break;
                case H: answer = answer + "H";
                        break;
                default:answer = answer + "?";
                        break;
            }
            answer = answer + "  ";
        }
        
        answer = answer + "\n";
        
        for(int n = 0; n < rowArray.length; n++)
        {
            answer = answer + rowArray[n].toString() + "\n";
        }
        return answer;
    }
    
    
    
    public Variable[] getVariables()
    {
        return variables;
    }
    
    
    
    public ChanceRow[] getChances()
    {
        return rowArray;
    }
    
    
    
    public Factor desummation(Variable variable)
    {
        Variable[] sumVariables = new Variable[columnLength-1];
        
        int i = 0;
        for(Variable oldVariable: variables)
        {
            if(oldVariable != variable)
            {
                sumVariables[i] = oldVariable;
                i++;
            }
        }
        
        ArrayList<Integer> used = new ArrayList<>();
        double[] newChances = new double[(int) rowArray.length/2];
        int count = 0;
        
        for(int n=0; n < rowArray.length; n++)
        {
            if(!used.contains(n))
            {
                for(int m=0; m < rowArray.length; m++)
                {
                    if((m != n) && (!used.contains(m)))
                    {
                        Boolean equal = true;
                        for(int k = 0; k < columnLength; k++)
                        {
                             if(rowArray[n].getVar(k) != variable)
                             {
                                 if(!rowArray[n].getBool(k).equals(rowArray[m].getBool(k)))
                                 {
                                     equal = false;
                                 }
                             }
                        }
                        if(equal)
                        {
                            double combinedChance = (rowArray[n].getChance() + rowArray[m].getChance());
                            ModelView.SUMCOUNTER ++;
                            used.add(n);
                            used.add(m);
                            newChances[count] = combinedChance;
                            count++;
                        }
                    }
                }
            }
        }
        Factor sumFact = new Factor(sumVariables, newChances);
        return sumFact;
    }
    
    
    
    public Factor multiplication(Factor fact)
    {
        ArrayList<Variable> combinedVariables = new ArrayList<>();
        for(int n=0; n< columnLength; n++)
            combinedVariables.add(variables[n]);
        
        for(int n=0; n< fact.getVariables().length; n++)
        {
            if(!combinedVariables.contains(fact.getVariables()[n]))
            {
                combinedVariables.add(fact.getVariables()[n]);
            }
        }
        
        Variable[] combVariables = new Variable[combinedVariables.size()];
        
        for(int n=0; n < combinedVariables.size(); n++)
        {
            combVariables[n] = combinedVariables.get(n);
        }
        
        double[] combChances = new double[(int) Math.pow(2, combVariables.length)];
        
        for(int n=0; n < ((int) Math.pow(2, combVariables.length)); n++)
        {
            Boolean[] boolValues = new Boolean[combVariables.length];
            for(int b=0; b < combVariables.length; b++)
            {
                boolValues[b] = ((n % (2*((int) Math.pow(2, b)))) >= ((int) Math.pow(2, b)));
            }
            
            ChanceRow piece1 = null;
            for(int f=0; f < rowArray.length; f++)
            {
                boolean correct = true;
                for(int varbool=0; varbool<columnLength; varbool++)
                {
                    for(int newBool=0; newBool<combVariables.length; newBool++)
                    {
                        if(rowArray[f].getVar(varbool) == combVariables[newBool])
                        {
                            if(!rowArray[f].getBool(varbool).equals(boolValues[newBool]))
                            {
                                correct = false;
                            }
                        }
                    }   
                }
                if(correct)
                {
                    piece1 = new ChanceRow(rowArray[f]);
                }
            }
            
            ChanceRow piece2 = null;
            for(int f=0; f < fact.getChances().length; f++)
            {
                boolean correct = true;
                for(int varbool=0; varbool< fact.getVariables().length; varbool++)
                {
                    for(int newBool=0; newBool<combVariables.length; newBool++)
                    {
                        if(fact.getChances()[f].getVar(varbool) == combVariables[newBool])
                        {
                            if(!fact.getChances()[f].getBool(varbool).equals(boolValues[newBool]))
                            {
                                correct = false;
                            }
                        }
                    }   
                }
                if(correct)
                {
                    piece2 = new ChanceRow(fact.getChances()[f]);
                }
            }
            
            combChances[n] = (piece1.getChance() * piece2.getChance());
            ModelView.MULTICOUNTER++;
        }
        Factor combFact = new Factor(combVariables, combChances);
        return combFact;
    }
    
    
    
    public Factor standardize()
    {
        double[] newChances = new double[rowArray.length];
        double sumOfChances = 0;
        for(int i=0; i < rowArray.length; i++)
        {
            sumOfChances += rowArray[i].getChance();
        }
        for(int i=0; i < rowArray.length; i++)
        {
            newChances[i] = (rowArray[i].getChance()/sumOfChances);
        }
        Factor fact = new Factor(variables, newChances);
        return fact;
    }
    
    
    
    public Factor setGiven(Variable given, Boolean givenBool)
    {
        ArrayList<Variable> newVariables = new ArrayList<>();
        for(int i=0; i < variables.length; i++)
        {
            if(!variables[i].equals(given))
            {
                newVariables.add(variables[i]);
            }
        }
        
        Variable[] givenVariables = new Variable[newVariables.size()];
        for(int i=0; i < newVariables.size(); i++)
        {
            givenVariables[i] = newVariables.get(i);
        }
       
        int count = 0;
        double[] newChances = new double[(int) Math.pow(2, givenVariables.length)];
        for(int n=0; n < ((int) Math.pow(2, variables.length)); n++)
        {
            for(int v=0; v < variables.length; v++)
            {
                if(rowArray[n].getVar(v) == given)
                {
                    if(rowArray[n].getBool(v).equals(givenBool))
                    {
                        
                        newChances[count] = rowArray[n].getChance();
                        ModelView.SUMCOUNTER++;
                        count++;
                    }
                }
            }
        }
        Factor fact = new Factor(givenVariables, newChances);
        return fact;
    }
            
}
