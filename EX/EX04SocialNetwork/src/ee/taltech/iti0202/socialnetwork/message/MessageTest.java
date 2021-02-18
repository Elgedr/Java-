package ee.taltech.iti0202.socialnetwork.message;

import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.Assert;


public class MessageTest {
    User user1 = new User("user1", 10);
    Message message1 = new Message("title1", "content1", user1);

    /**Test1*/
    @org.junit.Test
    public void getTitle() {
        String title = message1.getTitle(); // title1
        Assert.assertEquals("title1", title);
    }

    /**Test2*/
    @org.junit.Test
    public void getMessage() {
        String content = message1.getMessage(); // content1
        Assert.assertEquals("content1", content);

    }

    /**Test3*/
    @org.junit.Test
    public void getAuthor() {
        User author = message1.getAuthor(); // user1
        Assert.assertEquals(user1, author);
    }
}
