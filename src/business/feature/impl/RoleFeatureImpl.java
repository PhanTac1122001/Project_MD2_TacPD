package business.feature.impl;

import business.entity.Role;
import business.feature.IRoleFeatrue;
import business.utils.IOFileRole;

import java.util.ArrayList;
import java.util.List;

public class RoleFeatureImpl implements IRoleFeatrue {
    public static List<Role> roleList = new ArrayList<Role>();
    public RoleFeatureImpl() {
        roleList = IOFileRole.readFromFile(IOFileRole.PATH_ROLE);
    }

    public void saveOrUpdate(Role roles) {
        int indexCheck = findIndexById(roles.getRoleId());
        if (indexCheck < 0) {
            // chức năng thêm mới
            roleList.add(roles);
            System.out.println("Add successfully");
        } else {
            // chức năng cập nhật
            roleList.set(indexCheck, roles);
            System.out.println("Update successfully");
        }
        IOFileRole.writeToFile(IOFileRole.PATH_ROLE,roleList);
    }
    public int findIndexById(int idFind) {
        for (int i = 0; i < roleList.size(); i++) {
            if (roleList.get(i).getRoleId() == idFind) {
                return i;
            }
        }
        return -1;
    }
}
