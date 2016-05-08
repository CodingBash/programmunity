package com.programmunity.webapplication.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.programmunity.webapplication.models.Group;

@Component
public class GroupRepositoryImpl implements GroupRepository
{

	@Override
	public List<Group> retrieveTopGroups(int count)
	{

		List<Group> groupList = new ArrayList<Group>(count);

		for (int i = 0; i < count; i++)
		{
			Group group = new Group();

			group.setGroupName("Group" + i);
			group.setDescription(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris a sodales leo, non consequat velit. Vivamus fermentum, quam at eleifend lacinia, diam sem scelerisque mi, vel accumsan nisi tortor non nibh. Vestibulum nunc est, malesuada sed nunc sit amet, efficitur sodales purus. Vivamus faucibus nisl at varius fringilla. Maecenas quis nunc eu velit porttitor imperdiet a sit amet nisi. Sed ac mi a dui volutpat efficitur. Integer ac efficitur lectus. Proin viverra elit vitae urna blandit, id ultricies lorem iaculis. Quisque at auctor mi. Pellentesque tincidunt dui urna, at lacinia lacus suscipit eget. Ut sit amet nunc ac neque rhoncus rhoncus sit amet ut nunc.");
			groupList.add(group);
		}
		return groupList;
	}

}
