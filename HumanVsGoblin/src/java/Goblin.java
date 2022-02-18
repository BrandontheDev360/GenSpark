public class Goblin {
    private int health;

    public Goblin() {
        System.out.println(this);
    }

    public Goblin(int health) {
        setHealth(health);
        System.out.println(this);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public Human goblinAttack(Human human) {
        int getRandomValue = 0;
        int min = 1;
        int max = 10;
        for (int i = min; i <= max; i++ ) {
            getRandomValue = (int) (Math.random() * (max - min)) + min;
        }
        human.setHealth((int) (human.getHealth() - getRandomValue));
        return human;
    }
}
