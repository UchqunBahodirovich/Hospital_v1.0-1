package com.Hospital.hospital.db.entities;

import com.Hospital.hospital.db.enums.RoomType;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private int hospitalId;

    @Column
    @NotNull
    private int count;

    @Column
    @NotNull
    private int amountOfBeds;

    @Column
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "roomId")
    private Collection<Patient> reservations;
}
