package com.gs.inmemory.manageusers.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Builder
@Table(name = "useraddress")
public class UserAddress {
    @Id
    @NonNull
    @JsonIgnore
    @Column(name = "empid", nullable = false)
	private String empid;
    @NonNull
    @NotEmpty
	@Column(name = "street", nullable = false)
	private String street;
    @NonNull
    @NotEmpty
	@Column(name = "city", nullable = false)
	private String city;
    @NonNull
    @NotEmpty
	@Column(name = "state", nullable = false)
	private String state;

    @NonNull
	@Column(name = "postcode", nullable = false)
	private int postcode;

    @JsonIgnore
    @OneToOne 
    @PrimaryKeyJoinColumn
    private UserDetail user;


}
