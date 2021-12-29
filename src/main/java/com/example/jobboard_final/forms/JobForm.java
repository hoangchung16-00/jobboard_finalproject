package com.example.jobboard_final.forms;

import com.example.jobboard_final.entities.JobType;
import com.example.jobboard_final.entities.LevelType;
import com.example.jobboard_final.entities.SkillJob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobForm {
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    private String name;
    private String shortdescription;
    @NotBlank(message = "Mô tả không được để trống")
    private String description;
    @NotBlank(message = "Địa chỉ làm việc không được để trống")
    private String address;
    @Min(value = 1,message = "Số lượng không hợp lệ")
    private int number;
    private BigDecimal minsalary;
    private BigDecimal maxsalary;
    private String expiredate;
    private String benefit;
    private Long jobTypeId;
    @NotEmpty(message = "Kỹ năng không được để trống")
    private List<String> skillNameList;
    @NotEmpty(message = "Kỹ năng không được để trống")
    private List<String> skillExperienceList;
}
