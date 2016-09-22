/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayplanner;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Kabir
 */
public class Time {
    
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minutes;
  
   
    public Time(){
        
    }
    
    public class timeException extends Exception
    {
        public timeException()throws timeException
        {
            super();
        }
    } 
    
    public  Time(String timing)
    {
        String[] tokenized = timing.split(" ");
        String[] tokenized2 = tokenized[0].split("/");
        String[] tokenized3 = tokenized[1].split(":");
        month = Integer.parseInt(tokenized2[0]);
        day = Integer.parseInt(tokenized2[1]);
        year = Integer.parseInt(tokenized2[2]);
        hour = Integer.parseInt(tokenized3[0]);
        minutes = Integer.parseInt(tokenized3[1]);
        
    }
    
    public boolean TimeNeg(String timing)
    {
        String[] tokenized = timing.split(" ");
        String[] tokenized2 = tokenized[0].split("/");
        String[] tokenized3 = tokenized[1].split(":");
        month = Integer.parseInt(tokenized2[0]);
        day = Integer.parseInt(tokenized2[1]);
        year = Integer.parseInt(tokenized2[2]);
        hour = Integer.parseInt(tokenized3[0]);
        minutes = Integer.parseInt(tokenized3[1]);
        
        try 
        {
            if(month > 12 || month < 0 || day > 31 || day < 0 || year < 0 || hour > 24 || hour < 0 || minutes > 60 || minutes < 0){
            throw new timeException();
            }
        }
        catch (timeException ex) {
            
            return false;
        }
        
        return true;
        
    }
    
    @Override
    public String toString(){
        return (month + "/" + day + "/" + year + " " + hour + ":" + minutes);
    }
    
    public boolean checkDate(String timeInput)
    {
        SimpleDateFormat date2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Calendar calen = Calendar.getInstance();
        try 
        {
            calen.setTime(date2.parse(timeInput));
        }
        catch (Exception e) {
            
            return false;
        }
        
        return true;
    }
    
   
}
