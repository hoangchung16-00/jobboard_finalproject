package com.example.jobboard_final.forms;

import com.example.jobboard_final.entities.SkillUsers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EditProfileForm {
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    private String name;
    @NotBlank(message = "SĐT không được để trống")
    private String phonenumber;
    @NotBlank(message = "Email không được để trống")
    private String email;
    @NotBlank(message = "Địa chỉ không được để trống")
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
