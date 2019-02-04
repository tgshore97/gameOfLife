public class Main {
    public static int arraySize = 60;
    public static int[][] grid = new int[arraySize][arraySize];
    public static int[][] grid2 = new int[arraySize][arraySize] ;
    public static int[][] neighs = new int[arraySize][arraySize] ;

    public static void main(String[] args) {
        evolution.run(arraySize, grid);
    }
}
