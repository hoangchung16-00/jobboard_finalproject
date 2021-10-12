package com.example.jobboard_final.entities;
import com.sun.naming.internal.FactoryEnumeration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "job")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    private int Id;
    private String Name;
    private String ShortDescription;
    private String Description;
    private String Address;
    private int Number;
    private BigDecimal MinSalary;
    private BigDecimal MaxSalary;
    private Date ExpireDate;
    private Date PostDate;
    @ManyToOne
    @JoinColumn(name = "JobStatusId")
    private JobStatus jobStatus;
    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "JobTypeId")
    private JobType jobType;
    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<SkillJob> skillJobList;
    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<Benefit> benefitList;
    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<RequestRecruit> requestRecruitList;

    public Job(String name, String shortDescription, String description, String address, int number, BigDecimal minSalary, BigDecimal maxSalary, Date expireDate, Date postDate, JobStatus jobStatus, Company company, JobType jobType, List<SkillJob> skillJobList, List<Benefit> benefitList, List<RequestRecruit> requestRecruitList) {
        Name = name;
        ShortDescription = shortDescription;
        Description = description;
        Address = address;
        Number = number;
        MinSalary = minSalary;
        MaxSalary = maxSalary;
        ExpireDate = expireDate;
        PostDate = postDate;
        this.jobStatus = jobStatus;
        this.company = company;
        this.jobType = jobType;
        this.skillJobList = skillJobList;
        this.benefitList = benefitList;
        this.requestRecruitList = requestRecruitList;
    }
}
