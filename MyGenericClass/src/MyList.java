import java.util.Arrays;

public class MyList<T> {

    private int capacity;
    private int size = 0;
    private T[] array;


    //Boş contructor kullanılırsa dizinin başlangıç boyutu 10 olmalıdır.
    public MyList(){
        capacity = 10;
        array = (T[]) new Object[capacity];
    }

    //Dizinin başlangıç değeri capacity parametresinden alınmalıdır.
    public MyList(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    //dizideki eleman sayısını verir.
    public int size(){
        return size;
    }

    // dizinin kapasite değerini verir.
    public int getCapacity(){
        return capacity;
    }

    // sınıfa ait diziye eleman eklemek için kullanılmalıdır.
    // Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.
    public void add(T data){
        if(size == getCapacity()){
            int multiply = 2;
            int newCapacity = getCapacity() * multiply;
            capacity = newCapacity;
            T[] newArray = Arrays.copyOf(array, capacity);
            array = newArray;
        }
        array[size] = data;
        size++;
    }

    //verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
    public T get(int index){
        return index < array.length ? array[index] : null;
    }

    //verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sol doğru kaydırmalı.
    // Geçersiz indis girilerse null döndürür.
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        T removedValue = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        return removedValue;
    }

    //verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır.
    // Geçersiz indis girilerse null döndürür.
    public T set(int index, T data){
        return index < array.length ? array[index] = data : null;
    }

    //Sınıfa ait dizideki elemanları listeleyen bir metot.
    @Override
    public String toString() {
        return "MyList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    //Parametrede verilen nesnenin listedeki indeksini verir.
    // Nesne listede yoksa -1 değerini verir.
    public int indexOf(T data){
        for(int i = 0; i < size; i++){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    //Belirtilen öğenin listedeki son indeksini söyler.
    // Nesne listede yoksa -1 değerini verir.
    public int lastIndexOf(T data){
        for(int i = size-1; i >= 0; i--){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    //Listenin boş olup olmadığını söyler.
    public boolean isEmpty(){
        return size == 0;
    }

    //Listedeki bütün öğeleri siler, boş liste haline getirir.
    public void clear(){
        array = null;
        size = 0;
        capacity = 10;
    }

    //Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> subList(int start,int finish){
        if (start < 0 || finish > size() || start > finish) {
            throw new IndexOutOfBoundsException("Invalid start or finish index");
        }
        MyList<T> newList = new MyList<>();
        newList.array = (T[]) new Object[finish - start];
        newList.size = finish - start;

        for(int i = 0; i < newList.size; i++) {
            newList.array[i] = array[start + i];
        }

        return newList;
    }

    //Parametrede verilen değerin dizide olup olmadığını söyler.
    public boolean contains(T data){
        for(int i = 0; i<size(); i++){
            if(array[i] == data){
                return true;
            }
        }
        return false;
    }

}
