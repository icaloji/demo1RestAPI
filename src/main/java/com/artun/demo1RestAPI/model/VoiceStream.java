package com.artun.demo1RestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * Created by I.C.ARTUN
 */

// Lombok kutuphanesini kullanarak olusturuyoruz
//@Getter // getter metodlarini anotasyon kullanarak olusturduk
//@ToString // toString metodlarini anotasyon kullanarak olusturduk
@Data
// @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"}) // equals ve hashCode motodlarini olustururken id field'ini kullanarak olusturuyoruz.
@NoArgsConstructor // hicbir parametrenin olmadigi constructor olusturuyoruz
@AllArgsConstructor // tum parametrenin olmadigi constructor olusturuyoruz
@Table(value = "voice_stream") // cassandra db de tablo olusturuyoruz
public class VoiceStream implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString(); // cassandra da time based UUID dir. Bu nesne olusturuldugunda UUID nin random hali bu nesneye esit olsun.

    @Column(value = "phone_number")
    private String phoneNumber;

    @Column(value = "duration")
    private Long duration;

    @Column(value = "call_start_date")
    private Date callStartDate;

    @Column(value = "active")
    private Boolean active;

}

