package testing;

import java.util.Scanner;

public class Main {

    public static String checkQuadrant(int x, int y) {
        String result = "";
        if (x > 1000 || y > 1000 || x < -1000 || y < -1000) {
            result = "invalid";
        } else if (x == 0 && y == 0) {
            result = "1 2 3 4";
        } else if (x == 0 && y > 0) {
            result = "1 2";
        } else if (x == 0 && y < 0) {
            result = "3 4";
        } else if (x > 0 && y == 0) {
            result = "1 4";
        } else if (x < 0 && y == 0) {
            result = "2 3";
        } else if (x > 0 && y > 0) {
            result = "1";
        } else if (x < 0 && y > 0) {
            result = "2";
        } else if (x < 0 && y < 0) {
            result = "3";
        } else {
            result = "4";
        }
        return result;
    }
}
