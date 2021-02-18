package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SocialNetwork {
    private Set<Group> registeredGroups;
    private Feed feed;

    public void registerGroup(Group group) {
        registeredGroups.add(group);
    }

    public Set<Group> getGroups() {
        return this.registeredGroups;
    }

    public Feed getFeedForUser(User user) {
        Set<Message> groupMessages = new HashSet<>();
        for (Group group: this.registeredGroups){
            for (User userr: group.getParticipants()){
                if (userr == user){
                    groupMessages.addAll(group.getMessages());
                }
            }
        }
        return new Feed(user, groupMessages);
    }
}
