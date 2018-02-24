package q1_linkedList;

/**
 * Created by Zhaozhe on 16/11/2016.
 */
public class LinkedList {


    private LinkedListNode headNode;

    /*
     *  Level 1 - Methods
     */

    public void buildDemo(){
        LinkedListNode n1 = new LinkedListNode(6);
        headNode = n1;

        LinkedListNode n2 = new LinkedListNode(7);
        n1.setNextNode(n2);

        LinkedListNode n3 = new LinkedListNode(3);
        n2.setNextNode(n3);

        LinkedListNode n4 = new LinkedListNode(8);
        n3.setNextNode(n4);

        LinkedListNode n5 = new LinkedListNode(4);
        n4.setNextNode(n5);
    }

    public String description(){

        String description = "";
        description = description + "[";

        LinkedListNode node = headNode;

        while(node.getNextNode() != null){
            int value = node.getValue();
            String valueStr = Integer.toString(value) + ", ";
            description = description + valueStr;
            node = node.getNextNode();
        }

        description = description + Integer.toString(node.getValue());

        description = description + "]";


        return description;
    }

    public int size() {

        LinkedListNode temp = headNode;

        int counter = 1;
        while (temp.getNextNode()!= null){
            temp = temp.getNextNode();
            counter++;
        }

        return counter;
    }

    public boolean isEmpty(){

        boolean isempty = true;
        if (headNode != null){
            isempty = false;
        }
        return isempty;
    }

    /*
     *  Level 2 - Methods
     */

    public int get(int index) {
        LinkedListNode temp = headNode;

        int i = 0;

        while(i < index){

            temp = temp.getNextNode();
            i++;
        }

        int value = temp.getValue();


        return value;
    }

    public int lastValue() {

        LinkedListNode temp = headNode;

        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
        }

        int value = temp.getValue();


        return value;
    }

    public int indexOf(int value) {

        LinkedListNode temp = headNode;

        int counter = 0;

        while(temp.getValue() != value){
            temp = temp.getNextNode();
            if (temp.getNextNode() != null){
                counter++;
            }else{
                counter = -1;
                break;
            }

        }

        return counter;
    }

    public boolean contains(int value) {

        LinkedListNode temp = headNode;

        Boolean check = false;

        while(temp.getNextNode() != null){
            if(temp.getValue() == value){
                check = true;
            }
            temp = temp.getNextNode();
        }

        if (temp.getValue() == value){
            check = true;
        }

        return check;

    }

    /*
     *  Level 3 - Methods
     */

    public void add(int value) {
        LinkedListNode temp = headNode;

        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
        }

        LinkedListNode newNode = new LinkedListNode();
        temp.setNextNode(newNode);
        newNode.setValue(value);

    }

    public void push(int value) {
        LinkedListNode temp = headNode;

        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
        }

        LinkedListNode newNode = new LinkedListNode();
        temp.setNextNode(newNode);
        newNode.setValue(value);

    }

    public void pop(){
        LinkedListNode temp = headNode;

        if(temp.getNextNode() != null) {
            while (temp.getNextNode().getNextNode() != null) {
                temp = temp.getNextNode();
            }
        }
        System.out.println(temp.getValue());
        temp.setNextNode(null);

        //Why this one passes?

    }

    /*
     *  Level 4 - Methods
     */

    /*public void remove(int index){

        LinkedListNode node = headNode;

        LinkedListNode lastNode = headNode;
        LinkedListNode nextNode = headNode;

        int counter = 0;

        if (index == 0){
            nextNode = node.getNextNode();



        }else{
            while(counter<index-1){
                node = node.getNextNode();
                counter++;
                lastNode = node;
            }
            node = lastNode.getNextNode();
            nextNode = node.getNextNode();

            lastNode.setNextNode(nextNode);
            node.setNextNode(null);
        }
    }*/

    public void remove(int index){
        LinkedListNode node = headNode;

        LinkedListNode nodeBefore = node;

        for (int i = 0; i < index; i++){
            nodeBefore = node;
            if(node.getNextNode() != null){
                node = node.getNextNode();
            }
        }

        LinkedListNode nodeAfter = node.getNextNode();


        while (node.getNextNode() != null){
            node.setValue(nodeAfter.getValue());
            nodeBefore = node;
            node = nodeAfter;
            if (nodeAfter.getNextNode() != null){
                nodeAfter = nodeAfter.getNextNode();
            }
        }
        nodeBefore.setNextNode(null);
    }



    public void insert(int index, int value) {

        LinkedListNode node = headNode;

        LinkedListNode nodeBefore = node;

        for (int i = 0; i < index; i++){

            nodeBefore = node;
            node = node.getNextNode();
        }


        LinkedListNode newNode = new LinkedListNode();

        newNode.setValue(value);

        nodeBefore.setNextNode(newNode);
        newNode.setNextNode(node);

    }

    public void replace(int index, int value) {

        LinkedListNode node = headNode;


        for (int i = 0; i < index; i++){
            node = node.getNextNode();

        }

        node.setValue(value);

    }

    /*
     *  Level 5 - Methods
     */

    public LinkedList() {

    }

    public LinkedList(int[] values){

    }

    public LinkedList subList(int fromIndex, int toIndex) {
        return null;
    }

    /*
     *  Level 6 - Methods
     */

    public void remove(int fromIndex, int toIndex){

    }

    public void insert(int fromIndex, LinkedList list) {

    }

    public void replace(int fromIndex, int toIndex, LinkedList list){

    }
}































