import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
// item class to define all the attributes of an item
class Item{
    String itemId;
    String Name;
    String Description;
    double price;
    //constructor
    public Item(String itemId, String Name, String Description, double price){
        this.itemId=itemId;
        this.Name=Name;
        this.Description=Description;
        this.price=price;
    }
    public void display(){
        System.out.println(itemId+" "+Name+" "+Description+" "+price);
    }
    public double getPrice(){
        return price;
    }
}
//ShoppingCart class to map each item to its quantity
class ShoppingCart{
    HashMap<Item,Integer> cart=new HashMap<>();
    //adding an item to cart and updating its quantity if present
    public void addToCart(Item item,int quantity){
        if(cart.containsKey(item)){
            cart.put(item,cart.get(item)+quantity);
        }
        else{
            cart.put(item,quantity);
        }
        System.out.println("Item added successfully");
    }
    //displaying the quantity of an item 
    public int displayQty(Item item){
        return cart.getOrDefault(item,0);
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
    public double displayBill(){
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
        for(int i=0;i<items.size();i++){
            items.get(i).display();
        }
        int itemno;
        int qty;
        while(true){
            System.out.println("Enter \n 1. add to cart \n 2. display qty \n 3. update qty \n 4. delete item \n 5. display bill \n 6. exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("Select 1-5 which you want to add");
                    itemno=sc.nextInt()-1;
                    System.out.println("Enter the quantity");
                    qty=sc.nextInt();
                    cart.addToCart(items.get(itemno),qty);
                    break;
                case 2 : 
                    System.out.println("Enter item number to display quantity(1-5)");
                    itemno=sc.nextInt()-1;
                    qty=cart.displayQty(items.get(itemno));
                    System.out.println("quantity="+qty);
                    break;
                case 3 :
                    System.out.println("Enter item number to update the quantity(1-5)");
                    itemno=sc.nextInt()-1;
                    System.out.println("Enter the new quantity");
                    qty=sc.nextInt();
                    cart.updateQty(items.get(itemno),qty);
                    break;
                case 4 : 
                    System.out.println("Enter the item number to delete from cart(1-5)");
                    itemno=sc.nextInt()-1;
                    cart.deleteItem(items.get(itemno));
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