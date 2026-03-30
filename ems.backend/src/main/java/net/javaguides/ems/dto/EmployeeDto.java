package net.javaguides.ems.dto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private  Long departmentId;

}
