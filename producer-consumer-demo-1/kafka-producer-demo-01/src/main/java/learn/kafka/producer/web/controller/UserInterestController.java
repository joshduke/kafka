package learn.kafka.producer.web.controller;

import learn.kafka.producer.service.KafkaProducerService;
import learn.kafka.producer.web.model.UserInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInterestController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/userinterestapi/v1")
    public void addUserInterest(@RequestBody UserInterest userInterest) {
        kafkaProducerService.publish(userInterest.getUserName(), userInterest.getInterest());
    }

}
