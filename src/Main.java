public class Main {
    public static void main(String[] args) {
        // Выбираем сет (семейство)
        HeroEquipmentFactory factory = new LightEquipmentFactory();

        Hero hero = new Hero(factory);
        hero.startBattle();
    }
}
