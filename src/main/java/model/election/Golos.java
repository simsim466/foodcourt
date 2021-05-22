package model.election;

import model.User;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Golos {
    private Integer restaurantId;
    @EmbeddedId
    private GolosId id;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Golos(Integer restaurantId, Integer userId, LocalDate date) {
        this.restaurantId = restaurantId;
        this.id = new GolosId(date, userId);
    }

    public Golos() {
    }

    @Embeddable
    public class GolosId implements Serializable {
        private LocalDate date;
        private Integer userId;

        public GolosId(LocalDate date, Integer userId) {
            this.date = date;
            this.userId = userId;
        }

        public GolosId() {
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
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
            GolosId golosId = (GolosId) o;
            return date.equals(golosId.date) && userId.equals(golosId.userId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, userId);
        }
    }
}
