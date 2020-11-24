use heey;
CREATE TABLE User(
	Email CHAR(20) NOT NULL,
	Pass CHAR NOT NULL,
	Karma integer,
	UserID integer NOT NULL,
	Username CHAR(10) NOT NULL,
	PRIMARY KEY (UserID) 
);


/*CREATE TABLE Administrator(

	UserID integer NOT NULL,
	AdminID CHAR(10) NOT NULL,
	Admin_access_level integer,
	PRIMARY KEY (UserID),
	FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE
);*/
CREATE TABLE Administrator_r1(

	UserID integer NOT NULL,
	AdminID CHAR(10) NOT NULL,
	PRIMARY KEY (UserID),
	FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE
);
CREATE TABLE Administrator_r2(
	Admin_access_level integer,
	UserID integer NOT NULL,

	PRIMARY KEY (UserID),
	FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE
);

CREATE TABLE Post(
	PostID integer	NOT NULL,
	Content CHAR(200)	NOT NULL,
	UserID integer	NOT NULL,
	time CHAR(20)	NOT NULL,
	PRIMARY KEY(PostID),
	FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE
);

CREATE TABLE LocationOf_r1(
	Latitude DECIMAL(18,4) NOT NULL,
	Longitude DECIMAL(18,4) NOT NULL,

	time CHAR(20),
    UserID integer NOT NULL,
	PostID integer NOT NULL,
	PRIMARY KEY (Latitude, Longitude),
    FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);
CREATE TABLE LocationOf_r2(
	Latitude DECIMAL(18,4) NOT NULL,
	Longitude DECIMAL(18,4) NOT NULL,
	Address CHAR(50),
	UserID integer NOT NULL,
	PostID integer NOT NULL,
	PRIMARY KEY (Latitude, Longitude),
    FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);
/*CREATE TABLE LocationOf(
	Latitude DECIMAL(8,6) NOT NULL,
	Longitude DECIMAL(8,6) NOT NULL,
	Address CHAR(50),
	time CHAR(20),
    UserID INT NOT NULL,
	PostID integer NOT NULL,
	PRIMARY KEY (Latitude, Longitude),
    FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);*/

CREATE TABLE PhotoIn (
    PhotoID INTEGER NOT NULL,
    Size INTEGER NOT NULL,
    Format CHAR(100) NOT NULL,
    PostID INTEGER NOT NULL,
    PRIMARY KEY (PostID , PhotoID),
    FOREIGN KEY (PostID)
        REFERENCES Post (PostID)
        ON DELETE CASCADE
);

CREATE TABLE LikedPost(
	PostID integer	NOT NULL,
	Trending BOOLEAN,
	numberoflikes integer	NOT NULL,
    PRIMARY KEY (PostID),
	FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

CREATE TABLE TrendingTopic(
	TopicID CHAR(50)	NOT NULL, 
    Content text NOT NULL, 
    PostID integer	NOT NULL,
    PRIMARY KEY (TopicID),
	FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE NO ACTION
);

CREATE TABLE VoteFor(
	VoteID integer,		
    time CHAR(20),
    UserID integer	NOT NULL,
    PostID integer	NOT NULL,
    PRIMARY KEY (VoteID),
    FOREIGN KEY (UserID) REFERENCES User (UserID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

CREATE TABLE Comment(
	CommentID integer	NOT NULL, 
    UserID integer		NOT NULL,
    PostID integer		NOT NULL,
    time CHAR(20)		NOT NULL,
    Content text		NOT NULL,
    PRIMARY KEY (CommentID),
    FOREIGN KEY (UserID) REFERENCES Post (UserID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES Post (PostID) ON DELETE CASCADE
);

/*CREATE TABLE ReplyTo(
	ReplyID integer		NOT NULL, 
    UserID integer		NOT NULL, 
    CommentID integer	NOT NULL, 
    Content CHAR(100)		NOT NULL, 
    time CHAR(20)		NOT NULL,
    PRIMARY KEY (ReplyID),
    FOREIGN KEY (UserID) REFERENCES Post (UserID) ON DELETE CASCADE,
    FOREIGN KEY (CommentID) REFERENCES Comment (CommentID) ON DELETE CASCADE
);*/

CREATE TABLE ReplyTo_r1(
	ReplyID integer		NOT NULL,
    Content CHAR(100)	NOT NULL,
    time CHAR(20)		NOT NULL,
	UserID integer		NOT NULL,
    CommentID integer	NOT NULL,
    PRIMARY KEY (ReplyID),
    FOREIGN KEY (UserID) REFERENCES Post (UserID) ON DELETE CASCADE,
    FOREIGN KEY (CommentID) REFERENCES Comment (CommentID) ON DELETE CASCADE
);
CREATE TABLE ReplyTo_r2(
	ReplyID integer		NOT NULL,
    UserID integer		NOT NULL,
    CommentID integer	NOT NULL,

    PRIMARY KEY (ReplyID),
    FOREIGN KEY (UserID) REFERENCES Post (UserID) ON DELETE CASCADE,
    FOREIGN KEY (CommentID) REFERENCES Comment (CommentID) ON DELETE CASCADE
);




INSERT INTO User(Email, Pass, Karma, UserID, Username)
VALUES ("qwer@hotmail.com", "1", 10, 4468, "Potatoman");

INSERT INTO User(Email, Pass, Karma, UserID, Username)
VALUES ("myname@hotmail.com", "q", 50, 4469, "KateGoWild");

INSERT INTO User(Email, Pass, Karma, UserID, Username)
VALUES ("kas@hotmail.com", "q", 10, 4470, "Kassiod");

INSERT INTO User(Email, Pass, Karma, UserID, Username)
VALUES ("DavidS@hotmail.com", "q", 7856, 4471, "Kake");

INSERT INTO User(Email, Pass, Karma, UserID, Username)
VALUES ("holy@hotmail.com", "q", 5081, 4472, "Kevind");




/*INSERT INTO Administrator_r1(UserID, AdminID, Admin_access_level)
VALUES (4468, 8888, 5);

INSERT INTO Administrator_r1(UserID, AdminID, Admin_access_level)
VALUES (4470, 9999, 1);

INSERT INTO Administrator_r1(UserID, AdminID, Admin_access_level)
VALUES (4471, 1111, 2);

INSERT INTO Administrator_r1(UserID, AdminID, Admin_access_level)
VALUES (4472, 2222, 3);*/
INSERT INTO Administrator_r1(UserID, AdminID)
VALUES (4468, 8888);

INSERT INTO Administrator_r1(UserID, AdminID)
VALUES (4470, 9999);

INSERT INTO Administrator_r1(UserID, AdminID)
VALUES (4471, 1111);

INSERT INTO Administrator_r1(UserID, AdminID)
VALUES (4472, 2222);

INSERT INTO Administrator_r2(UserID, Admin_access_level)
VALUES (4468, 8888);

INSERT INTO Administrator_r2(UserID, Admin_access_level)
VALUES (4470, 9999);

INSERT INTO Administrator_r2(UserID, Admin_access_level)
VALUES (4471, 1111);

INSERT INTO Administrator_r2(UserID, Admin_access_level)
VALUES (4472, 2222);

-- need new insert queries for locationof Table
INSERT INTO Post(PostID, Content, UserID, time)
VALUES( 12250, "Trump is back",  4468, "2020.09.01");

INSERT INTO Post(PostID, Content, UserID, time)
VALUES( 12282, "THello Worldk",  4469, "2020.10.01");

INSERT INTO Post(PostID, Content, UserID, time)
VALUES( 12253, "Trump is back",  4470, "2020.09.05");

INSERT INTO Post(PostID, Content, UserID, time)
VALUES( 12255, "Trump is back",  4471, "2020.12.01");

INSERT INTO Post(PostID, Content, UserID, time)
VALUES( 12256, "Trump is back",  4472, "2020.12.08");

INSERT INTO LocationOf_r1(latitude, longitude, time, userid, postid)
VALUES (49.2606,-123.2460,"2020.09.01", 4468,12250 );

INSERT INTO LocationOf_r1(latitude, longitude, time, userid, postid)
VALUES (49.3029,-124.2302,"2020.09.01", 4469,12282  );
INSERT INTO LocationOf_r1(latitude, longitude, time, userid, postid)
VALUES (50.3029,-122.2302,"2020.09.01", 4470,12253  );
INSERT INTO LocationOf_r1(latitude, longitude, time, userid, postid)
VALUES (49.2397,-122.2302,"2020.09.01", 4471,12255  );
INSERT INTO LocationOf_r1(latitude, longitude, time, userid, postid)
VALUES (52.2783,-140.2312,"2020.09.01", 4472,12256 );

INSERT INTO LocationOf_r2(latitude, longitude, Address, userid, postid)
VALUES(49.2606,-123.2460,"UBC", 4469,12282 );
INSERT INTO LocationOf_r2(latitude, longitude, Address, userid, postid)
VALUES(49.3029,-124.2302,"Vancouver DT", 4470,12253);
INSERT INTO LocationOf_r2(latitude, longitude, Address, userid, postid)
VALUES(50.3029,-122.2302,"Surrey", 4470,12253);
INSERT INTO LocationOf_r2(latitude, longitude, Address, userid, postid)
VALUES(49.2397,-122.2302,"Langley", 4471,12255);
INSERT INTO LocationOf_r2(latitude, longitude, Address, userid, postid)
VALUES(52.2783,-140.2312,"Squamish", 4472,12256 );



-- do we really need photoIn???

-- INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
-- VALUES( ‘P12220’, ‘8775’, ‘JPEG’, ‘12250’);

-- INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
-- VALUES( ‘P12321’, ‘10028’, ‘JPEG’, ‘12252’);

-- INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
-- VALUES( ‘P12432’, ‘58082’, ‘JPEG’, ‘12871’);

-- INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
-- VALUES( ‘P18742’, ‘1008652’, ‘GIF’, ‘18752’);

-- INSERT INTO PhotoIn (PhotoID, Size, Format, PostID)
-- VALUES( ‘P16752’, ‘38062’, ‘JPEG’, ‘15658’);


INSERT INTO LikedPost(PostID, Trending, numberoflikes)
VALUES( 12250, FALSE, 2886);

INSERT INTO LikedPost(PostID, Trending, numberoflikes)
VALUES( 12282, FALSE, 4881);

INSERT INTO LikedPost(PostID, Trending, numberoflikes)
VALUES( 12253, FALSE, 13334);

INSERT INTO LikedPost(PostID, Trending, numberoflikes)
VALUES( 12255, FALSE, 98881);

INSERT INTO LikedPost(PostID, Trending, numberoflikes)
VALUES( 12256, FALSE, 23334);


INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES("Sport", "Lakers 2020 champions, will they win again next season", 12250);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES("Random", "Hello World", 12250);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES("Economic", "Bullish market 2020", 12250);

INSERT INTO TrendingTopic(TopicID, Content, PostID)
VALUES("Coding", "How to use hashmap in java", 12250);


INSERT INTO VoteFor(VoteID, time, UserID, PostID)
VALUES(44220, "2020.09.01", 4468, 12250);

INSERT INTO VoteFor(VoteID, time, UserID, PostID)
VALUES(44221, "2020.09.01", 4468, 12255);

INSERT INTO VoteFor(VoteID, time, UserID, PostID)
VALUES(44222, "2020.09.01", 4468, 12253);



INSERT INTO Comment( CommentID, UserId, PostID, time, Content)
VALUES(1, 4468, 12250, "2020.09.01", "good point!");

INSERT INTO Comment( CommentID, UserId, PostID, time, Content)
VALUES(2, 4469, 12250, "2020.09.01", "good point!");

INSERT INTO Comment( CommentID, UserId, PostID, time, Content)
VALUES(3, 4470, 12250, "22020.09.01", "good idea!");

INSERT INTO Comment( CommentID, UserId, PostID, time, Content)
VALUES(4, 4471, 12250, "2020.09.01", "good question!");

INSERT INTO Comment( CommentID, UserId, PostID, time, Content)
VALUES(5, 4472, 12250, "2020.09.01", "good discussion!");



/*INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, time)
VALUES(1,4468,1, "Hello, What other questions do you have", "18:27");

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, time)
VALUES(2,4468,1, "Hi there", "18:29");

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, time)
VALUES(3,4468,1, "Hi, have a Great day eve", "18:33");

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, time)
VALUES(4,4468,1, "hello, what is wrong e", "18:44");

INSERT INTO ReplyTo(ReplyID, UserID, CommentID, Content, time)
VALUES(5,4468,1, "hi, good nighte", "18:58");*/

INSERT INTO ReplyTo_r1(ReplyID, Content, time, UserID, CommentID)
VALUES(1, "Hello, What other questions do you have", "2020.09.01",4468,1);

INSERT INTO ReplyTo_r1(ReplyID, Content, time, UserID, CommentID)
VALUES(2, "Hi there", "2020.09.01",4468,1);

INSERT INTO ReplyTo_r1(ReplyID,Content, time, UserID, CommentID)
VALUES(3,"Hi, have a Great day eve", "2020.09.01",4468,1);

INSERT INTO ReplyTo_r1(ReplyID, Content, time, UserID, CommentID)
VALUES(4,"hello, what is wrong e", "2020.10.03",4468,1);
INSERT INTO ReplyTo_r1(ReplyID, Content, time, UserID, CommentID)
VALUES(5, "hi, good nighte", "2020.10.05",4468,1);

INSERT INTO ReplyTo_r2(ReplyID, UserID, CommentID)
VALUES(1,4468,1);
INSERT INTO ReplyTo_r2(ReplyID, UserID, CommentID)
VALUES(2,4468,1);
INSERT INTO ReplyTo_r2(ReplyID,UserID, CommentID)
VALUES(3,4468,1);
INSERT INTO ReplyTo_r2(ReplyID,UserID, CommentID)
VALUES(4,4468,1);
INSERT INTO ReplyTo_r2(ReplyID, UserID, CommentID)
VALUES(5,4468,1);



