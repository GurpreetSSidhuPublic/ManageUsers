package com.gs.inmemory.manageusers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import javax.persistence.CascadeType;

import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.OneToOne;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Builder
@Table(name = "userdetail")
public class UserDetail {

	@Id
	@NonNull
	@Pattern(regexp = "[0-9]+", message = "Emp Id field only accepts numeric values.")
	@Column(name = "empid", unique = true)
	private String empid;
	
	@NonNull
	@NotEmpty
	@Column(name = "title", nullable = false)
	private String title;

	@NonNull
	@NotEmpty
	@Column(name = "firstn", nullable = false)
	private String firstn;

	@NonNull
	@NotEmpty
	@Column(name = "lastname", nullable = false)
	private String lastname;

	@NonNull
	@NotEmpty
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@OneToOne(cascade = CascadeType.MERGE, mappedBy = "user", optional = true)
    @PrimaryKeyJoinColumn
	private UserAddress address;

}
