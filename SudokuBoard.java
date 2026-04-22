import java.util.*;
import java.io.*;

public class SudokuBoard {
   private String[][] board;
   
   public SudokuBoard(String fileName) {
      board = new String[9][9];
      try {
         Scanner file = new Scanner(new File(fileName));
         
         for(int r = 0; r < board.length; r++) {
            String line = file.nextLine();
            for(int c = 0; c < board[0].length; c++) {
               board[r][c] = "" + line.charAt(c);
            }
         }
      } catch (FileNotFoundException e) {
         System.out.println("File not found.");
      }
   }
   
   public boolean checkData(){
      for(int r = 0; r < board.length; r++) {
         for(int c = 0; c < board[0].length; c++) {
            if(!board[r][c].equals("1")||
               !board[r][c].equals("2")||
               !board[r][c].equals("3")||
               !board[r][c].equals("4")||
               !board[r][c].equals("5")||
               !board[r][c].equals("6")||
               !board[r][c].equals("7")||
               !board[r][c].equals("8")||
               !board[r][c].equals("9")||
               !board[r][c].equals(".")||) {
                  return false;
               }
         }
      }
      return true;
   }
   
   
   public boolean checkRows(){
     Set <String> set = new HashSet<String> ();
     for(int r = 0; r < board.length; r++) {
      for(int c = 0; c < board[0].length; c++) {
         if(set.contains(board[r][c]) &&  !board[r][c].equals("."))
            return false;
         else
            set.add(board[r][c]);
      }
     }
     
   }
   public boolean checkColumns(){
     Set <String> set = new HashSet<String> ();
     for(int r = 0; r < board.length; r++) {
      for(int c = 0; c < board[0].length; c++) {
         if(set.contains(board[c][r]) && !board[c][r].equals("."))
            return false;
         else
            set.add(board[c][r]);
      }
     }
     
   }
   private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
   
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }   
   public boolean checkMiniSquare(miniSquare(int spot)){
      for(int r = 0; r < mini.length; r++) {
         for(int c = 0; c < mini[0].length; c++) {
            if(!mini[r][c].equals("1")||
               !mini[r][c].equals("2")||
               !mini[r][c].equals("3")||
               !mini[r][c].equals("4")||
               !mini[r][c].equals("5")||
               !mini[r][c].equals("6")||
               !mini[r][c].equals("7")||
               !mini[r][c].equals("8")||
               !mini[r][c].equals("9")||
               !mini[r][c].equals(".")||) {
                  return false;
               }
         }
      }
      return true;
   }
   
   
   
   
   public String toString() {
      String output = "";
      for (int r = 0; r < 9; r++) {
        if (r % 3 == 0) {
            output += "  ---------------------\n";
        }
        for (int c = 0; c < 9; c++) {
            if (c % 3 == 0) {
                output += "| ";
            }
            String value = board[r][c];
            if (value.equals(".")) {
                output += "  ";
            } else {
                output += value + " ";
            }
        }
        output += "|\n";
    }
    output += "  ---------------------\n";
    return output;
   }
}