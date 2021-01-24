package cn.com.taiji.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepo extends JpaRepository <Permission, Long> {

    @Query(value = "from Permission where upId =?1")
    List<Permission> findChildByMenuId(long id);

    @Query(value = "from Permission where layer=1")
    List<Permission> findFirstLayer();
}
