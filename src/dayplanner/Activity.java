/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayplanner;

/**
 *
 * @author Kabir
 */
public class Activity {
    
    private String title;
    private String comment;
    private Time startTimeVal;
    private Time endTimeVal;
    private String type1;

    public Activity(String titleActivity, String beginTime, String finalTime, String commentDesc, String type) {
        title = titleActivity;
        startTimeVal = new Time(beginTime);
        endTimeVal = new Time(finalTime);
        comment = commentDesc;
        type1 = type;
    }
    
    public String getTitle(){
        return (title);
    }
    
    public String getType(){
        return (type1);
    }
    
    public String getStartTime() {
        return (startTimeVal.toString());
    }
    
    public String getEndTime() {
        return (endTimeVal.toString());
    }
    
    public void comment(String commentDesc) {
        comment = commentDesc;
    }
    
    @Override
    public String toString(){
        return ("Type: " +type1+ " Title: "+title+" Start Time: "+ startTimeVal+" End Time: "+ endTimeVal+" Comment: "+ comment);
    }
    
    public boolean equals(HomeActivity otherActivity) {
        return (this.equals(otherActivity));
    }
    
    
}
