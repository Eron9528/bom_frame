package cn.com.taiji.repository.login;

import cn.com.taiji.domain.login.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepo extends JpaRepository <UserGroup, Long> {
}
