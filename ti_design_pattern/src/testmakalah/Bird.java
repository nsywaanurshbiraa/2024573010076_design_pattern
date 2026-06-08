package testmakalah;

class Bird {}

class FlyingBird extends Bird {
    void fly() {
        System.out.println("Flying...");
    }
}

class Sparrow extends FlyingBird {}

class Penguin extends Bird {}
