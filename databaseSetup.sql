CREATE TABLE User(
	Email	CHAR(20)	NOT NULL,
	Password CHAR	NOT NULL,
	Karma	INT,
	UserID CHAR(10)	NOT NULL,
	Username CHAR(10)	NOT NULL,
	PRIMARY KEY (Username) 
);

CREATE TABLE Administrator(
	Admin_access_level INT,
	UserID CHAR(10)	NOT NULL,
	AdminID CHAR(10) NOT NULL,
	PRIMARY KEY (UserID),
	FOREIGN KEY (Username) REFERENCES User (UserID) ON DELETE CASCADE
);

CREATE TABLE LocationOf(
	Latitude DECIMAL(8,6)		NOT NULL,
	Longitude DECIMAL(8,6)		NOT NULL,
	Address CHAR(50),
	Time CHAR(20),
	PRIMARY KEY (Latitude, Longitude),
    FOREIGN KEY (UserID) REFERENCES User (User) ON DELETE CASCADE
    FOREIGN KEY (PostID) REFERENCES Post (Post) ON DELETE CASCADE

);

CREATE TABLE Post(
	PostID integer	NOT NULL,
	Content CHAR(200)	NOT NULL,
	UserID CHAR(10)	NOT NULL,
	Time CHAR(20)	NOT NULL,
	PRIMARY KEY(PostID),
	FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE
);

CREATE TABLE PhotoIn(
	PhotoID CHAR(10)	NOT NULL,
	Size integer		NOT NULL,
	Format CHAR(100)	NOT NULL,
	PostID CHAR(100)	NOT NULL,
	PRIMARY KEY(PostID, PhotoID),
	FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

CREATE TABLE LikedPost(
	PostID integer	NOT NULL,
	Trending BOOLEAN,
	#ofLikes integer	NOT NULL,
    PRIMARY KEY (PostID),
	FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

CREATE TABLE TrendingTopic(
	TopicID CHAR(10)	NOT NULL, 
    Content CHAR 50	NOT NULL, 
    PostID integer	NOT NULL,
    PRIMARY KEY (TopicID),
	FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE NO ACTION
);

CREATE TABLE VoteFor(
	VoteID CHAR(20)	
    Type BOOLEAN	
    Time CHAR(20)	
    UserID CHAR(10)	NOT NULL,
    PostID CHAR(20)	NOT NULL,
    PRIMARY KEY (VoteID),
    FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

CREATE TABLE Comment(
	CommentID CHAR(20)	NOT NULL, 
    UserID CHAR(10)		NOT NULL,
    PostID CHAR(20)		NOT NULL,
    Time CHAR(20)		NOT NULL,
    Content CHAR(200)		NOT NULL,
    PRIMARY KEY (CommentID),
    FOREIGN KEY (UserID) REFERENCES Post (UserID) ON DELETE CASCADE
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

CREATE TABLE ReplyTo(
	ReplyID CHAR(20)		NOT NULL, 
    UserID CHAR(10)		NOT NULL, 
    CommentID CHAR(20)	NOT NULL, 
    Content CHAR(100)		NOT NULL, 
    Time CHAR(20)		NOT NULL,
    PRIMARY KEY (ReplyID),
    FOREIGN KEY (UserID) REFERENCES Post (User) ON DELETE CASCADE
    FOREIGN KEY (CommentID) REFERENCES Comment (CommentID) ON DELETE CASCADE
);

INSERT INTO User(Email, Password, Karma, UserID, Username)
VALUES (‘qwer@hotmail.com’, ‘123123123’, ‘10’, ‘U4468’, ‘Potatoman’);

INSERT INTO User(Email, Password, Karma, UserID, Username)
VALUES (‘mynameiskate@hotmail.com’, ‘3348876’, ‘50’, ‘U4469’, ‘KateGoWild’);

INSERT INTO User(Email, Password, Karma, UserID, Username)
VALUES (‘kasleague@hotmail.com’, ‘qweasdzxc123’, ‘10’, ‘U4470’, ‘Kassio’);

INSERT INTO User(Email, Password, Karma, UserID, Username)
VALUES (‘DavidSmith@hotmail.com’, ‘applepie123’, ‘7856’, ‘U4471’, ‘MakeAmericaGreatAgain’);

INSERT INTO User(Email, Password, Karma, UserID, Username)
VALUES (‘holygrail98@hotmail.com’, ‘uikjawds’, ‘5081’, ‘U4472’, ‘Kevin’);



Administrator TABLE:

INSERT INTO Administrator(User_ID, AdminID, Admin_access_level)
VALUES (‘U4468’, ‘8888’, ‘5’);

INSERT INTO Administrator(User_ID, AdminID, Admin_access_level)
VALUES (‘U4469’, ‘9999’, ‘1’);

INSERT INTO Administrator(User_ID, AdminID, Admin_access_level)
VALUES (‘U4482’, ‘1111’, ‘2’);

INSERT INTO Administrator(User_ID, AdminID, Admin_access_level)
VALUES (‘U4321’, ‘2222’, ‘3’);

INSERT INTO Administrator(User_ID, AdminID, Admin_access_level)
VALUES (‘U4111’, ‘3333’, ‘1’);

LocationOf TABLE:

INSERT INTO LocationOf(Latitude, Longitude, Address, Time)
VALUES (‘42.546245’ , ‘1.601554’, ‘king Street’, ‘14:50’);

INSERT INTO LocationOf(Latitude, Longitude, Address, Time)
VALUES (‘45.931156’ , ‘13.89051’, ‘Denman Street’, ‘19:50’);

INSERT INTO LocationOf(Latitude, Longitude, Address, Time)
VALUES (‘81.997512’ , ‘3.875012’, ‘Robson Street’, ‘8:22’);

INSERT INTO LocationOf(Latitude, Longitude, Address, Time)
VALUES (‘36.986531’ , ‘16.233875’, ‘1st Street’, ‘16:33’);

INSERT INTO LocationOf(Latitude, Longitude, Address, Time)
VALUES (‘57.378612’ , ‘23.984612’, ‘Granville Street’, ‘13:42’);

Post TABLE:

INSERT INTO Post(PostID, Content, UserID, Time)
VALUES( ‘12250’， ‘Trump is back’, ‘US_Patriot’, ‘U2445’, ‘13:24’);

INSERT INTO Post(PostID, Content, UserID, Time)
VALUES( ‘12282’， ‘Hello World’, ‘ProCoder’, ‘U3861’, ‘16:02’);

INSERT INTO Post(PostID, Content, UserID, Time)
VALUES( ‘12250’， ‘Trump is back’, ‘US_Patriot’, ‘U2445’, ‘13:24’);

INSERT INTO Post(PostID, Content, UserID, Time)
VALUES( ‘12250’， ‘Trump is back’, ‘US_Patriot’, ‘U2445’, ‘13:24’);

INSERT INTO Post(PostID, Content, UserID, Time)
VALUES( ‘12250’， ‘Trump is back’, ‘US_Patriot’, ‘U2445’, ‘13:24’);


PhotoIn TABLE:

INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
VALUES( ‘P12220’， ‘8775’, ‘JPEG’, ‘12250’);

INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
VALUES( ‘P12321’， ‘10028’, ‘JPEG’, ‘12252’);

INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
VALUES( ‘P12432’， ‘58082’, ‘JPEG’, ‘12871’);

INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
VALUES( ‘P18742’， ‘1008652’, ‘GIF’, ‘18752’);

INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
VALUES( ‘P16752’， ‘38062’, ‘JPEG’, ‘15658’);



INSERT INTO LikedPost(PostID, Trending, #ofLikes)
VALUES( ‘12250’, ‘FALSE’, ‘2886’);

INSERT INTO LikedPost(PostID, Trending, #ofLikes)
VALUES( ‘1234’, ‘FALSE’, ‘4881’);

INSERT INTO LikedPost(PostID, Trending, #ofLikes)
VALUES( ‘4421’, ‘FALSE’, ‘13334’);

INSERT INTO LikedPost(PostID, Trending, #ofLikes)
VALUES( ‘12334’, ‘FALSE’, ‘98881’);

INSERT INTO LikedPost(PostID, Trending, #ofLikes)
VALUES( ‘1654’, ‘FALSE’, ‘23334’);


INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES(‘Sports’, ‘Lakers 2020 champions, will they win again next season?’, ‘14489’);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES(‘Random’, ‘Hello World’, ‘2557’);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES(‘Economics’, ‘Bullish market 2020’, ‘1448’);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES(‘Sports’, ‘Bulls new draft pick for big hopes’, ‘2267’);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES(‘Coding’, ‘How to use hashmap in java’, ‘123’);


INSERT INTO VoteFor(VoteID, Type, Time, UserID, PostID)
VALUES(‘V44220’, ‘TRUE’, ‘16:23’, ‘U7889’, ‘12554’);

INSERT INTO VoteFor(VoteID, Type, Time, UserID, PostID)
VALUES(‘V44220’, ‘TRUE’, ‘16:23’, ‘U7889’, ‘12554’);

INSERT INTO VoteFor(VoteID, Type, Time, UserID, PostID)
VALUES(‘V44220’, ‘TRUE’, ‘16:23’, ‘U7889’, ‘12554’);

INSERT INTO VoteFor(VoteID, Type, Time, UserID, PostID)
VALUES(‘V44220’, ‘TRUE’, ‘16:23’, ‘U7889’, ‘12554’);

INSERT INTO VoteFor(VoteID, Type, Time, UserID, PostID)
VALUES(‘V44220’, ‘TRUE’, ‘16:23’, ‘U7889’, ‘12554’);


INSERT INTO Comment( CommentID, UserId, PostID, Time, Content)
VALUES(‘C1’, ‘U1882’, ‘122395’, ‘19:12’, ‘good point!’);

INSERT INTO Comment( CommentID, UserId, PostID, Time, Content)
VALUES(‘C2’, ‘U1883’, ‘122395’, ‘19:18’, ‘good point!’);

INSERT INTO Comment( CommentID, UserId, PostID, Time, Content)
VALUES(‘C3’, ‘U1826’, ‘122395’, ‘19:22’, ‘good idea!’);

INSERT INTO Comment( CommentID, UserId, PostID, Time, Content)
VALUES(‘C4’, ‘U1884’, ‘122395’, ‘19:36’, ‘good question!’);

INSERT INTO Comment( CommentID, UserId, PostID, Time, Content)
VALUES(‘C5’, ‘U1889’, ‘122395’, ‘19:50’, ‘good discussion!’);



INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, Time)
VALUES(‘R24’, ‘U3314’, ‘C21’, ‘What other questions do you have?’, ‘18:27’);

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, Time)
VALUES(‘R25’, ‘U3587’, ‘C22’, ‘Hi there’, ‘18:29’);

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, Time)
VALUES(‘R26’, ‘U1458’, ‘C23’, ‘Great day’, ‘18:33’);

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, Time)
VALUES(‘R27’, ‘U2231’, ‘C24’, ‘what is wrong’, ‘18:44’);

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, Time)
VALUES(‘R28’, ‘U1667’, ‘C25’, ‘good night’, ‘18:58’);

