package com.zoolon.issue.config.database;
 
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
 
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
 
@Configuration
@ComponentScan
@EnableTransactionManagement
public class TransactionManageConfig {
	@Bean(destroyMethod = "close", initMethod = "init")
	public UserTransactionManager userTransactionManager() {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		return userTransactionManager;
	}

    @Bean(name = "transactionManager")
	public JtaTransactionManager transactionManager() {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(userTransactionManager());
		return jtaTransactionManager;
	}
}
