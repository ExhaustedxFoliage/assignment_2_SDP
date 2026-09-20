public class ShadowBlade implements Item{
    @Override
    public void castSpell() { System.out.println("The hero is invisible!"); }

    @Override
    public void castSound() {
        System.out.println("Sound: phtszzz...");
    }
}
