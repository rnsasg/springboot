package com.narayan.elasticsearchkafkaconsumer.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.narayan.elasticsearchkafkaconsumer.model.User;

@Repository
public interface KafkaUserRepository extends ElasticsearchRepository<User,String> {

}

