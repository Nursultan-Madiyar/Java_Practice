import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private static BufferedReader br;
    private static Character character = null;
    private static Battle battle = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Введите имя персонажа");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {
        if (character == null) {
            character = new Hero(string, 100, 20, 20, 10, 10);
            printNavigation();
        }
        switch (string) {
            case "1": {
                System.out.println("Сколько жизни вы хотите купить? 1 золото = 10 жизней.");
                int hp = Integer.parseInt(br.readLine());
                Dealer dealer = new Dealer();
                dealer.sell(character, hp);
                printNavigation();
                command(br.readLine());
            }
            case "2": {
                battle.fight(character, createMonster());

            }
            case "3": {
                System.exit(1);
                break;
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static Character createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                15,
                20,
                10
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                15,
                20,
                10
        );
    }
}
