interface Play {
    void play();
}

class Man implements Play {

    @Override
    public void play() {
        System.out.println("man playing");
    }
}

class Dog implements Play {
    @Override
    public void play() {
        System.out.println("Dog playing");
    }
}

public class C122 {
    public static void main(String[] args) {
        Play p1 = new Man();
        Play p2 = new Dog();
        play(p1);
        play(p2);
    }

    static void play(Play p) {
        p.play();
    }
}