package com.example.collegedemo.service;

import com.example.collegedemo.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public Address saveAddress(Address address);
    public List<Address> saveAllAddress(List<Address> addressList);
    public Address getAddress(int id);
    public List<Address> getAllAddress();
}
