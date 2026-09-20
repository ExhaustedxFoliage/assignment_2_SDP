public class Hero {
    private final Item item;
    private final Courier courier;

    public Hero(HeroEquipmentFactory factory) {
        this.item = factory.createItem();
        this.courier = factory.createCourier();
    }

    public void startBattle() {
        courier.deliver();
        item.castSound();
        item.castSpell();
    }
}
