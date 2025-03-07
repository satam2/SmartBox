package smartbox;
import mvc.*;

public class ContainerFactory implements AppFactory{
    @Override
    public Model makeModel() {
        return new Container();
    }

    @Override
    public View makeView(Model m) {
        if (!(m instanceof Container container))
            throw new RuntimeException("Model must instantiate Container");
        return new ContainerView(container);
    }

    @Override
    public String getTitle() {
        return "SmartBox";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"ADD - add a new component\nREMOVE - remove a component\nRUN - run a component"};
    }

    @Override
    public String about() {
        return "SmartBox v.1.0. Copyright 2024 by Sandy Tam";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"ADD","REMOVE","RUN"};
    }

    @Override
    public Command makeEditCommand(Model model, String name, Object source) {
        return switch (name) {
            case "ADD" -> new Add(model);
            case "REMOVE" -> new Remove(model);
            case "RUN" -> new Run(model);
            default -> throw new IllegalArgumentException("Unexpected value: " + name);
        };
    }
}
