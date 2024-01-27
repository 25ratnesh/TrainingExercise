public class MyStringBuilder {
    private char[] value;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyStringBuilder() {
        value = new char[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyStringBuilder(String str) {
        this();
        append(str);
    }

    public void append(String str) {
        ensureCapacity(size + str.length());
        str.getChars(0, str.length(), value, size);
        size += str.length();
    }

    public void insert(int index, String str) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        ensureCapacity(size + str.length());
        System.arraycopy(value, index, value, index + str.length(), size - index);
        str.getChars(0, str.length(), value, index);
        size += str.length();
    }

    public void delete(int start, int end) {
        if (start < 0 || end > size || start > end) {
            throw new IndexOutOfBoundsException("Invalid start or end index");
        }

        System.arraycopy(value, end, value, start, size - end);
        size -= (end - start);
    }

    @Override
    public String toString() {
        return new String(value, 0, size);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > value.length) {
            int newCapacity = Math.max(minCapacity, value.length * 2);
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, size);
            value = newValue;
        }
    }

    public static void main(String[] args) {
        MyStringBuilder myStringBuilder = new MyStringBuilder("Hello, ");

        myStringBuilder.append("world!");
        System.out.println("After Append: " + myStringBuilder);

        myStringBuilder.insert(7, "beautiful ");
        System.out.println("After Insert: " + myStringBuilder);

        myStringBuilder.delete(0, 6);
        System.out.println("After Delete: " + myStringBuilder);
    }
}
