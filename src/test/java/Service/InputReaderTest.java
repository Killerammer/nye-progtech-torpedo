package Service;

import hu.nye.progtech.torpedo.service.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class InputReaderTest {
    private static final String INPUT = "input";
    private InputReader underTest;
    @BeforeEach
    public void setUp() { underTest = new InputReader(); }

    @Test
    public void testReadCommandShouldReturnTheInputReadByScanner() {
        //When
        //String result = underTest.readCommand();

        //Then
    }
}
