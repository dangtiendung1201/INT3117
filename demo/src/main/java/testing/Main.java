package testing;

public class Main {

    public static String checkQuadrant(int x, int y) {
        if (x > 1000 || y > 1000 || x < -1000 || y < -1000)
            return "invalid";
        else if (x == 0 && y == 0)
            return "1 2 3 4";
        else if (x == 0 && y > 0)
            return "1 2";
        else if (x == 0 && y < 0)
            return "3 4";
        else if (x > 0 && y == 0)
            return "1 4";
        else if (x < 0 && y == 0)
            return "2 3";
        else if (x > 0 && y > 0)
            return "1";
        else if (x < 0 && y > 0)
            return "2";
        else if (x < 0 && y < 0)
            return "3";
        else
            return "4";
    }
}
