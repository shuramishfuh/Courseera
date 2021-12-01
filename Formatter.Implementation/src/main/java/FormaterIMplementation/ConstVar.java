package FormaterIMplementation;

public class ConstVar {
    public static final String RoomSchedule = "/roomschedule";
    public static final String WhoWasThereLast = "/whowastherelast";
    public static final String WhoIsThereNow = "/whoistherenow";
    public static final String ProfSchedule = "/profschedule";
    public static final String WhereIsProf = "/whereisprof";
    public static final String WhereWillProfBe = "/wherewillprofbe";
    public static final String help = "/help";
    public static final String userhelp = "Welcome\nTo chose a command:\nOn mobile, type / and long press the command you want then type your input\n"
            + "On a browser, type / then type the command you want, followed by your input\n"
            + "Note: If an instructor's first or last name if made up of two words or more, enclose the name with double quotes"
            + "or seperate the two words with a -";

    public static final String InvalidRoom = "Room not found";
    public static final String InvalidDate = "Incorrect Date";
    public static final String InvalidDayOfWeek = "Incorrect Day of Week";
    public static final String InvalidProfName = "Professor Name not found";
    public static final String InvalidCommand = "Command not found";
    public static final String RoomIsEmpty = "This Room is Empty";
    public static final String NoCoursesGiven = "The Professor has no classes today";
    public static final String NotInClass = "Professor is not currently in a class";
    public static final String NoClassesThisDate = "No courses are given on this date";
    public static final String NoClassesThisDay = "No courses are given on this day";

    public static final String SomethingWentWrong = "Sorry, something went wrong\nPlease try again later";

    public static final int Method = 0;

    public static final int RoomBuilding = 1;
    public static final int RoomNumber = 2;

    public static final int InstructorFirstName = 1;
    public static final int InstructorLastname = 2;

    public static final int DayofWeek = 3;
    public static final int Date = 3;
}