package com.artun.demo1RestAPI.engine;

import com.artun.demo1RestAPI.model.VoiceStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = "${app.kafka.topic.producer}", groupId = "${app.kafka.group.id}")
    public void consume(VoiceStream voiceStreamParameter) {
        log.info(String.format("#### -> Consumed message -> %s", voiceStreamParameter.getPhoneNumber()));
    }
}
