public class Main {
    public static void main(String[] args) {
        try {
            MyVector vector = new MyVector(3);

            vector.add(10);
            vector.add(20);
            vector.add(30);

            vector.print();

            vector.add(40);
            vector.print();

            vector.addFirst(5);
            vector.print();

            vector.addAt(2, 15);
            vector.print();

            System.out.println("Element at index 3: " + vector.get(3));
            System.out.println("Size: " + vector.size());
            System.out.println("Capacity: " + vector.capacity());

            vector.removeAt(1);
            vector.print();

            vector.clear();
            vector.print();

            vector.removeAt(0);

        } catch (InvalidCapacityException e) {
            System.out.println("Capacity error: " + e.getMessage());

        } catch (EmptyVectorException e) {
            System.out.println("Empty vector error: " + e.getMessage());

        } catch (InvalidIndexException e) {
            System.out.println("Index error: " + e.getMessage());

        } catch (NullValueException e) {
            System.out.println("Null value error: " + e.getMessage());

        } catch (VectorOverflowException e) {
            System.out.println("Overflow error: " + e.getMessage());
        }
    }
}
