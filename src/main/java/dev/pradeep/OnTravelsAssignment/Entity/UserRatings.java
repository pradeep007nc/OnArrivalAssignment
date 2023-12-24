package dev.pradeep.OnTravelsAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "UserRatings")
public class UserRatings {

    @Id
   public String userId;

   public String locationId;

   public float ratings;

}
