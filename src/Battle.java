public class Battle {
    public void fight(Character hero, Character monster) {
        int round = 1;
        boolean isFightEnded = false;
        while (!isFightEnded) {
            System.out.println("Начинается раунд " + round);
            if (round%2 != 0) {
                int attackPower = hero.attack();
                monster.setHealth(monster.getHealth() - attackPower);
                if (attackPower == 0) System.out.println(hero.getName() + " промахивается");
                else {
                    System.out.println(String.format("%s нанес удар в %d единиц", hero.getName(), attackPower));
                    System.out.println(String.format("У %s осталось %d здоровья", monster.getName(), monster.getHealth()));
                }
                if (monster.getHealth() <= 0) {
                    System.out.println(String.format("%s был убит", monster.getName()));
                    isFightEnded = true;
                    hero.setGold(hero.getGold() + monster.getGold());
                    hero.setExperience(hero.getExperience() + monster.getExperience());
                    System.out.println("Герой забрал золото и опыт монстра. ");
                    System.out.print(String.format("Теперь у героя %d золото и %d опыта.", hero.getGold(), hero.getExperience()));
                }
            }
            else {
                int attackPower = monster.attack();
                hero.setHealth(hero.getHealth() - attackPower);
                if (attackPower == 0) System.out.println(monster.getName() + " промахивается");
                else {
                    System.out.println(String.format("%s нанес удар в %d единиц", monster.getName(), attackPower));
                    System.out.println(String.format("У %s осталось %d здоровья", hero.getName(), hero.getHealth()));
                }
                if (hero.getHealth() <= 0) {
                    System.out.println("Герой был убит. Игра заканчивается.");
                    isFightEnded = true;
                }
            }
            round = round + 1;
        }
    }
}
