package com.neosoft.SpringBootApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name= "user_contact_tab")
public class UserContact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contactId;

    @NotNull(message = "Mobile number can not be null")
    private long mobileNo;

    @NotNull(message = "Alternate Mobile number can not be null")
    private long alternateNo;

    @NotNull(message = "Email  can not be null")
    private String emailId;
/*

    @Size(max = 510)
    @NotNull(message = "address can not be null")
    private String address;
*/

}
