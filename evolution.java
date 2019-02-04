public class evolution extends Main {
    //int[][] grid;

    /* fills in a grid of determined size with random values either 0 or 1 representing live cells if 1 */
    private static int[][] creation(int arraySize){
        int[][] game = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                game[i][j] = (int) Math.round(Math.random());
            }
        }
        return game;
    }
    /* counts and returns the number of neighbours each cell in the grid has */
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

    /* main algorithm which calculates the new value of each cell depending on thei previous values */
    private static int[][] evolution(int[][] game, int[][] game2, int[][] neighs, int arraySize) {
        int numNeighbours;
        int i, j;
        game2 = game;

        for (i = 0; i < arraySize; i++) {
            for (j = 0; j < arraySize; j++) {
                numNeighbours = neighbours(game, i, j, arraySize);
                neighs[i][j] = numNeighbours;
            }
        }

        //needed a copy of the original grid as it was being edited as the algorithm went along
        //which meant the first calculation were correct but later ones were not
        for (i = 0; i < arraySize; i++) {
            for (j = 0; j < arraySize; j++) {
                if (game[i][j] == 0 && neighs[i][j] == 0) {

                }
                //Scenario changes
                if (game[i][j] == 1) {
                    if (neighs[i][j] < 2) {
                        game2[i][j] = 0;
                    } else if (neighs[i][j] > 3) {
                        game2[i][j] = 0;
                    } else if (neighs[i][j] == 2 || neighs[i][j] == 3) {
                        game2[i][j] = 1;
                    }

                    //creation of life
                } else if (game[i][j] == 0) {
                    if (neighs[i][j] == 3) {
                        game2[i][j] = 1;
                    }
                }
            }
        }
        return game2;
    }

    /* simple method which makes the evolution steps happen from one statement */
    public static int[][] step(int[][] grid, int[][] grid2, int[][] neighs, int arraySize){
        grid2 = evolution(grid, grid2, neighs, arraySize);
        grid = grid2;
        return grid;
    }

    public static void run(int arraySize, int[][] grid) {
        grid = creation(arraySize);
        step(grid, Main.grid2, Main.neighs, arraySize);
        display.createDisplay(grid);
    }
}
