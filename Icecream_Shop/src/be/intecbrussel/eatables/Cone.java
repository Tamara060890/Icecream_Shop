package be.intecbrussel.eatables;

public class Cone implements Eatable {
    private Flavor[] balls;
    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    public void eat(){
        System.out.println("Ik eet een hoorntje met smaken: ");
        for (int i = 0; i < balls.length; i++){
            System.out.print(balls[i] + " ");
        }
    }
}
