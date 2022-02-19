public class Human {
    private int health;
    private String humanIcon = "H";

    public Human() {
    }

    public Human(int health) {
        setHealth(health);
    }

    @Override
    public String toString() {
        return "Human = { health = " + getHealth() + " }";
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public String getHumanIcon() {
        return this.humanIcon;
    }

    public void humanAttack (Goblin goblin) {
        int getRandomValue = 0;
        int min = 1;
        int max = 10;
        for (int i = min; i <= max; i++ ) {
            getRandomValue = (int) (Math.random() * (max - min)) + min;
        }
        goblin.setHealth(goblin.getHealth() - getRandomValue);
        System.out.println("The human attacked the goblin!");
        if (goblin.getHealth() <= 0) {
            System.out.println("The goblin has died.");
        }
        if (goblin.getHealth() > 0){
            System.out.println("Goblin has remaining health. Goblin's Health: " + goblin.getHealth());
            goblin.goblinAttack(this);
        }
    }


}
