/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aispml_3_bayesiannetworks;

import java.util.ArrayList;

/**
 *
 * @author harmbrand
 */
class BayesNetwork
{
    private ArrayList<Factor> factorList = new ArrayList<>();
    private ArrayList<Variable> variableList = new ArrayList<>();
    
    public BayesNetwork(ArrayList<Factor> rfactorList, ArrayList<Variable> rvariableList)
    {
        factorList = rfactorList;
        variableList = rvariableList;
    }
    
    public ArrayList<Factor> getFactors()
    {
        return factorList;
    }
    
    public ArrayList<Variable> getVariables()
    {
        return variableList;
    }
}
