
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benoitanger
 */

//INSTRUCTIONS: Create a class called "Agent" with an attribute "nosalle" (integrer) representing the room number
public class Agent {

// (declaration de l'attribut nosalle)    
int nosalle;

// INSTRUCTIONS: Build a constructor (definir le constructeur de la classe Agent pour initialiser son attribut)
public Agent(int numerosalle) {
        this.nosalle = numerosalle;
}

//INSTRUCTIONS: build a method "public int saisiCode()" to key in an integer and return the integer
public int saisiCode(){
Scanner input = new Scanner(System.in);
                             // int code; No need
System.out.println("Saisir code:");
                             // code = input.nextInt();
return input.nextInt();//code;  
}

//INSTRUCTIONS: Build a method "public String accuser()" to key in a string and return the string
public String accuser(){
Scanner input = new Scanner(System.in);
                             //String accuser;
System.out.println("Saisir code:");
                             //accuser = input.next();
return input.next(); //accuser;    
}
    
}
