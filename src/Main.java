import java.util.Scanner;


public class Main {
    private static int lantern = 0;
    private static boolean key = false;
    private static int health = 80;
    private static int sword = 0;
    public static void spawn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("you are in a small clearing of a forest. The only thing nearby is a house to the east.");
        String str = scanner.nextLine();
        while (!str.equals("go west")&&!str.equals("go east")) {
            System.out.println("You can't do that.");
            str = scanner.nextLine();
        }
        if (str.equals("go west")) forest();
        if (str.equals("go east")) house();
    }

    public static void forest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in a forest. " +
                "\n You hear some water to the east, and some rustling to the north.");
        String str = scanner.nextLine();
        while (!str.equals("go west")&&!str.equals("go east")&&!str.equals("go north")) {
            System.out.println("You can't do that.");
            str = scanner.nextLine();
        }
        if (str.equals("go west")) cliff();
        if (str.equals("go east")) spawn();
        if (str.equals("go north")) battle();

    }
    public static void house(){
        System.out.println("You stand before a small house.\nYou see a door, the place looks old.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.equals("open door")&&!str.equals("go west")){
            System.out.println("Try opening the door");
            str = scanner.nextLine();
        }
        if (str.equals("go west")) spawn();
        if (str.equals("open door")) System.out.println("It's locked.");
        str = scanner.nextLine();

        if (key==true){
            while (!str.equals("use key")){
                System.out.println("Use your key");
                str = scanner.nextLine();
            }
            if (str.equals("use key")){
                System.out.println("The door unlocks");
                str = scanner.nextLine();
                while (!str.equals("enter house")){
                    System.out.println("enter the house");
                    str = scanner.nextLine();}
                if (str.equals("enter house")) livingRoom();
            }
        }
        while (!str.equals("go west")) {
            System.out.println("You can't do that.");
            str = scanner.nextLine();
        }
        if (str.equals("go west")) spawn();
    }
    public static void livingRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in the living room of the house." +
                "\n You see a large rug on the floor, a cabinet of skulls to your left. There doesn't seem to be anyone around.");
        String str = scanner.nextLine();
        while (!str.equals("move rug")&&!str.equals("go west")){
            System.out.println("The floor beneath the rug feels strange");
            str = scanner.nextLine();
        }
        if (str.equals("go west")) house();
        if (str.equals("move rug")){
            System.out.println("The rug moves. It reveals a wooden trapdoor underneath.");
            str = scanner.nextLine();
            while (!str.equals("open trapdoor")){
                System.out.println("open the trapdoor");
                str = scanner.nextLine();
            }
            System.out.println("It opens. A dark staircase going down.");
            str = scanner.nextLine();
            while (!str.equals("go down")){
                System.out.println("go down");
                str = scanner.nextLine();
            }
            dungeon();
        }
        if(str.equals("go west")) spawn();
    }
    public static void dungeon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have made it downstairs. It is dark, you can't see anything.");
        String str = scanner.nextLine();
        while (!str.equals("use lantern")) {
            System.out.println("You can't do that. You can't see.");
            str = scanner.nextLine();
        }
        if (lantern ==1&&str.equals("use lantern")){
            lantern = 2;
            System.out.println("Your lantern is on. Now you can see the large, stone room. " +
                    "\n There is a nothing in the room but a cabinet with a long, shiny sword.");
            str = scanner.nextLine();
            while (!str.equals("get sword")) {
                System.out.println("You can't do that.");
                str = scanner.nextLine();
            }
                System.out.println("Taken.");
                sword = 1;
        }
        str = scanner.nextLine();
        while (!str.equals("go up")) {
            System.out.println("There's nothing left for you here. Go back up.");
            str = scanner.nextLine();
        }
        livingRoom();
    }

    public static void cliff(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are at the edge of a cliff. You see a waterfall flowing in front of you from north to south. " +
                "\n There is also a carved staircase to your south.");
        String str = scanner.nextLine();
        while (!str.equals("go south")&&!str.equals("go east")) {
            System.out.println("You can't do that.");
            str = scanner.nextLine();
        }
        if (str.equals("go south")) bottom();
        if (str.equals("go east")) forest();
    }
    public static void bottom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are by a plunge pool. Downsteam, you see a faint glow.");
        String str = scanner.nextLine();
        while (!str.equals("go south")&&!str.equals("go north")) {
            System.out.println("You can't do that.");
            str = scanner.nextLine();
        }
        if (str.equals("go south")) chest();
        if (str.equals("go north")) cliff();
    }
    public static void chest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are at a chest. It glows bright.");
        String str = scanner.nextLine();
        while (!str.equals("open chest")) {
            System.out.println("open the chest");
            str = scanner.nextLine();
        }
        if (str.equals("open chest")){
            System.out.println("The chest opens. It has a lantern, a key, and some pork inside.");
            str = scanner.nextLine();
        }

        str=scanner.nextLine();
        while (lantern==0||key==false) {
            while (!str.equals("get lantern")&&!str.equals("get key")&&!str.equals("eat pork")) {
                System.out.println("You can't do that.");
                str = scanner.nextLine();
            }
            if (str.equals("get lantern")) {
                System.out.println("Taken.");
                lantern = 1;
                str = scanner.nextLine();
            }
            if (str.equals("get key")) {
                System.out.println("Taken.");
                key = true;
                str = scanner.nextLine();
            }
            if (str.equals("eat pork")) {
                System.out.println("Delicious.");
                health = 100;
                str = scanner.nextLine();
            }
        }
        while (!str.equals("go north")) {
            System.out.println("You can't do that.");
            str = scanner.nextLine();
        }
        if (str.equals("go north")) bottom();
        }

    public static void battle(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in a forest. Suddenly, a troll emerges from the rocks. It attacks you. " +
                "\n You are on " + (health-20) +  " HP.");
        String str = scanner.nextLine();
        if (sword == 1){
            while (!str.equals("kill troll")){
                System.out.println("Kill the troll");
                str = scanner.nextLine();
            }
            if (str.equals("kill troll")) {
                System.out.println("With what?");
                str = scanner.nextLine();
                while (!str.equals("with sword")){
                    System.out.println("dumbo");
                    str = scanner.nextLine();
                }
                if (str.equals("with sword")){
                    System.out.println("The troll lunges at you again. You swing your sword, hitting it in the chest." +
                            "\n The troll looks angry. It gets back up, coming at you again.");
                    str = scanner.nextLine();
                }
                while (!str.equals("hit troll with sword")){
                    health = health - 20;
                    System.out.println("Ouch. The troll hits you. you are now on " + (health) + " HP. " +
                            "\n You must hit the troll with your sword");
                    if (health>= 1) str = scanner.nextLine();
                    else {System.out.println("You lose.");
                        return;}

                }
                if (str.equals("hit troll with sword")){
                    System.out.println("The troll is hurt but gets back up.");
                    str = scanner.nextLine();
                }
                while (!str.equals("hit troll with sword")){
                    health = health/ 2;
                    System.out.println("The troll makes a critical hit. you are now on " + (health) + " HP. " +
                            "\n You must hit the troll with your sword");
                    if (health>= 1)str = scanner.nextLine();
                    else {System.out.println("You lose.");
                    return;}
                }
                if (str.equals("hit troll with sword")){
                    System.out.println("With a mighty stab, you have killed the troll." +
                            "\n It falls down, magically turning into a helicopter. You can go home now."); return;
                }
            }
        }
        if (sword == 0) System.out.println("You are defenseless. The troll easily defeats you.\n He makes a soup and drinks your flesh.");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my game." +
                "Type 'go north' to go north, 'go west' to go west, etc." +
                    "\n You can also use actions such as get, take, open, enter, use, etc." +
                    "\n Please only use lower case letters.");
        spawn();
        }
    }


