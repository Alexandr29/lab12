package main.com.nixsolutions.study.laba11;

public class Main {
    public static void main(String[] args) {
        LoggingArrayCollectionImpl loggingArrayCollection = new LoggingArrayCollectionImpl();
        loggingArrayCollection.add(1);
        loggingArrayCollection.addAll(null);
    }
}
