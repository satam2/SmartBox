package smartbox;
import mvc.*;

public class Remove extends Command {
    public Remove(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Container container = (Container) model;
        String name = Utilities.ask("Component name?");
        try{
            container.remComponent(name);
        }
        catch(Exception e){
            Utilities.error("Component does not exist.");
        }
    }
}
