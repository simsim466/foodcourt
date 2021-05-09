package repository.datajpa.mealImpl;

import model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Modifying
    @Transactional
    int deleteRestaurantByIdAndCreatorId(int resId, int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant res WHERE res.id =: resId" +
            " AND res.creator.id =: userId")
    int delete(@Param("resId") int resId, @Param("userId")int userId);

    List<Restaurant> findAllByCreator_Id(int creatorId);

    @Query("SELECT res FROM Restaurant res WHERE res.creator.id =: userId")
    List<Restaurant> getAll(int userId);

    @Modifying
    @Query("SELECT res.creator.id FROM Restaurant res WHERE res.id =: resId")
    int getCreatorId(int resId);
}
