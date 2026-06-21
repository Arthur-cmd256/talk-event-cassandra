package com.talkevents.cassandra.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.talkevents.cassandra.models.User;

public interface UserRepository extends CassandraRepository<User, UUID> {

}
