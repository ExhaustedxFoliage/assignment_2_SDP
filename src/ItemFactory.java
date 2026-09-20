public class ItemFactory {
    public abstract Item createItem();

    public void useItem() {
        Item item = createItem();
        item.castSound();
        item.castSpell();
    }
}
