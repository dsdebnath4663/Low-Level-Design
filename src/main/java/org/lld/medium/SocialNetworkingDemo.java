package org.lld.medium;

import java.util.List;

public class SocialNetworkingDemo {
    public static void main(String[] args) {


        SocialNetworkingService service = SocialNetworkingService.getInstance();

        // Register users
        User alice = service.registerUser("1", "Alice", "alice@example.com", "password");//TODO
        User debnath = service.registerUser("2", "Debnath", "debnath@433.com", "1234");
        User rocky = service.registerUser("3", "Rocky", "Rocky@433.com", "1234");

        // login users
        User loggedInAlice = service.loginUser("alice@example.com", "password");
        User loggedInDebnath = service.loginUser("debnath@433.com", "1234");
        User loggedInRocky = service.loginUser("Rocky@433.com", "1234");

        //update their profile information.
        service.updateUserProfile("1", "profile_pic_alice.jpg", "123");
        service.updateUserProfile("2", "profile_pic_Debanth.jpg", "Aspiring java developer");


        service.sendFriendRequest(alice.getId(), debnath.getId());//TODO
        service.sendFriendRequest(alice.getId(), rocky.getId());//TODO

        service.acceptFriendRequest(alice.getId(), debnath.getId());//TODO
        service.acceptFriendRequest(alice.getId(), rocky.getId());//TODO

        Post alicePost = service.createPost(alice.getId(), "this is the good network ");
//        Post alicePost2 = service.createPost(alice.getId(), " new message  ");
        Post debnathPost = service.createPost(debnath.getId(), " Rex send a friend request ");
        Post rockyPost = service.createPost(rocky.getId(), " Kunal liked your new post  ");
        //news feed for alice
      //  List<Post> getNewsfeed  = service.getNewsfeed(alice.getId());
//news feed for rocky
        List<Post> getNewsfeedForRocky  = service.getNewsfeed(rocky.getId());


        System.out.println("-----Contents:---");
        for (Post post:getNewsfeedForRocky) {
            System.out.println("User: "+post.getUserId()+" Content: "+post.getContent());
        }
    }

}
