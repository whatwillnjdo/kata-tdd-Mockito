import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetStoreDAO {


    public String breedName;
    public int age;
    public double price;

    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public PetStoreDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Dogs> checkAvailabilityOfPetInInventory(String breedName) throws SQLException, ClassNotFoundException {
        List<Dogs> dogs = new ArrayList<>();
        statement = connection.createStatement();
        result = statement.executeQuery("SELECT BREEDNAME, AGE, PRICE FROM PETSTOREINVENTORY WHERE "
                + "BREEDNAME =" +breedName);
        while (result.next()) {
            dogs.add(new Dogs(result.getString("BREEDNAME"), result.getInt("AGE"), result.getDouble("PRICE")));
        }
        return dogs;
    }
}
