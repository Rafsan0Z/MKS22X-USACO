import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
// These fields are for the Bronze Problem
  private int length;
  private int width;
  private int Elevation;
  private int[][] field;
  private int[][] commands;
// These fields are for the Silver Problem

  \* This section is only for the Bronze problem *\

  public static void takeinputs(String filename){
    File text = new File(filename);
    Scanner puzzle = new Scanner(text);
    length = puzzle.nextInt();
    width = puzzle.nextInt();
    Elevation = puzzle.nextInt();
    field = new int[length][width];
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      field[i][j] = puzzle.nextInt();
    }
    while(puzzle.hasNextLine()){
      String line = puzzle.nextLine();
      System.out.println(line);
  }

  public int FindMountain(){

  }

  public void createRegion(int row, int col){

  }

  public boolean Stomp(int row, int col, int[] region){

  }

  public static int ProblemBronze(String inputFile){
    takeinputs(inputFile);
  }
}





  \* End of Bronze Problem *\

  \* This section is only for the Silver problem *\






  \* End of Silver Problem *\

}
