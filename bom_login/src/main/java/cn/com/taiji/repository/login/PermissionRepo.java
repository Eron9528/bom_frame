package cn.com.taiji.repository.login;

import cn.com.taiji.domain.login.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository <Permission, Long> {

}
