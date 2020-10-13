import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ActionSubmitListener implements ActionListener {
    private JTextField outField;
    private StringBuilder sb;

    public ActionSubmitListener(JTextField outField) {
        this.outField = outField;
        this.sb = new StringBuilder();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String val = sb.append(outField.getText())
                .toString();
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        try {
            Object expResult1 = scriptEngine.eval(val);
            outField.setText(expResult1.toString());
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
        }
        sb.setLength(0);
    }
}
