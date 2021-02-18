package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SocialNetworkTest {
    SocialNetwork socialNetwork = new SocialNetwork();
    User user1 = new User("user1");
    Group group1 = new Group("group1", user1);
    User user2 = new User("user2", 10);
    Message message1 = new Message("Hi", "HI, you", user1);
    Message message2 = new Message("m2", "hello", user2);
    Group group2 = new Group("group1", user2);

    /**Test1*/
    @Test
    public void getGroups() {
        socialNetwork.registerGroup(group1);
        socialNetwork.registerGroup(group2);
        Set<Group> actual = socialNetwork.getGroups();
        Set<Group> expected = new HashSet<>(Arrays.asList(group1, group2));
        Assert.assertArrayEquals(new Set[]{expected}, new Set[]{actual});
    }

    /**Test2*/
    @Test
    public void getFeedForUser() {
        group1.addUser(user1);
        group2.addUser(user2);
        socialNetwork.registerGroup(group1);
        socialNetwork.registerGroup(group2);
        Feed actual = socialNetwork.getFeedForUser(user1);
        Set<Message> res = new HashSet<>(Arrays.asList(message1));
        Feed expected = new Feed(user1, res);

        Assert.assertArrayEquals(new Feed[]{actual}, new Feed[]{actual});
    }
}