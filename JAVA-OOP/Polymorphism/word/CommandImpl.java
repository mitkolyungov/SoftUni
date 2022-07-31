package Skeletons.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    static class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(TextModifier text, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                text.getText ().setCharAt (i, Character.toUpperCase (text.getText ().charAt (i)));
            }
        }
    }

    class cutTransform implements TextTransform {
        private String lastRemoved = "";
        @Override
        public void invokeOn(TextModifier text, int startIndex, int endIndex) {
            if (text.getText ().toString ().length () <= 0) {
                return;
            }
            if (startIndex == endIndex) {
                text.setCut ("");
                return;
            }
            this.lastRemoved = "";
            for (int i = startIndex; i < endIndex; i++) {
                this.lastRemoved += text.getText ().charAt (i);
            }
            text.getText ().replace (startIndex, endIndex, "");
            text.setCut (lastRemoved);
        }
    }

    class pasteTransform implements TextTransform {
        @Override
        public void invokeOn(TextModifier text, int startIndex, int endIndex) {
            if (startIndex == endIndex) {
                text.getText().insert(startIndex, text.getCut());
            } else if (startIndex <= text.getText().toString().length() - 1) {
                text.getText().replace(startIndex, endIndex, text.getCut());
            } else {
                text.setText(text.getText().append(text.getCut()));
            }
        }
    }

    private Map<String, TextTransform> commandTransforms;
    private TextModifier text;
    private String removedElements;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<> ();
        this.text = new TextModifier (text);
    }

    @Override
    public void init() {
        this.commandTransforms.clear ();
        for (Command p : this.initCommands ()) {
            this.commandTransforms.putIfAbsent (p.getText (), p.getTextTransform ());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split ("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt (tokens[1]);
        int endInd = Integer.parseInt (tokens[2]);

        this.commandTransforms.get (commandName).invokeOn (this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<> ();
        commands.add (new Command ("uppercase", new ToUpperTransform ()));
        commands.add (new Command ("cut", new cutTransform ()));
        commands.add (new Command ("paste", new pasteTransform ()));
        return commands;
    }

    public String getRemovedElements() {
        return this.removedElements;
    }
}
