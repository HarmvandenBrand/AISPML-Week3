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
        
        Variable[] varsA = new Variable[1];
        varsA[0] = Variable.A;
        double[] dubsA = {0.1, 0.9};        
        Factor factorA = new Factor(varsA, dubsA);
        
        Variable[] varsB = new Variable[1];
        varsB[0] = Variable.B;
        double[] dubsB = {0.25, 0.75};        
        Factor factorB = new Factor(varsB, dubsB);
        
        Variable[] varsC = new Variable[3];
        varsC[0] = Variable.C;
        varsC[0] = Variable.B;
        varsC[0] = Variable.A;
        double[] dubsC = {0.9, 0.1 , 0.7, 0.3, 0.5, 0.5 , 0.01, 0.99};        
        Factor factorC = new Factor(varsC, dubsC);
        
        Variable[] varsD = new Variable[2];
        varsD[0] = Variable.D;
        varsD[1] = Variable.C;
        double[] dubsD = {0.35, 0.65, 0.2, 0.8};        
        Factor factorD = new Factor(varsD, dubsD);
        
        Variable[] varsE = new Variable[2];
        varsE[0] = Variable.E;
        varsE[1] = Variable.C;
        double[] dubsE = {0.5, 0.5, 0.5, 0.5};
        Factor factorE = new Factor(varsE, dubsE);
        
        
        
        //      
        //     ---                 ---
        //    | A |               | B |
        //     --- \             / ---
        //           \         /
        //              ---
        //             | C |
        //              ---
        //            /      \
        //     ---  /           \  ---
        //    | D |               | E |
        //     ---                 ---
    }
}
