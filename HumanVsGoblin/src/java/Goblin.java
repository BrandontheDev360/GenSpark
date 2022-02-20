public class Goblin {
    private int health;
    private String goblinIcon = "G";

    public Goblin() {
    }

    public Goblin(int health) {
        setHealth(health);
    }

    @Override
    public String toString() {
        return "Goblin = { health = " + getHealth() + " }";
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public String getGoblinIcon() {
        return this.goblinIcon;
    }

    public void goblinAttack(Human human) {
        int getRandomDmg = 0;
        int min = 1;
        int max = 10;
        for (int i = min; i <= max; i++ ) {
            getRandomDmg = (int) (Math.random() * (max - min)) + min;
        }
        human.setHealth(human.getHealth() - getRandomDmg);
        System.out.println("The goblin attacked the human!");
        if (human.getHealth() > 0) {
            System.out.println("You took " + getRandomDmg + ". Human's Health: " + human.getHealth());
        }
    }
}
