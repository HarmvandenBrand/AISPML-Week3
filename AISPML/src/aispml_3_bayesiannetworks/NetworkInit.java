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
public class NetworkInit {
    private ArrayList<BayesNetwork> networks = new ArrayList<>();
    
    public NetworkInit()
    {
        makeNetworks();
    }
    
    public void makeNetworks()
    {
        // Network 1; CANCER:
        
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
        
        Variable[] varsA = new Variable[1];
        varsA[0] = Variable.A;
        double[] dubsA = {0.9, 0.1};        
        Factor factorA = new Factor(varsA, dubsA);
        
        Variable[] varsB = new Variable[1];
        varsB[0] = Variable.B;
        double[] dubsB = {0.7, 0.3};        
        Factor factorB = new Factor(varsB, dubsB);
        
        Variable[] varsC = new Variable[3];
        varsC[0] = Variable.C;
        varsC[0] = Variable.B;
        varsC[0] = Variable.A;
        double[] dubsC = {0.999, 0.001 , 0.98, 0.02, 0.97, 0.03 , 0.95, 0.05};        
        Factor factorC = new Factor(varsC, dubsC);
        
        Variable[] varsD = new Variable[2];
        varsD[0] = Variable.D;
        varsD[1] = Variable.C;
        double[] dubsD = {0.8, 0.2, 0.1, 0.9};        
        Factor factorD = new Factor(varsD, dubsD);
        
        Variable[] varsE = new Variable[2];
        varsE[0] = Variable.E;
        varsE[1] = Variable.C;
        double[] dubsE = {0.7, 0.3, 0.35, 0.65};
        Factor factorE = new Factor(varsE, dubsE);
        
        ArrayList<Factor> network1 = new ArrayList<>();
        network1.add(factorA);
        network1.add(factorB);
        network1.add(factorC);
        network1.add(factorD);
        network1.add(factorE);
        
        ArrayList<Variable> variables1 = new ArrayList<>();
        variables1.add(Variable.A);
        variables1.add(Variable.B);
        variables1.add(Variable.C);
        variables1.add(Variable.D);
        variables1.add(Variable.E);
        
        BayesNetwork bayes1 = new BayesNetwork(network1, variables1);
        networks.add(bayes1);
        
        //Network 2; ASIA:
        //      
        //     ---                 ---
        //    | A |               | C |
        //     ---                /---\
        //      |                /     \
        //      |               /       \
        //     ---          ---/         \---
        //    | B |        | D |         | E |
        //     ---\        /---           ---
        //         \      /                |
        //           \---/                 |
        //           | F |                 |
        //           /---\_____            |
        //          /          \_____      |
        //         /                 \___  |
        //     ---/                      \---
        //    | G |                      | H |
        //     ---                        ---
        
        Variable[] varsA2 = new Variable[1];
        varsA2[0] = Variable.A;
        double[] dubsA2 = {0.99, 0.01};        
        Factor factorA2 = new Factor(varsA2, dubsA2);
        
        Variable[] varsB2 = new Variable[2];
        varsB2[0] = Variable.B;
        varsB2[1] = Variable.A;
        double[] dubsB2 = {0.99, 0.01, 0.95, 0.05};        
        Factor factorB2 = new Factor(varsB2, dubsB2);
        
        Variable[] varsC2 = new Variable[1];
        varsC2[0] = Variable.C;
        double[] dubsC2 = {0.5, 0.5};        
        Factor factorC2 = new Factor(varsC2, dubsC2);
        
        Variable[] varsD2 = new Variable[2];
        varsD2[0] = Variable.D;
        varsD2[1] = Variable.C;
        double[] dubsD2 = {0.99, 0.01, 0.9, 0.1};        
        Factor factorD2 = new Factor(varsD2, dubsD2);
        
        Variable[] varsE2 = new Variable[2];
        varsE2[0] = Variable.E;
        varsE2[1] = Variable.C;
        double[] dubsE2 = {0.7, 0.3, 0.4, 0.6};        
        Factor factorE2 = new Factor(varsE2, dubsE2);
        
        Variable[] varsF2 = new Variable[3];
        varsF2[0] = Variable.F;
        varsF2[1] = Variable.D;
        varsF2[2] = Variable.B;
        double[] dubsF2 = {1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0};        
        Factor factorF2 = new Factor(varsF2, dubsF2);
        
        Variable[] varsG2 = new Variable[2];
        varsG2[0] = Variable.G;
        varsG2[1] = Variable.F;
        double[] dubsG2 = {0.95, 0.05, 0.02, 0.98};        
        Factor factorG2 = new Factor(varsG2, dubsG2);
        
        Variable[] varsH2 = new Variable[3];
        varsH2[0] = Variable.H;
        varsH2[1] = Variable.E;
        varsH2[2] = Variable.F;
        double[] dubsH2 = {0.9, 0.1, 0.2, 0.8, 0.3, 0.7, 0.1, 0.9};        
        Factor factorH2 = new Factor(varsH2, dubsH2);
        
        ArrayList<Factor> network2 = new ArrayList<>();
        network2.add(factorA2);
        network2.add(factorB2);
        network2.add(factorC2);
        network2.add(factorD2);
        network2.add(factorE2);
        network2.add(factorF2);
        network2.add(factorG2);
        network2.add(factorH2);
        
        ArrayList<Variable> variables2 = new ArrayList<>();
        variables2.add(Variable.A);
        variables2.add(Variable.B);
        variables2.add(Variable.C);
        variables2.add(Variable.D);
        variables2.add(Variable.E);
        variables2.add(Variable.F);
        variables2.add(Variable.G);
        variables2.add(Variable.H);
        
        BayesNetwork bayes2 = new BayesNetwork(network2, variables2);
        networks.add(bayes2);
    }
    
    public ArrayList<BayesNetwork> getNetworks()
    {
        return networks;
    }
    
}
