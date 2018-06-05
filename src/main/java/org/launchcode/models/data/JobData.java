package org.launchcode.models.data;

import javafx.geometry.Pos;
import org.launchcode.models.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
public class JobData {

    private ArrayList<Job> jobs = new ArrayList<>();
    private static JobData instance;

    private JobFieldData<Employer> employers = new JobFieldData<>();
    private JobFieldData<Location> locations = new JobFieldData<>();
    private JobFieldData<CoreCompetency> coreCompetencies = new JobFieldData<>();
    private JobFieldData<PositionType> positionTypes = new JobFieldData<>();


    private JobData() {
        JobDataImporter.loadData(this);
    }

//This is loaded on program start, and wen going to /add
    public static JobData getInstance() {
        if (instance == null) {
            instance = new JobData();
        }
        //System.out.println(" WWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        return instance;
    }

    public Job findById(int id) {
        for (Job job : jobs) {
            ///this looks like it finds a specific job by id
            if (job.getId() == id)
                return job;
        }
        return null;
    }
    public ArrayList<Job> findAll() {
        System.out.println(" This showed up when I list all QQQQQQQQQQQQQQQQQQQ");
        return jobs;
    }

//def This is part of the list and search
    public ArrayList<Job> findByColumnAndValue(JobFieldType column, String value) {

        ArrayList<Job> matchingJobs = new ArrayList<>();

        for (Job job : jobs) {
            if (getFieldByType(job, column).contains(value))
                matchingJobs.add(job);
                //System.out.println(" XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        }

        return matchingJobs;
    }


    public ArrayList<Job> findByValue(String value) {

        ArrayList<Job> matchingJobs = new ArrayList<>();

        for (Job job : jobs) {

            if (job.getName().toLowerCase().contains(value)) {
                System.out.println(" JobData EEEEEEEEEEEEEE2222222E");
                matchingJobs.add(job);
                continue;
            }
                //searching all calles this p1
            for (JobFieldType column : JobFieldType.values()) {
                if (column != JobFieldType.ALL && getFieldByType(job, column).contains(value)) {
                    System.out.println(" JobData EEEEEEEEEEEEEE3333333333");
                    matchingJobs.add(job);
                    break;
                }
            }
        }      //searching all calles this p2
        System.out.println(" JobData EEEEEEEEEEEEEEEEEEEEEEEEEE");
        return matchingJobs;
    }


    public void add(Job job) {
        jobs.add(job);
    }

///This is loaded on the search by catagory
    private static JobField getFieldByType(Job job, JobFieldType type) {
        switch(type) {
            case EMPLOYER:
                return job.getEmployer();
            case LOCATION:
                return job.getLocation();
            case CORE_COMPETENCY:
                return job.getCoreCompetency();
            case POSITION_TYPE:
                //System.out.println(" RRRRRRRRRRRRRRRRRRRRRRRRRRR");
                return job.getPositionType();
        }

        throw new IllegalArgumentException("Cannot get field of type " + type);
    }
///these are initilize when loading the site. perhaps loading the jobs
    public JobFieldData<Employer> getEmployers() {
        //System.out.println(" YYYYYYYYYYYYYYYYYYYYYYYYYYYY");
        return employers;
    }

    public JobFieldData<Location> getLocations() {
        //System.out.println(" UUUUUUUUUUUUUUUUUUUUUUUUUU");
        return locations;
    }

    public JobFieldData<CoreCompetency> getCoreCompetencies() {
        //System.out.println(" IIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        return coreCompetencies;
    }

    public JobFieldData<PositionType> getPositionTypes() {
        //System.out.println(" OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        return positionTypes;
    }
}
