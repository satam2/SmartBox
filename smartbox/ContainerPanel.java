package smartbox;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import mvc.*;

public class ContainerPanel extends AppPanel {
    java.awt.List components;
    private JButton add;
    private JButton remove;
    private JButton run;
    public ContainerPanel(AppFactory factory) {
        super(factory);
        JPanel panel = new JPanel();
        add = new JButton("ADD");
        remove = new JButton("REMOVE");
        run = new JButton("RUN");

        add.addActionListener(this);
        remove.addActionListener(this);
        run.addActionListener(this);

        controlPanel.add(add);
        controlPanel.add(remove);
        controlPanel.add(run);

        controlPanel.setBackground(Color.LIGHT_GRAY);
    }

    // this override needed to re-initialize component fields table:
    public void setModel(Model m) {
        super.setModel(m);
        ((Container) m).initContainer(); // restore fields of components
    }

    public static void main(String[] args) {
        AppPanel panel = new ContainerPanel(new ContainerFactory());
        panel.display();
    }
}