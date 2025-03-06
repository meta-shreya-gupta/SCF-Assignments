import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
// item class to define all the attributes of an item
class Item{
    String itemId;
    String name;
    String description;
    double price;
    //constructor
    public Item(String itemId, String name, String description, double price){
        this.itemId=itemId;                 // CR -Done follow same naming convention across all variables. Somewhere we are using camel (itemId, price) case while somewhere Capital first (Name, Description)
        this.name=name;
        this.description=description;
        this.price=price;
    }
    public void display(){
        System.out.println(itemId+" "+name+" "+description+" "+price);
    }
    public double getPrice(){
        return price;
    }
}
//ShoppingCart class to map each item to its quantity
class ShoppingCart{
    HashMap<Item,Integer> cart=new HashMap<>(); // CR - Question-Done - Why you preferred HashMap here?
    //adding an item to cart and updating its quantity if present
    public void addToCart(Item item,int quantity){      // CR -Done Nice to update quantity if it exists, but beware that we already have a menu item to update quantity so this is like duplicated. "We should confirm requirements in these scenarios (PROJECT)"
        cart.put(item,quantity);
        System.out.println("Item added successfully");
    }
    //displaying the quantity of an item 
    public int displayQty(Item item){
        if(cart.get(item)!=null){
            return cart.get(item);
        }
        return 0;
    }
    //updating the quantity and printing message if its not present
    public void updateQty(Item item, int quantity){
        if(cart.containsKey(item)){
            cart.put(item,quantity);
            System.out.println("item updated successfully");
        }
        else{
            System.out.println("item is not present");
        }
    }
    //deleting the item if its present and displaying a message if its not
    public void deleteItem(Item item){
        if(cart.containsKey(item)){
            cart.remove(item);
            System.out.println("Item removed successfully");
        }
        else{
            System.out.println("Item is not present in the cart");
        }
    }
    //generating the bill acc to the quantity
    public double displayBill(){        // CR - Done Good to use for-each loops
        double amt=0;
        for(HashMap.Entry<Item,Integer> entry : cart.entrySet()){
            Item item=entry.getKey();
            int qty=entry.getValue();
            amt+=item.getPrice()*qty;
        }
        return amt;
    }
}
class Assignment1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ShoppingCart cart=new ShoppingCart();
        List<Item> items=new ArrayList<>();
        items.add(new Item("I1","Book","comedy book",200.00));
        items.add(new Item("I2","notebook","100 page notebook",40.00));
        items.add(new Item("I3","electric kettel","stainless steel",1000.00));
        items.add(new Item("I4","smart watch","fitness tracking, heartbeat monitoring", 2000.00));
        items.add(new Item("I5","wireless headphone","batter backup of 8 hrs",1500.00));
        //display the list of items
        for(Item item : items){
            item.display();
        }                       // CR -Done Always prefer for:each loop whenever possible
        int itemNumber;         // CR -Done Keep the naming convention consistent, itemNumber can be the best option 
        int quantity;           // CR -Done use fully qualified names - quantity
        while(true){
            System.out.println("Enter \n 1. add to cart \n 2. display qty \n 3. update qty \n 4. delete item \n 5. display bill \n 6. exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("Select 1-5 which you want to add");
                    itemNumber=sc.nextInt()-1;
                    System.out.println("Enter the quantity");
                    quantity=sc.nextInt();
                    cart.addToCart(items.get(itemNumber),quantity);
                    break;
                case 2 : 
                    System.out.println("Enter item number to display quantity(1-5)");
                    itemNumber=sc.nextInt()-1;
                    quantity=cart.displayQty(items.get(itemNumber));
                    if(quantity==0){
                        System.out.println("Item does not exist in the cart");
                    }
                    else{
                        System.out.println("quantity="+quantity);
                    }
                    break;
                case 3 :
                    System.out.println("Enter item number to update the quantity(1-5)");
                    itemNumber=sc.nextInt()-1;
                    System.out.println("Enter the new quantity");
                    quantity=sc.nextInt();
                    cart.updateQty(items.get(itemNumber),quantity);
                    break;
                case 4 : 
                    System.out.println("Enter the item number to delete from cart(1-5)");
                    itemNumber=sc.nextInt()-1;
                    cart.deleteItem(items.get(itemNumber));
                    break;
                case 5 : 
                    System.out.println("Total Bill amount is "+cart.displayBill());
                    break;
                case 6 : 
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);
                    break;
                default : System.out.println("Not a valid number...Please Try Again!");
            }
        }
    }
}

// Line 27 - I have used HashMap here as it is easy to get the quantity with respect to the item that we are searching for as compared to ArrayList in which we have to traverse for each item