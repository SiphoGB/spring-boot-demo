package commands

import org.crsh.cli.Usage;
import org.crsh.cli.Command;
import org.crsh.command.InvocationContext;

import org.springframework.beans.factory.BeanFactory;

import za.co.demo.spring.boot.LoadData;
import za.co.demo.spring.boot.domain.Topic;

class loadTopic {

    @Usage("Which Topic to Load")
    @Command
    def main(InvocationContext context) {
        BeanFactory beanFactory = (BeanFactory) context.getAttributes().get("spring.beanfactory");
        LoadData loadData = beanFactory.getBean(LoadData.class);
        Topic topic = loadData.insertTopic();
        return "Topic Created " + topic.getId();
    }

}