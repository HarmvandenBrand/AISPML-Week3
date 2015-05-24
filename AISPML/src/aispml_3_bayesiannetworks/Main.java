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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Variable[] vars1 = new Variable[3];
        vars1[0] = Variable.A;
        vars1[1] = Variable.B;
        vars1[2] = Variable.C;
        double[] dubs1 = {0.3, 0.7, 0.4, 0.6, 0.2, 0.8, 0.5, 0.5};
        
        Variable[] vars2 = new Variable[2];
        vars2[0] = Variable.C;
        vars2[1] = Variable.D;
        double[] dubs2 = {0.2, 0.8, 0.9, 0.1};
        
        Variable[] vars3 = new Variable[1];
        vars3[0] = Variable.B;
        double[] dubs3 = {0.1, 0.9};
        
        Variable[] vars4 = new Variable[1];
        vars4[0] = Variable.D;
        double[] dubs4 = {0.7, 0.3};
        
        ArrayList<Variable> varsAll = new ArrayList<>();
        varsAll.add(Variable.A);
        varsAll.add(Variable.B);
        varsAll.add(Variable.C);
        varsAll.add(Variable.D);
        
        Factor fact = new Factor(vars1, dubs1);
        Factor fact2 = new Factor(vars2, dubs2);
        Factor fact3 = new Factor(vars3, dubs3);
        Factor fact4 = new Factor(vars4, dubs4);
        System.out.println(fact);
        System.out.println(fact2);
        System.out.println(fact3);
        System.out.println(fact4);
        
        ArrayList<Factor> factAll = new ArrayList<>();
        factAll.add(fact);
        factAll.add(fact2);
        factAll.add(fact3);
        factAll.add(fact4);
        
        ArrayList<VariBool> given = new ArrayList<>();
        given.add(new VariBool(Variable.B, true));
        
        Variable query = Variable.A;
        
        VariableElimination eli = new VariableElimination();
        
        Factor result = eli.elimination(varsAll, factAll, given, query);
        System.out.println(result);
        /*
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
                */
    }
    
}
