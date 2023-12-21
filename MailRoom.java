import java.util.ArrayList;
import java.util.Scanner;

public class MailRoom {
    public static void main(String[] args) {
        ArrayList<Mail> deliver = new ArrayList<Mail>();
        Scanner myScan = new Scanner(System.in);
        int menuSelection;
        System.out.println("Welcome to KSUPS");
        do {
            System.out.print("1. Send letter\n2. Send flat\n3. Send regular box\n4. Send live box" +
                    "\n5. Dispatch items\n6. Quit\nEnter option: ");
            menuSelection = Integer.parseInt(myScan.nextLine());

            if (menuSelection == 1) {
                System.out.print("Enter the delivery address: ");
                String deliverAddress = myScan.nextLine();
                System.out.print("Enter the return address: ");
                String returnAddress = myScan.nextLine();
                System.out.print("Enter the width of your mail: ");
                double width = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the length of your mail: ");
                double length = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the thickness of your mail: ");
                double thickness = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the contents of your letter: ");
                String contents = myScan.nextLine();

                Letter newLetter = new Letter(deliverAddress, returnAddress, width, length, thickness, contents);
                if (handleLetter(newLetter, deliver))  {
                    System.out.println("Letter accepted for delivery.");
                }
                else {
                    System.out.println("Letter cannot be mailed.");
                }
            }
            else if (menuSelection == 2) {
                System.out.print("Enter the delivery address: ");
                String deliverAddress = myScan.nextLine();
                System.out.print("Enter the return address: ");
                String returnAddress = myScan.nextLine();
                System.out.print("Enter the width of your mail: ");
                double width = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the length of your mail: ");
                double length = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the thickness of your mail: ");
                double thickness = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the contents of your Flat: ");
                String contents = myScan.nextLine();

                Flat newFlat = new Flat(deliverAddress, returnAddress, width, length, thickness, contents);
                if (handleFlat(newFlat, deliver))  {
                    System.out.println("Flat accepted for delivery.");
                }
                else {
                    System.out.println("Flat cannot be mailed.");
                }
            }
            else if (menuSelection == 3) {
                System.out.print("Enter the delivery address: ");
                String deliverAddress = myScan.nextLine();
                System.out.print("Enter the return address: ");
                String returnAddress = myScan.nextLine();
                System.out.print("Enter the width of your mail: ");
                double width = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the length of your mail: ");
                double length = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the height of your mail: ");
                double height = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter how many items your box has: ");
                int count = Integer.parseInt(myScan.nextLine());
                System.out.print("Enter the weight of your box: ");
                double weight = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the contents of your box: ");
                String contents = myScan.nextLine();

                RegularBox newRegularBox = new RegularBox(deliverAddress, returnAddress, width, length, height, count, contents, weight);
                if (handleRegularBox(newRegularBox, deliver))  {
                    System.out.println("Regular box accepted for delivery.");
                }
                else {
                    System.out.println("Regular box cannot be mailed.");
                }
            }
            else if (menuSelection == 4) {
                System.out.print("Enter the delivery address: ");
                String deliverAddress = myScan.nextLine();
                System.out.print("Enter the return address: ");
                String returnAddress = myScan.nextLine();
                System.out.print("Enter the width of your mail: ");
                double width = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the length of your mail: ");
                double length = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter the height of your mail: ");
                double height = Double.parseDouble(myScan.nextLine());
                System.out.print("Enter how many items your box has: ");
                int count = Integer.parseInt(myScan.nextLine());
                System.out.print("Enter what animal is being shipped: ");
                String animal = myScan.nextLine();
                System.out.print("Enter age of the oldest animal, in days: ");
                int age = Integer.parseInt(myScan.nextLine());

                LiveBox newLiveBox = new LiveBox(deliverAddress, returnAddress, width, length, height, count, animal, age);
                if (handleLiveBox(newLiveBox, deliver))  {
                    System.out.println("Live box accepted for delivery.");
                }
                else {
                    System.out.println("Live box cannot be mailed.");
                }
            }
            else if (menuSelection == 5) {
                if (deliver.size()>0) {
                    System.out.println("DISPATCHING THE FOLLOWING ITEMS FOR DELIVERY:\n========");
                    for (int i = 0; i < deliver.size(); i++) {
                        System.out.println(i+"\n"+deliver.get(i).toString()+"\n========");
                    }
                    deliver.clear();
                }
                else {
                    System.out.println("Delivery queue is empty.");
                }
            }
        }while (menuSelection != 6);

        System.out.println("Quitting...");
    }

    public static boolean handleLetter(Letter letter, ArrayList<Mail> deliver) {
        //checks if letter includes deliver and return address
        if (letter.getDeliveryAddress().equalsIgnoreCase("") || letter.getReturnAddress().equalsIgnoreCase("")) {
            return false;
        }
        //checks if letter length is within parameters
        if (letter.getLength()<5 || letter.getLength()>11.5) {
            return false;
        }
        //checks if letter width is within parameters
        if (letter.getWidth()<3.5 || letter.getWidth()>6.125) {
            return false;
        }
        //checks if letter thickness is within parameters
        if (letter.getThickness()<0.007 || letter.getThickness()>0.25) {
            return false;
        }
        //checks if letter is rectangular
        if (letter.getLength() - 1.5 < letter.getWidth()) {
            return false;
        }
        deliver.add(letter);
        return true;
    }

    public static boolean handleFlat(Flat flat, ArrayList<Mail> deliver) {
        //checks if flat includes deliver and return address
        if (flat.getDeliveryAddress().equalsIgnoreCase("") || flat.getReturnAddress().equalsIgnoreCase("")) {
            return false;
        }
        //checks if flat length is within parameters
        if (flat.getLength()< 11.5 || flat.getLength()>15) {
            return false;
        }
        //checks if flat width is within parameters
        if (flat.getWidth()<6.125 || flat.getWidth()>12) {
            return false;
        }
        //checks if flat thickness is within parameters
        if (flat.getThickness()<0.25 || flat.getThickness()>0.75) {
            return false;
        }
        //checks that contents of flat is DOCUMENTS
        if (!flat.getContents().equalsIgnoreCase("DOCUMENTS")) {
            return false;
        }
        deliver.add(flat);
        return true;
    }

    public static boolean handleRegularBox(RegularBox regularBox, ArrayList<Mail> deliver) {
        //checks if regularBox includes deliver and return address
        if (regularBox.getDeliveryAddress().equalsIgnoreCase("") || regularBox.getReturnAddress().equalsIgnoreCase("")) {
            return false;
        }
        //checks if box length is within parameters
        if (regularBox.getLength()< 6 || regularBox.getLength()>27) {
            return false;
        }
        //checks if box width is within parameters
        if (regularBox.getWidth()<0.25 || regularBox.getWidth()>17) {
            return false;
        }
        //checks if box height is within parameters
        if (regularBox.getHeight()<3 || regularBox.getHeight()>17) {
            return false;
        }
        //checks that count is between 0 and 50
        if (regularBox.getCount()<0 || regularBox.getCount()>50) {
            return false;
        }
        //checks that weight is within parameters
        if (regularBox.getWeight()< 0 || regularBox.getWeight()>70) {
            return false;
        }
        deliver.add(regularBox);
        return true;
    }

    public static boolean handleLiveBox(LiveBox liveBox, ArrayList<Mail> deliver) {
        //checks if liveBox includes deliver and return address
        if (liveBox.getDeliveryAddress().equalsIgnoreCase("") || liveBox.getReturnAddress().equalsIgnoreCase("")) {
            return false;
        }
        //checks if box length is within parameters
        if (liveBox.getLength()< 6 || liveBox.getLength()>27) {
            return false;
        }
        //checks if box width is within parameters
        if (liveBox.getWidth()<0.25 || liveBox.getWidth()>17) {
            return false;
        }
        //checks if box height is within parameters
        if (liveBox.getHeight()<3 || liveBox.getHeight()>17) {
            return false;
        }
        //checks if it's honeybees or chickens. if not, returns false.
        if (!(liveBox.getAnimal().equalsIgnoreCase("HONEYBEES") || liveBox.getAnimal().equalsIgnoreCase("CHICKEN"))) {
            return false;
        }
        //if bees, makes sure amount is allowed/valid. if not, returns false.
        if (liveBox.getAnimal().equalsIgnoreCase("HONEYBEES")) {
            if (liveBox.getCount() < 0 || liveBox.getCount() > 20) {
                return false;
            }
        }
        //if chickens, makes sure amount is allowed/valid. if not, returns false.
        if (liveBox.getAnimal().equalsIgnoreCase("CHICKEN")) {
            if (liveBox.getCount() < 0 || liveBox.getCount()>10) {
                return false;
            }
            //checks if age is greater than 1 day or negative, if so returns false
            if (!(liveBox.getAge() < 0 || liveBox.getAge()==1)) {
                return false;
            }
        }
        deliver.add(liveBox);
        return true;
    }
}
