import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
// These fields are for the Bronze Problem
  private int row;
  private int col;
  private int Elevation;
  private int[][] field;
// These fields are for the Silver Problem

  \* This section is only for the Bronze problem *\

  public static void takeinputs(String filename){
    File text = new File(filename);
    Scanner puzzle = new Scanner(text);
    while(puzzle.hasNextLine()){
      String line = puzzle.nextLine();
      System.out.println(line);
  }

  public boolean Stomp(int row, int col, int[] field){
    
  }
}





  \* End of Bronze Problem *\

  \* This section is only for the Silver problem *\






  \* End of Silver Problem *\

}
