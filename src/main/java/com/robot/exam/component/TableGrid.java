package com.robot.exam.component;


public class TableGrid {

    public static final int MAX_UNIT_GRID = 5;
    public static final int MIN_TABLE_GRID = 0;

    public static int plusGridY(int y) {
        return  (y + 1 > TableGrid.MAX_UNIT_GRID) ? TableGrid.MAX_UNIT_GRID :
                (y + 1);
    }


    public static int minusGridY(int y) {
        return (y - 1 < TableGrid.MIN_TABLE_GRID) ? TableGrid.MIN_TABLE_GRID :
                (y - 1);
    }


    public static int plusGridX(int x) {
        return (x + 1 > TableGrid.MAX_UNIT_GRID) ? TableGrid.MAX_UNIT_GRID :
                (x + 1);
    }


    public static int minusGridX(int x) {
        return (x - 1 < TableGrid.MIN_TABLE_GRID) ? TableGrid.MIN_TABLE_GRID :
                (x - 1);
    }
}
