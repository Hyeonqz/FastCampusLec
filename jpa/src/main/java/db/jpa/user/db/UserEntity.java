package db.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="user")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment 시키는 것
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
