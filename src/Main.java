import Collections.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        MyStack<Integer> myStack = new MyStack<>();
        MyQueue<Integer> myQueue = new MyQueue<>();
        MyHashMap<Integer,String> myHashMap = new MyHashMap<>();

        //Testing collections (не встигаю закінчити наглядне тестування)

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println("My ArrayList after adding values "+myArrayList);
        System.out.println("Size of MyArrayList "+myArrayList.size());
        myArrayList.remove(1);
        System.out.println("My ArrayList after removing middle value"+myArrayList);
        System.out.println("Size of MyArrayList "+myArrayList.size());
        System.out.println("myArrayList.get(1) = " + myArrayList.get(1));
        myArrayList.clear();
        System.out.println("My ArrayList after clearing"+myArrayList);

        System.out.println("--------------------------------------------");

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        System.out.println("My MyLinkedList after adding values "+myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.remove(1);
        System.out.println("My LinkedList after removing middle value"+myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println("myLinkedList.get(0) = " + myLinkedList.get(0));



    }
}