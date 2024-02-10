package com.narayan.elasticsearchkafkaconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.narayan.elasticsearchkafkaconsumer.model.User;
import com.narayan.elasticsearchkafkaconsumer.repository.KafkaUserRepository;

@Service
public class KafkaUserService {
    @Autowired
    private KafkaUserRepository edao;

    public void saveUser(User user) {
        edao.save(user);
    }

    public Iterable<User> findAllUsers() {
        return edao.findAll();
    }
}
