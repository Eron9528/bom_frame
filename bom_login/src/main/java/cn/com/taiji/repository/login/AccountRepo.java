package cn.com.taiji.repository.login;

import cn.com.taiji.domain.login.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository <Account, Long> {

}
