package net.javaguides.ems.dto;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto
{
    private Long id;
    private String departmentName;
    private String departmentDescription;

}
