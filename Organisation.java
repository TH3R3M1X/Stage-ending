import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Organisation
{
    private String organame;
    private String orgaadress;
    private String organumber;
    private Date lastEdited;
    private Date created;



    public Organisation(String organame, String orgaadress, String organumber)
    {
        this.organame = organame;
        this.orgaadress = orgaadress;
        this.organumber = organumber;
        Date date = new Date(System.currentTimeMillis());
        created = date;
        lastEdited = date;
    }
    public String getOrganame() {
        return organame;
    }

    public String getOrganumber() {
        return organumber;
    }

    public String getOrgaadress() {
        return orgaadress;
    }

    public Date getCreatedDate()
    {
        return created;
    }

    public Date getLastEdited()
    {
        return lastEdited;
    }

    public void setOrganame(String organame, Date lastEdited) {
        this.organame = organame;
        this.lastEdited = lastEdited;
    }

    public void setOrganumber(String organumber, Date lastEdited) {
        this.organumber = organumber;
        this.lastEdited=lastEdited;
    }

    public void setOrgaadress(String orgaadress, Date lastEdited) {
        this.orgaadress = orgaadress;
        this.lastEdited=lastEdited;
    }

}