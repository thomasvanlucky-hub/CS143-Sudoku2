import java.util.*;
import java.io.*;

public class SudokuBoard {
   private int[][] board;
   
   public SudokuBoard() {
      board = new int[9][9];
   } 
   
   public SudokuBoard(String fileName) {
      this();
      try {
         Scanner console = new Scanner(new File(fileName));
         for(int r = 0; r < board.length; r++){
            if(console.hasNext()) {
               String line = console.next();
               for(int c = 0; c < board[0].length; c++) {
                  char value = line.charAt(c);
                  if(value == '.') {
                     board[r][c] = 0;
                  } else {
                     board[r][c] = value - '0';
                  }
               }
            }
         }
      } catch (FileNotFoundException e) {
         System.out.println("Error: File not found.");
      }
   }   
   
   public boolean isValid() {
      for(int r = 0; r < board.length; r++) {
         for(int c = 0; c < board[0].length; c++) {
            if(board[r][c] > board.length) {               // 1st part
               return false;
            }
         }
      }
      
      for(int c = 0; c < board.length; c++) {
         
      }
      
      return true;
   }
   
   private boolean checkNumbers() {
      for(int r = 0; r < board.length; r++) {
         for(int c = 0; c < board[0].length; c++) {
            if(board[r][c] < 0 || board[r][c] > 9) {
            return false;
            }
         }
      }
      
      return true;
   }
   
   private boolean checkRow() {
      Set<Integer> set = new HashSet<>();
   
      for(int r = 0; r < board.length; r++) {
         set.add(r);
         if(set.contains(r)) {
            return false;
         } 
      }
      
      
      return true;
   }
   
   public String toString() {
      String result = "";
      String line = "+-------+-------+-------+\n";
   
      for (int r = 0; r < board.length; r++) {
         if (r % 3 == 0) {
            result = result + line;
         }
         for (int c = 0; c < board[0].length; c++) {
            if (c % 3 == 0) {
               result = result + "| ";
            }
            if (board[r][c] == 0) {
               result = result + "- "; 
            } else {
               result = result + board[r][c] + " ";
            }
         }
         result = result + "|\n";
      }
      result = result + line;
      return result;
   }
}
