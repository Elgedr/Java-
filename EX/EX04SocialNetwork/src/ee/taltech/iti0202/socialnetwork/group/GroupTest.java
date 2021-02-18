package ee.taltech.iti0202.socialnetwork.group;


import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupTest {
    User user1 = new User("user1", 10);
    User user2 = new User("user2", 15);
    Group gr1 = new Group("G1",user1);
    Message m1 = new Message("M1", "Hiii", user2);


    @org.junit.Test
    public void getName() {
        gr1.setName("G2");
        String actual = gr1.getName();
        String expected = "G2";
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void setName() {
    }

    @org.junit.Test
    public void getOwner() {
        User actual = gr1.getOwner();
        User expected = user1;
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void addUser() {
    }

    @org.junit.Test
    public void getParticipants() {
        gr1.addUser(user2);
        Set<User> res = gr1.getParticipants();
        Set<User> expected = new HashSet<>(Arrays.asList(user1, user2));
        Assert.assertArrayEquals(new Set[]{expected}, new Set[]{res});


    }

    @org.junit.Test
    public void publishMessage() {
    }

    @org.junit.Test
    public void getMessages() {
        gr1.addUser(user2);
        gr1.publishMessage(m1);
        List<Message> res = gr1.getMessages();
        List<Message> expected = new ArrayList<>(Arrays.asList(m1));
        Assert.assertArrayEquals(new List[]{expected}, new List[]{res});
    }
}