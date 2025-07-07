package linkedlist;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    Set<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new HashSet<>();
    }
}

class SocialMedia {
    private User head = null;

    public void addUser(int id, String name, int age) {
        User u = new User(id, name, age);
        u.next = head;
        head = u;
    }

    public void addFriend(int id1, int id2) {
        User u1 = find(id1);
        User u2 = find(id2);
        if (u1 != null && u2 != null) {
            u1.friends.add(id2);
            u2.friends.add(id1);
        }
    }

    public void removeFriend(int id1, int id2) {
        User u1 = find(id1);
        User u2 = find(id2);
        if (u1 != null && u2 != null) {
            u1.friends.remove(id2);
            u2.friends.remove(id1);
        }
    }

    public void displayFriends(int id) {
        User u = find(id);
        if (u != null) {
            System.out.println("Friends of " + u.name + ": " + u.friends);
        }
    }

    public void searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) System.out.println(temp.userId + ", " + temp.age);
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        User u = find(id);
        if (u != null) System.out.println(u.name + ", " + u.age);
    }

    public void mutualFriends(int id1, int id2) {
        User u1 = find(id1);
        User u2 = find(id2);
        if (u1 != null && u2 != null) {
            Set<Integer> mutual = new HashSet<>(u1.friends);
            mutual.retainAll(u2.friends);
            System.out.println("Mutual Friends: " + mutual);
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + ": " + temp.friends.size());
            temp = temp.next;
        }
    }

    private User find(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaFriendManager {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 21);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.displayFriends(1);
        sm.mutualFriends(2, 3);
        sm.countFriends();
    }
}
