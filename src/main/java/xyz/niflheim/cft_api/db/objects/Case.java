package xyz.niflheim.cft_api.db.objects;

import xyz.niflheim.cft_api.db.annotation.Collection;

@Collection(table = "Cases")
public class Case extends DataObject {
    private String name;
    private String input;
    private String output;

    public Case() {
    }

    public String getName() {
        return name;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public Case setName(String name) {
        this.name = name;
        return this;
    }

    public Case setInput(String input) {
        this.input = input;
        return this;
    }

    public Case setOutput(String output) {
        this.output = output;
        return this;
    }
}
