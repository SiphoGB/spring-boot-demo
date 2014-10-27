package za.co.demo.spring.boot.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserTopic implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7282948236438370325L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = true)
    private long start;

    @Column(nullable = true)
    private long end;

    @Column(nullable = true)
    private double result;

    @ManyToOne
    private Topic topic;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTimeTaken() {
        return end - start;
    }

    @Override
    public String toString() {
        return "UserTopic [id=" + id + ", uuid=" + uuid + ", start=" + start
                + ", end=" + end + ", result=" + result + ", topic=" + topic
                + ", user=" + user + "]";
    }

}
