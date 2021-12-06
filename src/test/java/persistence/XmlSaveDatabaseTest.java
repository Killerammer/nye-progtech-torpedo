package persistence;

import hu.nye.progtech.torpedo.model.CharacterMap;
import hu.nye.progtech.torpedo.persistence.XmlSaveDatabase;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;

public class XmlSaveDatabaseTest {
    private XmlSaveDatabase underTest;

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    @BeforeEach
    public void init() {
        marshaller = Mockito.mock(Marshaller.class);
        unmarshaller = Mockito.mock(Unmarshaller.class);
        underTest = new XmlSaveDatabase(marshaller, unmarshaller);
    }

    @Test
    public void testSaveShouldCallMarshallerWhenThereIsNoException() throws JAXBException {

        //Given
        CharacterMap currentMap = Mockito.mock(CharacterMap.class);
        int mapLength = 10;
        Mockito.when(currentMap.getMapLength()).thenReturn(mapLength);
        char[][] map = {{'_','_'}, {'X','_'}};
        Mockito.when(currentMap.getMap()).thenReturn(map);

        //When
        underTest.save(currentMap);

        //Then
        CharacterMap characterMap = new CharacterMap(mapLength, map);
        Mockito.verify(marshaller).marshal(Mockito.eq(currentMap), Mockito.any(File.class));
        Mockito.verifyNoMoreInteractions(marshaller, unmarshaller, currentMap);
    }

    @Test
    public void testSaveShouldThrowRuntimeExceptionWhenThereIsJAXBException() throws JAXBException {
        // Given
        CharacterMap currentMap = Mockito.mock(CharacterMap.class);
        int mapLength = 10;
        Mockito.when(currentMap.getMapLength()).thenReturn(mapLength);
        char[][] map = {{'_','_'}, {'X','_'}};
        Mockito.when(currentMap.getMap()).thenReturn(map);
        CharacterMap persistableMapVO = new CharacterMap(mapLength, map);
        Mockito.doThrow(JAXBException.class).when(marshaller).marshal(Mockito.eq(currentMap), Mockito.any(File.class));

        // When
        Assertions.assertThrows(RuntimeException.class, () -> underTest.save(currentMap));

        // Then
        Mockito.verify(marshaller).marshal(Mockito.eq(currentMap), Mockito.any(File.class));
        Mockito.verifyNoMoreInteractions(marshaller, unmarshaller, currentMap);
    }
    @Test
    public void testLoadShouldReturnCharMapWhenThereIsNoException() throws JAXBException {
        // Given
        CharacterMap characterMap = Mockito.mock(CharacterMap.class);
        int mapLength = 10;
        Mockito.when(characterMap.getMapLength()).thenReturn(mapLength);
        char[][] map = {{'_','_'}, {'X','_'}};
        Mockito.when(characterMap.getMap()).thenReturn(map);
        CharacterMap expected = characterMap;
        Mockito.when(unmarshaller.unmarshal(Mockito.any(File.class))).thenReturn(characterMap);

        // When
        CharacterMap actual = underTest.load();

        // Then
        Assertions.assertEquals(expected, actual);
        Mockito.verify(unmarshaller).unmarshal(Mockito.any(File.class));
        Mockito.verifyNoMoreInteractions(marshaller, unmarshaller, characterMap);
    }

    @Test
    public void testLoadShouldThrowRuntimeExceptionWhenThereIsJAXBException() throws JAXBException {
        // Given
        CharacterMap characterMap = Mockito.mock(CharacterMap.class);
        int mapLength = 10;
        Mockito.when(characterMap.getMapLength()).thenReturn(mapLength);
        char[][] map = {{'_','_'}, {'X','_'}};
        Mockito.when(characterMap.getMap()).thenReturn(map);
        Mockito.when(unmarshaller.unmarshal(Mockito.any(File.class))).thenThrow(JAXBException.class);

        // When
        Assertions.assertThrows(RuntimeException.class, () -> underTest.load());

        // Then
        Mockito.verify(unmarshaller).unmarshal(Mockito.any(File.class));
        Mockito.verifyNoMoreInteractions(marshaller, unmarshaller, characterMap);
    }
}
