package com.example.job.controllers;

import com.example.job.entities.*;
import com.example.job.forms.JobForm;
import com.example.job.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JobController extends BaseController{
    public static final int PAGE_SIZE = 10;
    @Autowired
    private JobServices jobServices;

    @Autowired
    private RequestRecruitService requestRecruitService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private JobTypeService jobTypeService;

    @Autowired
    private LevelTypeService levelTypeService;

    @Autowired
    private JobStatusService jobStatusService;

    @Autowired
    private SkillJobService skillJobService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String getHome(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("jobs",jobServices.getJobs(pageable));
        model.addAttribute("totalPage",(jobServices.getTotalJob()+PAGE_SIZE-1)/PAGE_SIZE);
        model.addAttribute("currentPage",page);
        return "home";
    }

    @GetMapping("/jobdetail/{id}")
    public String getJobDetail(Model model, @PathVariable("id") Long id){
        if(!jobServices.existsById(id)){
            return "redirect:/404";
        }
        Job job = jobServices.getJobById(id);
        model.addAttribute("job",job);
        return "jobDetail";
    }

    @GetMapping("/approval/{status}")
    public String getApproval(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @PathVariable("status") String status, @RequestParam(value = "order",defaultValue = "desc") String order){
        Pageable pageable;
        if(order.equalsIgnoreCase("asc")){
            pageable = PageRequest.of(page-1,PAGE_SIZE, Sort.by("applytime").ascending());
        } else {
            pageable = PageRequest.of(page-1,PAGE_SIZE, Sort.by("applytime").descending());
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Company company = ((MyUserDetails) principal).getUser().getCompany();
        List<RequestRecruit> recruitList;
        if(status.equalsIgnoreCase("All")){
            recruitList = requestRecruitService.findByCompany(company,pageable);
            model.addAttribute("totalPage",(requestRecruitService.getTotalRequestByCompany(company)+PAGE_SIZE-1)/PAGE_SIZE);
        } else {
            Status s = statusService.getByName(status);
            recruitList = requestRecruitService.findByCompanyAndStatus(company,s,pageable);
            model.addAttribute("totalPage",(requestRecruitService.getTotalRequestByCompanyAndStatus(company,s)+PAGE_SIZE-1)/PAGE_SIZE);
        }
        model.addAttribute("recruitList",recruitList);
        model.addAttribute("currentPage",page);
        model.addAttribute("statusList",statusService.getAll());
        model.addAttribute("currentFilter",status);
        model.addAttribute("currentOrder",order);
        return "approval";
    }

    @GetMapping("/findJob/{search}")
    public String getFindJob(Model model, @RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "filter",defaultValue = "1234") String filter, @PathVariable("search") String search){
        int totalPage;
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        List<JobType> jobTypeList = jobTypeService.getAll();
        List<Long> filters = new ArrayList<>();
        for (JobType jobType : jobTypeList) {
            if(filter.contains(jobType.getId().toString())){
                filters.add(jobType.getId());
            }
        }
        if(search.equalsIgnoreCase("all")){
            model.addAttribute("jobs",jobServices.getJobsByFilter(filters,pageable));
            totalPage  = (jobServices.getTotalJobByFilter(filters)+PAGE_SIZE-1)/PAGE_SIZE;
        } else {
            model.addAttribute("jobs",jobServices.findJobByKeyword(search.toLowerCase(),filters,pageable));
            totalPage  = (jobServices.getTotalJobByKeyword(search.toLowerCase(),filters)+PAGE_SIZE-1)/PAGE_SIZE;
        }
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("jobTypes",jobTypeList);
        model.addAttribute("currentPage",page);
        model.addAttribute("search",search);
        return "findJob";
    }

    @GetMapping("/createJob")
    public String getCreateJob(Model model){
        model.addAttribute("job",new JobForm());
        model.addAttribute("jobTypeList",jobTypeService.getAll());
        model.addAttribute("levelTypeList",levelTypeService.findAll());
        return "createJob";
    }

    @PostMapping("/createJob")
    public String postCreateJob(@Valid @ModelAttribute("job") JobForm job, BindingResult bindingResult, Model model) throws ParseException {
        if(job.getSkillNameList().get(0).equalsIgnoreCase("")){
            bindingResult.rejectValue("skillNameList","error.job","Kỹ năng không được để trống");
        }
        if(job.getSkillExperienceList().get(0).equalsIgnoreCase("")){
            bindingResult.rejectValue("skillExperienceList","error.job","Kỹ năng không được để trống");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("jobTypeList",jobTypeService.getAll());
            model.addAttribute("levelTypeList",levelTypeService.findAll());
            return "createJob";
        }
        JobStatus jobStatus = jobStatusService.getById(1L);
        JobType jobType = jobTypeService.getById(job.getJobTypeId());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Company company = ((MyUserDetails) principal).getUser().getCompany();
        Job job1 = jobServices.createJob(job,jobStatus,company,jobType);
        List<SkillJob> skillJobList = new ArrayList<>();
        for(int i=0;i<job.getSkillExperienceList().size();i++){
            skillJobList.add(new SkillJob(job.getSkillNameList().get(i),levelTypeService.getById(Long.parseLong(job.getSkillExperienceList().get(i))),job1));
        }
        skillJobService.addSKillJobList(skillJobList);
        return "redirect:/";
    }

    @GetMapping("/editCompanyInfor")
    public String getEditCompanyInfor(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Company company = ((MyUserDetails) principal).getUser().getCompany();
        model.addAttribute("company",company);
        return "editCompanyInfor";
    }

    @PostMapping("/editCompanyInfor")
    public String postEditComapnyInfor(@RequestParam("imageCompany") MultipartFile image, @Valid @ModelAttribute("company") Company company, BindingResult bindingResult) throws IOException {
        if(!image.isEmpty()){
            String fileName =company.getId().toString()+"company" + image.getOriginalFilename();
            String oldFileName = companyService.getImage(company.getId());
            if (!fileName.contains(".jpg") && !fileName.contains(".png")) {
                bindingResult.rejectValue("image","error.image","File invalid");
            }
            else {
                if(!oldFileName.equals("company.png")){
                    Path oldImagePath = Paths.get("src/main/resources/static/image/" + oldFileName);
                    Files.delete(oldImagePath);
                }
                companyService.setImageForCompany(company,fileName);
                Path imagePath = Paths.get("src/main/resources/static/image/" + fileName);
                Files.write(imagePath, image.getBytes());
            }
        }
        if(bindingResult.hasErrors()){
            return "editCompanyInfor";
        }
        companyService.editCompany(company);
        return "redirect:/company/"+company.getId();
    }
    @GetMapping("/company/{id}")
    public String getCompany(Model model, @PathVariable("id") Long id){
        Company company = companyService.getById(id);
        model.addAttribute("company",company);
        return "company";
    }
}
