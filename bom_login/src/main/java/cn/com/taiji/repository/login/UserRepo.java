package cn.com.taiji.repository.login;

import cn.com.taiji.domain.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
}
