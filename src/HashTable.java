import java.util.LinkedList;
import java.util.Objects;

public class HashTable<K, V> {
    //объявляет вложенный класс.
    private static class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            //присваивание
            this.key = key;
            this.value = value;
        }

        public K getKey() {

            return key;
        }
        public V getValue() {

            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) { // определяет, равны ли два объекта

            if (this == obj) { //Проверяет, сравниваются ли один и тот же объект
                return true;
            }

            if (!(obj instanceof Entry<?, ?> entry)) { //Проверяет, является ли передаваемый объект obj экземпляром класса Entry
                return false;
            }

            return Objects.equals(getKey(), entry.getKey()); //Сравнивает ключи двух объектов
        }
        //реализует метод hashCode для класса Entry, который является вложенным классом в классе HashTable
        @Override
        public int hashCode() {
            return Objects.hash(getKey());
        }

    }
    //объявляет массив ссылок на LinkedList
    private LinkedList<Entry<K, V>>[] table;
    private int size; //поле целого типа, хранит количество элементов в HashTable

    public HashTable(int capacity) { //задает начальную емкость хэш-таблицы
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) { //принимает ключ и возвращает его хеш-код
        return Math.abs(Objects.hashCode(key)) % table.length; // Возвращает абсолютное значение хеш-кода, чтобы получить неотрицательное число
    }

    public void put(K key, V value) { //добавляет

        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        //обновление значения по ключу
        for (Entry<K, V> entry : table[index]) { //список элементов, которые хранятся в определенной ячейке массива table.
            if (entry.getKey().equals(key)) { //получает ключ текущего элемента Entry.
                entry.setValue(value); //обновление значения
                return;
            }
        }
//прибавление нового элемента
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) { //возвращает значение

        int index = hash(key);

        LinkedList<Entry<K, V>> bucket = table[index];

        if (bucket != null) { //bucket-список элементов Entry
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    public V remove(K key) {

        int index = hash(key);

        LinkedList<Entry<K, V>> bucket = table[index];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    V removedValue = entry.getValue();
                    bucket.remove(entry);
                    size--;
                    return removedValue;
                }
            }
        }

        return null;
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

}