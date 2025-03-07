package smartbox;
import mvc.*;

public class Run extends Command {
    public Run(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Container container = (Container) model;
        String name = Utilities.ask("Component name?");
        try{
            container.launch(name);
        }
        catch(Exception e){
            Utilities.error("Component does not exist.");
        }
    }
}
