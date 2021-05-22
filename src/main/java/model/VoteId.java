package model;

import jakarta.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class VoteId implements Serializable {
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id", nullable = false)
    //@NotNull
    //@OnDelete(action = OnDeleteAction.CASCADE)

    private Integer user;

    private LocalDate date;

    public VoteId(@NotNull Integer user, @NotNull LocalDate date) {
        this.user = user;
        this.date = date;
    }

    public VoteId() {
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteId voteId = (VoteId) o;
        return user.equals(voteId.user) && date.equals(voteId.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, date);
    }
}
