import javax.swing.text.AttributeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class map {

  /* map(Map<Character, Integer> mop) {
       this.mop = mop;
   }*/




    String[][] grid = {
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
    };


    public void createMap() {

        String [] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        System.out.println("Game Map");
        //System.out.print("  A B C D E F G H I J");
        System.out.println(" ");
        for (int i = 0; i < grid.length; i++) {
           // System.out.print(alpha[i]);
            //System.out.print(i+" ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void crete(){}


        /*System.out.print("0 ");
        char ch;
        for (int n = 0; n < 10; n++) {
            System.out.print(n + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < 1; i++) {
            for (ch = 'a'; ch <= 'j'; ch++) {
                System.out.print(ch + " ");
                for (int j = 0; j < grid[i].length; j++) {

                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }*/


    public void HitTank(int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[row][col] = "X";
            }
        }
        System.out.println("hit Tank");
    }

    public void showUpdatedMap() {

        System.out.println("Game Map");
        System.out.print("  A B C D E F G H I J");
        System.out.println(" ");
        for (int i = 0; i < grid.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("end of show updated map");

        /*
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("end of show updated map");
        */
    }

    public void missedTank(int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[row][col] = ".";
            }
        }
        System.out.println("missed Tank");
    }

    public void convertLettersToNumbers() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter shot in form <Letter><Number> e.g. B8");
        String nums = input.next();
        String[] parts = nums.split("");
        String row = parts[0];
        String col = parts[1];
       int li = Character.getNumericValue(parts[0].charAt(0));
       li = li-10;
        int lp = Integer.parseInt(col);

        if(CheckIfTankIsHit(lp,li)){
            HitTank(lp, li);
        } else { missedTank(lp, li);
            GamePlay();
        }



    }

    public void randomTank1(){
        Random rand = new Random();
        int low = 1;
        int high = 4;
        int low2 = 6;
        int high2 = 8;
        int high3 = 8;
        int low3 = 6;
        int row = rand.nextInt(high-low) + low;
        int col = rand.nextInt(high - low) +low;
        int row2 = rand.nextInt(high-low) + low;
        int col2 = rand.nextInt(high2-low2) + low2;
        int row3 = rand.nextInt(high2-low2) +low2;
        int col3 = rand.nextInt(high-low) +low;
        int row4 = rand.nextInt(high3+1-low3) +low3;
        int col4 = rand.nextInt(high3+1 -low3) +low3;


        System.out.println("row "+ row4 + " col " + col4);

        //tank
        grid[row][col]="M";
        grid[row+1][col]="M";
        grid[row][col+1]="M";
        grid[row-1][col]="M";


        //tank
        grid[row2][col2]="P";
        grid[row2+1][col2]="P";
        grid[row2][col2+1]="P";
        grid[row2-1][col2]="P";

        //tank
        grid[row3][col3]="I";
        grid[row3+1][col3]="I";
        grid[row3][col3+1]="I";
        grid[row3-1][col3]="I";

        grid[row4][col4]="O";
        grid[row4+1][col4]="O";
        grid[row4][col4+1]="O";
        grid[row4-1][col4]="O";

    }

    public boolean CheckIfTankIsHit(int row, int col){
        if(grid[row][col].equals("M")){
            System.out.println("tank found");
            return true;
        }  else {
            System.out.println("tank not found");
            return false;
        }
    }

    public void shotsFired(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter shot");
        String nums = input.next();
        }

        public void GamePlay(){
        System.out.print("Welcome to the game. Here is your map");
        showUpdatedMap();
        convertLettersToNumbers();
        }

        public char UpdateMapChar(char x, int row, int col){

        }
    }

    //getRow






