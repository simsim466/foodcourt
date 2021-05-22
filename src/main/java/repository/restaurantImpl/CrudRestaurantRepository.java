package repository.restaurantImpl;

import model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Modifying
    @Transactional
    int deleteRestaurantByIdAndCreatorId(int resId, int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant res WHERE res.id =:resId" +
            " AND res.creator.id =:userId")
    int delete(@Param("resId") int resId, @Param("userId")int userId);

    Optional<Restaurant> findRestaurantByIdAndCreator_Id(int resId, int userId);

    @Query("SELECT res FROM Restaurant res WHERE res.creator.id = :userId")
    List<Restaurant> getAllByUserId(@Param("userId") int userId);


    @Modifying
    @Query("SELECT res.creator.id FROM Restaurant res WHERE res.id =:resId")
    List<Integer> getAllByCreatorId(@Param("resId")int resId);

    boolean existsByIdAndCreator_Id(int resId, int userId);

    @Query("SELECT res FROM Restaurant res JOIN FETCH res.creator WHERE res.id = ?1")
    Optional<Restaurant> getWithUser(int resId);
}
