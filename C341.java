class HT {
    
}

public class C341 {
    public static void main(String[] args) {
        int hash = 17;
        String one = "10", two = "20", three = "30";
        hash = hash * 31 + one.hashCode();
        System.out.println(hash);
        System.out.println(hash % 17);
        hash = hash * 31 + two.hashCode();
        System.out.println(hash);
        System.out.println(hash % 17);
        hash = hash * 31 + three.hashCode();
        System.out.println(hash);
        System.out.println(hash % 17);
    }
}
