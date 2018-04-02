import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class PetStoreDAOTest {
    @Mock
    private Connection hsql;
    @Mock
    private Statement hsqlSelect;
    @Mock
    private ResultSet sqlResults;

    @Test
    public void ShouldReturnAListOfDogs() throws SQLException, ClassNotFoundException {
        PetStoreDAO petStoreDAO = new PetStoreDAO(hsql);
        Dogs dogs = new Dogs("Bugle", 10, 29.99);

        //GIVEN
        when(hsql.createStatement()).thenReturn(this.hsqlSelect);
        when(hsqlSelect.executeQuery(any())).thenReturn(this.sqlResults);
        when(sqlResults.next()).thenReturn(true, false);
        when(sqlResults.getString("BREEDNAME")).thenReturn("Bugle");
        when(sqlResults.getInt("AGE")).thenReturn(10);
        when(sqlResults.getDouble("PRICE")).thenReturn(29.99);

        //WHEN
        List<Dogs> availableDogs = petStoreDAO.checkAvailabilityOfPetInInventory("Bugle");

        List<Dogs> expectedDogs = asList(new Dogs("Bugle", 10, 29.99));
        assertThat(availableDogs, Is.is(expectedDogs));
    }
}
