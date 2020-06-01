import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main
{
    ArrayList<Entry> gespeicherteEintraege = new ArrayList<>();

    public static void main(String[] args)
    {
        new main();
    }

    public main()

    {
        while (true)
        {
            menu();
        }
    }

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[menu] Enter action (add, remove, edit, count, info, exit, search): ");
        String input = scanner.nextLine();

        switch (input)
        {
            case "add":
                add();
                break;
            case "remove":
                list(gespeicherteEintraege);
                remove(null);
                break;
            case "edit":
                list(gespeicherteEintraege);
                edit(null);
                break;
            case "count":
                System.out.println(gespeicherteEintraege.size());
                break;
            case "info":
                list(gespeicherteEintraege);
                info(gespeicherteEintraege, null);
                break;
            case "exit":
                System.exit(1);
                break;
            case "search":
                search();
                break;
            default:
                System.out.println("Bitte eines der oben genannten Wörter eingeben");
        }
    }

    public void recordmenu(Entry entry)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[record] Enter action (remove, edit, menu): ");
        String input = scanner.nextLine();

        switch (input)
        {
            case "remove": ;
                remove(gespeicherteEintraege.indexOf(entry));
                break;
            case "edit":
                edit(gespeicherteEintraege.indexOf(entry));
                break;
            case "menu":
                menu();
                break;
            default:System.out.println("Bitte eines der oben genannten Wörter eingeben");
        }
    }

    public void searchmenu(ArrayList<Entry> foundEntrys)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[search] Enter action ([number], back, again): ");
        String input = scanner.nextLine();

        switch (input)
        {
            case "back":
                menu();
                break;
            case "again":
                search();
                break;
            default:
                int eingabe = Integer.valueOf(input);
                if (eingabe > foundEntrys.size() || eingabe < 0)
                {
                    System.out.println("Dieser Eintrag existiert nicht!");
                    menu();
                }
                info(foundEntrys,eingabe );
                recordmenu(foundEntrys.get(eingabe));
        }
    }

    public void addperson()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        String name;
        name = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname;
        surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String nummer;
        nummer = scanner.nextLine();
        System.out.println("Enter the birth date:");
        String datum;
        datum = scanner.nextLine();
        System.out.println("Enter the Gender:");
        String gender;
        gender = scanner.nextLine();

        Entry entry = new Entry(new Person(name, surname, nummer, datum, gender));
        gespeicherteEintraege.add(entry);
        System.out.println("A record created!");
        System.out.println("A Phone Book with single record created !");
    }

    public void addorga()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the organization name:");
        String organame = scanner.nextLine();
        System.out.println("Enter the Adress:");
        String orgaadress = scanner.nextLine();
        System.out.println("Enter the number:");
        String organumber = scanner.nextLine();

        Entry entry = new Entry(new Organisation(organame, orgaadress, organumber));
        gespeicherteEintraege.add(entry);
        System.out.println("The Record Added");
    }

    public void list(ArrayList<Entry> list)
    {
        for (int i = 0; list.size() > i; i++)
        {
            if (list.get(i).getPerson() instanceof Person && list.get(i).getPerson() != null)
            {

                System.out.println(
                        i + ". " + list.get(i).getPerson().getName() + " " + list.get(i).getPerson().getSurName()
                                + ", " + list.get(i).getPerson().getNumber());
            }
            else if (list.get(i).getOrganisation() instanceof Organisation
                    && list.get(i).getOrganisation() != null)
            {
                System.out.println(i + ". " + list.get(i).getOrganisation().getOrganame() + " " + list.get(i)
                        .getOrganisation().getOrgaadress() + ", " + list.get(i).getOrganisation()
                        .getOrganumber());
            }
        }

    }

    public void remove(Integer integer)
    {
        if (integer == null)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a record: ");
            int record = scanner.nextInt();
            if (record > gespeicherteEintraege.size()|| record < 0)
            {
                System.out.println("Dieser Eintrag existiert nicht!");
                menu();
            }
            gespeicherteEintraege.remove(record);
            System.out.println("Record Removed");
        }
        else {
            gespeicherteEintraege.remove(integer);
        }
    }

    public void edit(Integer integer)
    {
        int record;
        Scanner scanner = new Scanner(System.in);
        if (integer == null)
        {
            System.out.println("Select a record: ");
            record = scanner.nextInt();
        }
        else
        {
            record = integer;
        }
        if (record > gespeicherteEintraege.size() || record < 0)
        {
            System.out.println("Dieser Eintrag existiert nicht!");
            menu();
        }
        Person person = gespeicherteEintraege.get(record).getPerson();
        Organisation organisation = gespeicherteEintraege.get(record).getOrganisation();
        if (person instanceof Person && person != null)
        {

            System.out.println("Select a field (name, surname, number, birthdate, gender):");

            switch (scanner.nextLine())
            {
                case "name":
                    System.out.println("Enter Name:");
                    person.setName(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                case "surname":
                    System.out.println("Enter Surname:");
                    person.setSurName(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                case "number":
                    System.out.println("Enter Number:");
                    person.setNumber(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                case "birthdate":
                    System.out.println("Enter date:");
                    person.setDatum(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                case "gender":
                    System.out.println("Enter gender:");
                    person.setGender(scanner.nextLine(),new Date(System.currentTimeMillis()));
                    break;
                default:System.out.println("Bitte eines der oben genannten Wörter eingeben");
            }
            System.out.println("The record updated!");
        }
        else if (organisation instanceof Organisation && organisation != null)
        {
            System.out.println("Select a field (name, adress, number):");
            scanner.nextLine();
            switch (scanner.nextLine())
            {
                case "name":
                    System.out.println("Enter Name:");
                    organisation.setOrgaadress(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                case "adress":
                    System.out.println("Enter Adress:");
                    organisation.setOrgaadress(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                case "number":
                    System.out.println("Enter Number:");
                    organisation.setOrganumber(scanner.nextLine(), new Date(System.currentTimeMillis()));
                    break;
                default:System.out.println("Bitte eines der oben genannten Wörter eingeben");
            }
            System.out.println("The record updated!");
        }
    }

    public void add()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type (person, organization)");
        String input = scanner.nextLine();
        switch (input)
        {
            case "person":
                addperson();
                break;
            case "organization":
                addorga();
                break;
            default:System.out.println("Bitte eines der oben genannten Wörter eingeben");
        }
    }

    public void info(ArrayList<Entry> entries, Integer integer)
    {
        int index;
        if (integer == null)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter index to show info: ");
            index = scanner.nextInt();
        }
        else
        {
            index = integer;
        }

        Person person = entries.get(index).getPerson();
        Organisation organisation = entries.get(index).getOrganisation();
        if (person instanceof Person && person != null)
        {
            System.out.println("Name : " + person.getName());
            System.out.println("Surname : " + person.getSurName());
            System.out.println("Birth Date : " + person.getBirthDate());
            System.out.println("Gender : " + person.getGender());
            System.out.println("Number : " + person.getNumber());
            System.out.println("Time created : " + person.getCreatedDate());
            System.out.println("Time last edit : " + person.getLastEdited());
        }
        else if (organisation instanceof Organisation && organisation != null)
        {
            System.out.println("Name : " + organisation.getOrganame());
            System.out.println("Adresse : " + organisation.getOrgaadress());
            System.out.println("Number : " + organisation.getOrganumber());
            System.out.println("Time created : " + organisation.getCreatedDate());
            System.out.println("Time last edit : " + organisation.getLastEdited());
        }

    }

    public void search()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search query : ");
        String searching = scanner.nextLine();
        ArrayList<Entry> foundEntrys = new ArrayList<>();

        for (Entry eintrag : gespeicherteEintraege)
        {
            if (eintrag.getPerson() != null)
            {
                if (eintrag.getPerson().getName().contains(searching) || eintrag.getPerson().getSurName()
                        .contains(searching) || eintrag.getPerson().getNumber().contains(searching) || eintrag
                        .getPerson().getGender().contains(searching) || eintrag.getPerson().getBirthDate()
                        .contains(searching))
                {
                    foundEntrys.add(eintrag);
                    System.out.println("Gefunden");
                }
            }
            if (eintrag.getOrganisation() != null)
            {
                if (eintrag.getOrganisation().getOrganumber().contains(searching) || eintrag.getOrganisation()
                        .getOrgaadress().contains(searching) || eintrag.getOrganisation().getOrganame()
                        .contains(searching))
                {
                    foundEntrys.add(eintrag);
                    System.out.println("Gefunden");
                }
            }
        }
        list(foundEntrys);
        searchmenu(foundEntrys);
    }
}