package com.artun.demo1RestAPI.repository;

import com.artun.demo1RestAPI.model.VoiceStream;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoiceStreamRepository extends CassandraRepository<VoiceStream, String> {
}
