package com.itliusir.micro.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: DatabaseConfig
 * @Description: mybatis相关配置
 * @author: yumeng
 *
 */
@Component
@Configuration
public class DatabaseConfig {

	/**
	 * 连接池
	 * @Title: getDataSource 
	 * @Description: 数据源的配置 
	 * @param: 
	 * @return 
	 * 注意 在Application.java代码中，配置DataSource时的注解
         @ConfigurationProperties(prefix=“spring.datasource”) 
                   表示将根据前缀“spring.datasource”从application.properties中匹配相关属性值。
	 *  DataSource @throws
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDataSource() {

		 return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	/**
	 * 
	 * @Title: sqlSessionFactory @Description:
	 * mybatis的sqlSessionFactory配置 @param: @param
	 * dataSource @param: @return @param: @throws Exception @return:
	 * SqlSessionFactory @throws
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis-mapper/*Mapper.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.itliusir.micro.model");
		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * 
	 * @Title: mapperScannerConfigurer @Description:
	 * mapper接口扫描包 @param: @return @return: MapperScannerConfigurer @throws
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.itliusir.micro.mapper");
		return mapperScannerConfigurer;
	}

	/**
	 * 
	 * @Title: transactionManager @Description: 配置事务管理器 @param: @param
	 * dataSource @param: @return @param: @throws Exception @return:
	 * DataSourceTransactionManager @throws
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}

}
