class Player {
    protected String name;
    protected int age;
    protected String position;

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void play() {
        System.out.println(name + " is playing as " + position);
    }

    public void train() {
        System.out.println(name + " is training.");
    }
}

class Cricket_Player extends Player {
    public Cricket_Player(String name, int age, String position) {
        super(name, age, position);
    }
}

class Football_Player extends Player {
    public Football_Player(String name, int age, String position) {
        super(name, age, position);
    }
}

class Hockey_Player extends Player {
    public Hockey_Player(String name, int age, String position) {
        super(name, age, position);
    }
}

public class EXP5Q2 {
    public static void main(String[] args) {
        Cricket_Player cricketer = new Cricket_Player("Virat Kohli", 34, "Batsman");
        Football_Player footballer = new Football_Player("Cristiano Ronaldo", 39, "Forward");
        Hockey_Player hockeyPlayer = new Hockey_Player("Manpreet Singh", 31, "Midfielder");

        cricketer.play();
        cricketer.train();
        
        footballer.play();
        footballer.train();
        
        hockeyPlayer.play();
        hockeyPlayer.train();
    }
}