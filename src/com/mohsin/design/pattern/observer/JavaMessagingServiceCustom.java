package com.mohsin.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {

    void register(Observer observer);
    void deregister(Observer observer);
    void notifyAllObserver();   //push -> used by Subject
    Object getUpdate(Observer observer);    //pull -> used by Observer
}

interface Observer {
    void update(); // used by Subject
    void setSubject(Subject subject); //used by Observer
}

class Topic implements Subject{
    List<Observer> observerList=null;
    boolean isChanged=false;
    String message=null;

    public Topic() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        if(!isChanged) return;
        isChanged=false;
        for (Observer observer:observerList) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message){
        this.message=message;
        this.isChanged=true;
        this.notifyAllObserver();
    }
}

class TopicSubscriber implements Observer{
    private String name;
    private Subject subject;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        Object message= subject.getUpdate(this);
        if(message==null){
            System.out.println(name +"::No new messages!!!");
        }else {
            System.out.println(name +"::"+message);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject=subject;
    }
}

public class JavaMessagingServiceCustom{
    public static void main(String[] args) {
        Topic topic=new Topic();

        TopicSubscriber subscriber1=new TopicSubscriber("subscriber1");
        TopicSubscriber subscriber2=new TopicSubscriber("subscriber2");
        TopicSubscriber subscriber3=new TopicSubscriber("subscriber3");

        subscriber1.setSubject(topic);
        subscriber2.setSubject(topic);
        subscriber3.setSubject(topic);

        topic.register(subscriber1);
        topic.register(subscriber2);
        topic.register(subscriber3);

        subscriber1.update();

        topic.postMessage("Mohsin Iqbal");
    }
}