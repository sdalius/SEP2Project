package PatientBookingGUI.Database;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private Statement stmt;
    private DatabaseAccessObject databaseObject;
    public CreateTable(DatabaseAccessObject dbobj) {
        this.databaseObject = dbobj;
    }

    public void createDomains()
    {
        try{
            stmt = databaseObject.getC().createStatement();
            stmt.executeUpdate ( "create domain d_customerid as char(4);" +
                        "create domain d_firstname varchar(10);" +
                        "create domain d_lastname varchar(20);" +
                        "create domain d_birthdate date check ( value > '1920-01-01');" +
                        "create domain d_phoneno varchar(11);" +
                        "create domain d_email as varchar(25);" +
                        "create domain d_invno as char(5);" +
                        "create domain d_price as int check ( value between 0 and 10000 );" +
                        "create domain d_size as varchar(5) check ( value in ('Kid', 'Adult'));" +
                        "create domain d_type as varchar(20) check ( value in ('All-mountain', 'Powder', 'Beginner', 'Downhill', 'Freestyle', 'Slalom') );" +
                        "create domain d_department as varchar(11) check ( value in ('Management', 'Maintenance', 'Cleaning', 'Reception'));" +
                        "create domain d_staffid as char(4);" +
                        "create domain d_sex as char(1) check ( value in ('F', 'M'));" +
                        "create domain d_payment as varchar(50) check ( value in ('Credit card', 'Cash', 'Debit card', 'Check', 'Store credit', 'Mobile'));");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        System.out.println ("Domains were created");
    }


    public void createCustomerTable(String tablename) {
        try{
            stmt = databaseObject.getC ().createStatement ();
            stmt.executeUpdate("CREATE TABLE \"SkiRental\"." + tablename + "(" +
                    "CustomerID int," +
                    "FirstName d_firstname,\n" +
                    "LastName d_lastname,\n" +
                    "Address varchar(25),\n" +
                    "Birthday d_birthdate,\n" +
                    "PhoneNo d_phoneno,\n" +
                    "eMail d_email,\n" +
                    "primary key (CustomerID)" +
                    ")");
            stmt.close ();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Customer table has been created");
    }
    public void createRentalSkiTable(String tablename) {
        try{
            stmt = databaseObject.getC ().createStatement ();
            stmt.executeUpdate("CREATE TABLE \"SkiRental\"." + tablename + "(" +
                    "    InventoryNO d_invno," +
                    "    Price d_price," +
                    "    Size d_size," +
                    "    Color varchar(8)," +
                    "    Brand varchar(20)," +
                    "    Type d_type," +
                    "    primary key (InventoryNO)" +
                    ")");
            stmt.close ();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Rental_Ski table has been created");
    }

    public void createStaffTable(String tablename) {
        try{
            stmt = databaseObject.getC ().createStatement ();
            stmt.executeUpdate("CREATE TABLE \"SkiRental\"." + tablename + "(" +
                    "StaffID d_staffid," +
                    "FirstName d_firstname," +
                    "LastName d_lastname," +
                    "Department d_department," +
                    "Sex d_sex," +
                    "Birthday d_birthdate," +
                    "PhoneNo d_phoneno," +
                    "email d_email," +
                    "SupervisorStaffID d_staffid," +
                    "primary key (StaffID)" + ")");
            stmt.close ();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Staff table has been created");
    }

    public void createBookingTable(String tablename) {
        try{
            stmt = databaseObject.getC ().createStatement ();
            stmt.executeUpdate("CREATE TABLE \"SkiRental\"." + tablename + "(" +
                    "CustomerID d_customerid," +
                    "InventoryNO d_invno," +
                    "DateFrom date not null," +
                    "DateTo date not null," +
                    "PaymentMethod d_payment," +
                    "RentalFee int," +
                    "primary key (CustomerID, InventoryNO, DateFrom))");
            stmt.close ();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Booking table has been created");
    }
    public void createRentalStaffTable(String tablename) {
        try{
            stmt = databaseObject.getC ().createStatement ();
            stmt.executeUpdate("CREATE TABLE \"SkiRental\"." + tablename + "(" +
                    "InventoryNO d_invno," +
                    "StaffID d_staffid," +
                    "MaintenanceDate date," +
                    "LastCleanedByID d_staffid," +
                    "primary key (InventoryNO, StaffID, MaintenanceDate)" + ")");
            stmt.close ();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Rental_Staff table has been created");
    }

    public void createSchema(String schemaName) {
        try{
            stmt = databaseObject.getC().createStatement ();
            stmt.executeUpdate ( "create schema \""+schemaName+"\";");
            stmt.executeUpdate ( "set search_path = \""+schemaName+"\";" );
            System.out.println ("Setting search path");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
