package edu.miu.cs544.kamal.day3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

public class ProtoTypeDestroy implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

    private final List<Object> prototypeBeans = new ArrayList<>();

    public  ProtoTypeDestroy(){
        System.out.println("Prototype Destroy Created.");
    }

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {

        synchronized (prototypeBeans){
            for(Object bean:prototypeBeans){
                if(bean instanceof DisposableBean){
                    DisposableBean disposableBean = (DisposableBean) bean;
                    disposableBean.destroy();
                }
            }
        prototypeBeans.clear();
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanFactory.isPrototype(beanName)){
            synchronized (prototypeBeans){
                prototypeBeans.add(bean);
            }
        }
        return bean;
    }
}
