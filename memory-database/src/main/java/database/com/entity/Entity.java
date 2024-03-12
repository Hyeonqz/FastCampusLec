package database.com.entity;

import lombok.Getter;
import lombok.Setter;

public abstract class Entity implements PrimaryKey{
    @Getter
    @Setter
    private Long id;

}
