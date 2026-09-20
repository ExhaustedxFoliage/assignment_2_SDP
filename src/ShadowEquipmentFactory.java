public class ShadowEquipmentFactory implements HeroEquipmentFactory {
    @Override
    public Item createItem() { return new ShadowBlade(); }

    @Override
    public Courier createCourier() { return new DireCourier(); }
}