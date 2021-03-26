package portals.customer.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Message implements Serializable {
    private int operation;
    private BigInteger cid;
    private Task task;

    public Message(int operation, BigInteger cid, Task task) {
        this.operation = operation;
        this.cid = cid;
        this.task = task;
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
}
