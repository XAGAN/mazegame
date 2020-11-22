import java.util.Scanner;


public class Main {
    static int yCoord;
    static int xCoord;

       public static void welcome() throws InterruptedException {
        String start = "\t\t\t\t\t\t WELCOME TO MAZE GAME v 0.1";
        String indev = "\t\tThe game is in development, only two maps available.";
        String howto = "Use the 'wasd' keys and enter button to reach the destination. Exit is marked 'E'.";
        System.out.println("\n");
        System.out.println("\n\n\n    \t\t\t");
           for ( int i = 0 ; i < start.length() ; i++){
               System.out.print(start.charAt(i));
               Thread.sleep(100);
           }
           System.out.println("\n\n");
           System.out.println("    \t   ");
           for ( int i = 0 ; i < indev.length() ; i++){
               System.out.print(indev.charAt(i));
               Thread.sleep(100);
           }
           System.out.println("\n\n\n");
           System.out.println("\t");
           for ( int i = 0 ; i < howto.length() ; i++){
               System.out.print(howto.charAt(i));
               Thread.sleep(100);
           }
           Thread.sleep(1500);


    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void printLevel(int map) {
        System.out.println("\n\n\n\n\n");
        if (map == 1){
            for (int i = 0; i != 25; ++i){
                System.out.print("\n");
                for (int j = 0; j != 100; ++j){
                    System.out.print(GameMap1.map1[i][j]);
                }
            }
            System.out.println("\n");
        }
        if (map == 2){
            for (int i = 0; i != 25; ++i){
                System.out.print("\n");
                for (int j = 0; j != 100; ++j){
                    System.out.print(GameMap1.map2[i][j]);
                }
            }
            System.out.println("\n");
        }
    }

    public static void setMe(int map) {
        final char me = '$';
        if (map == 1){
            getXandY(map);
            GameMap1.map1[xCoord][yCoord] = me;
        }
        if (map == 2){
            getXandY(map);
            GameMap1.map2[xCoord][yCoord] = me;
        }
    }


    public static char getKeyPress()  {
        Scanner scanner = new Scanner(System.in);
        char key ;

        key = scanner.next().charAt(0);

            if (key == 'w') {
                key = 'w';
            } else if (key == 'a'){
                key = 'a';
            } else if (key == 'd'){
                key = 'd';
            } else if (key == 's'){
                key = 's';
            }

        return key;
    }



    public static boolean isExit(int x, int y, int map) {

        if (map == 1){
            if (GameMap1.map1[x][y] == 'E'){
                return true;
            }
            else {
                return false;
            }
        }

        if (map == 2){
            if (GameMap1.map2[x][y] == 'E'){
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static void getPos(int map, int y) {
            if (map == 1){
            for (int i = 0; i != 25; ++i){
                for (int j = 0; j != 100; ++j){
                    if (GameMap1.map1[i][j] == '$'){
                        xCoord = i;
                        yCoord = j;

                    }
                }
            }
        }

        if (map == 2){
            for (int i = 0; i != 25; ++i){
                for (int j = 0; j != 100; ++j){
                    if (GameMap1.map2[i][j] == '$'){
                        xCoord = i;
                        yCoord = j;
                        
                    }
                }
            }
        }

    }


    public static boolean isWall(int x, int y, int map) throws InterruptedException {
        if (map == 1){
            if (GameMap1.map1[x][y] == '#'){
                System.out.println( "\n\t\t\t\t\t\tCannot move!");
                Thread.sleep(400);
                clearScreen();
                printLevel(map);
                return false;
            }
            else {
                return true;
            }
        }
        if (map == 2){
            if (GameMap1.map2[x][y] == '#'){
                System.out.println("\n\t\t\t\t\t\tCannot move!");
                Thread.sleep(400);
                clearScreen();
                printLevel(map);
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }


    public static void getXandY(int map){

        if (map == 1){
            for (int i = 0; i != 25; ++i){
                for (int j = 0; j != 100; ++j){
                    if (GameMap1.map1[i][j] == 'X'){
                        xCoord = i;
                        yCoord = j;

                    }
                }
            }
        }
        if (map == 2){
            for (int i = 0; i != 25; ++i){
                for (int j = 0; j != 100; ++j){
                    if (GameMap1.map2[i][j] == 'X'){
                        xCoord = i;
                        yCoord = j;

                    }
                }
            }
        }
    }


    public static void update(int map, int x, int y){
        final char me = '$';
        if (map == 1){
            GameMap1.map1[x][y] = me;
            printLevel(map);
        }
        if (map == 2){
            GameMap1.map2[x][y] = me;
            printLevel(map);
        }
    }


    public static void makeSpace(int map, int x, int y){
        final char space = ' ';
        if (map == 1){
            GameMap1.map1[x][y] = space;
        }
        if (map == 2){
            GameMap1.map2[x][y] = space;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        final char space = ' ';
        final char me = '$';

        Scanner scanner = new Scanner(System.in);
        clearScreen();
        welcome();
        clearScreen();

        System.out.println("\n\n\n    \t\t\t");
        System.out.println("\t\t\t\t\t\tPLEASE SELECT A MAP \n\n    \t\t\t\t\t\t1--------2\n    \t\t\t");
        int lvl;
        lvl = scanner.nextInt();

        clearScreen();
        setMe(lvl);
        printLevel(lvl);

        int x;
        int y;
        boolean CC = true ;
        while (CC) {

            char move = getKeyPress();

            switch (move) {

                case 'w':
                    getPos(lvl, yCoord);
                    if (isWall(xCoord - 1, yCoord, lvl)) {
                        if (isExit(xCoord - 1, yCoord, lvl)) {
                            clearScreen();
                            System.out.println("\t\t\t\t\t\tYou Won!\n");
                            System.out.println("\t\t\t\t\t\tI hope you enjoyed it ;)");
                            Thread.sleep(2000);
                            CC = false;
                            clearScreen();
                        }
                        clearScreen();
                        makeSpace(lvl, xCoord, yCoord);
                        update(lvl, xCoord - 1, yCoord);
                    }
                    break;
                case 's':
                    getPos(lvl, yCoord);
                    if (isWall(xCoord + 1, yCoord, lvl)) {
                        if (isExit(xCoord + 1, yCoord, lvl)) {
                            clearScreen();
                            System.out.println("\t\t\t\t\t\tYou Won!\n");
                            System.out.println("\t\t\t\t\t\tI hope you enjoyed it ;)");
                            Thread.sleep(2000);
                            //continue outer;
                            CC = false;
                            clearScreen();
                        }
                        clearScreen();
                        makeSpace(lvl, xCoord, yCoord);
                        update(lvl, xCoord + 1, yCoord);
                    }
                    break;
                case 'a':
                    getPos(lvl, yCoord);
                    if (isWall(xCoord, yCoord - 1, lvl)) {
                        if (isExit(xCoord, yCoord - 1, lvl)) {
                            clearScreen();
                            System.out.println("\t\t\t\t\t\tYou Won!\n");
                            System.out.println("\t\t\t\t\t\tI hope you enjoyed it ;)");
                            Thread.sleep(2000);
                            //continue outer;
                            CC = false;
                            clearScreen();
                        }
                        clearScreen();
                        makeSpace(lvl, xCoord, yCoord);
                        update(lvl, xCoord, yCoord - 1);
                    }
                    break;
                case 'd':
                    getPos(lvl, yCoord);
                    if (isWall(xCoord, yCoord + 1, lvl)) {
                        if (isExit(xCoord, yCoord + 1, lvl)) {
                            clearScreen();
                            System.out.println("\t\t\t\t\t\tYou Won!\n");
                            System.out.println("\t\t\t\t\t\tI hope you enjoyed it ;)");
                            Thread.sleep(2000);
                            CC = false;
                            clearScreen();
                            //continue outer;
                        }
                        clearScreen();
                        makeSpace(lvl, xCoord, yCoord);
                        update(lvl, xCoord, yCoord + 1);
                    }
                    break;
                default:
                    break;
            }

        }



        clearScreen();

    }
}
