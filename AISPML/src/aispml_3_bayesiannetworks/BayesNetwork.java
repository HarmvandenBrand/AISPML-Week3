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
    ArrayList<Factor> factorList = new ArrayList<>();
    
    public BayesNetwork()
    {
        
        Variable[] vars1 = new Variable[2];
        vars1[0] = Variable.A;
        vars1[1] = Variable.B;
        double[] dubs1 = {0.1, 0.9, 0.2, 0.8};        
        Factor factor1 = new Factor(vars1, dubs1);
        
        Variable[] vars2 = new Variable[2];
        vars2[0] = Variable.A;
        vars2[1] = Variable.B;
        double[] dubs2 = {0.3, 0.7, 0.6, 0.4};
        Factor factor2 = new Factor(vars2, dubs2);
        
        Variable[] vars1x2 = new Variable[3];
        vars1x2[0] = Variable.A;
        vars1x2[1] = Variable.B;
        vars1x2[2] = Variable.C;
        double[] dubs1x2 = {0.3, 0.7, 0.4, 0.6, 0.2, 0.8, 0.5, 0.5};
        Factor factor1x2 = new Factor(vars1x2, dubs1x2);
        
    }
}
