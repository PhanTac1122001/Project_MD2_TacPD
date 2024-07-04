package business.feature;

import business.entity.Address;
import business.entity.User;

public interface IAddressFeature {

    void saveOrUpdate(Address address);

    void deleteById(int idDelete);

    int findIndexById(int idFind);
}
