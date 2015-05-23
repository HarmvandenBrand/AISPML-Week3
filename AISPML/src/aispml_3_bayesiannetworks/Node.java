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
class Node
{
    private ArrayList<Node> parents;
    private int chance;
    private Factor factor;
    
    public Node(ArrayList parents, int chance)
    {
        this.parents = parents;
        if (parents.isEmpty())
            this.chance = chance;
        
        
    }
    
    
    
    
    public ArrayList<Node> getParents()
    {
        return parents;
    }
    
    public boolean hasParents()
    {
        return (!parents.isEmpty());
    }
}
