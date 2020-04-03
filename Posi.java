/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benoitanger
 */

//Java program to simulate a robot to deliver medication in a hosptial.
// The robot moves medication from the warehouse to several rooms.
// The robot can move and has several features:
//1) A screen to display messages
//2) A keybaord to receive insturctions
//3) A vault with locked drawers to move the medication

// The robot moves along a predefined pathway from the warehouse to all rooms. In order to 
// simplify the problem, the pathway will be made of fully horizontal or vertical moves.
// If a room has ordered one or several medications, when the robot passes along the room
// with the medication, the robot will stop and inform it is here. It will ask to an agent
// the password for the delivery (priorly sent via phone to the room).
// If the agent inputs the correct password, the robot shows the drawer with the medication and moves on
// after the agent acknowledges receipt of the delivery.
// Otherwise, after 3 wrong password, the robot moves on (i.e. continues to the next room of goes back to the warehouse if there is no 
// additional rooms to deliver.
// At the warehouse, an agent loads the robot and
// gives a list of instructions, the schedule slip ("Bodereau"), ordered according to the pathway. Each element
// instructs on the position where to spot, the room number and the delivery password.
// Regarding the pathway, it can be represented in a 10x10 2 dimensions matrix. Initially, the table is
// filled with 0, except the cells of the pathway wich are marked as 1. The robot moves to each cell marked with 1, 
// and after it passed a cell, the cell will be filled -1. When the robot is in a cell, depending on its current orientation,
// the robot can turn left, right or fully change direction (to then move backwards) in order to prepare its next move.

// The robot knows its position (row, column) and its orientation (N, E, S, O - O = W West in English). For each departure,
// the robot starts for the initial position, oriented north (N), de drawers are loaded according to the delivery
// schedule (and the schedule slip - Bodereau).
// Code this simulation to show the loading, the pathway, the robot position, how it moves cell after cell, messages and exchanges
// between the robot and agents, and the delivery status after the whole pathway is completed.




// INSTRUCTIONS: Create a class called "Posi" (which is the position) with 3 attributes "col", "lin", "ori" (column, row, orientation) of type integer, integer, and char.
public class Posi {    
  // (déclaration des attributs)
  int col; //(Attribut colonne)
  int lin; //(Attribut ligne)
  char ori; //(Attribut orientation)
     
// INSTRUCTIONS: Build a Constructor  (Définir le constructeur de la classe Posi pour initialiser tous ses attributs)
public Posi(int colonne, int ligne, char orientation) {
        this.col = colonne;
        this.lin = ligne;
        this.ori = orientation;
}
  


}

