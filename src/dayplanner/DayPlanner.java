/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayplanner;

/* importing libraries */
import java.util.*;
import java.io.*;

/**
 *
 * @author Kabir Singh
 */
public class DayPlanner {

    /**
     * @param args the command line arguments
     */
    /* Main method executes */
    private static ArrayList<Activity> guiList = new ArrayList<>();
    private static String readIO;
    
    public static void main(String[] args) {
        
        readIO = args[0];
        
        DayPlannerGUI gui;
        gui = new DayPlannerGUI();
        gui.setVisible(true);
        
        String inputChoice;
        String exit = "false";

        /* Creating arraylists */
        
        if(args.length == 0) {
            System.out.println("Program cannot find file");
            System.exit(0);
        } else if(args.length > 2) {
            readFileInput(guiList, args[1]);
        }
        Scanner input = new Scanner(System.in);
        
    }

    /* add function asks user for input of type, title, start/end time and if neccessary, location for other activity */
    
    public static void add2(String type, String startTime, String endTime, String title, String comment, String location) {
        
        Time timeObj = new Time();
        PrintWriter outputStream = null;

        Scanner inputAdd = new Scanner(System.in);

            if (type.equalsIgnoreCase("home")) {
                HomeActivity home = new HomeActivity(title, startTime, endTime, comment, type);
                guiList.add(home);
                
            } else if (type.equalsIgnoreCase("school")) {
                SchoolActivity school = new SchoolActivity(title, startTime, endTime, comment, type);
                guiList.add(school);
                
            } else if (type.equalsIgnoreCase("other")) {
                OtherActivity other = new OtherActivity(title, startTime, endTime, comment, location, type);
                guiList.add(other);
                
            }

        try {
            outputStream = new PrintWriter(new FileOutputStream(readIO, true));
        } catch (FileNotFoundException e) {
            System.err.println("File activityInputOutput.txt was not found");
            System.err.println("or could not be opened.");
            System.exit(0);
        }
        /* outputting to file */
        if (!type.equals("")) {
            outputStream.println("type = \"" + type + "\"");
        }
        if (!title.equals("")) {
            outputStream.println("title = \"" + title + "\"");
        }
        if (!startTime.equals("")) {
            outputStream.println("start = \"" + startTime + "\"");
        }
        if (!endTime.equals("")) {
            outputStream.println("end = \"" + endTime + "\"");
        }
        if (!location.equals("")) {
            outputStream.println("location = \"" + location + "\"");
        }
        if (!comment.equals("")) {
            outputStream.println("comment = \"" + comment + "\"");
        }

        outputStream.println();
        outputStream.close();
    }

    /* Function asks user to enter title search. Function locates records with same title name */
    public static void search(String type, String startTime, String endTime, String title, String comment, String location) {
        
        int i;
        int counter;

        if (type.equalsIgnoreCase("home") || type.equalsIgnoreCase("school") || type.equalsIgnoreCase("other")) {
            /* Splits the user input title into seperate words */
            String[] titleToken = title.split(" ");

            /* For loop goes through each word of respective list and see if it matches. */
            /* If title matchesand date matches, record is printed out */
            for (counter = 0; counter < guiList.size(); counter++) {
                for (i = 0; i < titleToken.length; i++) {
                    /* if original title and date matches with user search input title and time */
                    if (searchForDate(type, startTime, endTime, guiList, counter) == true) {
                        if (guiList.get(counter).getType().contains(type)) {
                            if (guiList.get(counter).getTitle().contains(titleToken[i])) {
                            }
                        }
                    } else {
                        
                    }
                }
            }
        }
        
    }

    /*Function searches for time that equals user input search of time */
    public static boolean searchForDate(String dateSearch, String time2, String endTime2, ArrayList<Activity> guiList, int counter) {
        /* If search activity is school */
        if (dateSearch.equalsIgnoreCase("school") || dateSearch.equalsIgnoreCase("home") || dateSearch.equalsIgnoreCase("other")) {
            if (guiList.get(counter).getStartTime().equals(time2) || time2.equals("")) {
                if (guiList.get(counter).getEndTime().equals(endTime2) || endTime2.equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* opening input and output file */
    public static void readFileInput(ArrayList<Activity> guiList,String args) {
        Scanner objectStream = null;
        String line;
        String[] token = null;
        String type = "";
        String title = "";
        String startTime = "";
        String endTime = "";
        String location = "";
        String comment = "";

        /* try and catch of outputting */
        try {
            objectStream = new Scanner(new FileInputStream(args));
        } catch (FileNotFoundException e) {
            System.err.println("File activityInputOutput.txt was not found");
            System.err.println("or could not be opened.");
            System.exit(0);
        }

        /*parse the string for your data and stores it respectively*/
        while (objectStream.hasNextLine()) {
            line = objectStream.nextLine();
            token = line.split(" = ");

            if (line.isEmpty() == false) {
                /*token[0] = token[0].trim();
                 token[1] = token[1].trim();*/
                if (token[0].equalsIgnoreCase("type")) {
                    token[1] = token[1].replaceAll("\"", "");
                    type = token[1];

                } else if (token[0].equalsIgnoreCase("title")) {
                    token[1] = token[1].replaceAll("\"", "");
                    title = token[1];

                } else if (token[0].equalsIgnoreCase("start")) {
                    token[1] = token[1].replaceAll("\"", "");
                    startTime = token[1];

                } else if (token[0].equalsIgnoreCase("end")) {
                    token[1] = token[1].replaceAll("\"", "");
                    endTime = token[1];

                } else if (token[0].equalsIgnoreCase("location")) {
                    token[1] = token[1].replaceAll("\"", "");
                    location = token[1];

                } else if (token[0].equalsIgnoreCase("comment")) {
                    token[1] = token[1].replaceAll("\"", "");
                    comment = token[1];

                }
            } else {
                if (type.equalsIgnoreCase("school")) {
                    SchoolActivity school = new SchoolActivity(title, startTime, endTime, comment, type);
                    guiList.add(school);
                } else if (type.equalsIgnoreCase("home")) {
                    HomeActivity home = new HomeActivity(title, startTime, endTime, comment, type);
                    guiList.add(home);
                } else if (type.equalsIgnoreCase("other")) {
                    OtherActivity other = new OtherActivity(title, startTime, endTime, comment, location, type);
                    guiList.add(other);
                }
                type = "";
                title = "";
                startTime = "";
                endTime = "";
                location = "";
                comment = "";
            }
        }

        objectStream.close();
    }

    /*Function creates HashMap*/
    public void hashMap(ArrayList<Activity> guiList) {

        Map<String, ArrayList<Integer>> hash = new HashMap<String, ArrayList<Integer>>();

        int counter1;
        int counter2;
        int counter3;

        for (counter1 = 0; counter1 < guiList.size(); counter1++) {

            String[] popping = guiList.get(counter1).getTitle().split(" ");

            for (counter2 = 0; counter2 < popping.length; counter2++) {
                ArrayList<Integer> integerList = new ArrayList();
                if (hash.containsKey(popping[counter2])) {
                    integerList = hash.get(popping[counter2]);
                }
                integerList.add(counter1);
                hash.put(popping[counter2], integerList);
                //System.out.println(hash);
            }
        }
        /*Iterator - Did not know how to do it*/
    }
}
