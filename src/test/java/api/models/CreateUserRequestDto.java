package api.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateUserRequestDto {
    String full_name;
    String email;
    String password;
    Boolean generate_magic_link;
}
