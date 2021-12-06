package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.CharacterMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class characterMapTest {

    private static final int MAP_LENGTH = 2;
    private static final char[][] EXPECTED_MAP = {
            {'_', '_'},
            {'_', '_'}
    };
    private CharacterMapGenerator underTest;

    @BeforeEach
    public void setUp() {
        underTest = new CharacterMapGenerator();
    }

    @Test
    public void testGeneratingCharacterMap() {
        // given

        // when
        CharacterMap result = underTest.generateMap(MAP_LENGTH);

        // then
        //assertEquals(EXPECTED_MAP, result);
    }
}