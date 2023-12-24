package dev.pradeep.OnArrivalAssignment.Controller;

import dev.pradeep.OnArrivalAssignment.Entity.User;
import dev.pradeep.OnArrivalAssignment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
    users controller
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*
        fetch existing users
     */
    @GetMapping("/fetch_all_users")
    public ResponseEntity<List<User>> fetchAllUsers(){
        return ResponseEntity.status(200).body(userService.fetchAllUsers());
    }

    /*
        fetch particular user
     */
    @GetMapping("/fetch_user/{userId}")
    public ResponseEntity<User> fetchUser(@PathVariable String userId){
        return ResponseEntity.status(200).body(userService.fetchUserById(userId));
    }

    /*
        delete user based on id
     */
    @DeleteMapping("/delete_user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        this.userService.deleteUserById(userId);
        return ResponseEntity.status(200).body("successfully deleted");
    }

    /*
        update user by id
     */
    @PostMapping("/update_user/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable User user){
        this.userService.updateUserById(user);
        return ResponseEntity.status(200).body("successfully updated");
    }

}
