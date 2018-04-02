import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Data
@AllArgsConstructor
public final class PetStore{

    List<Dogs> dogs;
    PetStoreDAO petStoreDAO;


    public Boolean doesStoreNeedToBuyThisBreed(String breedName, int age, double price)
            throws SQLException, ClassNotFoundException {
        if (age >= 10) {
            return false;
        }
        if (price >= 500) {
            return false;
        }
        if (!petStoreDAO.checkAvailabilityOfPetInInventory(breedName).isEmpty()) {
            return false;
        }
        return true;
    }

    public Boolean doesThePetStoreHaveDogToSell(String breedname) throws SQLException, ClassNotFoundException {
        if (!petStoreDAO.checkAvailabilityOfPetInInventory(breedname).isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
