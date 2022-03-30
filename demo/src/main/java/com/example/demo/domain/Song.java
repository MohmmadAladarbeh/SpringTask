package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties({"albums"})
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Song {

    @Setter (value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private int length;

    @NonNull
    private int trackNumber;

    @ManyToOne
    Albums albums;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", trackNumber=" + trackNumber +
                ", albums=" + albums +
                '}';
    }
}
