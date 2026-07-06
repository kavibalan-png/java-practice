import java.util.*;
public class ListExample1{
    public static void main(String[] args){
	List<String> list=new ArrayList<>();
	list.add("Apple");
	list.add("Orange");
	list.add("Mango");
	System.out.println("List: "+list);
	System.out.println("Size: "+list.size());
	System.out.println("Get: "+list.get(1));
	list.set(1,"Banana");
	System.out.println("After setting: "+list);
	list.remove("Apple");
	System.out.println("After removing: "+list);
	System.out.println("Does list contains Mango? : "+list.contains("Mango"));
	System.out.println("Index of Mango: "+list.indexOf("Mango"));
	System.out.println("Is list empty: "+list.isEmpty());
	list.clear();
	System.out.println("After clearing: "+list);
    }
}