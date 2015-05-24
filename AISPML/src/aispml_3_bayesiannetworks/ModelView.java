/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aispml_3_bayesiannetworks;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class ModelView {
    ArrayList<BayesNetwork> networks = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    public static int MULTICOUNTER = 0;
    public static int SUMCOUNTER = 0;
    
    public ModelView()
    {
        NetworkInit initialize = new NetworkInit();
        initialize.makeNetworks();
        networks = initialize.getNetworks();
        run();
    }
    
    public void run()
    {
        System.out.println("Which network do you want to use? Type 1, 2 or 3. (the networks are in our appendix)");
        int networkNumber = scan.nextInt();
        String empty = scan.nextLine();
        BayesNetwork used = networks.get(networkNumber-1);
        ArrayList<VariBool> variBool = new ArrayList<>();
        System.out.println("Do you want any variables to be given? (yes or no)");
        String answer = scan.nextLine();
        boolean givenVar = answer.equals("yes");
        while(givenVar)
        {
            System.out.println("Which variable is given? (give the letter in uppercase)");
            Variable var = null;
            String variable = scan.nextLine();
            switch(variable)
            {
                case "A": var = Variable.A;
                        break;
                case "B": var = Variable.B;
                        break;
                case "C": var = Variable.C;
                        break;
                case "D": var = Variable.D;
                        break;
                case "E": var = Variable.E;
                        break;
                case "F": var = Variable.F;
                        break;
                case "G": var = Variable.G;
                        break;
                case "H": var = Variable.H;
                        break;
                default : System.out.println("That is not an option!"); 
                        break;
            }
            if(var == null)
            {
                continue;
            }
            else
            {
                System.out.println("Is it true or false?");
                boolean theBool = false;
                boolean correct = true;
                String bool = scan.nextLine();
                switch(bool)
                {
                    case "true" : theBool = true;
                            break;
                    case "false": theBool = false;
                            break;
                    default     : System.out.println("That is not an option!");
                            correct = false;
                            break;

                }
                if(correct)
                    {
                        VariBool vb = new VariBool(var, theBool);
                        variBool.add(vb);
                        System.out.println("Do you want to add another given variable? (type yes or no)");
                        String yesorno = scan.nextLine();
                        if(!yesorno.equals("yes"))
                        {
                            givenVar = false;
                        }
                    }
            }
        }
        Variable query = null;
        System.out.println("Which variable is the query? (give the variable in uppercase)");
        boolean chosen = false;
        while(!chosen)
        {
            chosen = true;
            String variable = scan.nextLine();
            switch(variable)
            {
                case "A": query = Variable.A;
                        break;
                case "B": query = Variable.B;
                        break;
                case "C": query = Variable.C;
                        break;
                case "D": query = Variable.D;
                        break;
                case "E": query = Variable.E;
                        break;
                case "F": query = Variable.F;
                        break;
                case "G": query = Variable.G;
                        break;
                case "H": query = Variable.H;
                        break;
                default : System.out.println("That is not an option!"); 
                        chosen = false;
                        break;
            }
        }
        
        VariableElimination eli = new VariableElimination();
        Factor fact = eli.elimination(used.getVariables(), used.getFactors(), variBool, query);
        
        System.out.println("The chances of the query are:");
        System.out.println(fact);
        System.out.println("The amount of sums is: " + SUMCOUNTER);
        System.out.println("The amount of multiplications is: " + MULTICOUNTER);
    }
}
