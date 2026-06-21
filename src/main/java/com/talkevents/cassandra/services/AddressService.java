package com.talkevents.cassandra.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.talkevents.cassandra.models.Address;
import com.talkevents.cassandra.repositories.AddressRepository;

@Service
public class AddressService {

  private final AddressRepository addressRepository;

  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public List<Address> getAllAddresses() {
    return addressRepository.findAll();
  }

  public Address getAddressById(UUID id) {
    return addressRepository.findById(id).orElse(null);
  }

  public Address createAddress(Address address) {
    address.setId(UUID.randomUUID());
    return addressRepository.save(address);
  }

  public void updateAddress(Address updatedAddress) {
    addressRepository.findById(updatedAddress.getId())
        .ifPresent(address -> {
          address.setStreet(updatedAddress.getStreet());
          address.setCity(updatedAddress.getCity());
          address.setCountry(updatedAddress.getCountry());
          addressRepository.save(address);
        });
  }

  public void deleteAddress(UUID id) {
    addressRepository.deleteById(id);
  }
}
