package com.example.periodictable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Element implements Serializable {
    public String name, symbol, mass;
    public int number, row, col;
    public boolean isPlaceholder;

    public Element(int number, String symbol, String name, String mass, int row, int col) {
        this.number = number;
        this.symbol = symbol;
        this.name = name;
        this.mass = mass;
        this.row = row + 1;
        this.col = col + 1;
        this.isPlaceholder = false;
    }

    public Element(boolean isPlaceholder, String symbol, String name, int row, int col) {
        this.name = name;
        this.symbol = symbol;
        this.mass = "";
        this.number = 0;
        this.row = row + 1;
        this.col = col + 1;
        this.isPlaceholder = isPlaceholder;
    }

    public Element(String label, int row, int col) {
        this.name = label;
        this.symbol = "";
        this.mass = "";
        this.number = -3;
        this.row = row;
        this.col = col;
        this.isPlaceholder = false;
    }

    public String getState() {
        if (isPlaceholder) return "Placeholder";
        List<Integer> gases = Arrays.asList(1, 2, 7, 8, 9, 10, 17, 18, 36, 54, 86, 118);
        List<Integer> liquids = Arrays.asList(35, 80);

        if (gases.contains(number)) return "Gas";
        if (liquids.contains(number)) return "Liquid";
        return "Solid";
    }

    public String getBlock() {
        if (number == -3) return "Label";
        if (isPlaceholder) return "Placeholder";

        // f-block: Lanthanides and Actinides
        if ((number >= 57 && number <= 71) || (number >= 89 && number <= 103)) return "f-block";

        // s-block: Helium exception
        if (number == 2) return "s-block";

        // s-block: Groups 1 and 2
        if (col == 1 || col == 2) return "s-block";

        // p-block: Groups 13-18 (Cols 13-18)
        if (col >= 13 && col <= 18) return "p-block";

        // d-block: Groups 3-12 (Cols 3-12)
        if (col >= 3 && col <= 12) return "d-block";

        return "Unknown";
    }
}
