package Database;

public class MainStuff {
    public static void main(String[] args) {
        GetData getdata = new GetData ();

        for (int i = 0 ; i < getdata.getAllDoctors ().size () ; i++)
        {
            System.out.println (getdata.getAllDoctors ().get ( i ).geteMail ());
        }
    }

}
