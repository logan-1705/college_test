package com.example.collegedemo.service.impl;

import com.example.collegedemo.domain.Address;
import com.example.collegedemo.repositiory.AddressRepository;
import com.example.collegedemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address saveAddress(Address address) {
        return null;
    }

    @Override
    public List<Address> saveAllAddress(List<Address> addressList) {
        addressList.add(new Address(1, "addressLine1","abc","xyz","123456"));
        addressList.add(new Address(2, "addressLine2","abc1","xyz1","123456"));
        return addressRepository.saveAll(addressList);
    }

    @Override
    public Address getAddress(int id) {
        return null;
    }

    @Override
    public List<Address> getAllAddress() {
        return null;
    }
}
