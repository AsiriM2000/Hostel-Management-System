package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserve {
    @Id
    private String res_Id;
    private Date date;
    private String status;

    @ManyToMany
    private Student student_Id;
    @ManyToMany
    private Room room_type_Id;
}
