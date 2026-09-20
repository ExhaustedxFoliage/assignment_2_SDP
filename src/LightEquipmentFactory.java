public class LightEquipmentFactory implements HeroEquipmentFactory {
    @Override
    public Item createItem() { return new SunStrikeStuff(); }

    @Override
    public Courier createCourier() { return new LightCourier(); }
}