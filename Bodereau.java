
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

// INSTRUCTIONS: Create a class called "Bodereau" - schedule slip - to itemize the instructions to the robot and which should be a matrix called "list"
public class Bodereau {
    
    // (déclaration des attributs)
int[][] list; //(Attribut )

  
  // INSTRUCTIONS: Build a constructor (Initialiser). To initialise, build the list[i][j] 
        //where i represents the delivery number (the number of deliveries is min. 1 and max. 5). 
        //j represents the attributes of the delivery: 
        //list[i][0] and list [i][1] represent the column and row of the cell to stop; 
        //list[i][2] represents the room number of the room to deliver; 
        //list[i][3] represents the password to receive the delivery
        //list[i][4] represents the delivery status: 1 means delivered, 0 means wrong password keyed in
public Bodereau() { 

        //Figure out the size of the table: how many deliveries (totalNbDeliveries = 1 to 5) (determiner la taille de la 'list' qui depend du nombre de livraison (qui est compris d'apres l'ennoncé entre 1 et 5)
        Scanner input = new Scanner(System.in);
        int totalNbDeliveries = 0; 
            while(totalNbDeliveries>5||totalNbDeliveries<1) {
            System.out.println("Combien de livraisons le robot effectue-t-il? (max. 5):");
            totalNbDeliveries = input.nextInt();
            } 
        // Then create the table based on the number of deliveries
        int[][] list = new int[totalNbDeliveries][5]; 
    
        // Then, for each delivery, key in the column number, row number, delivery room number and password
        int livraisonNb;
    
            for (livraisonNb =1; livraisonNb <=totalNbDeliveries;livraisonNb = 1+ livraisonNb){
            System.out.println("Livraison #" +livraisonNb);
        
            //Key in the column number (numéro de colonne de la position où le robot doit s’arreter pour la i-eme livraison)
            int temp = -1;
            while(temp<0||temp>9) {
                System.out.println("numéro de colonne de la position où le robot doit s’arreter pour la livraison #"+livraisonNb+" (entre 0 et 9):");
                temp = input.nextInt();
                list[livraisonNb-1][0] = temp;}
        
            //Key in the row number (numéro de ligne de la position où le robot doit s’arreter pour la i-eme livraison)
            temp = -1;
            while(temp<0||temp>9) {
                System.out.println("numéro de ligne de la position où le robot doit s’arreter pour la livraison #"+livraisonNb+" (entre 0 et 9):");
                temp = input.nextInt();
                list[livraisonNb-1][1] = temp;}

            //Key in the delivery room number (numéro de la salle à livrer pour la i-eme livraison)
            temp = -1;
            while(temp<1||temp>5) {
                System.out.println("numéro de la salle à livrer pour la livraison #"+livraisonNb+" (entre 1 et 5):");
                temp = input.nextInt();
                list[livraisonNb-1][2] = temp;}

            //Key in the password (code pour la i-eme livraison)
                System.out.println("code pour la livraison #"+livraisonNb+" (entier):");
                list[livraisonNb-1][3] = input.nextInt();
            }    

            
}    

// INSTRUCTIONS: Build a method to display the instructions (column, row, delivery room, password, status) (méthode affich(int i) : pour afficher la i`eme ligne d’un bordereau)
public void affich(int i){
String s = "LIVRAISON " + i + " : Position de la salle a livrer: (" + list[i][0] + "," + 
                list[i][1] +  "), Salle No: " + list[i][2] + ", Code :" + 
                list[i][3] + ", Etat :" + list[i][4];
        System.out.println(s);
}


}




