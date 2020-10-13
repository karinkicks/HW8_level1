import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSubmitHandleListener implements ActionListener {
    private JTextField outField;
    private StringBuilder sb;

    public ActionSubmitHandleListener(JTextField outField) {
        this.outField = outField;
        this.sb = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String val = sb.append(outField.getText())
                .toString();
        if (val.contains("-")||val.contains("+")) {
            String parts[] = val.split("-|\\+");
            String part1 = parts[0];
            String part2 = parts[1];
            boolean addition = val.contains("+");
            int result = Integer.parseInt(part1) + (addition ? Integer.parseInt(part2) : -Integer.parseInt(part2));
            outField.setText(val +" = "+ result);
        }
        sb.setLength(0);
    }
}
