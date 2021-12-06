package Service;

import hu.nye.progtech.torpedo.model.CharacterMap;
import hu.nye.progtech.torpedo.service.*;
import hu.nye.progtech.torpedo.ui.MapPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GameStateTest {
    private GameState underTest;

    @Mock
    private InputReader inputReader;
    @Mock
    private CommandHandler commandHandler;
    @Mock
    private MapGenerator mapGenerator;
    @Mock
    private CharacterMapGenerator characterMapGenerator;
    @Mock
    private MapPrinter mapPrinter;
    @Mock
    private CharacterMap characterMap;
    private int mapLength;
    @Mock
    private String input;

    @BeforeEach
    public void init() {
        underTest = new GameState();
        inputReader = Mockito.mock(InputReader.class);
        commandHandler = Mockito.mock(CommandHandler.class);
        mapGenerator = Mockito.mock(MapGenerator.class);
        characterMapGenerator = Mockito.mock(CharacterMapGenerator.class);
        mapPrinter = Mockito.mock(MapPrinter.class);

        characterMap = Mockito.mock(CharacterMap.class);
        mapLength = 10;
    }
    @Test
    public void testPlayGameShouldLoopTheGameUntilTheUserDoesNotExit() {
        // given
        input = "exit";
        // when
        //underTest.playGame();

        // then
        Mockito.verify(mapGenerator.generateMap(10));

        Mockito.verifyNoMoreInteractions(underTest);
    }
}
