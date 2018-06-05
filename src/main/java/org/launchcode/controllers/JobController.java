package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {
        System.out.println(id + "Jobcontroller ------- /job?id=17fffffffjob-detail templatef ");
        // TODO #1 - get the Job with the given ID and pass it into the view

        Job someJobV = jobData.findById(id); // creating a variable  G

        // doing nothing now---  someJobV.getCoreCompetency().getValue(); //get core copetency is a clase

        String jobName = someJobV.getName();        // passes part to a vairable g2
        Employer jobEmployer = someJobV.getEmployer();
        Location jobLocation = someJobV.getLocation();
        PositionType jobPositionType = someJobV.getPositionType();
        CoreCompetency jobCoreCompetency = someJobV.getCoreCompetency();

        //model.addAttribute("view_item_veraible", contorller_item_variable);
        model.addAttribute("name", jobName);
        model.addAttribute("employer", jobEmployer);
        model.addAttribute("location", jobLocation);
        model.addAttribute("positionType", jobPositionType);
        model.addAttribute("coreCompetency", jobCoreCompetency);

        System.out.println(someJobV.toString() + "XXX  " + jobName + "  job nob job asdffffffffffdetail templatef " + jobEmployer + jobLocation + jobPositionType+ jobCoreCompetency);


        return "job-detail";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        System.out.println("Jobcontroller Shows up when accessing add ddddddddddddd ");
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors,
                      @RequestParam String name,
                      @RequestParam String employerId,
                      @RequestParam String locationId,
                      @RequestParam String coreCompetencyId,
                      @RequestParam String positionTypeId) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.

        System.out.println("Jobcontroller shows up -------------------   n= " + name  + " E= " + employerId +" L= " + locationId + " P= " + positionTypeId +  " C= " + coreCompetencyId);
        return "new-job";

    }
}
