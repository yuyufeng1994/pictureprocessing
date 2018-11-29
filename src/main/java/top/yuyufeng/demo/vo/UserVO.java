package top.yuyufeng.demo.vo;

/**
 * @author yuyufeng
 * @date 2018/11/29.
 */
public class UserVO {
    private String name;
    private Integer age;

    public UserVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
