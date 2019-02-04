public class Main {
    //Array is set to 60 as that is the current grid size and large enough to show evolution
    public static int arraySize = 60;
    public static int[][] grid = new int[arraySize][arraySize];
    public static int[][] neighs = new int[arraySize][arraySize] ;


    public static void main(String[] args) {
        evolution.run(arraySize);
    }
}
