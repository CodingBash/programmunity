/**
 * 
 */
package com.programmunity.webapplication.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.programmunity.webapplication.models.Event;
import com.programmunity.webapplication.models.Group;
import com.programmunity.webapplication.models.Group.Directory;
import com.programmunity.webapplication.models.GroupRole;
import com.programmunity.webapplication.models.Residable;
import com.programmunity.webapplication.models.User;

/**
 * @author Basheer
 *
 */
@Component
public class EventRepositoryImpl implements EventRepository
{

	/**
	 * @see com.programmunity.webapplication.database.EventRepository#getEvents(long,
	 *      int)
	 */
	@Override
	public List<Event> getEvents(long eventId, int count)
	{
		List<Event> eventList = new ArrayList<Event>(count);
		for (int i = 0; i <= count; i++)
		{
			Event event = new Event();
			event.setTitle("Title: " + i);
			event.setDescription(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ac ornare lacus. Integer sit amet nulla at quam vehicula rutrum. Nam imperdiet ultrices nibh eget consequat. Fusce et mi vitae orci sollicitudin posuere. Vivamus aliquet eu nisl eu ultrices. Curabitur suscipit scelerisque lacus, non efficitur ex tristique a. Curabitur a molestie nibh. Maecenas aliquam turpis est, sit amet venenatis mauris lobortis quis. Maecenas quis ultrices justo. Phasellus volutpat enim vel nulla iaculis, vitae scelerisque est luctus. Donec leo lectus, ultrices nec dui vitae, tempor aliquet velit. Nullam placerat mollis auctor. Mauris laoreet dolor volutpat diam ultricies hendrerit.");
			List<Residable> attendees = new ArrayList<Residable>();

			Group group = new Group();
			Directory directory = group.new Directory();
			Map<User, GroupRole> members = new HashMap<User, GroupRole>();

			User user1 = new User();
			user1.setUserName("user1_" + i);
			User user2 = new User();
			user2.setUserName("user2_" + i);
			User user3 = new User();
			user3.setUserName("user3_" + i);
			User user4 = new User();
			user4.setUserName("user4_" + i);
			User user5 = new User();
			user5.setUserName("user5_" + i);

			directory.setOwner(user1);
			members.put(user2, GroupRole.ADMINISTRATOR);
			members.put(user3, GroupRole.MODERATOR);
			members.put(user4, GroupRole.REGULAR);
			members.put(user5, GroupRole.REGULAR);
			directory.setMembers(members);
			group.setDirectory(directory);
			attendees.add(group);

			event.setAttendees(attendees);
			eventList.add(event);
		}
		return eventList;
	}

	/**
	 * @see com.programmunity.webapplication.database.EventRepository#getEvents(int)
	 */
	@Override
	public List<Event> getEvents(int count)
	{
		return getEvents(-1, 20);
	}

	/**
	 * @see com.programmunity.webapplication.database.EventRepository#register(java.
	 *      lang.Long, java.lang.Long)
	 */
	@Override
	public void register(long eventId, long userId)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @see com.programmunity.webapplication.database.EventRepository#getEvents(java.
	 *      lang.Long)
	 */
	@Override
	public Event getEvent(long eventId)
	{
		Event event = new Event();
		List<Residable> attendees = new ArrayList<Residable>();

		Group group = new Group();
		Directory directory = group.new Directory();
		Map<User, GroupRole> members = new HashMap<User, GroupRole>();

		User user1 = new User();
		user1.setUserName("user1_");
		User user2 = new User();
		user2.setUserName("user2_");
		User user3 = new User();
		user3.setUserName("user3_");
		User user4 = new User();
		user4.setUserName("user4_");
		User user5 = new User();
		user5.setUserName("user5_");

		directory.setOwner(user1);
		members.put(user2, GroupRole.ADMINISTRATOR);
		members.put(user3, GroupRole.MODERATOR);
		members.put(user4, GroupRole.REGULAR);
		members.put(user5, GroupRole.REGULAR);
		directory.setMembers(members);
		group.setDirectory(directory);
		attendees.add(group);

		event.setAttendees(attendees);
		return event;
	}

	/**
	 * @see com.programmunity.webapplication.database.EventRepository#getEvents(
	 *      List<Long>)
	 */
	@Override
	public List<Event> getEvents(List<Long> eventIds) throws RuntimeException
	{
		return getEvents(-1, eventIds.size());
	}

	/**
	 * @see com.programmunity.webapplication.database.EventRepository#getEvents(Integer, String, int)
	 */
	@Override
	public List<Event> getEvents(Integer page, String sort, int count)
	{
		return getEvents(-1, count);
	}

}
