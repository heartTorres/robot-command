package com.robot.exam.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TableGridTest {

    private TableGrid tableGrid;


    @Test
    void testPlusGridX_withCorrect_paramIntWithinLimit_shouldBeSuccess() {

       int newX = TableGrid.plusGridX(1);
       assertEquals(2, newX);
    }


    @Test
    void testPlusGridX_withCorrect_paramIntBeyondLimit_valueShouldEqualToMax() {

        int newX = TableGrid.plusGridX(5);
        assertEquals(5, newX);

    }

    @Test
    void testMinusGridX_withCorrect_paramIntWithinLimit_shouldBeEqualToMin() {

        int newX = TableGrid.minusGridX(1);
        assertEquals(TableGrid.MIN_TABLE_GRID, newX);
    }


    @Test
    void testMinusGridX_withCorrect_paramIntBeyondLimit_valueShouldBeSuccess() {

        int newX = TableGrid.minusGridX(5);
        assertEquals(4, newX);

    }


    @Test
    void testPlusGridY_withCorrect_paramIntWithinLimit_shouldBeSuccess() {

        int newY = TableGrid.plusGridY(1);
        assertEquals(2, newY);
    }


    @Test
    void testPlusGridY_withCorrect_paramIntBeyondLimit_valueShouldEqualToMax() {

        int newY = TableGrid.plusGridY(5);
        assertEquals(TableGrid.MAX_UNIT_GRID, newY);

    }
}
