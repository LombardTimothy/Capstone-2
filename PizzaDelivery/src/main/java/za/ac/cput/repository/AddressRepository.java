package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import java.util.HashSet;
import java.util.Set;

/*
AddressRepository.java
Author: Tamryn Lisa Lewin (219211981)
Date: 05 April 2023
Last update: 08 April 2023
 */

public class AddressRepository implements IAddressRepository {
    private static AddressRepository addressRepository = null;
    private Set<Address> addressDB;
    private AddressRepository() {
        addressDB = new HashSet<Address>();
    }

    public static AddressRepository getRepository() {
        if (addressRepository == null) {
            addressRepository = new AddressRepository();
        }
        return addressRepository;
    }

    @Override
    public Address create(Address address) {
        boolean success = addressDB.add(address);
        if(!success) {
            return null;
        }else
            return address;
    }

    @Override
    public Address read(String addressId) {
        for(Address a : addressDB) {
            if(a.getAddressId().equals(addressId))
                return a;
        }
        return  null;
    }

    @Override
    public Address update(Address address) {
        Address currentAddress = read(address.getAddressId());
        if(currentAddress != null) {
            addressDB.remove(currentAddress);
            addressDB.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String addressId) {
        Address deleteAddress = read(addressId);
        if(deleteAddress != null) {
            addressDB.remove(deleteAddress);
            System.out.println("Deleted.");
            return true;
        }else {
            System.out.println("Could not delete.");
            return false;
        }
    }

    @Override
    public Set<Address> getAll() {
        return addressDB;
    }
}
