package com.artun.demo1RestAPI.controller;

import com.artun.demo1RestAPI.model.VoiceStream;
import com.artun.demo1RestAPI.service.VoiceStreamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // lombok log anotasyonu
@RequiredArgsConstructor // voiceStreamService nesnesinin constructor unu olusturuyorum ve bunun uzerinden inject yapiyorum
@RestController
@RequestMapping(value = "/voiceStream")
public class VoiceStreamController {

    private final VoiceStreamService voiceStreamService; // final dedim, constructor uzerinden inject islemini yapacagim.

    @GetMapping("/{id}")
    public ResponseEntity<VoiceStream> findVoiceStreamById(@PathVariable String id) {
        log.info("Incoming parameter id : " + id);
        return ResponseEntity.ok(voiceStreamService.findVoiceStreamByIdService(id));
    }

    @PostMapping(value = "/findAllVoiceStream")
    public ResponseEntity<List<VoiceStream>> findAllVoiceStream() {
        return ResponseEntity.ok(voiceStreamService.findAllVoiceStreamService());
    }

    @PostMapping(value = "/saveVoiceStream")
    public ResponseEntity<VoiceStream> saveVoiceStream(@RequestBody VoiceStream voiceStream) {
        return ResponseEntity.ok(voiceStreamService.saveVoiceStreamService(voiceStream));
    }
}
