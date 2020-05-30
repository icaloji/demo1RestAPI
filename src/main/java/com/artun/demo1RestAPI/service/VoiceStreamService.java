package com.artun.demo1RestAPI.service;

import com.artun.demo1RestAPI.engine.Producer;
import com.artun.demo1RestAPI.model.VoiceStream;
import com.artun.demo1RestAPI.repository.VoiceStreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // voiceStreamRepository nesnesinin constructor unu olusturuyorum ve bunun uzerinden inject yapiyorum
@Service
public class VoiceStreamService {

    private final VoiceStreamRepository voiceStreamRepository; // final dedim, constructor uzerinden inject islemini yapacagim.
    private final Producer producer;

    public VoiceStream findVoiceStreamByIdService(String id){
        return voiceStreamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<VoiceStream> findAllVoiceStreamService(){
        return voiceStreamRepository.findAll();
    }

    public VoiceStream saveVoiceStreamService(VoiceStream voiceStream){

        // send to kafka topic
        producer.sendMessage(voiceStream);
        // cassandra kayit islemi
        return voiceStreamRepository.save(voiceStream);
    }
}
