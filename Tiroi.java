/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benoitanger
 */

//INSTRUCTIONS: Create a class "Tiroi" with 2 attributes: "nosalle" and "code" which are integers
public class Tiroi extends Agent{
    
// (declaration des attributs nosalle et code)
int code;

//INSTRUCTIONS: Build a constructor (definir le constructeur de la classe Tiroi pour initialiser son attribut)
public Tiroi(int numerosalle, int tcode) {
        this.nosalle = numerosalle;
        this.code = tcode;
}   



//INSTRUCTIONS: Build a method "boolean verificode(Agent ag)" to ask to 'Agent ag' of the room 'nosalle' 
//to key in the password (saisiCode()), and verify if this password is the same as the value of the 
//password attribute in the schedule slip (Bodereau)
    /**
     *
     * @param ag
     * @param bdr
     * @return
     */
    public boolean verificode(Agent ag, Bodereau bdr){    //The instruction ask to build a function with only Agent ag as variable (verificode(Agent ag)), but how to get the password from the 'Bodereau'??
int codeSaisi = saisiCode();
return codeSaisi == bdr.list[ag.nosalle][3];       
}


}
