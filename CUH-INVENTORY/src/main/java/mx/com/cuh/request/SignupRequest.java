package mx.com.cuh.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;
}
