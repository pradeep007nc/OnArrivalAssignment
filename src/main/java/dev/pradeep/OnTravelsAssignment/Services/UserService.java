package dev.pradeep.OnTravelsAssignment.Services;

import dev.pradeep.OnTravelsAssignment.Entity.Location;
import dev.pradeep.OnTravelsAssignment.Entity.LocationEntites.Feature;
import dev.pradeep.OnTravelsAssignment.Entity.User;
import dev.pradeep.OnTravelsAssignment.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    private LocationService locationService;

    public UserService(UserRepository repository, LocationService locationService){
        this.locationService = locationService;
        this.repository = repository;
    }


    public boolean addUser(User user){
        Optional<User> data = repository.findById(user.getName());
        if (data.isEmpty()){
            repository.save(user);
            return true;
        }
        return false;
    }

    /*
     delete a user
     takes a parameter userId
     */
    public boolean deleteUser(String id){
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            repository.delete(user.get());
            return true;
        }
        return false;
    }

    /*
        Fetching all users
     */
    public List<User> fetchAllUsers(){
        return this.repository.findAll();
    }

    /*
        saving individual location(feature/particular location) in a user object
        takes parameter feature id
     */
    public boolean saveSpotsForUser(String userName, Location location, String featureId){
        Optional<User> data = repository.findById(userName);
        if (data.isPresent()){
            for (Feature feature: location.getFeatures()){
                //checking for features
                if (feature.getId().equals(featureId)){
                    //for that user object add the particular feature
                    data.get().addLocations(feature);
                }
            }
            return true;
        }
        return false;
    }

    public void deleteAllUsers(){
        this.repository.deleteAll();
    }



}
