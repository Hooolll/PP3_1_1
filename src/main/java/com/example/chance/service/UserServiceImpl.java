package com.example.chance.service;

import com.example.chance.model.User;
import com.example.chance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    @Transactional
    public void addUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        usersRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        usersRepository.deleteById(id);
    }
}
