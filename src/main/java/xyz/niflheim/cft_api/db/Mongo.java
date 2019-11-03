package xyz.niflheim.cft_api.db;

import xyz.niflheim.cft_api.db.objects.*;
import xyz.niflheim.cft_api.db.util.Connection;

public class Mongo extends DataManager {
    public Mongo() {
        super();
    }

    public Mongo(Connection conn, boolean cloud, DataObject... objects) {
        super(conn, cloud);
        setMappings(objects);
    }

    public User getUserById(long id) {
        return get(id, User.class);
    }

    public User getUserByField(String field, String value) {
        return getByField(field, value, User.class, 1);
    }

    public Problem getProblemById(long id) {
        return get(id, Problem.class);
    }

    public Problem getProblemByField(String field, String value) {
        return getByField(field, value, Problem.class, 1);
    }

    public Submission getSubmissionById(long id) {
        return get(id, Submission.class);
    }

    public Submission getSubmissionByField(String field, String value) {
        return getByField(field, value, Submission.class, 1);
    }

    public Case getCaseById(long id) {
        return get(id, Case.class);
    }

    public Case getCaseByField(String field, String value) {
        return getByField(field, value, Case.class, 1);
    }

    public void updateUser(User user) {
        update(user.getId(), user);
    }

    public void updateProblem(Problem problem) {
        update(problem.getId(), problem);
    }

    public void updateSubmission(Submission submission) {
        update(submission.getId(), submission);
    }

    public void updateCase(Case caze) {
        update(caze.getId(), caze);
    }

    public void deleteUser(User user) {
        delete(user.getId(), User.class);
    }

    public void deleteProblem(Problem problem) {
        delete(problem.getId(), Problem.class);
    }

    public void deleteSubmission(Submission submission) {
        delete(submission.getId(), Submission.class);
    }

    public void deleteCase(Case caze) {
        delete(caze.getId(), Case.class);
    }
}
