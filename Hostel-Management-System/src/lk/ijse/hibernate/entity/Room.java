package lk.ijse.hibernate.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Room {
    @Id
    private String room_type_Id;
    private String type;
    private BigDecimal key_money;
    private int qty;
//    @OneToMany(mappedBy = "Room")
//    private Set<Reserve>reserveSet = new HashSet<>();

}
