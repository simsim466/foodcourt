package repository.datajpa.mealImpl;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM User user WHERE user.id =: userId")
    int delete(@Param("userId") int userId);


}
