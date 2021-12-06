package persistence;

import java.sql.*;
import java.util.List;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.ScoreDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ScoreDatabaseTest {
    private ScoreDatabase underTest;

    private Connection connection;

    @BeforeEach
    public void init() {
        connection = Mockito.mock(Connection.class);

        underTest = new ScoreDatabase(connection);
        }
        @Test
        public void testPlayersShouldReturnPlayerListWhenThereIsNoException () throws SQLException {

            //given
            Statement statement = Mockito.mock(Statement.class);
            Mockito.when(connection.createStatement()).thenReturn(statement);
            ResultSet resultSet = Mockito.mock(ResultSet.class);
            Mockito.when(statement.executeQuery(ScoreDatabase.SELECT_STATEMENT)).thenReturn(resultSet);

            //when
            List<Player> actual = underTest.players();

            //Then
            Mockito.verify(connection).createStatement();
            Mockito.verify(statement).executeQuery(ScoreDatabase.SELECT_STATEMENT);
            Mockito.verify(resultSet).next();
            Mockito.verify(resultSet).close();
            Mockito.verify(statement).close();
    }

    @Test
    public void testPlayersShouldThrowRuntimeExceptionWhenSqlExceptionIsThrown() throws SQLException {
        // Given
        Mockito.when(connection.createStatement()).thenThrow(new SQLException());

        // When
        Assertions.assertThrows(RuntimeException.class, () -> underTest.players());

        // Then
        Mockito.verify(connection).createStatement();
        Mockito.verifyNoMoreInteractions(connection);
    }

    @Test
    public void testUpdateShouldUpdateScoreBoardDatabase() throws SQLException {
        // Given
        Statement statement = Mockito.mock(Statement.class);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.when(connection.prepareStatement(ScoreDatabase.INSERT_STATEMENT))
                .thenReturn(preparedStatement);
        String name = "name";
        Integer wins = 1;

        // When
        underTest.update(name, wins);

        // Then
        Mockito.verify(connection).prepareStatement(ScoreDatabase.INSERT_STATEMENT);
        Mockito.verify(preparedStatement).setString(1, name);
        Mockito.verify(preparedStatement).setString(2, wins.toString());
        Mockito.verify(preparedStatement).executeUpdate();
        Mockito.verify(preparedStatement).close();
        Mockito.verifyNoMoreInteractions(connection, preparedStatement);
    }
    @Test
    public void testCloseShouldCloseConnection() throws Exception {
        // When
        underTest.close();

        // Then
        Mockito.verify(connection).close();
        Mockito.verifyNoMoreInteractions(connection);
    }
}