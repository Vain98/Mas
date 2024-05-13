import Interfaces.Flyable;
import Interfaces.Float;
public class AmphibiousPlane implements Flyable,Float{
    @Override
    public void FlotOnWater() {
        System.out.println("Floating on the water currently");
    }

    @Override
    public void NavigateOnWater() {
        System.out.println("Navigating on water");

    }

    @Override
    public void TakeOffFromWater() {
        System.out.println("Taking off from water");

    }

    @Override
    public void LandOnWater() {
        System.out.println("Landing inside water");

    }
}
