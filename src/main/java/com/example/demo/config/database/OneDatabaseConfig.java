package com.example.demo.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@DependsOn("transactionManager")
@Configuration
@MapperScan(basePackages = "com.example.demo.dao.one",
        //sqlSessionFactoryRef = "oneSqlSessionFactory",
        sqlSessionTemplateRef = "oneSqlSessionTemplate"
)
public class OneDatabaseConfig {

    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.one")
    public DataSource oneDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Primary
    @Bean(name = "oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource oneDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(oneDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:com/example/demo/dao/one/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "oneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}