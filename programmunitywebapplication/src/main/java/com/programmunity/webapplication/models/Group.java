package com.programmunity.webapplication.models;

import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * Model containing information for a community group
 * 
 * @author Basheer
 *
 */
public class Group extends Residable
{
	// TODO: Verify hibernate
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private long groupId;

	@NotNull
	@Size(max = 50)
	private String groupName;

	@NotNull
	@Size(max = 250)
	private String description;

	@NotNull
	private Directory directory;

	/**
	 * @return the groupId
	 */
	public long getGroupId()
	{
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	/**
	 * @return the title
	 */
	public String getGroupName()
	{
		return groupName;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the directory
	 */
	public Directory getDirectory()
	{
		return directory;
	}

	/**
	 * @param directory
	 *            the directory to set
	 */
	public void setDirectory(Directory directory)
	{
		this.directory = directory;
	}

	/**
	 * Directory of users in a {@list Group}
	 * 
	 * @author Basheer
	 *
	 */
	public class Directory
	{

		/**
		 * Owner of group. Contains highest privileges Abstract to a field and
		 * not to a {@link GroupRole}
		 */
		private User owner;

		/**
		 * Nap of all members and their {@link GroupRole}
		 */
		private Map<User, GroupRole> members;

		public User getOwner()
		{
			return owner;
		}

		public void setOwner(User owner)
		{
			this.owner = owner;
		}

		public Map<User, GroupRole> getMembers()
		{
			return members;
		}

		public void setMembers(Map<User, GroupRole> members)
		{
			this.members = members;
		}

	}

}
