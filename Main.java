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

    public static int[][] evolution(int[][] game, int arraySize) {
        int numNeighbours = 0;
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - 1; j++) {
                if (game[i - 1][j - 1] == 1) {
                    numNeighbours += 1;
                }
                if (game[i][j - 1] == 1) {
                    numNeighbours += 1;
                }
                if (game[i + 1][j - 1] == 1) {
                    numNeighbours += 1;
                }
                if (game[i - 1][j] == 1) {
                    numNeighbours += 1;
                }
                if (game[i + 1][j] == 1) {
                    numNeighbours += 1;
                }
                if (game[i - 1][j + 1] == 1) {
                    numNeighbours += 1;
                }
                if (game[i][j + 1] == 1) {
                    numNeighbours += 1;
                }
                if (game[i + 1][j + 1] == 1) {
                    numNeighbours += 1;
                }

                //Scenario changes
                if (game[i][j] == 1) {
                    if (numNeighbours < 2) {
                        game[i][j] = 0;
                    } else if (numNeighbours > 3) {
                        game[i][j] = 0;
                    } else if (numNeighbours == 2 || numNeighbours == 3) {
                        game[i][j] = 1;
                    }
                    //creation of life
                } else if (game[i][j] == 0) {
                    if (numNeighbours == 3) {
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
        int arraySize = 3;
       // int[][] grid = new int[arraySize][arraySize];


        //grid = creation(arraySize);
        //TESTS
        int[][] grid = {{0,0,0}, {1, 1, 1}, {0, 0, 0}};
        printGrid(grid, arraySize);

        System.out.println();

        grid = evolution(grid, arraySize);
        printGrid(grid, arraySize);

    }
}
