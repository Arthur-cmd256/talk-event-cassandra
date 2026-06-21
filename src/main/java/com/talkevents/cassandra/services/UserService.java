package com.talkevents.cassandra.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.talkevents.cassandra.models.User;
import com.talkevents.cassandra.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(UUID id) {
    return userRepository.findById(id).orElse(null);
  }

  public User createUser(User user) {
    user.setId(UUID.randomUUID());
    return userRepository.save(user);
  }

  public User updateUser(User updatedUser) {
    return userRepository.findById(updatedUser.getId())
        .map(user -> {
          user.setName(updatedUser.getName());
          user.setAge(updatedUser.getAge());
          user.setEmail(updatedUser.getEmail());
          user.setAddressId(updatedUser.getAddressId());
          return userRepository.save(user);
        })
        .orElse(null);
  }

  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }
}
