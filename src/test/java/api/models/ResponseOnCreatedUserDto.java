package api.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOnCreatedUserDto {
        public String full_name;
        public String email;
        public Object magic_link;
        public String created;
        public String updated;
}
