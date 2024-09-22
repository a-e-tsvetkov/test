package hello.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_owner")
public class ItemOwner {

    @Id
    private Long id;


//    @JdbcType(JdbcType.)
@JdbcTypeCode(SqlTypes.JSON)
    private JsonNode j;

}
