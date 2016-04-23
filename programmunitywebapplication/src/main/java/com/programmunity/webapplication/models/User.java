package com.programmunity.webapplication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

/**
 * Model containing information for an application user
 * 
 * @author Basheer
 *
 */
public class User extends Residable
{

	// TODO: Verify hibernate
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private long userId;

	@NotNull
	@Size(min = 5, max = 15)
	private String userName;

	@NotNull
	@Email
	@Size(min = 5, max = 35)
	private String email;

	// TODO: Add tighter password validation (numbers, digits, decimals, etc)
	@NotNull
	@Size(min = 5, max = 30)
	private String password;

	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

	@Size(max = 256)
	private String description;

	@Size(max = 25)
	private List<Skill> skills;

	/**
	 * Field only used for profile reference, not for logical processing
	 */
	@Size(max = 50)
	private List<Group> groups;
	
	@NotNull
	@Past
	private Date birthdate;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Skill> getSkills()
	{
		return skills;
	}

	public void setSkills(List<Skill> skills)
	{
		this.skills = skills;
	}

	public Date getBirthdate()
	{
		return birthdate;
	}

	public void setBirthdate(Date birthdate)
	{
		this.birthdate = birthdate;
	}

}
