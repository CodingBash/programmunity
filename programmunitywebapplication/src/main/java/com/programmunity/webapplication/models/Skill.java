package com.programmunity.webapplication.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.programmunity.webapplication.constants.SkillLevel;

public class Skill
{
	@NotNull
	@Size(min = 1, max = 15)
	private String skill;

	@NotNull
	private SkillLevel level;

	public String getSkill()
	{
		return skill;
	}

	public void setSkill(String skill)
	{
		this.skill = skill;
	}

	public SkillLevel getLevel()
	{
		return level;
	}

	public void setLevel(SkillLevel level)
	{
		this.level = level;
	}

}