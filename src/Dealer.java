public class Dealer {
    public void sell(Character character, int hp) {
        int price = Math.round(hp/10);
        if (price == 0) price = 1;
        if (price <= character.getGold()) {
            character.setHealth(character.getHealth() + hp);
            character.setGold(character.getGold() - price);
            System.out.println(String.format("Теперь у героя %d жизни и %d золото.", character.getHealth(), character.getGold()));
        }
        else {
            System.out.println(character.getName() + " не достаточно средств для покупки.");
        }
    }
}
