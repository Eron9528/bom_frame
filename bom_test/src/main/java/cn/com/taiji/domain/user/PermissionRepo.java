package cn.com.taiji.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository <Permission, Long> {

}
