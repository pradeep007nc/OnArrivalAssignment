package dev.pradeep.OnTravelsAssignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    public String email;
    public String password;
    public String userName;
    public String userAddress;
}
