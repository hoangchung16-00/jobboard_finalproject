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
    private Long id;
    private String name;
    private String shortdescription;
    private String description;
    private String address;
    private int number;
    private BigDecimal minsalary;
    private BigDecimal maxsalary;
    private Date expiredate;
    private Date postdate;
    @ManyToOne
    @JoinColumn(name = "jobstatusid")
    private JobStatus jobStatus;
    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "jobtypeid")
    private JobType jobType;
    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<SkillJob> skillJobList;
    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<Benefit> benefitList;
    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<RequestRecruit> requestRecruitList;

    public Job(String name, String shortdescription, String description, String address, int number, BigDecimal minsalary, BigDecimal maxsalary, Date expiredate, Date postdate, JobStatus jobStatus, Company company, JobType jobType, List<SkillJob> skillJobList, List<Benefit> benefitList, List<RequestRecruit> requestRecruitList) {
        this.name = name;
        this.shortdescription = shortdescription;
        this.description = description;
        this.address = address;
        this.number = number;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.expiredate = expiredate;
        this.postdate = postdate;
        this.jobStatus = jobStatus;
        this.company = company;
        this.jobType = jobType;
        this.skillJobList = skillJobList;
        this.benefitList = benefitList;
        this.requestRecruitList = requestRecruitList;
    }
}
