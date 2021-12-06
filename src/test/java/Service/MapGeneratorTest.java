package Service;

import hu.nye.progtech.torpedo.service.MapGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MapGeneratorTest {
    private MapGenerator underTest;

    private static final Boolean[][] map = {{false, false, false}, {false, false, false}, {false, false, false}};
    Random r = new Random();
    @BeforeEach
    public void setUp() { underTest = new MapGenerator(); }

    @Test
    public void testGenerateMapShouldReturnMapVO() {

    }
}
