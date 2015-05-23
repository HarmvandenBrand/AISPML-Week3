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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BayesNetwork bn = new  BayesNetwork();
        
        Variable[] vars1 = new Variable[3];
        vars1[0] = Variable.A;
        vars1[1] = Variable.B;
        vars1[2] = Variable.C;
        double[] dubs1 = {0.3, 0.7, 0.4, 0.6, 0.2, 0.8, 0.5, 0.5};
        
        Variable[] vars2 = new Variable[2];
        vars2[0] = Variable.C;
        vars2[1] = Variable.D;
        double[] dubs2 = {0.2, 0.8, 0.9, 0.1};
        
        Factor fact = new Factor(vars1, dubs1);
        Factor fact2 = new Factor(vars2, dubs2);
        System.out.println(fact);
        System.out.println(fact2);
        
        //Set given:
        Factor givenFact = fact.setGiven(Variable.A, true);
        System.out.println(givenFact);
        
        //Multiplication:
        Factor multFact = fact.multiplication(fact2);
        System.out.println(multFact);
        
        //Summation:
        Factor sumFact = fact.desummation(Variable.B);
        System.out.println(sumFact);
        Factor sum2Fact = sumFact.desummation(Variable.C);
        System.out.println(sum2Fact);
        
        //Standardization:
        Factor standFact = sum2Fact.standardize();
        System.out.println(standFact);
    }
    
}
