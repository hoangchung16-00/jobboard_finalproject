package com.example.jobboard_final.forms;

import com.example.jobboard_final.entities.SkillUsers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EditProfileForm {
    private Long id;
    private String name;
    private String phonenumber;
    private String email;
    private String address;
    private String dob;
    private String education;
    private String description;
    private String hobby;
    private String gender;
    private String image;
    private List<String> skillNameList;
    private List<String> skillExperienceList;
    private List<Long> skillIdList;
}
