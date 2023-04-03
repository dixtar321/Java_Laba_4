public class Main{

    public static void main(String[] args){
        SortedIntegerList list1 = new SortedIntegerList(false, 1);
        SortedIntegerList list2 = new SortedIntegerList(true, 0);

        list1.add(4);
        list1.add(6);
        list1.add(4);
        list1.add(7);
        list1.add(3);
        list1.add(1);


        list2.add(7);
        list2.add(4);
        list2.add(6);
        list2.add(4);
        list2.remove(7);
        list2.remove(5);
        //System.out.println(list1.equals(list2));
        
        list1.printList();  
        list1.reverse();


        list1.printList();
        list2.printList();
    }
}