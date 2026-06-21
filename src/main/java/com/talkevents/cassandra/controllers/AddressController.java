package com.talkevents.cassandra.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talkevents.cassandra.models.Address;
import com.talkevents.cassandra.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
  private final AddressService addressService;

  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping
  public ResponseEntity<List<Address>> getAllAddresses() {
    return ResponseEntity.ok(addressService.getAllAddresses());
  }

  @PostMapping
  public ResponseEntity<Address> createAddress(@RequestBody Address address) {
    return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(address));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Address> getAddressById(@PathVariable UUID id) {
    Address address = addressService.getAddressById(id);
    if (address != null) {
      return ResponseEntity.ok(address);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping
  public ResponseEntity<Void> updateAddress(@RequestBody Address updatedAddress) {
    addressService.updateAddress(updatedAddress);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAddress(@PathVariable UUID id) {
    addressService.deleteAddress(id);
    return ResponseEntity.noContent().build();
  }
}
