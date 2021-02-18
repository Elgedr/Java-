
package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Group {
    private String groupName;
    private User chatCreator;
    private Set<User> users = new HashSet<>(Arrays.asList(chatCreator));
    private List<Message> publishedMessages = new LinkedList<>();

    public Group(String name, User owner) {
        this.groupName = name;
        this.chatCreator = owner;
    }

    public String getName() {
        return this.groupName;
    }

    public void setName(String name) {
        this.groupName = name;
    }

    public User getOwner() {
        return this.chatCreator;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Set<User> getParticipants() {
        return this.users;
    }

    public void publishMessage(Message message) {
        if (users.contains(message.getAuthor())){
            publishedMessages.add(message);
        }
    }

    public List<Message> getMessages() {
        return publishedMessages;
    }
}