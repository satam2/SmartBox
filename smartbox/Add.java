package smartbox;
import mvc.*;

public class Add extends Command {
    public Add(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Container container = (Container) model;
        String name = Utilities.ask("Component name?");
        try{
            container.addComponent(name);
        }
        catch(Exception e){
            Utilities.error("Component does not exist.");
        }
    }
}
