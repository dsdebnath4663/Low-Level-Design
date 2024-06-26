package org.lld.medium;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SocialNetworkingService {

    private static SocialNetworkingService instance;
    private final Map<String, User> userCollection;
    private final Map<String, Notification> notificationMap;
    private final Map<String, Post> postMap;


    SocialNetworkingService() {
        userCollection = new ConcurrentHashMap<>();
        notificationMap = new ConcurrentHashMap<>();
        postMap = new ConcurrentHashMap<>();
    }

    public synchronized static SocialNetworkingService getInstance() {
        if (instance == null) {
            instance = new SocialNetworkingService();
        }
        return instance;
    }

    public User registerUser(String id, String name, String email, String password) {
        User user = new User(id, name, email, password);
        userCollection.put(id, user);
        System.out.println("Registration done for :" + user.getEmail());
        return user;
    }

    public User loginUser(String email, String password) {
        for (User user : userCollection.values()) {

            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                System.out.println("Login successfully for :" + user.getEmail());

                return user;
            }

        }
        System.out.println("Login failed for :" + email);

        return null;

    }

    public void updateUserProfile(String id, String profilePicture, String bio) {
        User user = userCollection.get(id);
        if (user != null) {
            user.setProfilePicture(profilePicture);
            user.setBio(bio);
            //update user obj to userCollection hashmap
            userCollection.put(id, user);


            User updateUserObj = userCollection.get(id);
            System.out.println("Update user obj is " + updateUserObj.toString());

        }

    }


    public void sendFriendRequest(String userId, String friendId) {
        User user = userCollection.get(userId);
        User friend = userCollection.get(friendId);

        if (user != null && friend != null) {

            // Assuming a simple notification for friend request
            Notification notification = new Notification(generateId(), userId, NotificationType.FRIEND_REQUEST, user.getName() + " send a friend request", String.valueOf(System.currentTimeMillis()));
            notificationMap.put(notification.getId(), notification);
            System.out.println(user.getName() + " send a friend request");
        }

    }

    public void acceptFriendRequest(String userId, String friendId) {
        User user = userCollection.get(userId);
        User friend = userCollection.get(friendId);

        if (user != null && friend != null) {
            user.addFriend(friend);
            friend.addFriend(user);

            // Notify friend request accepted
            Notification notification = new Notification(generateId(),
                    friendId,
                    NotificationType.FRIEND_REQUEST_ACCEPTED,
                    friend.getName() + " accepted  your friend request", String.valueOf(System.currentTimeMillis()));
            notificationMap.put(notification.getId(), notification);
            System.out.println(friend.getName() + " accepted your friend request");
        }

    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public Post createPost(String userId, String content) {
        Post post = new Post();
        User user = userCollection.get(userId);

        if (userId != null && content != null) {
            post = new Post(generateId(), userId, content, System.currentTimeMillis());
            postMap.put(post.getId(), post);
            user.addPost(post);

            System.out.println(user.getName() + " created a post ");

        }
        return post;
    }

    public List<Post> getNewsfeed( String userId) {
        User user = userCollection.get(userId);
        List<Post> newsFeed = new CopyOnWriteArrayList<>();
        if(user!=null){
      //      System.out.println("Friends Object's are: "+user.getFriends());

            for (User friend: user.getFriends()) {
         //       System.out.println("Friends name's are : "+friend.getName());
       //         System.out.println("Friends post's are : "+friend.getPosts());

                List<Post>  friendPost = friend.getPosts();
                newsFeed.addAll(friendPost);
            }

         //   System.out.println("user.getPosts():"+user.getPosts());
            List<Post>  userPost = user.getPosts();
            newsFeed.addAll(userPost);
            newsFeed.sort((p1, p2) -> Long.compare(p2.getTimestamp(), p1.getTimestamp()));
        }
        System.out.println(newsFeed);
        return newsFeed;

    }

    public  void likePost(String userId,String postId){
        Post post = postMap.get(postId);
        if(post !=null ){
            User user= userCollection.get(userId);
            post.addLikes(user);


            Notification qnotification = new Notification(generateId(),
                    userId,
                    NotificationType.LIKE,
                    user.getName() + " Liked your  post ",
                    String.valueOf(System.currentTimeMillis()));

            System.out.println(user.getName()+"liked on ******"+post.getContent()+"********");

        }


    }
    public void commentOnPost (String userId, String postId, String content){
        Post post = postMap.get(postId);
        if (post!= null){
            Comment comment = new Comment(generateId(),
                    userId,
                    postId,
                    content,
                    String.valueOf(System.currentTimeMillis()));
            post.addComment(comment);

//Notify that user has commented on a post
            User user = userCollection.get(userId);
            Notification notification = new Notification(generateId(),
                    userId,
                    NotificationType.COMMENT,
                    user.getName()+" Commented your post",
                    String.valueOf(System.currentTimeMillis()));
            notificationMap.put(notification.getId(),notification);

            System.out.println(user.getName()+" commented: "+content+" on post: "+post.getContent());
        }
    }
    //getNotifications
    public List<Notification> getNotifications( String userId) {
        User user = userCollection.get(userId);
        List<Notification> userNotifictions = new CopyOnWriteArrayList<>();
        if(user!=null){
            for (Notification notification: notificationMap.values()) {

                userNotifictions.add(notification);
                System.out.println("Notification :"+notification.toString());
            }
        }

        return userNotifictions;

    }
}
