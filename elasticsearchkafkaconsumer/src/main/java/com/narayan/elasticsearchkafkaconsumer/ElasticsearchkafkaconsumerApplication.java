package com.narayan.elasticsearchkafkaconsumer;

import com.narayan.elasticsearchkafkaconsumer.model.User;
import com.narayan.elasticsearchkafkaconsumer.service.KafkaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ElasticsearchkafkaconsumerApplication {


	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchkafkaconsumerApplication.class, args);
	}

	@Autowired
	KafkaUserService kafkaUserService;
	@KafkaListener(topics = "gfg", groupId = "gfg-group")
	public void listen(User user) {
		System.out.println("Received User information : " + user.toString());
		try {
			kafkaUserService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/getElasticUserFromKafka")
	public Iterable<User> findAllUser() {
		return kafkaUserService.findAllUsers();
	}
}
