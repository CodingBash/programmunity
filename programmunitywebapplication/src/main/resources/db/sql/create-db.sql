create table userRoles (
	userRoleId int identity primary key,
	userRole varchar(10) not null
);

create table users (
  userId int identity primary key,
  userRoleId int not null,
  userName varchar(15) not null,
  email varchar(35) not null,
  password varchar(30) not null,
  firstName varchar(30) not null,
  lastName varchar(30) not null,
  description varchar(256) not null,
  foreign key (userRoleId) references userRoles(userRoleId)
);

create table skills (
	skillId int identity primary key,
	skill varchar(30) not null,
	skillLevel int(5) not null	
);

create table userSkillRelationship (
	userId int not null,
	skillId int not null,
	primary key (userId, skillId),
	foreign key (userId) references users(userId),
	foreign key (skillId) references skills(skillId)
);
	
CREATE TABLE feeds(
	feedId int identity PRIMARY KEY,
	posterId int not null,
	post varchar(500) not null,
	foreign key (posterId) references users(userId)
);

create table groups (
	groupId int identity primary key,
	ownerId int not null,
	groupName varchar(50) not null,
	groupDescription varchar(250),
	foreign key(ownerId) references users(userId)
);

create table groupRoles (
	groupRoleId int identity primary key,
	groupRole varchar(10) not null
);

create table directory (
	groupId int not null,
	memberId int not null,
	groupRoleId int not null,
	primary key (groupId, memberId, groupRoleId),
	foreign key (groupId) references groups(groupId),
	foreign key (memberId) references users(userId),
	foreign key (groupRoleId) references groupRoles(groupRoleId)
);




