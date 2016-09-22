/******************/
Kabir Singh
November 28, 2014
/*****************/

/*****
README
******/

/**************
General Problem
**************/
Previously: 

Creating a Day Planner where the user can add or search activities. Now that the day planner was created
from the first assignment, a super class must be created for all the activities and only have one array list.
Also, there will be loading and saving of activities with files. Finally, a HashMap must be created.

Now:

Creating a functioning GUI where the user can add or search for activities. 

/************
Testing Plan
************/

First Panel:

Welcome to the Day Planner.
Choose a command from the 'Commands' menu


Commands -> Add :


Adding an activity:

Type: school

Title: writing		RESET

Starting time(year, month, day, hour, mintute):

2013/03/23 12:23

Ending time(year, month, day, hour, mintute):

2013/03/23 15:30
			ENTER
Messages:

Type: school
Title: writing
Starting time: 2013/03/23 12:23
Ending time: 2013/03/23 15:30


Commands -> Search :


Adding an activity:

Type: school

Title: writing		RESET

Starting time(year, month, day, hour, mintute):

2013/03/23 12:23

Ending time(year, month, day, hour, mintute):

2013/03/23 15:30
			ENTER
Search Results:

Type: school
Title: writing
Starting time: 2013/03/23 12:23
Ending time: 2013/03/23 15:30

/***********
Limitations
***********/

- Can only show the first activity to the message box
- When entering negative time, it still adds activities

/*********
User Guide
*********/

- Open Netbeans
- Open DayPlanner.java located in the src folder of assignment folder
- Press F6 on keyboard to build and run project

/***********
Improvements
***********/

- Can improve on error checking on time 

/***********
Bonus
***********/

- Adding about information
- Added colored grey background


