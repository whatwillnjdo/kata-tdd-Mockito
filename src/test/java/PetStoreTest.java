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
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class PetStoreTest {
    @Mock
    private Connection hsql;
    @Mock
    private Statement hsqlSelect;
    @Mock
    private ResultSet sqlResults;

    @Test
    public void ShouldBuyTheBreedIfPetStoreDoesntHaveIt() throws SQLException, ClassNotFoundException {
        List<Dogs> somedogs = asList(new Dogs("Bugle", 5, 10.00));
        PetStoreDAO petStoreDAO = new PetStoreDAO(hsql);
        PetStore petStore = new PetStore(somedogs, petStoreDAO);

        when(hsql.createStatement()).thenReturn(this.hsqlSelect);
        when(hsqlSelect.executeQuery(any())).thenReturn(this.sqlResults);
        when(sqlResults.next()).thenReturn(false);

        Boolean expectedvalue = petStore.doesStoreNeedToBuyThisBreed("Bugle", 5, 19.99);
        assertThat(expectedvalue, Is.is(true));
    }

    @Test
    public void ShouldReturnFalseIfTheAgeOfTheBreedIsGreaterThanOrEqualToTen()
            throws SQLException, ClassNotFoundException {
        List<Dogs> somedogs = asList(new Dogs("Bugle", 5, 10.00));
        PetStoreDAO petStoreDAO = new PetStoreDAO(hsql);
        PetStore petStore = new PetStore(somedogs, petStoreDAO);
        
        Boolean expectedValue = petStore.doesStoreNeedToBuyThisBreed("Bugle", 11, 20.99);
        assertThat(expectedValue, Is.is(false));
    }

    @Test
    public void ShouldReturnFalseIfPriceIsGreaterThanOrEqualToFiveHundred()
            throws SQLException, ClassNotFoundException {
        List<Dogs> somedogs = asList(new Dogs("Bugle", 5, 10.00));
        PetStoreDAO petStoreDAO = new PetStoreDAO(hsql);
        PetStore petStore = new PetStore(somedogs, petStoreDAO);

        Boolean exppectedValue = petStore.doesStoreNeedToBuyThisBreed("Bugle", 8, 500.00);
        assertThat(exppectedValue, Is.is(false));
    }

    @Test
    public void ShouldNotBuyTheBreedIfThePetStoreAlreadyHasIt() throws SQLException, ClassNotFoundException {
        List<Dogs> somedogs = asList(new Dogs("Bugle", 5, 10.00));
        PetStoreDAO petStoreDAO = new PetStoreDAO(hsql);
        PetStore petStore = new PetStore(somedogs, petStoreDAO);

        when(hsql.createStatement()).thenReturn(this.hsqlSelect);
        when(hsqlSelect.executeQuery(any())).thenReturn(this.sqlResults);
        when(sqlResults.next()).thenReturn(true, false);

        Boolean expectedValue = petStore.doesStoreNeedToBuyThisBreed("Bugle", 8, 100.00);
        assertThat(expectedValue, Is.is(false));
    }

    @Test
    public void SHouldBeAbleToSellPetIfTheBreedExists() throws SQLException, ClassNotFoundException {
        List<Dogs> soomedogs = asList(new Dogs("Bugle", 6, 25.99));
        PetStoreDAO petStoreDAO = new PetStoreDAO(hsql);
        PetStore petStore = new PetStore(soomedogs, petStoreDAO);

        when(hsql.createStatement()).thenReturn(hsqlSelect);
        when(hsqlSelect.executeQuery(any())).thenReturn(sqlResults);
        when(sqlResults.next()).thenReturn(true, false);

        Boolean expectedValue = petStore.doesThePetStoreHaveDogToSell("Bugle");
        assertThat(expectedValue, Is.is(true));

    }
}
