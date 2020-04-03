/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benoitanger
 */

//INSTRUCTIONS: Create a class called "Trajet" (which is the pathway) with 2 attributes: "plan": a 2-dimension matrix, and "deb" which is the position / starting position
public class Trajet {  
  // (déclaration des attributs)
  int[][] plan; //(Attribut plan)
  Posi deb; //(Attribut Posi)

// INSTRUCTIONS: Build a constructor to initialise the pathway [(C1,L1) - (C1,L3)],[(C1,L3) - (C4,L3)], [(C4,L3), (C4, L8)]. And deb as the stating position: (1,1,S) (Initialiser)
public Trajet() {
plan = new int[10][10];
    //NO NEED - ALREADY INITIALSED WITH 0 (Mettre des 0 dans chaque case)
    //int i;
    //for (i = 0; i < 10; i++) {
    //plan[i][0] = 0;
    //}
    
    //Change cells of the pathway to 1 (Mettre des 1 sur les cases du trajet)
    plan[1][1] = plan[1][2]= plan[1][3]= plan[2][3]= plan[3][3] = plan[4][3]= plan[4][4]= plan[4][5]= plan[4][6]= plan[4][7]= plan[4][8] =1;

deb = new Posi(1, 1, 'N');            

}  


// INSTRUCTIONS: Build a method to display the pathway
public void affichTrajet(int[][] plan) {
int n, m;
    for (n = 0; n < 10; n++) {
    for (m = 0; m < 10; m++) System.out.print(plan[n][m] + " ");
    System.out.println(); System.out.println();
    }   
}

// INSTRUCTIONS: Build a main method to test this class
public static void main(String[] args) {
        Trajet trajet1 = new Trajet(); // Object names are always lowercase, and the second word and onwards are capital. Just how you make variable names in Java.
        trajet1.affichTrajet(trajet1.plan); 
}
    
    
}
    

