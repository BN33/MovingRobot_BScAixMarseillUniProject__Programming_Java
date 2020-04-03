

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benoitanger
 */

//INSTRUCTIONS: Create a class called "Robot" with two attributes: "coffre" (meaning vault) which is a table of 5 drawers
// and "pos" (Posi class) which represents the current position and orientation of the robot
public class Robot {
      // (déclaration des attributs)
  int[][] coffre; //(Attribut coffre)
  Posi pos; //(Attribut Posi)

    //INSTRUCTIONS: Build a constructor (Initialiser)
    public Robot(Trajet traj) {
    int[][] coffre = new int [2][5]; //5 rows (one per delivery), 2 column: column 1: room number, column 2: password)  (5 colonnes (une par tiroi) + 2 lignes: ligne 0 pour les numeros de salle, ligne 1 pour les codes)
    pos = traj.deb; 
    }


    //INSTRUCTIONS: Build a method "void charger(Bordereau bdr)" to load the medication into the drawers of the robot and in the delivery order: 
    //medications to deliver in the first room shall be in the first drawer... This shall be done by copying the 
    //room number and the password from the schedule slip (Bodereau) into the robot vault "coffre"
    public void charger(Bodereau bdr, Trajet traje){
    Robot robo = new Robot(traje);

        int p;
        for(p=0;p>4;p=1+p){
        robo.coffre [0][p] = bdr.list[p][2];    
        }

        for(p=0;p>4;p=1+p){
        robo.coffre[1][p] = bdr.list[p][2];    
        }   
    }

    //INSTRUCTIONS: Build a method "int notiroi(int nosal)" to return the drawer number that holds the medications 
    // to deliver in the room with the number "nosal"
    public int notiroi(int nosal, Bodereau bdreau){ //The instruction is to build a function based only on nosal, but I don't see how to do that without the variable Bodereau
    int i,j = 0;
    for (i=0;i>4;i++){
        if (bdreau.list[i][2] == nosal) {j = i;};    
    }
    return j;
    }

    //INSTRUCTIONS: Build a method "pas suivant (Trajet tr)" (translation: next move) to display the current position of the robot,
    //the actions to execute to move to the next cell on the pathway, update the current position, and return TRUE
    //if there are still cells to go. If there is no more cells to go, return FALSE and show "Fin de trajet" (translation: "end of the path") 
    boolean pas_suivant (Trajet tr){
    Posi posCourante = tr.deb; //starting position (position de depart)

    boolean ret=true;
    
    //Several scenario based on the orientation (differents scenarii en fonction de l'orientation)    
    switch(posCourante.ori){
        case 'N': 
            if(tr.plan[posCourante.col][posCourante.lin-1]==1)
                {posCourante.lin--;}
            else {
                if(tr.plan[posCourante.col+1][posCourante.lin]==1)
                    {posCourante.ori= 'E';posCourante.col++;}
                else{
                    if(tr.plan[posCourante.col-1][posCourante.lin]==1)
                    {posCourante.ori= 'O';posCourante.col--;}
                    }
                }; 
        
        case 'O': 
            if(tr.plan[posCourante.col-1][posCourante.lin]==1)
                {posCourante.col--;}
            else{
                if(tr.plan[posCourante.col][posCourante.lin-1]==1)
                    {posCourante.ori= 'N';posCourante.lin--;}
                else{
                    if(tr.plan[posCourante.col][posCourante.lin+1]==1)
                    {posCourante.ori= 'S';posCourante.lin++;}
                    }
                }; 
        
        case 'S': 
            if(tr.plan[posCourante.col][posCourante.lin+1]==1)
                {posCourante.lin++;}
            else{
                if(tr.plan[posCourante.col+1][posCourante.lin]==1)
                    {posCourante.ori= 'E';posCourante.col++;}
                else{
                    if(tr.plan[posCourante.col-1][posCourante.lin]==1)
                    {posCourante.ori= 'O';posCourante.col--;}
                    }
                }; 
        
        case 'E': 
            if(tr.plan[posCourante.col+1][posCourante.lin]==1)
                {posCourante.col++;}
            else{
                if(tr.plan[posCourante.col][posCourante.lin-1]==1)
                    {posCourante.ori= 'N';posCourante.lin--;}
                else{
                    if(tr.plan[posCourante.col][posCourante.lin+1]==1)
                    {posCourante.ori= 'S';posCourante.lin++;}
                    }
                };
                
        default: 
            System.out.println("Fin de trajet");
            ret=false;}
    
    return ret;

    }        

    
    //INSTRUCTIONS: Build a method "void tourner(Trajet trj, Bordereau bdr)" to simulate the robot deliveries on the pathway trajet trj and the schedule slip bordereau bdr.
    void tourner(Trajet trj, Bodereau bdr, Agent ag){       
    //The instruction ask to use only 2 variables: Trajet and Bodereau, but I don't see how not to use Agent as well
    
    //get a variable with the delivery number and understand the total number of deliveries
    int deliveryNumber = 1 ;
    int totalNbOfDeliveries = bdr.list.length;
                
    //Start with the moves and if the moves ends up on a
    while (deliveryNumber <= totalNbOfDeliveries) {
        if(pas_suivant (trj)) //?? Will this will make the robot move? or just return TRUE/FALSE ??
        {
            if(posCourante.col == bdr.list[deliveryNumber][0] && posCourante.lin == bdr.list[deliveryNumber][1]) { //??Why is posCourante.XXX not recognized while I use the pas_suivant function ??
                int essai;
                    for (essai=0; essai>3; essai++) {		
                        if(Tiroi.verificode(ag, bdr)){ //I don't understand this error
                                    bdr.list[deliveryNumber][4]=1;
                                    deliveryNumber++;
                        } else{
                            bdr.list[deliveryNumber][4]=0;
                        }
            }
        }
        else{
        }
        }
    }


    // RENDU: tourner(Tiroi tiroi, Bodereau bdr, Agent ag)
    //    int h =0;
    //        for (h=0;h<5;h++){
    //    boolean x = tiroi.verificode(ag, bdr);       
    //                 int essai =0;
    //            for (essai=0; essai>3; essai++) {            		
    //                if(tiroi.verificode(ag, bdr)){
    //                		bdr.list[h][4]=1;
    //                } else{              
    //                	bdr.list[h][4]=0;
    //                }
    //            }      
        
//    Posi posCourante;    
//    switch(posCourante.ori){
//            case 'N': if(trj.plan[posCourante.col+1][posCourante.lin]==1){ verifCodeComplet(bdr);}else{if(trj.plan[posCourante.col-1][posCourante.lin]==1){verifCodeComplet(bdr);}}; 
//            case 'O': if(trj.plan[posCourante.col][posCourante.lin-1]==1){ verifCodeComplet(bdr);}else{if(trj.plan[posCourante.col][posCourante.lin+1]==1){verifCodeComplet(bdr);}}; 
//            case 'S': if(trj.plan[posCourante.col+1][posCourante.lin]==1){ verifCodeComplet(bdr);}else{if(trj.plan[posCourante.col-1][posCourante.lin]==1){verifCodeComplet(bdr);}}; 
//            case 'E': if(trj.plan[posCourante.col][posCourante.lin-1]==1){ verifCodeComplet(bdr);}else{if(trj.plan[posCourante.col][posCourante.lin+1]==1){verifCodeComplet(bdr);}}; 
//            }
        
        }
        
//INSTRUCTIONS: Build a method "void rapport(Bordereau bdr)" to display a report of the delivery status of each room
public void rapport (Bodereau bdr){
int j;
for (j = 0; j < 6; j++) {
    System.out.print("Statut de livraison de la salle " + j +" :" + bdr.list[j][4] + "; "); 
    System.out.println(); System.out.println();
    }
}   

//INSTRUCTIONS: Build a method "main()" to test all the classes showing the loading, the pathway, the initial position, the moves, the messages, and the final delivery report
public static void main (String args[]) {     

Bodereau bdrTest = new Bodereau();
Trajet trjTest = new Trajet();
Agent agTest = new Agent();

this.charger(bdrTest, trjTest); //I don't understand the mistake: "non stastic method cannot be referened from a static context
Trajet.affichTrajet(trjTest.plan);
System.out.print(trjTest.deb);
this.tourner(trjTest, bdrTest, agTest);
this.pas_suivant(trjTest);
this.rapport(bdrTest);
    
}

}

        
        
    
    
    




