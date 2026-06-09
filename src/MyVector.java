public class MyVector {
    private Integer[] data;
    private int size;
    private int capacity;

    public MyVector() throws InvalidCapacityException {
        this(10);
    }

    public MyVector(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0");
        }

        this.capacity = capacity;
        this.data = new Integer[capacity];
        this.size = 0;
    }

    public void add(Integer value) {
        if (value == null) {
            throw new NullValueException("Value cannot be null");
        }

        ensureCapacity();
        data[size] = value;
        size++;
    }

    public void addFirst(Integer value) {
        addAt(0, value);
    }

    public void addAt(int index, Integer value) {
        if (value == null) {
            throw new NullValueException("Value cannot be null");
        }

        if (index < 0 || index > size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        return data[index];
    }

    public void removeAt(int index) throws EmptyVectorException {
        if (size == 0) {
            throw new EmptyVectorException("Vector is empty");
        }

        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
    }

    public void clear() {
        data = new Integer[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            if (capacity > Integer.MAX_VALUE / 2) {
                throw new VectorOverflowException("Vector is too large");
            }

            capacity *= 2;
            Integer[] newData = new Integer[capacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    public void print() {
        System.out.print("[ ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("]");
    }
}
