package business.feature.impl;

import business.entity.Category;
import business.entity.User;
import business.feature.ICategoryFeature;
import business.feature.IUserFeature;
import business.utils.IOFileCategory;
import business.utils.IOFileUser;

import java.util.ArrayList;
import java.util.List;

public class UserFeatureImpl implements IUserFeature {

    public static List<User> userList=new ArrayList<>();

    public UserFeatureImpl() {
        userList = IOFileUser.readFromFile(IOFileUser.PATH_USERS);
    }


    @Override
    public void saveOrUpdate(User user) {
        int indexCheck = findIndexById(user.getUserId());
        if (indexCheck < 0) {
            // chức năng thêm mới
            userList.add(user);
            System.out.println("Add successfully");
        } else {
            // chức năng cập nhật
            userList.set(indexCheck, user);
            System.out.println("Update successfully");
        }
        IOFileUser.writeToFile(IOFileUser.PATH_USERS,userList);
    }

    @Override
    public void deleteById(int idDelete) {
        int indexDelete = findIndexById(idDelete);
        if (indexDelete >= 0) {
            userList.remove(indexDelete);
            System.out.println("Delete successfully");
            IOFileUser.writeToFile(IOFileUser.PATH_USERS,userList);
        } else {
            System.err.println("ID does not exist = " + idDelete);
        }
    }

    @Override
    public int findIndexById(int idFind) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId() == idFind) {
                return i;
            }
        }
        return -1;
    }
}
