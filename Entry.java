public class Entry
{
    private Person person;
    private Organisation organisation;

    public Entry(Person person)
    {
        this.person=person;
    }
    public Entry(Organisation organisation)
    {
        this.organisation = organisation;
    }

    public Organisation getOrganisation()
    {
        return organisation;
    }

    public Person getPerson()
    {
        return person;
    }
}