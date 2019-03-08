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

  public int getVolume(){
    int volume = 0;
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      if(field[i][j] > Elevation){field[i][j] = 0;}
      else{field[i][j] = Elevation - field[i][j];}
      volume += field[i][j]*72*72;
    }
    return volume;
  }

  public int FindMountain(int[] region){
    int peak = region[0];
    for(int i = 1; i < 9; i++){
      if(region[1] > peak){peak = region[1];}
    }
    return peak;
  }

  public void completeRegion(int row, int col, int depth){
    for(int i = row, j = col; i < row + 3 && j < col + 3; i = j+1, j++){
      if(field[i][j] > depth){field[i][j] = depth;}
    }
  }

  public void Elevate(){
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        if(field[i][j] >= Elevation){field[i][j] = 0;}
        else{field[i][j] = Elevation - field[i][j];}
      }
    }
  }

  public int[] createRegion(int row, int col){
    int[] result = new int[9];
    int counter = 0;
    for(int i = row, j = col; i < row + 3 && j < col + 3; i = j+1, j++){
      result[counter] = field[i][j];
      counter++;
    }
    return result;
  }

  public boolean Stomp(int row, int col, int[] region){

  }

  public int ProblemBronze(String inputFile){
    try{
    File text = new File(inputFile);
    Scanner puzzle = new Scanner(text);
    length = puzzle.nextInt();
    width = puzzle.nextInt();
    Elevation = puzzle.nextInt();
    int commandlength = puzzle.nextInt();
    commands = new int[commandlength][3];
    field = new int[length][width];
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      field[i][j] = puzzle.nextInt();
    }
    for(int i = 0; i < commandlength; i++){
      for(int j = 0; j < 3; j++){
        commands[i][j] = puzzle.nextInt();
      }
    }
    for(int i = 0; i < commands.length; i++){
      int[] region = createRegion(commands[i][0], commands[i][1]);
      int peak = FindMountain(region);
      int depth = peak - commands[i][2];
      completeRegion(commands[i][0],commands[i][1],depth);
    }
    puzzle.Elevate();
    return getVolume();
    puzzle.close();
  } catch(FileNotFoundException e){
  System.out.println("File not Found");
  return 0;
  }
  }

  /* End of Bronze Problem */

  /* This section is only for the Silver problem */

  public boolean canGo(int r, int c){
    if(Pasture[r][c] == '*'){return false;}
    return true;
  }

  public int CowsPerPath(int row, int col){
    if(row == PointB[0] && col == PointB[1]){return true;}
  }

  public int ProblemSilver(String inputFile){
    File text = new File(filename);
    Scanner puzzle = new Scanner(text);
    Length = puzzle.nextInt();
    Width = puzzle.nextInt();
    steps = puzzle.nextInt();
    Pasture = new char[length][width];
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      String strip = puzzle.nextLine();
      Pasture[i][j] = strip.charAt(j);
    }

    for(int i = 0; i < 2; i++){
      PointA[i] = puzzle.nextInt();
    }
    for(int i = 0; i < 2; i++){
      PointB[i] = puzzle.nextInt();
    }
    return CowsPerPath();
  }

  /* End of Silver Problem */
  // Here is the driver
  public void main(String[] args){
    System.out.println("Under Construction!");
    int num = ProblemBronze("start");
  }

}
