package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        System.out.println("JObController " + jobName + "  atef " + jobEmployer + jobLocation + jobPositionType+ jobCoreCompetency);


        return "job-detail";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        System.out.println("Jobcontroller Shows up when accessing add ddddddddddddd ");
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors
//                      @RequestParam String name,  //it appears not of these request params are needed
//                      @RequestParam String employerId,
//                      @RequestParam String locationId,
//                      @RequestParam String positionTypeId,
//                      @RequestParam String coreCompetencyId
    )     {


        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.
        //jobForm is unvestigation

        if (errors.hasErrors()){
            System.out.println(" error for some reason" );
            return "new-job";
        }

        ////this is the stuped lin that took me forever to get
        Job newJob = new Job(jobForm.getName(),jobForm.getEmployer(), jobForm.getLocation(), jobForm.getPositionType(), jobForm.getCoreCompetency());
        jobData.add(newJob); //This is needed to add the job. Need to figure out how to make it array-like

        //System.out.println("Jobcontroller Shows up on add--- nacho = "+  " n= " + name );
        //System.out.println(" E= " + jobForm +" L= "  + " P= " + positionTypeId +  " C= " + coreCompetencyId);
        //System.out.println(" n= " + name  + "E= " + emp +" L= " + loc + " P= " + posType +  " C= " + coreComp);
        System.out.println(" added" );
        return "redirect:/job?id=" +newJob.getId();
        //return "new-job";

    }
}
