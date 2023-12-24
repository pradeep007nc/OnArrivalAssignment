package dev.pradeep.OnTravelsAssignment.Services;

import dev.pradeep.OnTravelsAssignment.Dto.BookingLocationDto;
import dev.pradeep.OnTravelsAssignment.Dto.LocationDto;
import dev.pradeep.OnTravelsAssignment.Entity.Location;
import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnTravelsAssignment.Entity.User;
import dev.pradeep.OnTravelsAssignment.Repository.LocationRepository;
import dev.pradeep.OnTravelsAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*
    user services for crud users operations
 */
/*
    add user is already existing in signup
    just adding fetch all users delete users and other crud related operations
*/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationService locationService;

    /*
        fetch all users
     */
    public List<User> fetchAllUsers(){
        return this.userRepository.findAll();
    }

    /*
        update user by id
     */
    public void updateUserById(User user){
        Optional<User> userData = this.userRepository.findById(user.getUserName());

        if (userData.isPresent()){
            User dummyUser = userData.get();
            dummyUser.setUserName(user.userName);
            dummyUser.setUserAddress(user.userAddress);
            this.userRepository.save(dummyUser);
        }

    }

    /*
        delete user by id
     */
    public void deleteUserById(String userId){
        Optional<User> userData = this.userRepository.findById(userId);
        if (userData.isPresent()){
            this.userRepository.delete(userData.get());
        }
    }

    /*
        get user by id
     */
    public User fetchUserById(String userId){
        Optional<User> userData = this.userRepository.findById(userId);
        if (userData.isPresent()){
            return userData.get();
        }
        return null;
    }






}
