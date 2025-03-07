package smartbox;
import mvc.*;
import java.util.*;

public class ContainerView extends View {

    private java.awt.List components;

    public ContainerView(Model model) {
        super(model);
        components = new java.awt.List(10);
        this.add(components);
    }

    @Override
    public void update(){
        components.removeAll();
        Collection<Component> currentComponents = ((Container) model).getComponents();
        for (Component comp : currentComponents) {
            // Assuming the Component class has a method getName() to fetch the name for display
            components.add(comp.getName());
        }
    }

    // etc.
}
