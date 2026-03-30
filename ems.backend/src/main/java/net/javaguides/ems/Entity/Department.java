package net.javaguides.ems.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="department")
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Dep_Name")
    private  String departmentName;
    @Column(name = "Dep_Desc")
    private String departmentDescription;

}
