package xyz.niflheim.cft_api.db.objects;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import xyz.niflheim.cft_api.db.annotation.Collection;

import java.util.Arrays;
import java.util.List;

public class Problem extends DataObject {
    private String name;
    private String description;
    private List<Long> cases;

    public Problem() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getCases() {
        return cases;
    }

    public Problem setName(String name) {
        this.name = name;
        return this;
    }

    public Problem setDescription(String description) {
        this.description = description;
        return this;
    }

    public Problem setCases(List<Long> cases) {
        this.cases = cases;
        return this;
    }

    @BsonIgnore
    public Problem appendCases(Long... ids) {
        cases.addAll(List.of(ids));
        return this;
    }

    @BsonIgnore
    public Problem appendCases(Case... cases) {
        Arrays.asList(cases).forEach(c -> this.cases.add(c.getId()));
        return this;
    }

    @BsonIgnore
    public Problem removeCases(Long... ids) {
        this.cases.removeAll(List.of(ids));
        return this;
    }

    @BsonIgnore
    public Problem removeCases(Case... cases) {
        Arrays.asList(cases).forEach(c -> this.cases.remove(c.getId()));
        return this;
    }
}
