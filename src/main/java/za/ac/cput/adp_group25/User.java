/*
Coded By: Charles Matthew Shaw 222451432
*/
package za.ac.cput.adp_group25;

import java.io.Serializable;

public class User implements Serializable
    {
        private String fstName;
        private String lstName;
        private String Password;
        private int ID;
        private boolean isAdmin;
        private String Function;
    
    //Basic Constructor for Login    
    public User(int ID, String password, String function)
    {
        this.ID = ID;
        this.Password = password;
        this.Function = function;
    }
    
    //Full Length Constructor
    public User(int ID, String pass, String name, String surname, boolean isAdmin)
    {
        this.ID = ID;
        this.Password = pass;
        this.fstName = name;
        this.lstName = surname;
        this.isAdmin = isAdmin;
    }
    
    //Full Length Constructor + Function (Differentiates the Server side processing.)
    public User(int ID, String pass, String name, String surname, boolean isAdmin, String function)
    {
        this.ID = ID;
        this.Password = pass;
        this.fstName = name;
        this.lstName = surname;
        this.isAdmin = isAdmin;
        this.Function = function;
    }
    
    public String getUserFName()
    {
        return fstName;
    }
    
    public void setUserFName()
    {
        this.fstName = fstName;
    }
    
    public String getUserLName()
    {
        return lstName;
    }
    
    public void setUserLName()
    {
        this.lstName = lstName;
    }
    
    public int getUserID()
    {
        return ID;
    }
    
    public void setUserID()
    {
        this.ID = ID;
    }
    
    public String getPass()
    {
        return Password;
    }
    
    public void setPass()
    {
        this.Password = Password;
    }
    
    public String getFunction()
    {
        return Function;
    }
    
    public void setFunction()
    {
        this.Function = Function;
    }
    
    public Boolean isAdmin()
    {
        return isAdmin;
    }
    
    public String toString()
    {
        //Temporary to string method.
        return ID + ", " + fstName + ", " + lstName;
    }
}
