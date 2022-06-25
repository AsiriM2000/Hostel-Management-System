package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String student_Id;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;
//    @OneToMany(mappedBy = "Student",cascade = CascadeType.ALL)
//    private Set<Reserve> reserveSet = new HashSet<>();

}
