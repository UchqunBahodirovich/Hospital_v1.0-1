package com.Hospital.hospital.db.entities;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Column
    private String patientFirstName;

    @Column
    private String patientLastName;

    @Column
    private int roomId;

    @Column
    private int reservationBeds;

    @Column
    private LocalDate arrivalDate;

    @Column
    private int userId;

    @Column
    private LocalDate departureDate;
}
