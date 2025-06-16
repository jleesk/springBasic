package hello.core.beanfind;

import hello.core.AppConfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest
{
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBeans(){
		String [] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("name = " + beanDefinitionName + "object =" + bean);
		}
	}
	@Test
	@DisplayName("App. 빈 출력하기")
	void findApplicationAllBeans(){
		String [] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);

			//
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + "object =" + bean);
			}

		}
	}
}
