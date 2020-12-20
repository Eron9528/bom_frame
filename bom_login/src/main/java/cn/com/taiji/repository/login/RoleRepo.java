package cn.com.taiji.repository.login;

import cn.com.taiji.domain.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository <Role, Long> {
}
