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
  private int Length;
  private int Width;
  private int steps;
  private int[][] moves = new int[][] {{1,0} , {-1,0}, {0,1}, {0,-1}};
  private char[][] Pasture;
  private int[] PointA;
  private int[] PointB;

  /* This section is only for the Bronze problem */

  public static void takeinputs(String filename){
    try{
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
} catch(FileNotFoundException e){
  System.out.println("File not Found");
  return 0;
}
}

  public int getVolume(){
    int volume = 0;
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      if(field[[i][j] > Elevation){field[i][j] = 0;}
      else{field[i][j] = Elevation - field[i][j];}
      volume += field[i][j]*72*72;
    }
    return volume;
  }

  public int FindMountain(){
    for(int i = 0, j = 0; i < commands.length && j < commands[0].length; i = j+1, j++){
      int peak = field[commands[i][j]]
    }
  }

  public void createRegion(int row, int col){

  }

  public boolean Stomp(int row, int col, int[] region){

  }

  public static int ProblemBronze(String inputFile){
    takeinputs(inputFile);
    Elevation = FindMountain();
    return getVolume();
  }
}

  /* End of Bronze Problem */

  /* This section is only for the Silver problem */

  public static void TakeInputs(inputFile){
    File text = new File(filename);
    Scanner puzzle = new Scanner(text);
    Length = puzzle.nextInt();
    Width = puzzle.nextInt();
    steps = puzzle.nextInt();
    Pasture = new char[length][width];
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){

    }

    for(int i = 0; i < 2; i++){
      PointA[i] = puzzle.nextInt();
    }
    for(int i = 0; i < 2; i++){
      PointB[i] = puzzle.nextInt();
    }
  }

  public boolean canGo(int r, int c){
    if(Pasture[r][c] == '*'){return false;}
    return true;
  }

  public int CowsPerPath(int row, int col){
    if(row == PointB[0] && col == PointB[1]){return true;}
  }

  public static int ProblemSilver(String inputFile){
    TakeInputs(inputFile);
    return CowsPerPath();
  }

  /* End of Silver Problem */
  // Here is the driver
  public static void main(String[] args){
    System.out.println("Under Construction!");
  }

}
