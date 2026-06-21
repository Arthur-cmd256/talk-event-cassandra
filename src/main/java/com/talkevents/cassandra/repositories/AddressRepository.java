package com.talkevents.cassandra.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.talkevents.cassandra.models.Address;

@Repository
public interface AddressRepository extends CassandraRepository<Address, UUID> {

}
