package org.launchcode.controllers;

import org.launchcode.models.Job;
import org.launchcode.models.JobField;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        model.addAttribute("items", jobName);


        System.out.println(someJobV.toString() + "XXX  " + jobName + "  job nob job asdffffffffffdetail templatef ");


        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        System.out.println("Jobcontroller Shows up when accessing add ddddddddddddd ");
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.
        System.out.println("Jobcontroller shows up when submitting the add wwwwwwwwwwwwwww ");
        return "";

    }
}
