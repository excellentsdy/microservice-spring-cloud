package pers.chdy.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.chdy.cloud.entity.User;

/**
 * CreteTime:2017/9/7 10:13.
 *
 * @author chdy
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
