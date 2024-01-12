package org.example;

import java.util.Scanner;

import static org.example.Admin.*;

public class Main {
    public static void main(String[] args) {
        Animals animal0 = new Animals();
        animal0.setName("lion");
        animal0.setType("mammal");
        animal0.setAnimal_ID(0);
        Animals animal1 = new Animals();
        animal1.setName("elephant");
        animal1.setType("mammal");
        animal1.setAnimal_ID(1);
        Animals animal2 = new Animals();
        animal2.setName("crocodile");
        animal2.setType("reptile");
        animal2.setAnimal_ID(2);
        Animals animal3 = new Animals();
        animal3.setName("snake");
        animal3.setType("reptile");
        animal3.setAnimal_ID(3);
        Animals animal4 = new Animals();
        animal4.setName("frog");
        animal4.setType("amphibian");
        animal4.setAnimal_ID(4);
        Animals animal5 = new Animals();
        animal5.setName("salamander");
        animal5.setType("amphibian");
        animal5.setAnimal_ID(5);

        Admin.animals[0] = animal0;
        Admin.animals[1] = animal1;
        Admin.animals[2] = animal2;
        Admin.animals[3] = animal3;
        Admin.animals[4] = animal4;
        Admin.animals[5] = animal5;

        Discounts d1 = new Discounts();
        d1.setCategory("Minor");
        d1.setDiscountCode("MINOR10");
        d1.setDisc_perc(10);

        Discounts d2 = new Discounts();
        d2.setCategory("Senior");
        d2.setDiscountCode("SENIOR20");
        d2.setDisc_perc(20);

        discs[0] = d1;
        discs[1] = d2;

        SpecialDeals deal1 = new SpecialDeals();
        deal1.setNo_of_Attraction_tickets(2);
        deal1.setSpecialDealPercentage(15);

        SpecialDeals deal2 = new SpecialDeals();
        deal2.setNo_of_Attraction_tickets(3);
        deal2.setSpecialDealPercentage(30);

        specialDeals[0] = deal1;
        specialDeals[1] = deal2;

        boolean b = true;
        while (b) {
            Scanner SC = new Scanner(System.in);
            System.out.println("----------------------------------------");
            System.out.println("---------Welcome to ZOOtopia------------");
            System.out.println();
            System.out.print("1. Enter as Admin\n" +
                    "2. Enter as a Visitor\n" +
                    "3. View Special Deals\n");
            System.out.println("----------------------------------------");
            System.out.print("Enter your Choice: ");
            int choice = SC.nextInt();
            SC.nextLine();
            if (choice == 1) {
                // Admin
                System.out.println();
                System.out.print("Enter Admin Username: ");
                String username = SC.nextLine();
                System.out.print("Enter Admin Password: ");
                String password = SC.nextLine();

                if (username.equals("admin") && password.equals("admin123")) {   // Default admin ID
                    Admin admin = new Admin();
                    admin.Admin();
                } else {
                    System.out.println("Incorrect Login ID and Password !!");
                }
            } else if (choice == 2) {
                // Visitor
                Visitor visitor = new Visitor();
                visitor.Visitor();
                // b = false;
            } else if (choice == 3) {
                // View Special Deals
                int count = 1;
                for(int i=0; i<specialDeals.length; i++){
                    if(specialDeals[i] != null){
                        System.out.println(count +". Buy "+ specialDeals[i].getNo_of_Attraction_tickets() + " tickets and get" +
                                specialDeals[i].getSpecialDealPercentage() + " % off");
                    }
                }
            } else {
                System.out.println("------------------------------\n"+"Thanks for Visiting ;)\n"+"------------------------------\n");
                b = false;
            }
        }
    }
}

class Visitor {
    private String name;
    private int age;
    private long mob_no;
    private float balance;
    private String email;
    private String passwd;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMob_no(long mob_no) {
        this.mob_no = mob_no;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    private float money_Spent = 0;
    public float getMoney_Spent() {
        return money_Spent;
    }

    private int no_of_visitors=0;
    public int getNo_of_visitors() {
        return no_of_visitors;
    }
    public void setNo_of_visitors(int no_of_visitors) {
        this.no_of_visitors = no_of_visitors;
    }

    private boolean Membership;  // True-> Basic , False-> Premium
    public boolean isMembership() {
        return Membership;
    }
    public void setMembership(boolean membership) {
        Membership = membership;
    }

    private int tickets = 0;
    public int getTickets() {
        return tickets;
    }

    private String feedback;
    public String getFeedback() {
        return feedback;
    }

    static Attraction_Tickets[] buy_attraction_tickets = new Attraction_Tickets[50];

    public void Visitor() {
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        boolean d = true;
        while (b && d) {
            System.out.println("1. Register\n" +
                    "2. Login\n");
            int input = sc.nextInt();
            sc.nextLine();
            if (input == 1) {
                System.out.print("Enter Visitor Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Visitor Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Visitor Phone Number: ");
                long mob_no = sc.nextLong();
                sc.nextLine();

                System.out.print("Enter Visitor Balance: ");
                int balance = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Visitor Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Visitor Password: ");
                String passwd = sc.nextLine();

                setName(name);
                setAge(age);
                setMob_no(mob_no);
                setBalance(balance);
                setEmail(email);
                setPasswd(passwd);
                setMembership(true);

                visitors[no_of_visitors++] = this;

                System.out.println();
                System.out.println("Registration is successful.\n");

            }
            else if (input == 2) {
                // email and passwd check kro
                System.out.print("Enter your email: ");
                String email_id = sc.nextLine();
                System.out.print("Enter your password: ");
                String passwd_id = sc.nextLine();
                int count = 0;
                try {
                    for (int i = 0; i < visitors.length; i++) {
                        if (visitors[i] != null) {
                            if(email_id.equals(visitors[i].email) && passwd_id.equals(visitors[i].passwd)) {
                                System.out.println("Login Successful");
                                boolean y = true;
                                while (y) {
                                    System.out.println();
                                    System.out.println("---------------------------------\n" +
                                            "Visitor Menu:\n" +
                                            "1. Explore the Zoo\n" +
                                            "2. Buy Membership\n" +
                                            "3. Buy Tickets\n" +
                                            "4. View Discounts\n" +
                                            "5. View Special Deals\n" +
                                            "6. Visit Animals\n" +
                                            "7. Visit Attractions\n" +
                                            "8. Leave Feedback\n" +
                                            "9. Log Out\n" +
                                            "---------------------------------\n");
                                    System.out.print("Enter your choice: ");
                                    int visitor_choice = sc.nextInt();
                                    switch (visitor_choice) {
                                        case 1:
                                            // Explore Zoo
                                            explore_Zoo();
                                            break;
                                        case 2:
                                            // Buy Membership
                                            buy_Membership();
                                            break;
                                        case 3:
                                            // Buy Tickets
                                            buy_Tickets();
                                            break;
                                        case 4:
                                            // View Discounts
                                            view_Discounts();
                                            break;
                                        case 5:
                                            // View Special Deals
                                            view_SpecialDeals();
                                            break;
                                        case 6:
                                            // Visit Animals
                                            visit_Animals();
                                            break;
                                        case 7:
                                            // Visit Attractions
                                            visit_Attraction();
                                            break;
                                        case 8:
                                            // Leave Feedback
                                            leave_Feedback();
                                            break;
                                        case 9:
                                            // Log out
                                            System.out.println();
                                            System.out.println("Logged Out.");
                                            y = false;
                                            d = false;
                                            break;
                                        default:
                                            System.out.println("Invalid Input !!");
                                            break;
                                    }
                                }
                                break;
                            }
                        }
                        else if(count == visitors.length - 1) {
                            throw new IllegalArgumentException("Incorrect email and password !!\n" +
                                    "Please try again.");
                        }
                        count++;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                }
            }
            else {
                b = false;
            }
        }
    }

    public void explore_Zoo(){
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while(b) {
            System.out.println("-----------------------\n" +
                    "Explore the Zoo:\n" +
                    "1. View Attractions\n" +
                    "2. View Animals\n" +
                    "3. Exit\n" +
                    "-----------------------\n");
            System.out.print("Enter your Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    // View Attractions
                    View_Attractions();
                    break;
                case 2:
                    // View Animals
                    View_Animals();
                    break;
                case 3:
                    // Exit
                    b = false;
                    break;
            }
        }
    }

    public void View_Attractions(){
        Scanner sc = new Scanner(System.in);
        int att_count = 1;
        for(int i=0; i<attractions.length; i++){
            if(attractions[i] != null){
                System.out.println(att_count+" " + attractions[i].getAttraction_name()+" "+"      , Attraction ID: "+attractions[i].getUnique_ID_attraction());
                att_count++;
            }
        }
        System.out.println();
        System.out.print("Enter the Attraction ID of Attraction you want to see : ");
        int choice_id = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<attractions.length; i++){
            if(attractions[i] != null){
                if(attractions[i].getUnique_ID_attraction() == choice_id){
                    System.out.print(attractions[i].getAttraction_description());
                    System.out.println(" Buy your tickets now!");
                    break;
                }
            }
        }
    }

    public void View_Animals(){
        int ani_count = 1;
        for (int i=0; i<Admin.animals.length; i++){
            if(Admin.animals[i] != null){
                System.out.println(ani_count+" "+Admin.animals[i].getName()+" ,Type: "+Admin.animals[i].getType());
                ani_count++;
            }

        }
    }

    public void view_SpecialDeals(){
        int count = 1;
        for(int i=0; i<specialDeals.length; i++){
            if(specialDeals[i] != null){
                System.out.println(count +". Buy "+ specialDeals[i].getNo_of_Attraction_tickets() + " tickets and get" +
                        specialDeals[i].getSpecialDealPercentage() + " % off");
            }
        }
    }
    public void buy_Membership(){
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while(b) {
            System.out.println("-----------------------\n" +
                    "Buy Membership:\n" +
                    "1. Basic Membership (₹20)\n" +
                    "2. Premium Membership (₹50)\n" +
                    "-----------------------\n");
            int buy = sc.nextInt();
            sc.nextLine();
            System.out.println();
            System.out.print("Apply Discount: ");
            String coupon = sc.nextLine();
            switch (buy) {
                case 1:
                    float new_balance_basic = 0;
                    for(int i=0; i< discs.length; i++) {
                        if(discs[i] != null) {
                            if (coupon.equals("None") || (coupon.equals(discs[i].getDiscountCode()) && !(discs[i].getDiscountCode().equals("MINOR10"))   ||   (discs[i].getDiscountCode().equals("SENIOR20"))  )) {
                                if(coupon.equals("None")) {
                                    new_balance_basic = this.balance - 20;
                                    money_Spent += 20;
                                }
                                else{
                                    new_balance_basic = this.balance - 20 + discs[i].getDisc_perc()*20/100;
                                    money_Spent += 20 - 20*(discs[i].getDisc_perc()/100);
                                }
                                this.setBalance(new_balance_basic);
                                System.out.println("Basic Membership purchased successfully. Your balance is now "+new_balance_basic);
                                b = false;
                                this.Membership = true;
                                break;
                            } else if (coupon.equals(discs[i].getDiscountCode())) {
                                if(discs[i].getDiscountCode().equals("MINOR10") && this.age <= 18) {
                                    new_balance_basic = this.balance - 20 + discs[i].getDisc_perc() * 20 / 100;
                                    money_Spent += 20 - discs[i].getDisc_perc() * 20 / 100;
                                    this.setBalance(new_balance_basic);
                                    System.out.println("Basic Membership purchased successfully. Your balance is now "+new_balance_basic);
                                    b = false;
                                    this.Membership = true;
                                    break;
                                } else if (discs[i].getDiscountCode().equals("SENIOR20") && this.age >= 60) {
                                    new_balance_basic = this.balance - 20 + discs[i].getDisc_perc() * 20 / 100;
                                    money_Spent += 20 - discs[i].getDisc_perc() * 20 / 100;
                                    this.setBalance(new_balance_basic);
                                    System.out.println("Basic Membership purchased successfully. Your balance is now "+new_balance_basic);
                                    b = false;
                                    this.Membership = true;
                                    break;
                                }
                                else{
                                    System.out.println("Cannot apply Discount Code");
                                    break;
                                }
                            }
                        }
                    }
                    break;



                case 2:
                    float new_balance_premium = this.balance;
                    for(int i=0; i< discs.length; i++) {
                        if(discs[i] != null) {
                            if (coupon.equals("None")  || discs[i].getDiscountCode().equals(coupon) && !(discs[i].getDiscountCode().equals("MINOR10")  || discs[i].getDiscountCode().equals("SENIOR20") )) {
                                if(coupon.equals("None")){
                                    new_balance_premium = this.balance - 50;
                                    money_Spent += 50;
                                }
                                else{
                                    new_balance_premium = this.balance - 50 + discs[i].getDisc_perc()*50/100;
                                    money_Spent += 50 - discs[i].getDisc_perc()*50/100;
                                }
                                this.setBalance(new_balance_premium);
                                System.out.println("Premium Membership purchased successfully. Your balance is now "+new_balance_premium);
                                b = false;
                                this.Membership = false;
                                break;
                            }
                            if (coupon.equals(discs[i].getDiscountCode())) {
                                if(discs[i].getDiscountCode().equals("MINOR10") && this.age <= 18) {
                                    new_balance_premium = this.balance - 50 + discs[i].getDisc_perc() * 50 / 100;
                                    money_Spent += 50 - discs[i].getDisc_perc() * 50 / 100;
                                    this.setBalance(new_balance_premium);
                                    System.out.println("Premium Membership purchased successfully. Your balance is now "+new_balance_premium);
                                    b = false;
                                    this.Membership = false;
                                    break;
                                } else if (discs[i].getDiscountCode().equals("SENIOR20") && this.age >= 60) {
                                    new_balance_premium = this.balance - 50 + discs[i].getDisc_perc() * 50 / 100;
                                    money_Spent += 50 - discs[i].getDisc_perc() * 50 / 100;
                                    this.setBalance(new_balance_premium);
                                    System.out.println("Premium Membership purchased successfully. Your balance is now "+new_balance_premium);
                                    b = false;
                                    this.Membership = false;
                                    break;
                                }
                                else{
                                    System.out.println("Cannot apply Discount Code");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Input !!");
                    break;
            }
        }
    }



    public void visit_Attraction(){
        Scanner sc = new Scanner(System.in);
        int count = 1;
        for (int i=0; i< attractions.length; i++){
            if(attractions[i] != null){
                System.out.println(count + " " + attractions[i].getAttraction_name() + "    Attraction ID: " + attractions[i].getUnique_ID_attraction());
                count++;
            }
        }
        System.out.println();
        System.out.print("Enter the ATTRACTION ID of Attraction you want to visit: ");
        int choice_id = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<attractions.length; i++){
            if(attractions[i] != null){
                if(attractions[i].getUnique_ID_attraction() == choice_id){
                    if(attractions[i].isOpen()){
                        for (int j=0; j<buy_attraction_tickets.length; j++){
                            if(buy_attraction_tickets[j].getUid_attraction() == attractions[i].getUnique_ID_attraction() && buy_attraction_tickets[j].getNo_tickets_bought()>0){
                                int bought = buy_attraction_tickets[j].getNo_tickets_bought() - 1;
                                int visit = buy_attraction_tickets[j].getNo_visits() + 1;
                                buy_attraction_tickets[j].setNo_visits(visit);
                                buy_attraction_tickets[j].setNo_tickets_bought(bought);
                                System.out.println("Thanks for visiting. Hope you enjoyed your time.");
                                break;
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Attraction is currently closed.");
                    }
                }
            }
        }
    }

    public void visit_Animals(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Animals in our Zoo : ");
        for(int i=0; i<animals.length; i++){
            if(animals[i] != null){
                System.out.println(i+1 + " " + animals[i].getName() + ", Animal_ID: "+ animals[i].getAnimal_ID());
            }
        }
        System.out.print("Enter animal ID of animal you want to see: ");
        int id = sc.nextInt();
        for(int i=0; i<animals.length; i++){
            if(animals[i] != null){
                if (animals[i].getAnimal_ID() == id){
                    animals[i].animal_noise();
                    break;
                }
            }
        }
    }

    public void buy_Tickets(){
        Scanner sc = new Scanner(System.in);
        int count = 1;
        System.out.println("--------------------------\n"+
                "Buy Tickets:\n" +
                "Select an Attraction to Buy a Ticket\n");
        // Attractions List
        for (int i=0; i< attractions.length; i++){
            if(attractions[i] != null){
                System.out.println(count +" "+"Attraction ID: "+attractions[i].getUnique_ID_attraction() + "  "+ attractions[i].getAttraction_name()+" (₹"+attractions[i].getAttraction_fee()+")");
                count++;
            }
        }
        System.out.println("--------------------------\n");

        System.out.print("Enter ATTRACTION ID of Attraction you want to see: ");
        int att_id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter no of Tickets you want to purchase : ");
        int att_tickets = sc.nextInt();
        sc.nextLine();

        if(this.Membership){
            // Basic Visitor
            for (int i=0; i<attractions.length; i++){
                if(attractions[i] != null){
                    if(attractions[i].getUnique_ID_attraction() == att_id){
                        if (this.balance >= att_tickets * attractions[i].getAttraction_fee()){
                            int counter = 0;
                            for(int k=0; k<specialDeals.length; k++) {
                                if(specialDeals[k] != null) {
                                    if(att_tickets == specialDeals[k].getNo_of_Attraction_tickets() && att_tickets == 2) {
                                        money_Spent += att_tickets * attractions[i].getAttraction_fee() - att_tickets * attractions[i].getAttraction_fee() * specialDeals[k].getSpecialDealPercentage()/100;
                                        this.balance = this.balance - att_tickets * attractions[i].getAttraction_fee() - att_tickets * attractions[i].getAttraction_fee() * specialDeals[k].getSpecialDealPercentage()/100;
                                        break;
                                    } else if (att_tickets >= 3) {
                                        money_Spent += att_tickets * attractions[i].getAttraction_fee() - att_tickets * attractions[i].getAttraction_fee() * 30/100;
                                        this.balance = this.balance - att_tickets * attractions[i].getAttraction_fee() - att_tickets * attractions[i].getAttraction_fee() * 30/100;
                                        break;
                                    }
                                } else if (counter == specialDeals.length-1) {
                                    money_Spent += att_tickets * attractions[i].getAttraction_fee();
                                    this.balance = this.balance - att_tickets * attractions[i].getAttraction_fee();
                                    break;
                                }
                                counter++;
                            }
                            int count_disc = 0;
                            for (int l=0; l<discs.length; l++){
                                if(discs[l] != null){
                                    if(discs[l].getDiscountCode().equals("MINOR10") && this.age <= 18){
                                        money_Spent -= att_tickets * attractions[i].getAttraction_fee() * 10/100;
                                        this.balance += att_tickets * attractions[i].getAttraction_fee() * 10/100;
                                        break;
                                    } else if (discs[l].getDiscountCode().equals("SENIOR20") && this.age >= 60) {
                                        money_Spent -= att_tickets * attractions[i].getAttraction_fee() * 20/100;
                                        this.balance += att_tickets * attractions[i].getAttraction_fee() * 20/100;
                                        break;
                                    } else if (this.age <= 60 && this.age >= 18) {
                                        money_Spent -= att_tickets * attractions[i].getAttraction_fee() * discs[l].getDisc_perc()/100;
                                        this.balance += att_tickets * attractions[i].getAttraction_fee() * discs[l].getDisc_perc()/100;
                                        break;
                                    }
                                } else if (count_disc == discs.length-1) {
                                    System.out.println("Applied Discount Code: None");
                                }
                                count_disc++;
                            }
                            Attraction_Tickets curr_att_tickets = new Attraction_Tickets();
                            curr_att_tickets.setNo_tickets_bought(att_tickets);
                            curr_att_tickets.setUid_attraction(attractions[i].getUnique_ID_attraction());
                            for(int j=0; j<buy_attraction_tickets.length; j++){
                                if(buy_attraction_tickets[j] == null){
                                    buy_attraction_tickets[j] = curr_att_tickets;
                                    System.out.println("Attraction Tickets bought successfully !!");
                                    break;
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Insufficient Balance !!");
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Tickets are free of cost for Premium Visitors.");
            for(int i=0; i<attractions.length; i++){
                if(attractions[i] != null){
                    if(attractions[i].getUnique_ID_attraction() == att_id){
                        Attraction_Tickets curr_att_tickets = new Attraction_Tickets();
                        curr_att_tickets.setNo_tickets_bought(att_tickets);
                        curr_att_tickets.setUid_attraction(attractions[i].getUnique_ID_attraction());
                        for(int j=0; j<buy_attraction_tickets.length; j++){
                            if(buy_attraction_tickets[j] == null){
                                buy_attraction_tickets[j] = curr_att_tickets;
                                System.out.println("Attraction Tickets bought successfully !!");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void view_Discounts(){
        System.out.println("----------------------\n" +
                "View Discounts:\n" +
                "----------------------\n");
        for (int i = 0; i< discs.length; i++){
            if(discs[i] != null){
                System.out.println(i+1 + " " + discs[i].getCategory()+" - "+discs[i].getDiscountCode());
            }
        }
    }

    public void leave_Feedback(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Leave Feedback:\n"+
                "Enter your feedback (max 200 characters): ");
        String curr_feedback = sc.nextLine();
        this.feedback = curr_feedback;
        System.out.println("Thank you for your feedback.");
    }
}

class Discounts extends Visitor{
    private String category;
    private String discountCode;
    private int disc_perc;

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
    public int getDisc_perc() {
        return disc_perc;
    }
    public void setDisc_perc(int disc_perc) {
        this.disc_perc = disc_perc;
    }
}

class SpecialDeals extends Visitor{
    private int no_of_Attraction_tickets;
    private int specialDealPercentage;

    public int getNo_of_Attraction_tickets() {
        return no_of_Attraction_tickets;
    }
    public void setNo_of_Attraction_tickets(int no_of_Attraction_tickets) {
        this.no_of_Attraction_tickets = no_of_Attraction_tickets;
    }
    public int getSpecialDealPercentage() {
        return specialDealPercentage;
    }
    public void setSpecialDealPercentage(int specialDealPercentage) {
        this.specialDealPercentage = specialDealPercentage;
    }
}

class Attractions{
    private String attraction_name;
    private String attraction_description;
    private int Unique_ID_attraction;
    private boolean isOpen;
    private float attraction_fee;

    private int no_of_visits;

    public int getNo_of_visits() {
        return no_of_visits;
    }
    public void setNo_of_visits(int no_of_visits) {
        this.no_of_visits = no_of_visits;
    }

    public float getAttraction_fee() {
        return attraction_fee;
    }
    public void setAttraction_fee(float attraction_fee) {
        this.attraction_fee = attraction_fee;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean open) {
        isOpen = open;
    }
    public void setUnique_ID_attraction(int unique_ID_attraction) {
        Unique_ID_attraction = unique_ID_attraction;
    }
    public int getUnique_ID_attraction() {
        return Unique_ID_attraction;
    }
    public void setAttraction_name(String attraction_name) {
        this.attraction_name = attraction_name;
    }
    public void setAttraction_description(String attraction_description) {
        this.attraction_description = attraction_description;
    }
    public String getAttraction_name() {
        return attraction_name;
    }
    public String getAttraction_description() {
        return attraction_description;
    }
}

class Attraction_Tickets{
    private int uid_attraction;
    private int no_tickets_bought;
    private int no_visits;

    public int getUid_attraction() {
        return uid_attraction;
    }
    public void setUid_attraction(int uid_attraction) {
        this.uid_attraction = uid_attraction;
    }
    public int getNo_tickets_bought() {
        return no_tickets_bought;
    }
    public void setNo_tickets_bought(int no_tickets_bought) {
        this.no_tickets_bought = no_tickets_bought;
    }
    public int getNo_visits() {
        return no_visits;
    }
    public void setNo_visits(int no_visits) {
        this.no_visits = no_visits;
    }
}
