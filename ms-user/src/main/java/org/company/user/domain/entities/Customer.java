package org.company.user.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.company.user.domain.CustomerLevel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "LEVEL")
    @Enumerated(value = EnumType.STRING)
    private CustomerLevel customerLevel;

/*    @Column(name = "PIN", unique = true)
    private String pin;*/

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ORDER_COUNT",nullable = false)
    private Integer orderCount = 0;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

}
