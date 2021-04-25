# cpsc304

![image](https://user-images.githubusercontent.com/43102997/115989239-4c4e8080-a572-11eb-90c9-d8cdea3b02ec.png)



The domain that we are going to model is like a Reddit-like posting system with the addition of location tagging feature (social media). We will be focusing on the data that is posted by different users. 
	We will focus on the users and posts of this social media community. This includes things like the user information (eg. The user’s name, email and other private info), what posts they have posted, what posts they have saved. There will be subcategories for different types of posts to let users browse more efficiently (eg. posts with the same hashtags will be grouped together, while hot topics will include the trending posts). Moreover, each post will include a geotag that shows the location when it was posted (eg. the longitude and latitude and an option to check out the location on google maps). There will be another entity called reply for existing comments on a post, which then acts as a weak entity. 
	There will be two different classes of accounts of the system: the administrators and the users. The administrators will be able to manage posts, comments, replies, and the categorizing of a post. They will also be able to remove posts from a certain category and censor offensive comments or inappropriate posts. In addition, they can reset usernames and passwords depending on the administrator’s access level. The user will be able to access their favourite posts, comment on posts, and upvote/downvote posts.  
	The benefits that the database will bring to our application are: reduced runtime, clearer logic flow of how data is related, and easier for developers to organise data. Moreover, by implementing a database, we can reduce data redundancy, thus saving memory. We can reduce updating errors, thus increasing correctness and consistency. We can improve data security by implementing an end-to-end authentication.
	We are not planning on using any hardware. For our technology stack, we are planning on using Java and JDBC for our database implementation. 

