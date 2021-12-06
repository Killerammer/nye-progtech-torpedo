package hu.nye.progtech.torpedo.persistence;

import java.io.File;

import hu.nye.progtech.torpedo.model.CharacterMap;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlSaveDatabase implements SaveDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlSaveDatabase.class);
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XmlSaveDatabase(Marshaller marshaller, Unmarshaller unmarshaller) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }

    @Override
    public CharacterMap load() {
        try {
            CharacterMap characterMap = (CharacterMap) unmarshaller.unmarshal(new File("gamesave.xml"));
            return characterMap;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the gamesave.");
        }
    }

    @Override
    public void save(CharacterMap currentMap) {
        try {
            marshaller.marshal(currentMap, new File("gamesave.xml"));
        } catch (JAXBException e) {
            LOGGER.error("Error while saving current gamestate to XML file!", e);
            throw new RuntimeException("Failed to save the gamestate!", e);
        }
    }
}
