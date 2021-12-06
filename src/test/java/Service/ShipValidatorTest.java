package Service;

import hu.nye.progtech.torpedo.service.ShipValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShipValidatorTest {
    private ShipValidator underTest;

    private boolean[][] map = {{false, true, false}, {true, false, true}, {true, false, true}};
    private final int rowNumber = 1;
    private final int columnNumber = 1;

    @BeforeEach
    public void setUp () { underTest = new ShipValidator(map, rowNumber, columnNumber); }

    @Test
    public void testUpperLeftShouldReturnTrueWhenUpperLeftFieldHasNoShip() {
        // When
        boolean result = underTest.upperLeft();
        // Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testBottomLeftShouldReturnFalseWhenUpperLeftFieldHasShip() {
        // When
            boolean result = underTest.bottomLeft();
        // Then
            Assertions.assertFalse(result);
    }

    @Test
    public void testLeftShouldReturnFalseWhenUpperLeftFieldHasShip() {
        // When
        boolean result = underTest.left();
        // Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testUpperRightShouldReturnTrueWhenUpperLeftFieldHasNoShip() {
        // When
        boolean result = underTest.upperRight();
        // Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testBottomRightShouldReturnFalseWhenUpperLeftFieldHasShip() {
        // When
        boolean result = underTest.bottomRight();
        // Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testRightShouldReturnFalseWhenUpperLeftFieldHasShip() {
        // When
        boolean result = underTest.right();
        // Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testUpShouldReturnFalseWhenUpperLeftFieldHasShip() {
        // When
        boolean result = underTest.up();
        // Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testDownShouldReturnTrueWhenUpperLeftFieldHasNoShip() {
        // When
        boolean result = underTest.down();
        // Then
        Assertions.assertTrue(result);
    }
}
