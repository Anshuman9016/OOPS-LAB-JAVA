class PlayerDefeatedException extends Exception {
    public PlayerDefeatedException(String message) {
        super(message);
    }
}

class Player {
    private String name;
    private int health;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) throws PlayerDefeatedException {
        health -= damage;
        if (health < 0) {
            throw new PlayerDefeatedException(name + " has been defeated");
        }
        System.out.println(name + " took " + damage + " damage. Remaining health: " + health);
    }
}

public class EXP8Q2 {
    public static void main(String[] args) {
        Player player = new Player("Warrior 1", 70);
        int[] attacks = {20, 15, 20};

        for (int attack : attacks) {
            try {
                player.takeDamage(attack);
            } catch (PlayerDefeatedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
