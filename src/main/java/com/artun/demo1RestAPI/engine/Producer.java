package com.artun.demo1RestAPI.engine;

import com.artun.demo1RestAPI.model.VoiceStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@RequiredArgsConstructor
@Service
public class Producer {

    @Value("${app.kafka.topic.producer}")
    private String TOPIC;

    private final KafkaTemplate<String, VoiceStream> kafkaTemplate;

    public void sendMessage(VoiceStream voiceStreamParameter) {
        log.info(String.format("#### -> Producing message -> %s", voiceStreamParameter));
        this.kafkaTemplate.send(TOPIC, voiceStreamParameter).addCallback(new ListenableFutureCallback<SendResult<String, VoiceStream>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Error while producing : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, VoiceStream> stringVoiceStreamSendResult) {
                log.info("Received new metadata. \n" +
                        "Topic : " + stringVoiceStreamSendResult.getRecordMetadata().topic() + "\n" +
                        "Partition : " + stringVoiceStreamSendResult.getRecordMetadata().partition() + "\n" +
                        "Offset : " + stringVoiceStreamSendResult.getRecordMetadata().offset() + "\n" +
                        "Timestamp :" + stringVoiceStreamSendResult.getRecordMetadata().timestamp());
            }
        });
    }
}
