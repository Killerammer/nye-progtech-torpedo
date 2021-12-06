package hu.nye.progtech.torpedo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.CharacterMap;
import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.SaveDatabase;
import hu.nye.progtech.torpedo.persistence.ScoreDatabase;
import hu.nye.progtech.torpedo.persistence.XmlSaveDatabase;
import hu.nye.progtech.torpedo.service.exception.CoordinateException;
import hu.nye.progtech.torpedo.ui.CharacterMapPrinter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);
    CharacterMapPrinter characterMapPrinter = new CharacterMapPrinter();
    Connection connection;

    /**
     * Itt adjuk meg a h2 adatbázis elérhetőségét és a hozzáféréshez szükséges adatokat.
     */

    {
        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/./progtech",
                    "admin", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private final ScoreDatabase scoreDatabase = new ScoreDatabase(connection);

    JAXBContext jaxbContext;

    {
        try {
            jaxbContext = JAXBContext.newInstance(CharacterMap.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    Marshaller marshaller;

    {
        try {
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    Unmarshaller unmarshaller;

    {
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    Enemy enemy = new Enemy();
    Player player = new Player("Player", 0);

    private final SaveDatabase saveDatabase = new XmlSaveDatabase(marshaller, unmarshaller);

    public void handleCommand(String input, MapVO map, CharacterMap characterMap) {
        String command = input.split(" ")[0].toLowerCase();

        switch (command) {

            case "help":
                System.out.println("Usable commands:\n- help\n- name *name*" +
                        "\n- save\n- load" +
                        "\n- shoot *coordinate*\n- exit\n- scoreboard");
                break;

            case "name":
                try {
                    String name = input.split(" ")[1];
                    player.setName(name);
                    System.out.println("Player name has been changed to " + name);
                    System.out.println("Greetings " + name + "!");
                } catch (Exception e) {
                    LOGGER.error("The user entered an incorrect name!");
                    System.out.println("You entered an incorrect name!");
                }
                break;

            case "shoot":
                try {
                    String coordinate = input.split(" ")[1].toUpperCase();

                    int row = Integer.parseInt(String.valueOf(coordinate.charAt(1)));
                    int column = coordinate.charAt(0);

                    column -= 65;
                    if (input.split(" ")[1].length() != 2 ||
                            column < 0 || column > 9 || row < 0 || row > 9) {
                        throw new CoordinateException("You entered an invalid coordinate!");
                    }
                    if (characterMap.getMap()[row][column] == '+' || characterMap.getMap()[row][column] == 'X') {
                        System.out.println("This coordinate has been already shot!");
                    } else {
                        if (map.getMap()[row][column]) {
                            characterMap.getMap()[row][column] = '+';
                            int hit = map.getHit();
                            map.setHit(hit + 1);
                            System.out.println("You hit a ship's part!\nHow many hits: " + map.getHit());
                        } else {
                            characterMap.getMap()[row][column] = 'X';
                        }

                        characterMapPrinter.printMap(characterMap.getMap());

                        if (map.getHit() == 15) {

                            System.out.println(player.getName() + " have won the game!");
                            player.setWinCounter(player.getWinCounter() + 1);
                            System.exit(0);

                        }
                        enemy.turn();
                    }
                } catch (CoordinateException | IndexOutOfBoundsException
                        | NumberFormatException e) {
                    LOGGER.error("An Exception has occurred!" + e);
                    System.out.println("Invalid coordinate!");
                }

                break;

            case "load":
                characterMap.setMap(saveDatabase.load().getMap());
                LOGGER.info("You succesfully loaded a gamestate!");
                break;

            case "save":
                saveDatabase.save(characterMap);
                LOGGER.info("You succesfully saved a gamestate!");
                break;

            case "rs":
                try {
                    scoreDatabase.update(player.getName(), player.getWinCounter());
                    System.out.println("O");
                } catch (SQLException throwables) {
                    System.out.println("x");
                    throwables.printStackTrace();
                }

                break;

            case "scoreboard":
                ArrayList<Player> scoreboard = new ArrayList<>(scoreDatabase.players());
                for (Player player : scoreboard) {
                    System.out.println(player.getName() + " has  " + player.getWinCounter() + " wins!");
                }
                break;

            case "exit":
            System.exit(0);
            break;

            default:
                System.out.println("You entered an unknown command!");
                LOGGER.info("The user entered an unknown command!");
                break;
        }

    }
}
