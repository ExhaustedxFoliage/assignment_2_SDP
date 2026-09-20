public class Bloodthorn implements Item {
    @Override
    public void castSpell() {
        System.out.println("The target is silenced!");
        System.out.println("+50 magic damage from each hit!");
    }
    @Override
    public void castSound() {
        System.out.println("Sound: Pchhsss...");
    }
}
