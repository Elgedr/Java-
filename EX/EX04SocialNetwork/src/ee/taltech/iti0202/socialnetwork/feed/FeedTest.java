package ee.taltech.iti0202.socialnetwork.feed;


import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FeedTest {
    User user1 = new User("user1", 10);
    Message message1 = new Message("title1", "content1", user1);
    Set<Message> fin = new HashSet<>(Arrays.asList(message1));
    Feed feedd = new Feed(user1, fin);

    /**Test1*/
    @org.junit.Test
    public void getUser() {
        User actual = feedd.getUser();
        User expected = user1;
        Assert.assertEquals(expected, actual);
    }

    /**Test2*/
    @org.junit.Test
    public void getMessages() {
        Set<Message> actual = feedd.getMessages();
        Set<Message> exp = new HashSet<>(Arrays.asList(message1));
        Assert.assertArrayEquals(new Set[]{exp}, new Set[]{actual});
    }
}
