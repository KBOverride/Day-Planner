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
public class OtherActivity extends Activity{
    
    private String title;
    private String comment;
    private String location;
    private Time startTimeVal;
    private Time endTimeVal;

    public OtherActivity(String titleActivity, String beginTime, String finalTime, String commentDesc, String locationOther, String type) {
        super(titleActivity, beginTime, finalTime, commentDesc, type);
        location = locationOther;
    }
    
    @Override
    public String toString()
    {
        return super.toString() +" Location: " +location;
    }
   
}
