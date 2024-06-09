package org.lld.medium;

public class SocialNetworkingDemo {
    public static void main(String[] args) {


        SocialNetworkingService service = SocialNetworkingService.getInstance();

        // Register users
        User alice = service.registerUser("1", "Alice", "alice@example.com", "password");//TODO
        User debnath = service.registerUser("2", "Debnath", "debnath@433.com", "1234");
        // login users
        User loggedInAlice = service.loginUser("alice@example.com", "password");
        User loggedInDebnath = service.loginUser("debnath@433.com", "123");


        //update their profile information.
        service.updateUserProfile("1", "profile_pic_alice.jpg", "123");
        service.updateUserProfile("2", "profile_pic_Debanth.jpg", "Aspiring java developer");



        service.sendFriendRequest(alice.getId(), debnath.getId());//TODO

        service.acceptFriendRequest(alice.getId(), debnath.getId());//TODO



    }
}
