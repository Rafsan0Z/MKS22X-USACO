import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{

  public static String printArray(int[] ary) {
 String result = "[";
 for (int i = 0; i < ary.length ; i++) {
  result += " " + ary[i];
  if (i != ary.length - 1) {
    result += ",";
  }
}
  return result + "]";
}

public static String printArray(int[][] ary) {
  String result = "[";
  for (int i = 0; i < ary.length ; i++) {
    for(int j = 0; j < ary[i].length ; j++) {
      if ( j == 0 ) {
        result += "{";
      }
      if ( j == ary[i].length - 1) {
        result += ary[i][j];
        result += "}, \n";
      }
      else{
        result += ary[i][j] + ",";
      }
    }
  }
  return result + "]";
}

private static boolean inBounds(int r, int c, int length, int width){
  if(r < length && r >= 0 && c < width && c >= 0){
    return true;
  }
  return false;
}

  public static int ProblemBronze(String inputFile){
    int length = 0;
    int width = 0;
    int Elevation = 0;
    try{
    File text = new File(inputFile);
    Scanner puzzle = new Scanner(text);
    length = puzzle.nextInt();
    width = puzzle.nextInt();
    Elevation = puzzle.nextInt();
    int commandlength = puzzle.nextInt();
    int[][] commands = new int[commandlength][3];
    int[][] field = new int[length][width];
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
      field[i][j] = puzzle.nextInt();
    }
    }
    for(int i = 0; i < commandlength; i++){
      for(int j = 0; j < 3; j++){
        commands[i][j] = puzzle.nextInt();
      }
    }
  for(int i = 0; i < commands.length; i++){
    int row = commands[i][0]-1;
    int col = commands[i][1]-1;
    int[] region = new int[9];
    int counter = 0;
    for(int j = row; j < row + 3; j++){
      for(int k = col; k < col + 3; k++){
      if(inBounds(j,k,length,width)){
      region[counter] = field[j][k];
    }
      counter++;
    }
    }
    int peak = region[0];
    for(int l = 1; l < 9; l++){
      if(region[l] > peak){peak = region[l];}
    }
    int depth = peak - commands[i][2];
    for(int m = row; m < row + 3; m++){
      for(int n = col; n < col + 3; n++){
        if(inBounds(m,n,length,width)){
      if(field[m][n] > depth){field[m][n] = depth;}
    }
    }
  }
  }
  int volume = 0;
  int multiplier = width*width*12*12;
  for(int i = 0; i < length; i++){
    for(int j = 0; j < width; j++){
    if(field[i][j] >= Elevation){field[i][j] = 0;}
    else{field[i][j] = Elevation - field[i][j];}
    volume += field[i][j];
  }
  }
  return volume*72*72;
}catch(FileNotFoundException e){
System.out.println("File not Found");
return 0;
}
  }

  public static int ProblemSilver(String inputFile){
    try{
    File text = new File(inputFile);
    Scanner puzzle = new Scanner(text);
    int Length = puzzle.nextInt();
    int Width = puzzle.nextInt();
    int steps = puzzle.nextInt();
    char[][] Pasture = new char[Length][Width]; // field of chars
    int[][] copy = new int[Length][Width]; // copy of the pasture array
    int[][] print = new int[Length][Width]; // array used to print the result
    String strip = puzzle.nextLine();
    for(int i = 0; i < Length; i++){
      strip = puzzle.nextLine();
      for(int j = 0; j < Width; j++){
      Pasture[i][j] = strip.charAt(j);
    }
  }
    int startx = puzzle.nextInt() - 1;
    int starty = puzzle.nextInt() - 1;
    int endx = puzzle.nextInt() - 1;
    int endy = puzzle.nextInt() - 1;
    for (int i = 0; i < Length; i++) {
      for (int j = 0; j < Width; j++) {
        if (Pasture[i][j] == '*') {
          print[i][j] = -1;
          copy[i][j] = print[i][j];
      }
    }
    }
    print[startx][starty] = 1;
    while (steps > 0) {
      for (int i = 0; i < Length; i++) {
        for (int j = 0; j < Width; j++) {
           copy[i][j] = print[i][j];
      }
  }
      for(int i = 0; i < Length; i++){
        for(int j = 0; j < Width; j++){
          if(Pasture[i][j] != '*'){
            if(i>=1 && copy[i-1][j] >= 0){
              print[i][j] += copy[i-1][j];
            }
            if(j>=1 && copy[i][j-1] >= 0){
              print[i][j] += copy[i][j-1];
            }
        }
        }
      }
  steps--;
}
  return print[endx][endy];
  }catch(FileNotFoundException e){}
    return -1;
  }

  public static void main(String[] arg){
    try{
    for(int i = 1; i <= 5; i++){
      String input = "makelake."+i+".in";
      String output = "makelake."+i+".out";
      File test = new File(output);
      Scanner answer = new Scanner(test);
      int compare = answer.nextInt();
      int num = ProblemBronze(input);
      if(num == compare){System.out.println("Input: " + input+". Result: PASS!");}
      else{System.out.println("Input: " + input+". Result: FAIL! Actual: " + compare/(72*72)+ ". Result: "+num);}
    }
  }catch(FileNotFoundException e){
    System.out.println("No file!");
  }
  try{
  for(int i = 1; i <= 5; i++){
    String input = "ctravel."+i+".in";
    String output = "ctravel."+i+".out";
    File test = new File(output);
    Scanner answer = new Scanner(test);
    int compare = answer.nextInt();
    int num = ProblemSilver(input);
    if(num == compare){System.out.println("Input: " + input+". Result: PASS!");}
    else{System.out.println("Input: " + input+". Result: FAIL! Actual: " + compare+ ". Result: "+num);}
  }
}catch(FileNotFoundException e){
  System.out.println("No file!");
}
  }

}
