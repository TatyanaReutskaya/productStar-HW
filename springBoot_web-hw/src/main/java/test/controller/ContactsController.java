package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.dao.UserDao;
import test.model.User;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    private UserDao userDao;
    @Autowired
    public ContactsController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public List<User> test(){
        return userDao.showAll();
    }
    @PostMapping()
    public void create(@RequestBody User user) {
        userDao.create(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return userDao.getUser(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User user) {
        userDao.update(id,user);
    }

}
