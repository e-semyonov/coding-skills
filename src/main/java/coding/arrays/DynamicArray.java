package coding.arrays;

class DynamicArray {

    int[] array;
    int capacity = 0;
    int numOfElements = 0;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            this.array = new int[capacity];
            this.capacity = capacity;
            this.numOfElements = 0;
        } else {
            throw new IllegalArgumentException("Size of the array sould be higher than 0, input size = " + capacity);
        }
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (this.numOfElements == this.capacity) {
            this.resize();
        }
        this.array[numOfElements] = n;
        numOfElements++;
    }

    public int popback() {
        int elementToReturn = array[numOfElements - 1];
        numOfElements--;
        return elementToReturn;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int[] newArray = new int[this.capacity];
        for(int i=0; i <= numOfElements - 1; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int getSize() {
        return numOfElements;
    }

    public int getCapacity() {
        return capacity;
    }
}
