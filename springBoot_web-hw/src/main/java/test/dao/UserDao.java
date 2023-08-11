package test.dao;

import org.springframework.stereotype.Repository;
import test.model.User;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserDao {
private List<User> users;
    {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("James","Doe","123","JD@mail.com"));
        users.add(new User("Judy","Doe","1234","JD@mail.com"));
        users.add(new User("James","Smith","12345","JS@mail.com"));
        users.add(new User("Mike","Vazovski","123456","MV@mail.com"));
    }
    public List<User> showAll() {
        return users;
    }
    public void create(User user){
        users.add(user);
    }

    public User getUser(int id) {
        if (id>= users.size()) {
            return null;
        }
        return users.get(id);
    }

    public void update(int id, User user) {
        User updateUser = getUser(id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        updateUser.setEmail(user.getEmail());
    }
}
