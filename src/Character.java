public abstract class Character {
    private String name;
    private int health, gold, agility, experience, force;

    public Character(String name, int health, int gold, int agility, int experience, int force) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.agility = agility;
        this.experience = experience;
        this.force = force;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int attack() {
        if (agility * 3 > getRandomValue()) return superAttack();
        else return 0;
    }

    public int superAttack() {
        if (getRandomValue() > 90) return force * 2;
        else return force;
    }

    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, health);
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }
}
