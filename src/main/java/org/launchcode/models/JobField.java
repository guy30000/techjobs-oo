package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class JobField {

    private String value;
    private int id;
    private static int nextId = 1;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String aValue) {
        this();
        value = aValue;
    }

    public boolean contains(String value) {
        return this.value.toLowerCase().contains(value.toLowerCase());
    }

    public String getValue() { return value; }

    public void setValue(String aValue) {
        value = aValue;
    }
///This is part of searching and listing all jobs
    public String toString() {
        //System.out.println(" JOBField loads when list cat selected and final selection aaaaaaaaaaaaaaaaaaaaaaa"); //
        return value;
    }

    public int getId() {
        //System.out.println(" JOBField Loads on addlinkbbbbbbbbbbbbbbbbbbbbb");
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobField jobField = (JobField) o;

        return id == jobField.getId();
    }

    @Override
    public int hashCode() {
        //System.out.println(" JOBField Loads on addlink, and list cat  selected iiIIIIIIISi");
        return id;
    }

}
