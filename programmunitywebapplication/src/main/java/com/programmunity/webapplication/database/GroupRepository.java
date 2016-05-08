package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.models.Group;

public interface GroupRepository
{

	public List<Group> retrieveTopGroups(int count);

}
