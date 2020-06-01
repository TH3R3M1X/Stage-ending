import java.util.Date;

public class Person
{
    private String name;
    private String surName;
    private String number;
    private String datum;
    private String gender;
    private Date lastEdited;
    private Date created;


    public Person(String name, String surName, String number, String datum , String gender)
    {
        this.name = name;
        this.surName = surName;
        this.number = number;
        this.datum = datum;
        this.gender = gender;
        Date date = new Date(System.currentTimeMillis());
        created = date;
        lastEdited = date;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSurName() {
        return surName;
    }

    public String getBirthDate() { return datum; }

    public String getGender() { return gender; }

    public Date getCreatedDate()
    {
        return created;
    }

    public Date getLastEdited()
    {
        return lastEdited;
    }

    public void setName(String name, Date lastEdited) {
        this.name = name;
        this.lastEdited=lastEdited;
    }

    public void setNumber(String number, Date lastEdited) {
        this.number = number;
        this.lastEdited=lastEdited;
    }

    public void setSurName(String surName, Date lastEdited) {
        this.surName = surName;
        this.lastEdited=lastEdited;
    }

    public void setDatum(String datum, Date lastEdited) {
        this.datum = datum;
        this.lastEdited=lastEdited;
    }

    public void setGender(String gender, Date lastEdited) {
        this.gender = gender;
        this.lastEdited=lastEdited;
    }
}