package com.example.jobboard_final.forms;

import com.example.jobboard_final.entities.JobType;
import com.example.jobboard_final.entities.LevelType;
import com.example.jobboard_final.entities.SkillJob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobForm {
    private Long id;
    private String name;
    private String shortdescription;
    private String description;
    private String address;
    private int number;
    private BigDecimal minsalary;
    private BigDecimal maxsalary;
    private String expiredate;
    private String benefit;
    private Long jobTypeId;
    private List<String> skillNameList;
    private List<String> skillExperienceList;
}
