package database.com.book.entity;

import database.com.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends Entity {
    private String name;
    private String category;
    private BigDecimal amount;
}
