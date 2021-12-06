package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.CharacterMap;
import hu.nye.progtech.torpedo.model.MapVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameState {
    MapGenerator mapGenerator = new MapGenerator();

    CharacterMapGenerator characterMapGenerator = new CharacterMapGenerator();

    InputReader inputReader = new InputReader();

    CommandHandler commandHandler = new CommandHandler();


    MapVO enemyMap = mapGenerator.generateMap(10);

    CharacterMap enemyCharacterMap = characterMapGenerator.generateMap(10);
    private static final Logger LOGGER = LoggerFactory.getLogger(GameState.class);

    /**
     * Itt indítom el az igazi játékot.
     */

    public void playGame() {
        System.out.println("You successfully started the game!");
        System.out.println("If you want help with the commands, type *help* into the command line!");
        String inputContainer;
        do {
            System.out.print("Enter a valid command: ");
            inputContainer = inputReader.readCommand();
            commandHandler.handleCommand(inputContainer, enemyMap, enemyCharacterMap);

        } while (!inputContainer.equals("exit"));
    }
}
