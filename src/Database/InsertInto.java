package Database;

import Database.DatabaseAccessObject;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertInto {
    private DatabaseAccessObject dbobj;
    private Statement statement;
    public InsertInto(DatabaseAccessObject dbobj) {
        this.dbobj = dbobj;
    }

    public void addCustomer(int ID, String fname, String lname, String address, String date, int phoneNo, String email) throws SQLException {
       try{
           statement = dbobj.getConnection().createStatement();
           statement.executeUpdate("INSERT INTO \"SkiRental\".customer(CustomerID, FirstName, LastName, Address, Birthday, PhoneNo, eMail) VALUES('"+ID+"','"+fname+"','"+lname+"', '"+address+"','"+Date.valueOf(date)+"','"+phoneNo+"','"+email+"'" + ")");
           statement.close();
       }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            System.out.println("Database update ok");
        }
    }

    public void addRentalSki(int inventoryID, int price, String size, String color, String brand, String type) throws SQLException {
        try{
            statement = dbobj.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO \"SkiRental\".rental_ski(InventoryNO, Price, Size, Color, Brand, Type) VALUES('"+inventoryID+"','"+price+"','"+size+"', '"+color+"','"+brand+"','"+type+"'" + ")");
            statement.close();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            System.out.println("Database update ok");
        }
    }
    public void addStaff(int staffID, String firstname, String lastName, String department, char sex, String birthday, int phoneNo, String eMail, int SupervisorStaffID) throws SQLException {
        try{
            statement = dbobj.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO \"SkiRental\".Staff(StaffID, FirstName, LastName, Department, Sex, Birthday, PhoneNo, email, SupervisorStaffID) VALUES('"+staffID+"','"+firstname+"','"+lastName+"', '"+department+"','"+sex+"','"+birthday+"','"+phoneNo+"','"+eMail+"','"+SupervisorStaffID+"'" + ")");
            statement.close();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            System.out.println("Database update ok");
        }
    }
    public void addBooking(int customerID, int inventoryNo, String dateFrom, String dateTo, String paymentMethod, int rentalFee) throws SQLException {
        try {
            statement = dbobj.getConnection().createStatement ();
            statement.executeUpdate ( "INSERT INTO \"SkiRental\".booking(CustomerID,InventoryNo,DateFrom,DateTo,PaymentMethod,RentalFee) VALUES('" + customerID + "','" + inventoryNo + "','" + dateFrom + "', '" + dateTo + "','" + paymentMethod + "','" + rentalFee + "'" + ")" );
            statement.close ();
        } catch (Exception e) {
            System.err.println ( e.getClass ().getName () + ": " + e.getMessage () );
            System.exit ( 0 );
            System.out.println ( "Database update ok" );
        }
    }
    public void addRentalStaff(int inventoryNo, int staffID, String maintenanceDate, int lastCleanedByID) throws SQLException {
        try {
            statement = dbobj.getConnection().createStatement ();
            statement.executeUpdate ( "INSERT INTO \"SkiRental\".rental_staff(InventoryNO, StaffID, MaintenanceDate, LastCleanedByID) VALUES('" +inventoryNo+ "','" + staffID + "','" + maintenanceDate + "', '" + lastCleanedByID + "'" + ")" );
            statement.close ();
        } catch (Exception e) {
            System.err.println ( e.getClass ().getName () + ": " + e.getMessage () );
            System.exit ( 0 );
            System.out.println ( "Database update ok" );
        }
    }
}