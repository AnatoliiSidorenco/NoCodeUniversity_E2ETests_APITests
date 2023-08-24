package api.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DeleteUserDto {
    String code;
    String message;
    String instance;
    Object status;
    Object title;
    Object type;
    Object source;

}
