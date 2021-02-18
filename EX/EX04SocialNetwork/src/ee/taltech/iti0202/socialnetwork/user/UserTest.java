package ee.taltech.iti0202.socialnetwork.user;

import org.junit.Assert;

public class UserTest {

    /**Test1*/
    @org.junit.Test
    public void getName() {
        User user1 = new User("user1", 10);
        String actual = user1.getName(); // user1
        Assert.assertEquals("user1", actual);

    }

    /**Test2*/
    @org.junit.Test
    public void getAge() {
        User user1 = new User("user1", 10);
        int actual = user1.getAge(); // 10
        Assert.assertEquals(10, actual);
    }
}