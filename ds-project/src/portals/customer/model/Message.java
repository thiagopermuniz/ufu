package portals.customer.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Message implements Serializable {
    private int operation;
    private BigInteger cid;
    private Task task;

    public Message() {
    }

    public BigInteger getCid() {
        return cid;
    }

    public void setCid(BigInteger cid) {
        this.cid = cid;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Message{" +
                "operation=" + operation +
                ", cid=" + cid +
                ", task=" + task +
                '}';
    }
}
