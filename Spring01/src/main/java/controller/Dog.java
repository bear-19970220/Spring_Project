package controller;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/9 18:56
 */
public class Dog {

    private String name;
    private String age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("狗在吃东西");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Dog() {
    }

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
