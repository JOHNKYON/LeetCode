import questions.addTwoNumbers.AddTwoNumbers;


public class Main {
    public static void main(String[] args){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.printList(addTwoNumbers.addTwoNumbers(
                addTwoNumbers.buildTestData(new int[]{1,2,3,5}),
                addTwoNumbers.buildTestData(new int[]{2,3,4,5})
        ));
    }

}
