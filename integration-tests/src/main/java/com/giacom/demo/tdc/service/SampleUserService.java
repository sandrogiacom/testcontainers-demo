package com.giacom.demo.tdc.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giacom.demo.tdc.domain.SampleUser;
import com.giacom.demo.tdc.exception.InvalidUserException;
import com.giacom.demo.tdc.repository.SampleUserRepository;

@Service
public class SampleUserService {

    @Autowired
    private SampleUserRepository repository;

    public Iterable<SampleUser> findAll() {
        return repository.findAll();
    }

    public SampleUser create(SampleUser user) throws InvalidUserException {
        validateUser(user);

        if (user.getId() != null) {
            throw new InvalidUserException("id must be null!!");
        }
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);

    }

    public SampleUser update(SampleUser user) throws Exception {

        if (user.getId() == null || user.getId().isEmpty()) {
            throw new InvalidUserException("id can not be null!!");
        }

        checkExistingUser(user.getId());

        validateUser(user);

        return repository.save(user);

    }

    private void validateUser(SampleUser user) throws InvalidUserException {
        if (user.getAge() <= 0) {
            throw new InvalidUserException("Invalid age!!!");
        }
        if (user.getName() == null || user.getName().isEmpty() || user.getName().length() <= 3) {
            throw new InvalidUserException("Invalid user name!!!");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new InvalidUserException("Invalid user last name!!!");
        }
    }


    public void delete(String id) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new InvalidUserException("id can not be null!!");
        }
        checkExistingUser(id);

        repository.deleteById(id);

    }

    private void checkExistingUser(String id) {
        findById(id);
    }

    public SampleUser findById(String id) {
        SampleUser user = null;
        try {
            user = repository.findById(id).get();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (user == null) {
            throw new EntityNotFoundException("user not found with id " + id);
        }
        return user;
    }

    public List<SampleUser> findByNameContainingIgnoreCase(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<SampleUser> findByLastNameContainingIgnoreCase(String name) {
        return repository.findByLastNameContainingIgnoreCase(name);
    }
}
