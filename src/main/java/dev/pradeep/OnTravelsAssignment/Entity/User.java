package dev.pradeep.OnTravelsAssignment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.pradeep.OnTravelsAssignment.Dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    public String email;
    public String password;
    public String userName;
    public String userAddress;




}
