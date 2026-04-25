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
   
   private boolean checkData() {
      Set<String> valid = new HashSet<>(Arrays.asList(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "."));
      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[0].length; c++) {
            if (!valid.contains(board[r][c])) {
               return false;              }
         }
      }
      return true;
   }
   
   
   public boolean checkRows(){
     for(int r = 0; r < board.length; r++) {
         Set <String> set = new HashSet<String> ();
            for(int c = 0; c < board[0].length; c++) {
               if(set.contains(board[r][c]) &&  !board[r][c].equals("."))
               return false;
            else
               set.add(board[r][c]);
         }
     }
     return true;
   }
   
   public boolean checkColumns(){
      for(int r = 0; r < board.length; r++) {
      Set <String> set = new HashSet<String> ();
         for(int c = 0; c < board[0].length; c++) {
            if(set.contains(board[c][r]) && !board[c][r].equals("."))
               return false;
         else
            set.add(board[c][r]);
         }
     }
     return true;
   }
   private String[][] miniSquare(int spot) {
      String[][] mini = new String[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
   
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }   
   
   public boolean checkMiniSquare() {
      for (int k = 1; k <= 9; k++) {
         String[][] minisq = miniSquare(k);
         Set<String> set = new HashSet<String>();
         for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
               if (set.contains(minisq[r][c]) && !minisq[r][c].equals("."))
                  return false;
               else
                  set.add(minisq[r][c]);
            }
         }
      }
      return true;  
   }
   
   public boolean isValid() {
      return checkData() && checkRows() && checkColumns() && checkMiniSquare();
   }
   
   f
   
   
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