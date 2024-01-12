package org.example;

import java.util.Scanner;

import static org.example.Visitor.buy_attraction_tickets;

public class Admin implements Animal_Methods{
    static Visitor[] visitors = new Visitor[500];
    int unique_id_no = 1;
    static Attractions[] attractions = new Attractions[100];
    int no_of_attractions = 0;
    static Animals[] animals = new Animals[200];
    int no_of_animals = 0;
    static Discounts[] discs = new Discounts[20];
    static SpecialDeals[] specialDeals = new SpecialDeals[20];

    public void Admin(){
        System.out.println("Logged in as ADMIN");
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        System.out.println();
        while(b){
            System.out.println("----------------------------\n" +
                    "Admin Menu:\n" +
                    "1. Manage Attractions\n" +
                    "2. Manage Animals\n" +
                    "3. Schedule Events\n" +
                    "4. Set Discounts\n" +
                    "5. Set Special Deal\n" +
                    "6. View Visitor Stats\n" +
                    "7. View Feedback\n" +
                    "8. Exit\n"+
            "----------------------------\n");

            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    // Manage Attractions
                    Manage_Attractions();
                    break;
                case 2:
                    // Manage Animals
                    Manage_Animals();
                    break;
                case 3:
                    // Schedule Events
                    Schedule_Events();
                    break;
                case 4:
                    // Set Discounts
                    Set_Discounts();
                    break;
                case 5:
                    // Set Special Deal
                    Set_Special_Deals();
                    break;
                case 6:
                    // View Visitor Stats
                    View_Visitor_Stats();
                    break;
                case 7:
                    // View Feedback
                    View_Feedback();
                    break;
                case 8:
                    // Exit
                    b = false;
                    break;
                default:
                    System.out.println("Invalid Input!!\n" +
                            "Please try again.");
                    break;
            }
        }
    }
    public void Manage_Attractions(){
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while(b){
            System.out.println("-----------------------------\n"+
                    "Manage Attractions:\n" +
                    "1. Add Attraction\n" +
                    "2. View Attractions\n" +
                    "3. Modify Attraction\n" +
                    "4. Remove Attraction\n" +
                    "5. Exit\n"+
                    "-----------------------------\n");
            System.out.print("Enter your Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch){
                case 1:
                    // Add attr
                    add_Attractions();
                    break;
                case 2:
                    // View attr
                    view_Attractions();
                    break;
                case 3:
                    // Modify attr
                    modify_Attraction();
                    break;
                case 4:
                    // Remove attr
                    remove_Attractions();
                    break;
                case 5:
                    b = false;
                    break;
                default:
                    System.out.println("Invalid Input !! Please try again.");
                    break;
            }
        }
    }

    public void add_Attractions(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of Attraction: ");
        String att_name = sc.nextLine();
        System.out.print("Enter Description for Attraction: ");
        String att_description = sc.nextLine();

        for (int i=0; i< attractions.length; i++){
            if(attractions[i] == null){
                Attractions new_att = new Attractions();
                attractions[i] = new_att;
                attractions[i].setAttraction_name(att_name);
                attractions[i].setAttraction_description(att_description);
                attractions[i].setUnique_ID_attraction(unique_id_no);
                // Default
                attractions[i].setOpen(true);
                attractions[i].setAttraction_fee(20);

                System.out.println("Attraction added successfully !!");
                no_of_attractions++;
                unique_id_no++;
                break;
            }
        }
    }

    public void view_Attractions(){
        for (int i=0; i< attractions.length; i++){
            if(attractions[i] == null) continue;
            else{
                System.out.println(i+1 + " " + "ID: " +  attractions[i].getUnique_ID_attraction()  +" "+ attractions[i].getAttraction_name());
                System.out.println(attractions[i].getAttraction_description());
                System.out.println();
            }
        }
    }

    public void modify_Attraction(){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the Unique ID of Attraction: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i<attractions.length; i++){
            if(attractions[i] != null){
                if(id == attractions[i].getUnique_ID_attraction()){
                    System.out.println("--------------------\n"+
                            "Modify: \n"+
                            "1. Attraction name\n"+
                            "2. Attraction Description\n"+
                            "--------------------\n");
                    System.out.print("Enter your Choice: ");
                    int choice = sc.nextInt();
                    if (choice == 1){
                        System.out.print("Enter new Name for Attraction: ");
                        String new_name = sc.nextLine();
                        attractions[i].setAttraction_name(new_name);
                        System.out.println("Name modified successfully !!");
                        break;
                    } else if (choice == 2) {
                        System.out.print("Enter new Description for Attraction: ");
                        String new_desc = sc.nextLine();
                        attractions[i].setAttraction_description(new_desc);
                        System.out.println("Description modified successfully !!");
                        break;
                    }else {
                        System.out.println("Invalid Choice !!");
                        break;
                    }
                }
            }
            else if (count == attractions.length - 1) {
                System.out.println("No such Attraction with this ID is found.");
                System.out.println();
                break;
            }
            count++;
        }
    }

    public void remove_Attractions(){
        int count = 0;
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the Unique ID of Attraction to remove : ");
        int id = sc.nextInt();

        for (int i = 0; i<attractions.length; i++){
            if (attractions[i] != null){
                if (id == attractions[i].getUnique_ID_attraction()){
                    attractions[i] = null;
                    System.out.println("Attraction with ID: "+ id +" removed successfully.");
                    System.out.println();
                    no_of_attractions--;
                    break;
                }
            } else if (count == attractions.length-1) {
                System.out.println("Attraction with ID: "+ id +" not found !!");
                System.out.println();
            }
            count++;
        }
    }

    public void Manage_Animals() {
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("-----------------------------\n" +
                    "Manage Animals:\n" +
                    "1. Add Animal\n" +
                    "2. Update Animal Details\n" +
                    "3. Remove Animal\n" +
                    "4. Exit\n" +
                    "-----------------------------\n");
            System.out.print("Enter your Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

//            Animals animal0 = new Animals();
//            animal0.setName("lion");
//            animal0.setType("mammal");
//            animal0.setAnimal_ID(0);
//            Animals animal1 = new Animals();
//            animal1.setName("elephant");
//            animal1.setType("mammal");
//            animal1.setAnimal_ID(1);
//            Animals animal2 = new Animals();
//            animal2.setName("crocodile");
//            animal2.setType("reptile");
//            animal2.setAnimal_ID(2);
//            Animals animal3 = new Animals();
//            animal3.setName("snake");
//            animal3.setType("reptile");
//            animal3.setAnimal_ID(3);
//            Animals animal4 = new Animals();
//            animal4.setName("frog");
//            animal4.setType("amphibian");
//            animal4.setAnimal_ID(4);
//            Animals animal5 = new Animals();
//            animal5.setName("salamander");
//            animal5.setType("amphibian");
//            animal5.setAnimal_ID(5);
//
//            Admin.animals[0] = animal0;
//            Admin.animals[1] = animal1;
//            Admin.animals[2] = animal2;
//            Admin.animals[3] = animal3;
//            Admin.animals[4] = animal4;
//            Admin.animals[5] = animal5;

            switch (ch) {
                case 1:
                    // Add Animal
                    add_Animal();
                    no_of_animals++;
                    break;
                case 2:
                    // Update Animal Details
                    update_Animal_Details();
                    break;
                case 3:
                    // Remove Animal
                    remove_Animal();
                    no_of_animals--;
                    break;
                case 4:
                    b = false;
                    break;
                default:
                    System.out.println("Invalid Input !! Please try again.");
                    break;
            }
        }
    }

    public void Schedule_Events(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Attraction ID : ");
        int att_ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Set current Attraction Open(1)/Closed(0): ");
        boolean bo = sc.nextBoolean();
        for (int i=0; i<attractions.length; i++){
            if(attractions[i] != null){
                if(att_ID == attractions[i].getUnique_ID_attraction()){
                    attractions[i].setOpen(bo);
                    System.out.println("Attraction scheduled successfully !!");
                    break;
                }
            }
        }

        // Set Attraction Entry Fee
        System.out.print("Set Fee for current Attraction: ");
        float fee = sc.nextFloat();
        sc.nextLine();
        for (int i=0; i<attractions.length; i++){
            if(attractions[i] != null){
                if(att_ID == attractions[i].getUnique_ID_attraction()){
                    attractions[i].setAttraction_fee(fee);
                    System.out.println("Attraction Fee set successfully !!");
                    break;
                }
            }
        }
    }

    public void Set_Discounts(){
        Scanner sc =new Scanner(System.in);
        boolean b = true;
        while(b) {
            System.out.println("----------------------\n" +
                    "Set Discounts:\n" +
                    "1. Add Discount\n" +
                    "2. Modify Discount\n" +
                    "3. Remove Discount\n" +
                    "4. Exit\n" +
                    "----------------------\n");
            int ch = sc.nextInt();
            sc.nextLine();
//            Discounts d1 = new Discounts();
//            d1.setCategory("Minor");
//            d1.setDiscountCode("MINOR10");
//            d1.setDisc_perc(10);
//
//            Discounts d2 = new Discounts();
//            d2.setCategory("Senior");
//            d2.setDiscountCode("SENIOR20");
//            d2.setDisc_perc(20);
//
//            discs[0] = d1;
//            discs[1] = d2;

            switch (ch) {
                case 1:
                    // Add
                    Discounts d = new Discounts();
                    System.out.print("Enter the Discount Category: ");
                    String cat = sc.nextLine();
                    d.setCategory(cat);
                    System.out.print("Enter the Discount Code: ");
                    String code = sc.nextLine();
                    d.setDiscountCode(code);
                    System.out.print("Enter the Discount Percentage: ");
                    int perc = sc.nextInt();
                    sc.nextLine();
                    d.setDisc_perc(perc);
                    for(int i=0; i< discs.length; i++){
                        if(discs[i] == null){
                            discs[i] = d;
                            System.out.println("Discount added successfully !!");
                            break;
                        }
                    }
                    break;
                case 2:
                    // Modify
                    System.out.print("Enter the Discount code of coupon to be MODIFIED: ");
                    String old_code = sc.nextLine();
                    System.out.println();
                    for (int i=0; i< discs.length; i++){
                        int count = 0;
                        if(discs[i] != null){
                            if (discs[i].getDiscountCode().equals(old_code)){
                                System.out.print("Enter the Modified Discount Category: ");
                                String new_disc_cat = sc.nextLine();
                                System.out.print("Enter the Modified Discount Code: ");
                                String new_disc_code = sc.nextLine();
                                System.out.print("Enter the Modified Discount Percentage: ");
                                int new_disc_perc = sc.nextInt();
                                discs[i].setCategory(new_disc_cat);
                                discs[i].setDiscountCode(new_disc_code);
                                discs[i].setDisc_perc(new_disc_perc);
                                System.out.println("Discount modified successfully !!");
                                break;
                            }
                            else if (count == discs.length-1) {
                                System.out.println("Discount code does not exist.");
                            }
                        }
                        count++;
                    }
                    break;
                case 3:
                    // Remove
                    for(int i=0; i< discs.length; i++){
                        if(discs[i] != null){
                            System.out.println(i+1 + " " + discs[i].getCategory()+" "+discs[i].getDiscountCode()+" "+discs[i].getDisc_perc());
                        }
                    }
                    System.out.println();
                    System.out.print("Enter the Discount CODE of coupon to be REMOVED: ");
                    String rem_disc = sc.nextLine();
                    for(int i=0; i< discs.length; i++){
                        if(discs[i] != null){
                            if(discs[i].getDiscountCode().equals(rem_disc)){
                                discs[i] = null;
                                System.out.println("Discount Coupon removed successfully !!");
                                break;
                            } else if (i == discs.length-1) {
                                System.out.println("Discount coupon does not exist.");
                            }
                        }
                    }
                    System.out.println();

                    //View
                    for(int i=0; i< discs.length; i++){
                        if(discs[i] != null){
                            System.out.println(i+1 + " " + discs[i].getCategory()+" "+discs[i].getDiscountCode()+" "+discs[i].getDisc_perc());
                        }
                    }
                    break;
                default:
                    b = false;
                    break;
            }
        }
    }

    public void Set_Special_Deals(){
        int count = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Special Deals :");
        for(int i=0; i< specialDeals.length; i++){
            if(specialDeals[i] != null){
                System.out.println(count +" No of Tickets reqd: "+ specialDeals[i].getNo_of_Attraction_tickets() +" Discount percentage : "+specialDeals[i].getSpecialDealPercentage());
            }
        }
        System.out.println("Do you want to : \n"+
                "1. Add a Special Deal\n"+
                "2. Remove a Special Deal\n"+
                "3. Return\n");
        System.out.println();
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();
        switch (ch) {
            case 1:
                for (int i = 0; i < specialDeals.length; i++) {
                    if (specialDeals[i] == null) {
                        SpecialDeals deal = new SpecialDeals();
                        int no_of_tickets_attraction = sc.nextInt();
                        sc.nextLine();
                        int deal_perc = sc.nextInt();
                        sc.nextLine();
                        deal.setNo_of_Attraction_tickets(no_of_tickets_attraction);
                        deal.setSpecialDealPercentage(deal_perc);
                        specialDeals[i] = deal;
                        System.out.println("Special Deal added successfully !!");
                        break;
                    }
                }
                break;
            case 2:
                System.out.print("Enter the No of tickets reqd parameter of Deal to REMOVE: ");
                int n = sc.nextInt();
                sc.nextLine();
                for(int i=0; i< specialDeals.length; i++){
                    if(specialDeals[i] != null){
                        if(specialDeals[i].getNo_of_Attraction_tickets() == n){
                            specialDeals[i] = null;
                            System.out.println("Special Deal removed successfully !!");
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public void View_Visitor_Stats(){
        //Admins can access statistics on the number of visitors, revenue, and popular attractions.
        int count = 0;
        for(int i=0; i< visitors.length; i++){
            if(visitors[i] != null)count++;
        }
        System.out.println("No of Visitors in ZOOtopia: "+count);

        // Revenue
        float revenue = 0;
        for (int i=0; i< visitors.length; i++){
            if(visitors[i] != null){
                revenue += visitors[i].getMoney_Spent();
            }
        }
        System.out.println("Revenue : ₹ " + revenue);

        // Popular Attraction

        int max = 0;
        int most_pop_id = 0;
        // compl kro
        for(int x=0; x< visitors.length; x++){
            if(visitors[x] != null) {
                for (int i = 0; i < buy_attraction_tickets.length; i++) {
                    if (buy_attraction_tickets[i] != null) {
                        if (buy_attraction_tickets[i].getNo_visits() > max) {
                            max = buy_attraction_tickets[i].getNo_visits();
                            most_pop_id = buy_attraction_tickets[i].getUid_attraction();
                        }
                    }
                }
            }
        }
        for(int i=0; i<attractions.length ; i++){
            if(attractions[i] != null){
                if(most_pop_id == attractions[i].getUnique_ID_attraction()){
                    System.out.println("Most Popular Attraction is : "+ attractions[i].getAttraction_name());
                    break;
                }
            }
        }

    }
    public void View_Feedback(){
        int count = 1;
        // Access list of Feedback created in Admin class and view feedbacks added to this list via leaveFeedback() method in Visitor.
        for(int i=0; i< visitors.length; i++){
            if(visitors[i] != null) {
                if (visitors[i].getFeedback() != null) {
                    System.out.println(count + " " + visitors[i].getFeedback());
                    count++;
                }
            }
        }
    }
}

abstract class Animal_Things{
    abstract void animal_noise();
    abstract void read();
}

//    Manage Animals:
//        1. Add Animal
//        2. Update Animal Details
//        3. Remove Animal
//        4. Exit

class Animals extends Animal_Things implements Mammal,Reptile,Amphibian{
    private String name;
    private String type;
    private int animal_ID;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAnimal_ID() {
        return animal_ID;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAnimal_ID(int animal_ID) {
        this.animal_ID = animal_ID;
    }

    Scanner sc = new Scanner(System.in);
    public void animal_noise(){
        if(this.getType().equals("mammal")){
            if(this.getName().equals("lion")){
                Mammal mammal = new Lion();
                System.out.println("Do you want to : \n"+
                        "1. Feed\n"+
                        "2. Read\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        mammal.animal_noise();
                        break;
                    case 2:
                        mammal.read();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            }
            else if (this.getName().equals("elephant")) {
                Mammal mammal = new Elephant();
                System.out.println("Do you want to : \n"+
                        "1. Feed\n"+
                        "2. Read\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        mammal.animal_noise();
                        break;
                    case 2:
                        mammal.read();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            }
        }
        else if (this.getType().equals("reptile")) {
            if(this.getName().equals("crocodile")){
                Reptile reptile = new Crocodile();
                System.out.println("Do you want to : \n"+
                        "1. Feed\n"+
                        "2. Read\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        reptile.animal_noise();
                        break;
                    case 2:
                        reptile.read();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            }
            else if (this.getName().equals("snake")) {
                Reptile reptile = new Snake();
                System.out.println("Do you want to : \n"+
                        "1. Feed\n"+
                        "2. Read\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        reptile.animal_noise();
                        break;
                    case 2:
                        reptile.read();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            }
        }
        else if (this.getType().equals("amphibian")) {
            if(this.getName().equals("frog")){
                Amphibian amphibian = new Frog();
                System.out.println("Do you want to : \n"+
                        "1. Feed\n"+
                        "2. Read\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        amphibian.animal_noise();
                        break;
                    case 2:
                        amphibian.read();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            } else if (this.getName().equals("salamander")) {
                Amphibian amphibian = new Salamander();
                System.out.println("Do you want to : \n"+
                        "1. Feed\n"+
                        "2. Read\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        amphibian.animal_noise();
                        break;
                    case 2:
                        amphibian.read();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            }
        }
        else{
            System.out.println("We have methods for Default Animals only.");
        }
    }
    public void read(){
        // Already implemented in Animal_noise
    }
}
// Mammals,Reptiles,AMphibians ko Interface bna do & Animal_Methods pe Inheritance lga do
interface Mammal{
    public void animal_noise();
    public void read();
}

class Lion implements Mammal{
    @Override
    public void animal_noise() {
        System.out.println("Roar");
    }

    @Override
    public void read() {
        System.out.println("The lion is a large cat of the genus Panthera native to Africa and India. " +
                "It has a muscular, broad-chested body; short, rounded head; round ears; and a hairy tuft at the end of its tail. " +
                "It is sexually dimorphic; adult male lions are larger than females and have a prominent mane.");
    }
}

class Elephant implements Mammal{
    @Override
    public void animal_noise() {
        System.out.println("Trumphet");
    }

    @Override
    public void read() {
        System.out.println("Elephants are the largest living land animals. " +
                "Three living species are currently recognised: the African bush elephant, the African forest elephant, and the Asian elephant.");
    }
}

interface Reptile{
    public void animal_noise();
    public void read();
}
class Crocodile implements Reptile{
    @Override
    public void animal_noise() {
        System.out.println("Growl");
    }

    @Override
    public void read() {
        System.out.println("Crocodiles or true crocodiles are large semiaquatic reptiles that live throughout" +
                " the tropics in Africa, Asia, the Americas and Australia.");
    }
}
class Snake implements Reptile{
    @Override
    public void animal_noise() {
        System.out.println("Hiss");
    }

    @Override
    public void read() {
        System.out.println("Snakes are elongated, limbless, carnivorous reptiles of the suborder Serpentes." +
                " Like all other squamates, snakes are ectothermic, amniote vertebrates covered in overlapping scales.");
    }
}

interface Amphibian{
    public void animal_noise();
    public void read();
}
class Frog implements Amphibian{
    @Override
    public void animal_noise() {
        System.out.println("Croak");
    }

    @Override
    public void read() {
        System.out.println("A frog is any member of a diverse and largely carnivorous group of short-bodied," +
                " tailless amphibians composing the order Anura");
    }
}
class Salamander implements Amphibian{
    @Override
    public void animal_noise() {
        System.out.println("Hiss");
    }

    @Override
    public void read() {
        System.out.println("Salamanders are a group of amphibians typically characterized" +
                " by their lizard-like appearance, with slender bodies.");
    }
}
interface Animal_Methods{

    public default void add_Animal(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of Animal: ");
        String animal_name = sc.nextLine();
        System.out.print("Enter type of animal: ");
        String animal_type = sc.nextLine();
//        System.out.print("Enter the Attraction ID where animal resides: ");
//        int animal_attraction_id = sc.nextInt();
//        sc.nextLine();

        for (int i=0; i<Admin.animals.length; i++){
            if(Admin.animals[i] == null){
                Animals new_animal = new Animals();
                new_animal.setName(animal_name);
                new_animal.setType(animal_type);
                new_animal.setAnimal_ID(i);
                Admin.animals[i] = new_animal;
                System.out.println("Animal added successfully !!");
                break;
            }
        }
    }

    public default void update_Animal_Details(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the animal you want to update: ");
        String animalName = sc.nextLine();

        for (int i = 0; i < Admin.animals.length; i++) {
            if (Admin.animals[i] != null && Admin.animals[i].getName().equals(animalName)) {
                System.out.print("Enter the new name of the animal: ");
                String new_Name = sc.nextLine();
                System.out.print("Enter the new type of the animal: ");
                String new_Type = sc.nextLine();
//                System.out.print("Enter the new attraction ID where the animal is located: ");
//                int new_AttractionID = sc.nextInt();

                Admin.animals[i].setName(new_Name);
                Admin.animals[i].setType(new_Type);
                //Admin.animals[i].setAnimal_ID(new_AttractionID);
                System.out.println("Animal details updated successfully!");
                return;
            }
        }
        System.out.println("Animal not found !!");
    }

    public default void remove_Animal(){
        Scanner sc = new Scanner(System.in);
        int no_mammals = 0;
        int no_reptiles = 0;
        int no_amphibians = 0;
        for(int x=0; x<Admin.animals.length; x++){
            if(Admin.animals[x] != null){
                if(Admin.animals[x].getType().equals("mammal")){
                    no_mammals++;
                } else if (Admin.animals[x].getType().equals("reptile")) {
                    no_reptiles++;
                } else if (Admin.animals[x].getType().equals("amphibian")) {
                    no_amphibians++;
                }
            }
        }
        if(no_mammals >= 2  &&  no_reptiles >= 2  &&  no_amphibians >= 2) {
            System.out.print("Enter the name of the animal you want to remove: ");
            String animalName = sc.nextLine();
            for (int i = 0; i < Admin.animals.length; i++) {
                if (Admin.animals[i] != null && Admin.animals[i].getName().equals(animalName)) {
                    Admin.animals[i] = null;
                    System.out.println("Animal removed successfully!");
                    return;
                }
            }
            System.out.println("Animal not found!");
        }
        else {
            System.out.println("We cannot remove any animal currently.");
        }
    }
}
