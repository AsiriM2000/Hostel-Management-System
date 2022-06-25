package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reserve {
    @Id
    private String res_Id;
    private Date date;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Room room;
    private String status;

}
