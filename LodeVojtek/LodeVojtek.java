package lodevojtek;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LodeVojtek {

public static void main(String[] args) {
 int doskaVel = 4;
 int lodeC = 3;
 char voda = '-';
 char lod = 'V';
 char trafil = 'X';
 char vedla = '0';
    
    char [][] doska = createDoska(doskaVel, voda, lod, lodeC);
   printdoska(doska, voda, lod);
int nedetekovanaLodCislo = lodeC;
while(nedetekovanaLodCislo > 0){
    int[] hadamMiesto = UserMiesto(doskaVel);
    char miestoUpdate = Vyhodnotenie(hadamMiesto, doska, lod, voda, trafil, vedla );
    if (miestoUpdate == trafil){
    nedetekovanaLodCislo--;
    
    
    }
    doska = updatedoska(doska, hadamMiesto, miestoUpdate);
    printdoska(doska, voda, lod);
}



}


    private static char[][] createDoska(int doskaVel, char voda, char lod, int lodeC) {
    char[][] doska = new char [doskaVel][doskaVel];
    for(char[] row : doska){
    Arrays.fill(row, voda);
    }
    return polozenieLodi(doska, lodeC, voda, lod);
    
    }

    private static char[][] polozenieLodi(char[][] doska, int lodeC, char voda, char lod) {
        int polozeneLode = 0;
        int doskaVel = doska.length;
        while (polozeneLode < lodeC){
            int[] lokacia = generovanieMiestaLodi(doskaVel);
            char PossPlace = doska[lokacia[0]][lokacia[1]];
            if(PossPlace == voda) {
                doska[lokacia[0]][lokacia[1]] = lod;
                polozeneLode++;
            }    
        } 
    return doska;
    }

    private static int[] generovanieMiestaLodi(int doskaVel) {
    int[] miesta = new int[2];
    for(int i =0; i < miesta.length; i++){
    miesta[i] = new Random().nextInt(doskaVel);
    }
     return miesta;   
        
    }

    private static void printdoska(char[][] doska, char voda, char lod) {
        int doskaVel = doska.length;
        System.out.print("  ");
        for (int i = 0; i< doskaVel; i++){
        System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int row = 0; row < doskaVel; row++){
            System.out.print(row + 1 + " ");
            for(int col = 0; col < doskaVel; col++){
                char miesto = doska[row][col];
            if (miesto == lod){
            System.out.print(voda + " ");

            }else {
            System.out.print(miesto + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[] UserMiesto(int doskaVel) {
    int row;
    int col;
    do {
     System.out.print("Riadok: ");
     row = new Scanner(System.in).nextInt();
     }
     while (row < 0 || row > doskaVel + 1);
     do{
     System.out.print("Stlpec: ");
     col = new Scanner(System.in).nextInt();
         
     }
     while (col < 0 || col > doskaVel + 1);
     return new int[]{row - 1, col - 1};
    }

    private static char Vyhodnotenie(int[] hadamMiesto, char[][] doska, char lod, char voda, char trafil, char vedla) {
        String sprava;
        int row = hadamMiesto[0];
        int col = hadamMiesto[1];
        char ciel = doska[row][col];
        if(ciel == lod){
        sprava = "Trafil si!";
        ciel = trafil;
        }
        else if (ciel == voda){
        sprava = "Netrafil";
        ciel = vedla;
        }else{
            sprava = "Uz si tu strielil"; 
        }
        System.out.println(sprava);
        return ciel;
        
        
    }

    private static char[][] updatedoska(char[][] doska, int[] hadamMiesto, char miestoUpdate) {
    int row = hadamMiesto[0];
    int col =hadamMiesto[1];
    doska[row][col] = miestoUpdate;
    return doska;
    }


    
    
    
    
    
    
    
    
    
    
}
