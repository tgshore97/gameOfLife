

public class Main {

    //NOT USED WHILE TESTING SET VALUES
    public static int[][] creation(int arraySize){
        int[][] game = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                game[i][j] = (int) Math.round(Math.random());
            }
        }
        return game;
    }

    //FINISHED neighbours counter correctly | could use simpler method
    private static int neighbours(int[][] game, int i, int j, int arraySize){
        int numNeighbours = 0;
        if (i > 0 && j > 0) {
            if (game[i - 1][j - 1] == 1) {
                numNeighbours += 1;
            }

        }
        if (i > 0) {
            if (game[i - 1][j] == 1) {
                numNeighbours += 1;
            }
        }
        if (i > 0 && j < arraySize-1){
            if (game[i - 1][j + 1] == 1) {
                numNeighbours += 1;
            }
        }
        if (j > 0){
            if (game[i][j - 1] == 1) {
                numNeighbours += 1;
            }
        }
        if (j > 0 && i < arraySize-1){
            if (game[i + 1][j - 1] == 1) {
                numNeighbours += 1;
            }
        }
        if (i < arraySize-1 && j < arraySize-1) {
            if (game[i + 1][j + 1] == 1) {
                numNeighbours += 1;
            }
        }
        if (i < arraySize-1) {
            if (game[i + 1][j] == 1) {
                numNeighbours += 1;
            }
        }
        if (j < arraySize-1) {
            if (game[i][j + 1] == 1) {
                numNeighbours += 1;
            }
        }

        return numNeighbours;
    }

    private static int[][] evolution(int[][] game, int[][] neighs, int arraySize) {
        int numNeighbours;
        int i;
        int j;
        for (i = 0; i < arraySize; i++) {
            for (j = 0; j < arraySize; j++) {

                numNeighbours = neighbours(game, i, j, arraySize);
                neighs[i][j] = numNeighbours;


            }
        }


        for (i = 0; i < arraySize; i++) {
            for (j = 0; j < arraySize; j++) {

                //Scenario changes
                if (game[i][j] == 1) {
                    if (neighs[i][j] < 2) {
                        game[i][j] = 0;
                    } else if (neighs[i][j] > 3) {
                        game[i][j] = 0;
                    } else if (neighs[i][j] == 2 || neighs[i][j] == 3) {
                        game[i][j] = 1;
                    }

                    //creation of life
                } else if (game[i][j] == 0) {
                    if (neighs[i][j] == 3) {
                        game[i][j] = 1;
                    }
                }
            }
        }


        return game;
    }

    public static void printGrid(int[][] game, int arraySize){
        for (int i = 0; i  < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        /* To fill the array (grid) with random 0s or 1s
         * 1 represents live cell, 0 represents not live
         */
        int arraySize = 5;
        int[][] grid = new int[arraySize][arraySize];
        int[][] neighs = new int[arraySize][arraySize];


        grid = creation(arraySize);
        //TESTS
        //nt[][] grid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        printGrid(grid, arraySize);

        System.out.println();

        //AFTER EVOLVING
        grid = evolution(grid, neighs, arraySize);
        printGrid(grid, arraySize);
        System.out.println();

        System.out.println();

        printGrid(neighs, arraySize);



    }
}
