package business.feature;

import business.entity.Role;
import business.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface IRoleFeatrue {
    void saveOrUpdate(Role roles);



    int findIndexById(int idFind);
}
