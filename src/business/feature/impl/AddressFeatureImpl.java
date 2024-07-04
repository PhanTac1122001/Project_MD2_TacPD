package business.feature.impl;

import business.entity.Address;
import business.entity.User;
import business.feature.IAddressFeature;
import business.feature.IUserFeature;
import business.utils.IOFileAddress;
import business.utils.IOFileUser;

import java.util.ArrayList;
import java.util.List;

public class AddressFeatureImpl implements IAddressFeature {

    public static List<Address> addressList=new ArrayList<>();

    public AddressFeatureImpl() {
        addressList = IOFileAddress.readFromFile(IOFileAddress.PATH_ADDRESS);
    }


    @Override
    public void saveOrUpdate(Address address) {
        int indexCheck = findIndexById(address.getAddressId());
        if (indexCheck < 0) {
            // chức năng thêm mới
            addressList.add(address);
            System.out.println("Add successfully");
        } else {
            // chức năng cập nhật
            addressList.set(indexCheck, address);
            System.out.println("Update successfully");
        }
        IOFileAddress.writeToFile(IOFileAddress.PATH_ADDRESS,addressList);
    }

    @Override
    public void deleteById(int idDelete) {
        int indexDelete = findIndexById(idDelete);
        if (indexDelete >= 0) {
            addressList.remove(indexDelete);
            System.out.println("Delete successfully");
            IOFileAddress.writeToFile(IOFileAddress.PATH_ADDRESS,addressList);
        } else {
            System.err.println("ID does not exist = " + idDelete);
        }
    }

    @Override
    public int findIndexById(int idFind) {
        for (int i = 0; i < addressList.size(); i++) {
            if (addressList.get(i).getAddressId() == idFind) {
                return i;
            }
        }
        return -1;
    }
}
