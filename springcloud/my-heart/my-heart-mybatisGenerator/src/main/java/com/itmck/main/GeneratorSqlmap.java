package com.itmck.main;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * MyBatis Generator 逆向工程启动类
 * 
 * @author 34745
 *
 */
public class GeneratorSqlmap {

	private static Logger logger = LoggerFactory.getLogger(GeneratorSqlmap.class);

	/**
	 * 主函数
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlmap.generator();
			logger.info("==============>代码生成成 ..刷新项目即可");
		} catch (Exception e) {
			logger.info("==========>代码生成失败<============");
			e.printStackTrace();
		}

	}

	public static void generator() throws Exception {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 指定逆向工程配置文件
		File configFile = new File("src/main/resources/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}
}
