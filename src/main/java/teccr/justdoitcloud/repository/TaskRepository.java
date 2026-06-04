package teccr.justdoitcloud.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teccr.justdoitcloud.data.Task;

import java.util.List;

/**
 * Repository abstraction for task operations.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

    /**
     * Return the list of tasks for a given username. If user doesn't exist, return empty list.
     */
    List<Task> findByUserId(Long userId);


    @Query("""
    SELECT t FROM Task t
    WHERE t.userId = :userId
      AND t.status = :status
      AND t.deadline >= CURRENT_DATE
    ORDER BY t.deadline ASC
    """)
    List<Task> findTop5UpcomingByUserAndStatus(@Param("userId") Long userId,
                                               @Param("status") Task.Status status,
                                               Pageable pageable);

}
