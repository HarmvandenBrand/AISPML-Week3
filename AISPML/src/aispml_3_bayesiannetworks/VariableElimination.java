/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aispml_3_bayesiannetworks;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class VariableElimination {
    
    
    public Factor elimination(ArrayList<Variable> vs, ArrayList<Factor> fs, ArrayList<VariBool> given, Variable query)
    {
        for(int i=0; i< vs.size(); i++)
        {
            if(!vs.get(i).equals(query))
            {
                Boolean isGiven = false;
                for(int g=0; g< given.size(); g++)
                {
                    if(vs.get(i).equals(given.get(g).getVar()))
                    {
                        isGiven = true;
                        int f = 0;
                        while(f < fs.size())
                        {
                            Variable[] variables = fs.get(f).getVariables();
                            boolean contains = false;
                            for(int b=0; b<variables.length; b++)
                            {
                                if(variables[b].equals(given))
                                {
                                    contains = true;
                                }
                            }
                            if(contains)
                            {
                                Factor newFact = fs.get(f).setGiven(given.get(g).getVar(), given.get(g).getBool());
                                fs.add(newFact);
                                fs.remove(f);
                            }
                            else
                            {
                                f++;
                            }
                        }
                    }
                }
                if(!isGiven)
                {
                    
                }
            }
        }
    }
}
