public class Human {
    private int health;

    public Human() {
        System.out.println(this);
    }

    public Human(int health) {
        setHealth(health);
        System.out.println(this);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public Goblin humanAttack (Goblin goblin) {
        int getRandomValue = 0;
        int min = 1;
        int max = 10;
        for (int i = min; i <= max; i++ ) {
            getRandomValue = (int) (Math.random() * (max - min)) + min;
        }
        goblin.setHealth((int) (goblin.getHealth() - getRandomValue));
        return goblin;
    }


}
