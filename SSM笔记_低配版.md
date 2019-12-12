# Maven

---



## 下载与安装

- 官网：https://maven.apache.org/
- 下载：apache-maven-3.6.1（ 注：目前最新版本 3.6.3 好像不兼容 IDEA 2018.3，连接不上 ）
- 安装：解压即可。





## 相关配置

### 配置 Maven 仓库

~~~txt
- apache-maven-3.6.1
	- conf
		- settings.xml
~~~

~~~xml
<localRepository>E:\apache-maven-repository</localRepository>
~~~





### IDEA 配置 Maven

以 web 工程为例

1. 新建一个工程（ New Project ）

2. 选择 Maven

3. 勾选 Create from archetype

4. 选择下方的 org.apache.maven.archetypes:maven-archetype-webapp

   ~~~txt
   注意：是 org.apache.maven.archetypes:maven-archetype-webapp
   ~~~

5. 下一步

6. 填写项目信息

   ~~~txt
   GroupId：com.dfbz
   ArtifactId：项目名
   ~~~

7. 配置 Maven

   ~~~txt
   Maven home directory：Maven 安装路径
   User settings file：就是上面配置仓库路径的 settings.xml
   Local repository：指定仓库路径（一般 IDEA 会自动识别 settings.xml 获得）
   ~~~

8. 项目创建完成

   ~~~txt
   此时 Maven 会自动下载一些 web 相关的资源，如 junit 和一些插件。
   ~~~

9. 配置 jar 包（pom.xml）

   ~~~xml
   <!-- 
   	dependency 可以到 maven 网上仓库拷贝。
   	一旦配置过，以后可直接在 IDEA 通过 alt + Insert 快捷键搜索历史。
   -->
   <dependencies>
       <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-context</artifactId>
           <version>5.2.1.RELEASE</version>
       </dependency>
       
       <!-- https://mvnrepository.com/artifact/junit/junit -->
       <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>4.12</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ~~~

10. 导入 jar 包

    ~~~txt
    配置完 jar 包的各种信息后，点击 IDEA 的侧边功能栏 [MavenProject]，点击其左上角的刷新按钮，完成 jar 包的导入。
    ~~~

---

### **关于 web 工程打包部署的步骤**

- 打开项目设置（ Project Structure ）

11. 将项目声明为 web 项目

    ~~~txt
    - Modules
    	选中当前项目，点击 + 按钮，选择 web。
    	分别配置 web.xml 的路径、 web 项目文件夹（即：webapp）的路径
    ~~~

12. 为项目配置 tomcat 依赖

    ~~~txt
    - Modules
    	再次选中当前项目，选择第三个 Dependencies
    	点击 + 按钮，选择 Libary，导入 tomcat 的相关 jar 包
    ~~~

13. 将项目打包成 war 包

    ~~~txt
    - Artifacts
    	点击 + 按钮，选择 Web Application:Exploded - From Modules
    	选中当前项目，完成打包
    ~~~

14. 配置 tomcat

    ~~~txt
    - Add Configuration
    	通过上方的 Add Configuration 添加 tomcat 服务器
    	选择 Deployment 将打包好的项目导入进来（自动）
    ~~~

15. 启动项目





## 关于Maven 项目

### **项目相关设置**

~~~txt
在创建 Maven 项目后，需要对项目中的包进行类型声明。
设置方式：
- Moduals
	在 Sources 中，对项目中的包进行分类（没有的就新建）
	
效果如下：
	- 项目名
		- src
			- main
				- java（ 声明为 [Sources] ）
				- resource（ 声明为 [Resources] ）
			- test
				- java（ 声明为 [Tests] ）
				
注：
	[Sources] 和 [Resources] 中的源码和配置文件，编译后会放在 classes 下。
~~~







### 生成的项目

~~~txt
Maven 项目一经运行，会打包生成一个 target 文件夹。

层级结构：
    - target
        - classes
            - ...（自己写的那些类）
        - generated-sources
        - generated-test-sources
        - test-classes

所以，classes（类路径）同样是在项目下一级，
~~~











# Spring

---

## **IOC**

### 配置环境

1. 导包

   - 传统方式

     ~~~txt
     主要：
         spring-beans-5.2.1-RELEASE.jar
         spring-core-5.2.1-RELEASE.jar
         spring-context-5.2.1-RELEASE.jar（ 核心包，Maven 下会自动依赖其他三个包 ）
         spring-expression-5.2.1-RELEASE.jar
     
     辅助：
         commons-logging-1.2.jar
         log4j-1.2.16.jar
     ~~~

   - Maven

     ~~~xml
     <!-- 直接导入核心依赖 -->
     <dependencies>
         <dependency>
             <groupId>org.springframework</groupId>
             <artifactId>spring-context</artifactId>
             <version>5.0.2.RELEASE</version>
         </dependency>
     </dependencies>
     ~~~

     

2. 创建配置文件

   ~~~txt
   右键 resources 新建一个 XML Configuration File。（若导包成功，会出现 Spring Config）
   ~~~

   ![image-20191210103755699](C:\Users\FTDN\AppData\Roaming\Typora\typora-user-images\image-20191210103755699.png)

   ~~~xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
   
       <bean id="dog" class="com.dfbz.domain.Dog"></bean>
   
   </beans>
   ~~~

3. 由容器创建对象

   ~~~java
   ApplicationContext ac = new ClassPathXmlApplicationContext("配置文件路径");
   Dog dog = ac.getBean("dog", Dog.class);	// 通过 bean 的 id + 对应类的字节码获取
   ~~~




IDEA 全局设置

![image-20191210103825977](C:\Users\FTDN\AppData\Roaming\Typora\typora-user-images\image-20191210103825977.png)

![image-20191210103850309](C:\Users\FTDN\AppData\Roaming\Typora\typora-user-images\image-20191210103850309.png)





~~~xml
<dependencies>
    <!--
		spring 核心依赖包:
		导入context包会自动将其他需要的依赖包自动导入
 	-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
    <!--
         alt + ins  快速索引本地仓库中存在的依赖包
 	-->
</dependencies>
~~~





重新构建 IDEA 中 Maven 仓库的索引

![image-20191210104304427](C:\Users\FTDN\AppData\Roaming\Typora\typora-user-images\image-20191210104304427.png)

![image-20191210104257917](C:\Users\FTDN\AppData\Roaming\Typora\typora-user-images\image-20191210104257917.png)

找到关联 Maven 仓库的 index.properties 文件，删了，重启 IDEA。





**关于 Maven 项目配置 JDK 版本（默认是 1.5，？？？）**

~~~xml
<build>
    <!--插件是指  用于在构建项目的时候的扩展功能组件  -->
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <!--设置class文件的jdk版本-->
                <target>1.8</target>
                <!--设置源码的jdk版本呢-->
                <source>1.8</source>
            </configuration>
        </plugin>
    </plugins>
</build>
~~~





















#### **注解**

1. 导入依赖（ pom.xml ）

   ~~~xml
   <!-- 对应 spring-context-5.2.1-RELEASE.jar -->
   <dependencies>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-context</artifactId>
           <version>5.2.1.RELEASE</version>
       </dependency>
   </dependencies>>
   ~~~

   

2. 在 Spring 配置文件中配置要扫描的包

   ~~~xml
   <context:component-scan base-package="com.dfbz"></context:component-scan>
   ~~~

   

   

##### 成为 Bean：@Component

- 经典格式

  ~~~xml
  <bean id="dog" class="com.dfbz.domain.Dog"></bean>
  ~~~

- 关于对象注解

  ~~~txt
  一共有四种，目前来说，效果完全一致。为了便于识别，还是对应使用为好。
      	
      - @Controller
      	用于声明表现层
      - @Service
      	用于声明服务层
      - @Repository
      	用于声明持久层
      - @Component
      	用于声明三层以外的通用组件
      	
    	
  问题：那么，这四个注解交换使用会报错吗。如：持久层，我放@Service标记。

  答：处理 @Controller 在 SpringMVC 里面有强制的要求，SpringMVC 的表示层必须使用 @Controller 组件注解。其他情况，用乱了是不会报错的，不过我们必须不能用乱。要遵守规范，不然别人无法跟你一起开发了。
  ~~~
  
  
  
  

1. 编写一个类，通过 @Component 注解，将其配置 Spring 容器中（ 成为 Bean ）

   ~~~java
   /**
    * @Component：默认将类名首字母转小写作为 Bean 的 id / name
    * 
    * @Component("dog")：通过 value 属性指定 Bean 的名字
    */
   @Component
   public class Dog {
       public void eat() {
           System.out.println("狗在啃骨头");
       }
   }
   ~~~

2. 尝试通过 Spring 容器将其初始化

   ~~~java
   /**
    * ac.getBean(Class<T> type);	根据类型创建 Bean 对象（适合一个类型只有一个类）
    * ac.getBean(String name, Class<T> type);
    */
   @Test
   public void test() {
       ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
       Dog dog = ac.getBean(Dog.class);
       dog.eat();
   }
   ~~~

   

##### 属性注入

###### @Autowired

- 说明

  ~~~txt
  用于注入引用类型
  ~~~

- 经典格式

  ~~~xml
  <!-- UserService -->
  <bean id="userService" class="com.dfbz.service.UserServiceImpl">
      <property name="userDao" ref="userDao"></property>	<!-- 此处的 ref 不能省略 -->
  </bean>
  
  <!-- UserDao -->
  <bean id="userDao" class="com.dfbz.dao.UserDaoImpl"></bean>
  ~~~

  

1. UserService

   ~~~java
   // 将 UserServiceImpl 加入 Bean 套餐，并取名为 userService
   @Service("userService")
   public class UserServiceImpl implements UserService {
   
       @Autowired
       private UserDao userDao;	// 注入 userDao
   
       @Override
       public void findAllUser(){
           userDao.findAllUser();
       }
   
   }
   ~~~

2. UserDao

   ~~~java
   // // 将 UserDaoImpl 加入 Bean 套餐，并取名为 userDao
   @Repository("userDao")
   public class UserDaoImpl implements UserDao {
   
       @Override
       public void findAllUser(){
           System.out.println("查询所有用户...");
       }
   
   }
   ~~~

3. 测试

   ~~~java
   @Test
   public void test() {
       ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
       UserService userService = ac.getBean("userService", UserService.class);
       userService.findAllUser();
   }
   ~~~





###### @Qualifier

- 说明

  ~~~txt
  @Qualifier 指定属性注入来源的 name，即 ref
  ~~~

- 经典格式

  ~~~xml
  <bean id="userService" class="com.dfbz.service.UserServiceImpl">
  	<property name="userDao" ref="userDao"></property>
  </bean>
  
  <bean id="userDao" class="com.dfbz.dao.UserDaoImpl"></bean>
  ~~~

  

- 假设现在 UserDao 有两个实现类：UserDaoImpl、UserDaoImplNew
  则必须指定注入来源
  否则，会抛异常：expected single matching bean but found 2

  ~~~java
  @Service("userService")
  public class UserServiceImpl implements UserService {
  
      @Autowired
      @Qualifier("userDaoImplNew")	// 指定注入来源
      private UserDao userDao;
  
      @Override
      public void findAllUser(){
          userDao.findAllUser();
      }
  
  }
  ~~~

  



###### **@Resource**

- 说明

  ~~~txt
  @Resource = @AutoWired
  @Resource(name="...") = @AutoWired + @Qualifier
  
  注：
  	@Resource 只能注入方法和属性，不能注入构造方法
  ~~~





###### @Value

- 说明

  ~~~txt
  @Value 只能注入 String 类型、基本类型、基本类型的包装类型。
  ~~~

- 经典格式

  ~~~xml
  <bean id="dog" class="com.dfbz.domain.Dog">
      <property name="name" value="旺财"></property>
      <property name="age" value="100"></property>
  </bean>
  ~~~



- 普通注入

  > 1. 有那么一个类（Dog），它有俩属性：name、age
  >
  >    ~~~java
  >    @Component("dog")
  >    public class Dog {
  >        
  >        @Value("旺财")
  >        private String name;
  >        @Value("100")
  >        private Integer age;
  >        
  >        public void sayHi() {
  >            System.out.println("大家好，我叫" + name + "，今年" + age + "岁。");
  >        }
  >    }
  >    ~~~
  >
  >    
  >
  > 2. 创建它
  >
  >    ~~~java
  >    @Test
  >    public void test(){
  >        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
  >        Dog dog = ac.getBean("dog", Dog.class);
  >        dog.sayHi();
  >    }
  >    ~~~
  >
  >    



- Properties 配置文件注入

  > 1. xxx.properties
  >
  >    ~~~txt
  >    name=旺财
  >    age=100
  >    ~~~
  >
  >    
  >
  > 2. 读取配置
  >
  >    ~~~xml
  >    <context:property-placeholder file-encoding="utf-8" 
  >                                  location="classpath:xxx.properties"/>
  >    ~~~
  >
  >    
  >
  > 3. 获取数据
  >
  >    ~~~java
  >    @Component("dog")
  >    public class Dog {
  >    
  >        @Value("${name}")
  >        private String name;
  >        @Value("${age}")
  >        private Integer age;
  >    
  >    }
  >    ~~~
  >
  >    
  >
  > 4. 关于配置多个 Properties
  >
  >    ~~~xml
  >    最佳答案：
  >    
  >    property-placeholder 本质上是【一个】，且配置后全局可用。
  >    一般建议全局配置所有的，可定义一个入口 spring 配置，在入口配置处配置具有多个 properties 文件的 property-placeholder，然后 import 导入各个模块的 spring 配置文件。
  >    这应该是比较优美且简单的解决方式，首先推荐。
  >    
  >    但如果我们不按套路走，需要搞独具特色的语义分拆配置，可以看看下面的说明，可采用结论给出的配置方式。
  >    
  >    知识叨叨：
  >    ignore-unresolvable 单独使用来看是：是否忽视不存在的配置项？
  >    不仅如此，经过测验，有一个隐含意思：是否还要扫描其他配置项？
  >    如果扫描到的为 false，则会忽视后续的 property-placeholder（如下面测试 2,3）。
  >    
  >    测试：
  >    首先我们确保稳定的加载顺序（使用 orderd，不使用的话应该是按配置 spring 的顺序，将下面这个，从左到右，但我们不应该依赖于这种顺序）：
  >    
  >    在 applicationContext.xml 中：
  >    <context:property-placeholder location="classpath:config.properties" ignore-unresolvable="表格中第二列的值" order="1" />
  >    
  >    在 applicationContext2.xml 中：
  >    <context:property-placeholder location="classpath:config2.properties" ignore-unresolvable="表格中第三列的值" order="2" />
  >    
  >    测试用例    applicationContext中ignore-unresolvable值    applicationContext2中ignore-unresolvable值    结果分析    总结
  >    1	true	true	两个配置项都会加载，但会完全忽视配置项不存在的情况，不会抛出异常，如果 prop 是 String，则赋值为 "${foo}"，这个肯定是错误的。    业务正确，但出错后（少配了个配置项）不易发现
  >    2	false	false	第二个配置项文件会被忽视，业务会出现错误    业务错误
  >    3	false	true	第二个配置项文件会被忽视，业务会出现错误（同上）    业务错误
  >    4	true	false	两个配置项都会加载，且会检查 config.properties 和 config2.properties 的配置项，是我们的首选。    完美解决，业务正确且会报错
  >    
  >    
  >    结论：
  >    第 4 种是最佳的！同理，如果有三个，那么依次配置 ignore-unresolvable 为 true，true，false，只要保证最后的为 false 即可。
  >    在applicationContext.xml中：
  >    <context:property-placeholder location="classpath:config.properties" ignore-unresolvable="true" order="1" />
  >    在applicationContext2.xml中：
  >    <context:property-placeholder location="classpath:config2.properties" ignore-unresolvable="false" order="2" />
  >    ~~~
  >
  >    
  >
  >    所以，设置如下：
  >
  >    ~~~xml
  >    <context:property-placeholder file-encoding="utf-8" 
  >                                  location="classpath:db.properties" 
  >                                  ignore-unresolvable="true"/>
  >    
  >    <context:property-placeholder file-encoding="utf-8" 
  >                                  location="classpath:xxx.properties" 
  >                                  ignore-unresolvable="false" />
  >    ~~~
  >
  >    







##### 案例：三层结构

###### Spring 配置文件

~~~xml
<context:component-scan base-package="com.dfbz"/>
~~~



###### dao

1. 结构

   ~~~java
   @Repository("userDao")
   public class UserDaoImpl implements UserDao {
   
       @Autowired
       private JdbcTemplate jdbcTemplate;
   
       // ... CRUD
   }
   ~~~

2. 注入 JdbcTemplate

   ~~~txt
   为了更好地降低耦合，JdbcTemplate 的创建也交由 Spring 实现。
   
   如何配置？
   答案：交给工具类 ———— JdbcUtils
   ~~~

   

###### DbUtils：**@Bean**

1. 功能说明

   ~~~txt
   创建 DataSource 连接池对象。
   创建 JdbcTemplate 对象。
   ~~~

2. 代码实现

   ~~~java
   /**
    * @Bean
    * 作用：将方法的返回值作为 Bean 存入 Spring 容器
    * 		- 如：将 createDataSource() 的返回值 DataSource 放入容器
    */
   @Component
   public class JdbcUtils {
   
       @Autowired
       private DataSource ds;
   
       @Bean
       public DataSource createDataSource() throws Exception {
           Properties props = new Properties();
           props.load(JdbcUtils.class.getResourceAsStream("/db.properties"));
           return DruidDataSourceFactory.createDataSource(props);
       }
   
       @Bean
       public JdbcTemplate getJdbcTemplate() {
           return new JdbcTemplate(ds);
       }    
   
   }
   ~~~
   
- 另外，@Bean 还有另外一个特性
  
     ~~~java
     /** 
      * @Bean
      * 功能：若创建 Bean 的方法需要参数，@Bean 会自动在容器中找
      * 		- 如：getJdbcTemplate(DataSource ds) 
      */
     @Component
     public class JdbcUtils {
     
         // 此处将不再声明 Datasource 为成员变量，改由传参的方式给 getJdbcTemplate()
     
         @Bean
         public DataSource createDataSource() throws Exception {
             Properties props = new Properties();
             props.load(JdbcUtils.class.getResourceAsStream("/db.properties"));
             return DruidDataSourceFactory.createDataSource(props);
         }
     
         @Bean
         public JdbcTemplate getJdbcTemplate(DataSource ds) {
             return new JdbcTemplate(ds);
         }    
     
     }
     ~~~
   
   - 创建 DataSource 连接池，除了通过 getResourceAsStrem() 的方式，还可以通过 Spring 读取
   
     > 1. 在 Spring.xml 中配置
     >
     >    ~~~xml
     >    <context:property-placeholder 
     >                                  file-encoding="utf-8" 
     >                                  location="classpath:db.properties"/>
     >    ~~~
     >
     > 2. DbUtils
     >
     >    ~~~java
     >    @Component
     >    public class JdbcUtils {
     >    
     >        // 注入 Properties 属性值
     >        @Value("${jdbc.driverClassName}")
     >        private String driver;
     >        @Value("${jdbc.url}")
     >        private String url;
     >        @Value("${jdbc.username}")
     >        private String username;
     >        @Value("${jdbc.password}")
     >        private String password; 
     >    
     >        @Bean
     >        public DataSource createDataSource() throws Exception {
     >            // 注：只有 DruidDataSource 才有下面的四个方法
     >            DruidDataSource ds = new DruidDataSource();
     >            ds.setDriverClassName(driver);
     >            ds.setUrl(url);
     >            ds.setUsername(username);
     >            ds.setPassword(password);
     >            return ds;
     >        }
     >    
     >        @Bean
     >        public JdbcTemplate getJdbcTemplate(DataSource ds) {
     >            return new JdbcTemplate(ds);
     >        }    
     >    
     >    }
     >    ~~~
     >
     >    
   
     

###### service

~~~java
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    // ... 业务
}
~~~





###### controller

~~~java
@Controller("userController")
public class UserController {

    @Autowired
    private UserService userService;

    // ...
}
~~~



###### Test

- 方式一（经典）：

  > 通过创建 Spring 容器（ApplicationContext）来实例化 Bean 对象

  

  ~~~java
  public class UserTest {
  
      @Test
      public void test() {
          ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
          UserService userService = ac.getBean("userService", UserService.class);
          userService.listUser().forEach(x -> System.out.println(x));
      }
  
  }
  ~~~

- 方式二：

  > 通过 @RunWith 将测试类配置在 Spring 容器的环境下，直接完成 Bean 注入
  >
  > 通过 @ContextConfiguration(locations = { }) 指定 Spring 配置文件

  

  ~~~java
  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(locations = {"classpath:spring.xml"})
  public class UserTest {
  
      @Autowired
      UserService userService;
  
      @Test
      public void test() {
          userService.listUser().forEach(x -> System.out.println(x));
      }
  
  }
  ~~~

  







##### 生命周期注解

###### @Scope 作用域

~~~txt
value 属性值：

- singleton：单例

- prototype：多例

- request：（web）Spring 将创建的对象放在 request 作用域中
- session：（web）Spring 将创建的对象放在 session 作用域中
- globalSession：（web）应用域集群环境，如果没有集群环境相当于 session
~~~

###### @PostConstruct 指定初始化方法

###### @PreDestroy 指定销毁方法







#### 纯注解

- 说明

  ~~~xml
  <!--
  	在使用了 @Component、@Autowired 和 @Bean 之后，Spring.xml 配置文件中就只剩下：
  -->
  <context:component-scan base-package=""/>
  <context:property-placeholder location="" file-encoding=""/>
  ~~~

- 用 Java 类取代 Spring.xml





##### 配置类

~~~java
@Configuration	// 声明这是 Spring 配置类
@ComponentScan("com.dfbz")	// 配置包扫描
@PropertySource("classpath:db.properties")	// 读取配置文件
public class ConfigBean {

}
~~~







##### Test

- 说明

  ~~~txt
  由于 Spring.xml 已不复存在，所以无法再通过读取配置文件的方式 getBean()
  包括：
      - ClassPathXmlApplicationContext
      - FileSystemXmlApplicationContext
      - @ContextConfiguration(locations={"classpath:spring.xml"})
  ~~~

- 方式一：创建 Spring 容器

  ~~~java
  public class UserTest {
  
      @Test
      public void test() {
          ApplicationContext ac;
          ac = new AnnotationConfigApplicationContext(ConfigBean.class);
          UserService userService = ac.getBean(UserService.class);
          userService.listUser().forEach(x -> System.out.println(x));
      }
  
  }
  ~~~

  

- 使用 @ContextConfiguration(classes = { }) 加载 Spring 配置类

  ~~~java
  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes = {ConfigBean.class})
  public class UserTest {
  
      @Autowired
      UserController userController;
  
      @Test
      public void test(){
          userService.listUser().forEach(x -> System.out.println(x));
      }
  
  }
  ~~~

  



## **AOP**

### 动态代理

#### 原理

~~~~txt
代理类在程序运行时创建的代理方式被成为动态代理。
----------------------------
JDK动态代理有以下特点:

- 代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们提供目标对象所实现的接口的字节码对象)

- 动态代理要求目标对象一定要实现接口，所以也叫做接口代理！
~~~~



#### Proxy 动态代理

1. 有一个接口：Player

   ~~~java
   public interface Player {
       
       void play();
       
   }
   ~~~

2. 它的实现类

   ~~~java
   public class MyPlayer implements Player {
   
       @Override
       public void play() {
           System.out.println("攻击！");
       }
       
   }
   ~~~

3. Test

   > - 内部类实现
   >
   >   ~~~java
   >   @Test
   >   public void test() {
   >   
   >       // 原对象
   >       Player player = new MyPlayer();
   >       player.play();        
   >   
   >       // 代理对象
   >       Player proxyPlayer = (Player) Proxy.newProxyInstance(
   >           player.getClass().getClassLoader(),
   >           player.getClass().getInterfaces(),
   >           new InvocationHandler() {
   >               @Override
   >               public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
   >                   System.out.println("蓄力！");
   >                   Object result = method.invoke(player, args);
   >                   System.out.println("魂吸！");
   >                   return result;
   >               }
   >           });
   >       proxyPlayer.play();
   >   
   >   }
   >   ~~~
   >
   >   
   >
   > - 实现类实现（代理工厂）
   >
   >   ~~~java
   >   /**
   >    * 创建一个类，实现 InvocationHandler 接口 
   >    */
   >   public class ProxyFactory implements InvocationHandler {
   >   
   >       // 原对象
   >       private Object sourceObject;
   >   
   >       // 通过构造方法注入原对象
   >       public ProxyFactory(Object sourceObject) {
   >           this.sourceObject = sourceObject;
   >       }
   >   
   >       // 重写 invoke 方法
   >       @Override
   >       public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
   >           System.out.println("被代理的对象的方法被代理执行-前");
   >           Object result =  method.invoke(sourceObject, args);
   >           System.out.println("被代理的对象的方法被代理执行-后");
   >           return result;
   >       }
   >   
   >       // 创建代理对象
   >       public Object createProxyObject() {
   >           return Proxy.newProxyInstance(
   >               sourceObject.getClass().getClassLoader(),
   >               sourceObject.getClass().getInterfaces(),
   >               this	// 现在 InvocationHandler 就是自己本身
   >           );
   >       }
   >   
   >   }
   >   ~~~
   >
   >   ~~~java
   >   @Test
   >   public void test() {
   >   
   >       // 原对象
   >       Player player = new MyPlayer();
   >       player.play();
   >   
   >       // 由代理工厂创建代理对象
   >       ProxyFactory factory = new ProxyFactory(player);
   >       Player proxyPlayer = (Player) factory.createProxyObject();
   >       proxyPlayer.play();
   >   
   >   }
   >   ~~~
   >
   >   





### AOP 名词

#### JoinPoint 连接点

#### Pointcut 切入点

#### Advice 通知 / 增强

##### 通知的类型

~~~txt
- 前置通知(Before)：执行连接点方法之前执行
- 后置通知(After-returning)：目标方法
- 环绕通知(Around)
- 最终通知(After)
- 异常通知(AfterThrowing)
~~~



#### Target 目标对象

#### Waving 织入

####  Proxy 代理

#### Aspect 切面





### 基于 XML 配置

#### 1. 环境搭建

- 需要新的依赖：

  ~~~xml
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>5.1.9.RELEASE</version>
  </dependency>
  ~~~

- Spring.xml

  ~~~xml
  <!-- 包扫描 -->
  <context:component-scan base-package="com.dfbz"/>
  ~~~
  
  



#### 2. 被通知（代理增强）的类

~~~java
@Component
public class MyPlayer {

    public void play() {
        System.out.println("攻击");
    }

    public void eat() {
        int i = 1 / 0;
        System.out.println("吃吃吃，就知道吃！");

    }

    public void sleep() {
        System.out.println("中午啦！还睡！猪吗你！");
    }
    
}
~~~





#### 3. 创建切面类

~~~java
@Component
public class AspectBean {

    public void before() {
        System.out.println("前置通知...");
    }

    public void afterReturning() {
        System.out.println("后置通知...");
    }

    public void afterThrowing() throws Exception {
        System.out.println("异常通知...");
    }

    public void after() {
        System.out.println("最终通知...");
    }

    /**
     * 环绕通知包含了前置通知和后置通知的功能
     * 需要引入被代理的方法（有点类似 Proxy 的 method）
     * 然后在方法执行的前后可以进行环绕
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置环绕...");
        Object result = joinPoint.proceed();
        System.out.println("后置环绕...");
        return result;
    }

}
~~~





#### 4. 配置 AOP

~~~xml
<aop:config>
    
    <!-- 切点：配置切入点表达式（声明需要被通知的方法） -->
    <aop:pointcut id="pc" expression="within(com.dfbz.MyPlayer)"/>
    
    <!-- 通知：导入切面类，进行通知配置 -->
    <aop:aspect ref="aspectBean">
        <aop:before method="before" pointcut-ref="pc"/>        
        <aop:around method="around" pointcut-ref="pc"/>
        <aop:after-returning method="afterReturning" pointcut-ref="pc"/>
        <aop:after-throwing method="afterThrowing" pointcut-ref="pc"/>
        <aop:after method="after" pointcut-ref="pc"/>
    </aop:aspect>
    
</aop:config>
~~~

- 注：通知配置的顺序要严格控制！

  

- 关于各种通知

  ~~~txt
  after-throwing：目标方法抛出异常时调用，若目标方法没有对异常进行处理，则不会继续下面的操作（废话）
  
  after：无论有没有执行异常，最后都会调用（相当于 finally）
  ~~~

  

  

- 关于切入点表达式

  > - within
  >
  >   ~~~txt
  >   按类匹配
  >   ~~~
  >
  >   
  >
  > - execution
  >
  >   ~~~txt
  >   按方法
  >   
  >   * *..*.service.impl.*.*(..)
  >   ~~~
  >
  > - 全局和局部
  >
  >   ~~~txt
  >   除了向上面那样定义一个全局的切入点表达式，还可以在各个通知内部设置局部的切入点表达式。
  >   pointcut
  >   ~~~
  >
  >   



#### 5. Test

~~~java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class DemoTest {

    @Autowired
    Player myPlayer;

    @Test
    public void test() {
        myPlayer.play();
        myPlayer.eat();
        myPlayer.sleep();
    }

}
~~~







# MyBatis

---









































# 日志

---

## 三大组件

~~~txt
Log4j 三大组件：
	- Loggers（记录器）：日志的类别
	- Appenders（输出源）：日志输出的地方
	- Layouts（布局）：日志输出的形式
~~~



### Loggers

~~~txt
八个级别（范围）：ALL < TRACE < ( DEBUG < INFO < WARN < ERROR < FATAL ) < OFF

    - ALL
    	最低等级，用于打开所有日志记录。
    - TRACE
    	追踪。很低的日志级别，一般不会使用（压根儿不用）。
    - DEBUG
    	指出细粒度信息事件，对调试应用程序是非常有帮助的，主要用于开发过程中打印一些运行信息。
    - INFO
    	消息在粗粒度级别上突出强调应用程序的运行过程。打印一些你感兴趣的或者重要的信息。（用得最多）
    	这个可以用于生产环境中输出程序运行的一些重要信息，但是不能滥用，避免打印过多的日志。
    - WARN
    	表明会出现潜在错误的情形，有些信息不是错误信息，但是也要给程序员的一些提示。
    - ERROR
    	指出虽然发生错误事件，但仍然不影响系统的继续运行。
    	打印错误和异常信息，如果不想输出太多的日志，可以使用这个级别。（用得比较多）
    - FATAL
    	指出每个严重的错误事件将会导致应用程序的退出。
    - OFF
    	最高等级的，用于关闭所有日志记录。

只会输出当前级别或比当前级别高的日志。
log4j 默认的优先级为 ERROR。
~~~





### Appenders

~~~txt
允许把日志输出到不同的地方，如：
	- 控制台（Console）
	- 文件（Files）
	
可以根据天数 / 文件大小产生新的文件
可以以流的形式发送到其它地方
...

常使用的类如下：
    org.apache.log4j.ConsoleAppender（控制台）
    org.apache.log4j.FileAppender（文件）
    org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）
    org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸时产生一个新的日志文件）
    org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
~~~

~~~txt
配置格式：
log4j.appender.appenderName.操作1 = 值1	// appenderName:代表一个目的地，命名随意
...
log4j.appender.appenderName.操作N = 值N
~~~





### Layouts

~~~txt
Layouts 提供四种日志输出样式：
	- HTML 样式
	- 自由指定样式
	- 包含日志级别与信息的样式
	- 包含日志时间、线程、类别等信息的样式
	
常使用的类如下：
    org.apache.log4j.HTMLLayout（以HTML表格形式布局）
    org.apache.log4j.PatternLayout（可以灵活地指定布局模式）
    org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）
    org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等信息）

---------------------------------
样式举例：
- HTMLLayout
    <html>
    ... 一个表格
    </html>

- PatternLayout
    DEBUG 日志

- SimpleLayout
    DEBUG - bebug 日志

- TTCCLayout
    [main] DEBUG Log4jTest - bebug 日志
~~~

~~~txt
配置格式：
log4j.appender.appenderName.layout = 类名
log4j.appender.appenderName.layout.操作1 = 值1
...
log4j.appender.appenderName.layout.操作N = 值N
~~~





### 示例

> 配置
>
> ~~~properties
> # 配置根 Logger：设置级别、目的地（可配置多个目的地，命名随意）
> log4j.rootLogger = DEBUG, dest_01_console
> 
> # 设置目的地 console_01 指向控制台
> log4j.appender.dest_01_console = org.apache.log4j.ConsoleAppender
> 
> # 设置目的地 console_01 的输出格式为
> log4j.appender.dest_01_console.layout = org.apache.log4j.SimpleLayout
> ~~~
>
> Test
>
> ~~~java
> public class Log4jTest {
> 
>     private static Logger logger;
>     static {
>         logger = Logger.getLogger(Log4jTest.class);
>     }
> 
>     @Test
>     public void test() {
>         logger.trace("TRACE 日志");
>         logger.debug("DEBUG 日志");
>         logger.info("INFO 日志");
>         logger.warn("WARN 日志");
>         logger.error("ERROR 日志");
>         logger.fatal("FATAL 日志");
>     }
> 
> }
> ~~~
>
> 输出结果
>
> ~~~txt
> TRACE - trace 日志
> DEBUG - bebug 日志
> INFO - info 日志
> WARN - warn 日志
> ERROR - error 日志
> FATAL - fatal 日志
> ~~~
>
> 



### 示例二

> 配置
>
> ~~~properties
> log4j.rootLogger = DEBUG, dest_01_console
> log4j.appender.dest_01_console = org.apache.log4j.ConsoleAppender
> log4j.appender.dest_01_console.layout = org.apache.log4j.PatternLayout
> log4j.appender.dest_01_console.layout.ConversionPattern =  %d{ABSOLUTE} %5p %c{1}:%L - %m%n
> ~~~
>
> 输出结果
>
> ~~~txt
> 15:32:53,514 TRACE Log4jTest:15 - trace 日志
> 15:32:53,517 DEBUG Log4jTest:16 - bebug 日志
> 15:32:53,517  INFO Log4jTest:17 - info 日志
> 15:32:53,517  WARN Log4jTest:18 - warn 日志
> 15:32:53,518 ERROR Log4jTest:19 - error 日志
> 15:32:53,518 FATAL Log4jTest:20 - fatal 日志
> ~~~
>
> 







## 配置详解



引用：
[Java-优雅的记录日志](https://www.cnblogs.com/crazyacking/p/5456347.html#_label00)
[Log4J日志整合及配置详解](https://www.cnblogs.com/wangzhuxing/p/7753420.html)





### 1. 日志说明

~~~txt
在实际应用中，要使 Log4j 在系统中运行，必须事先设定配置文件。
配置文件事实上也就是对 Logger、Appender 及 Layout 进行相应设定。

Log4j 支持两种配置文件格式：
	- XML
	- properties
~~~





### 2. 配置步骤

#### 2.1 配置根 Logger

~~~txt
log4j.rootLogger = [LEVEL] , appenderName1, appenderName2, ...（默认输出目的地，当前端传入类名）

log4j.additivity.org.apache=false：表示Logger不会在父Logger的appender里输出，默认为true。

[LEVEL]：设定日志记录的最低级别
appenderName：就是指定日志信息要输出到哪里。可以同时指定多个输出目的地，用逗号隔开。
例如：log4j.rootLogger ＝ INFO, A1, B2, C3
~~~



#### 2.2 配置输出目的地 Appender

~~~txt
log4j.appender.appenderName = className
	- appenderName：自定义 appderName，在 log4j.rootLogger 设置中使用；
	- className：可设值有以下五个：

- ConsoleAppender 选项：
    Threshold=WARN：指定日志信息的最低输出级别，默认为DEBUG。
    ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
    Target=System.err：默认值是System.out。

- FileAppender 选项：
    Threshold=WARN：指定日志信息的最低输出级别，默认为 DEBUG。
    ImmediateFlush=true：表示所有消息都会被立即输出，设为 false 则不输出，默认值是 true。
    Append=false：true 表示消息增加到指定文件中，false 则将消息覆盖指定的文件内容，默认值是 true。
    File=D:/logs/logging.log4j：指定消息输出到 logging.log4j 文件中。

- DailyRollingFileAppender 选项：
    Threshold=WARN：指定日志信息的最低输出级别，默认为 DEBUG。
    ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
    Append=false：true表示消息增加到指定文件中，false则将消息覆盖指定的文件内容，默认值是true。
    File=D:/logs/logging.log4j：指定当前消息输出到logging.log4j文件中。
    DatePattern='.'yyyy-MM：每月滚动一次日志文件，即每月产生一个新的日志文件。当前月的日志文件名为logging.log4j，前一个月的日志文件名为logging.log4j.yyyy-MM。
    另外，也可以指定按周、天、时、分等来滚动日志文件，对应的格式如下：
    1)'.'yyyy-MM：每月
    2)'.'yyyy-ww：每周
    3)'.'yyyy-MM-dd：每天
    4)'.'yyyy-MM-dd-a：每天两次
    5)'.'yyyy-MM-dd-HH：每小时
    6)'.'yyyy-MM-dd-HH-mm：每分钟

- RollingFileAppender 选项：
    Threshold=WARN：指定日志信息的最低输出级别，默认为DEBUG。
    ImmediateFlush=true：表示所有消息都会被立即输出，设为false则不输出，默认值是true。
    Append=false：true表示消息增加到指定文件中，false则将消息覆盖指定的文件内容，默认值是true。
    File=D:/logs/logging.log4j：指定消息输出到logging.log4j文件中。
    MaxFileSize=100KB：后缀可以是KB, MB 或者GB。在日志文件到达该大小时，将会自动滚动，即将原来的内容移到logging.log4j.1文件中。
    MaxBackupIndex=2：指定可以产生的滚动文件的最大数，例如，设为2则可以产生logging.log4j.1，logging.log4j.2两个滚动文件和一个logging.log4j文件。
~~~



#### 2.3 配置输出格式 Layout

~~~txt
log4j.appender.appenderName.layout = className

className：可设值

- HTMLLayout选项：
    LocationInfo=true：输出java文件名称和行号，默认值是false。
    Title=My Logging： 默认值是Log4J Log Messages。
- PatternLayout选项：
    ConversionPattern=%m%n：设定以怎样的格式显示消息。
~~~





### 日志输出格式

上面示例二中，console 的输出内容是有一定格式的。关于配置格式：

~~~properties
log4j.appender.dest_01_console.layout.ConversionPattern =  %d{ABSOLUTE} %5p %c{1}:%L - %m%n
~~~

~~~txt
%p: 输出日志信息优先级，即 DEBUG，INFO，WARN，ERROR，FATAL,
%d: 输出日志时间点的日期或时间，默认格式为 ISO8601，也可以在其后指定格式，
	比如：%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921
%r: 输出自应用启动到输出该log信息耗费的毫秒数
%c: 输出日志信息所属的类目，通常就是所在类的全名
%t: 输出产生该日志事件的线程名
%l: 输出日志事件的发生位置，相当于%C.%M(%F:%L)的组合，包括类目名、发生的线程，以及在代码中的行数。
	比如：Testlog4.main(TestLog4.java:10)
%x: 输出和当前线程相关联的 NDC(嵌套诊断环境)，尤其用到像 java servlets 这样的多客户多线程的应用中。
%%: 输出一个 "%" 字符
%F: 输出日志消息产生时所在的文件名称
%L: 输出代码中的行号
%m: 输出代码中指定的消息,产生的日志具体信息
%n: 输出一个回车换行符，Windows 平台为 "\r\n"，Unix平台为 "\n" 输出日志信息换行

可以在 % 与模式字符之间加上修饰符来控制其最小宽度、最大宽度、和文本的对齐方式。
说明：
"c" 指定输出category的名称
"-" 号表示左对齐
如：
	- %20c
		指定输出 category 的名称，最小的宽度是20；
		如果 category 的名称小于20的话，默认的情况下右对齐。
	- %-20c	
		指定输出 category 的名称，最小的宽度是20；
		如果 category 的名称小于20的话，"-" 号指定左对齐。
	- %.30c
		指定输出 category 的名称，最大的宽度是30；
		如果 category 的名称大于30的话，就会将左边多出的字符截掉；
		但小于30的话也不会有空格。
	- %20.30c
		如果 category 的名称小于20就补空格，并且右对齐；
		如果其名称长于30，就从左边交远销出的字符截掉。
~~~





### 3. 小案例

~~~properties
### 设置级别和目的地(这里多个目的地) ###
log4j.rootLogger = trace, CONSOLE, zhangsanLog
### 这里的 me 是包，也就是在这个包记录日志时，是只记录debug及以上级别的日志
log4j.logger.me = DEBUG

### 输出到控制台 ###
log4j.appender.CONSOLE = org.apache.log4j.ConsoleAppender
log4j.appender.CONSOLE.Target = System.out
log4j.appender.CONSOLE.layout = org.apache.log4j.PatternLayout
log4j.appender.CONSOLE.layout.ConversionPattern =  %d{ABSOLUTE} %5p %c{1}:%L [%t:%r]- %m%n

### 输出到日志文件 ###
log4j.appender.zhangsanLog = org.apache.log4j.DailyRollingFileAppender
log4j.appender.zhangsanLog.File =G\:\\var\\alldata\\zhenduan\\debug.log
# log4j.appender.zhangsanLog.File =/var/alldata/zhenduan/debug.log
log4j.appender.zhangsanLog.Append = true
## 只输出DEBUG级别以上的日志
log4j.appender.zhangsanLog.Threshold = DEBUG

#'.'yyyy-MM-dd: 每天产生一个新的文件
log4j.appender.zhangsanLog.DatePattern = '.'yyyy-MM-dd
log4j.appender.zhangsanLog.layout = org.apache.log4j.PatternLayout
log4j.appender.zhangsanLog.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss} [%t:%r] - [%p] [%c{1}:%L] [%M] %m%n
log4j.additivity.zhangsanLog = false
~~~

















## 比较全面的日志配置

Log4j配置文件实现了输出到控制台、文件、回滚文件、发送日志邮件、输出到数据库日志表、自定义标签等全套功能。

~~~properties
log4j.rootLogger=DEBUG,console,dailyFile,im
log4j.additivity.org.apache=true
~~~

### 控制台（console）
~~~properties
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.ImmediateFlush=true
log4j.appender.console.Target=System.err
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~

### 日志文件（logFile）
~~~properties
log4j.appender.logFile=org.apache.log4j.FileAppender
log4j.appender.logFile.Threshold=DEBUG
log4j.appender.logFile.ImmediateFlush=true
log4j.appender.logFile.Append=true
log4j.appender.logFile.File=D:/logs/log.log4j
log4j.appender.logFile.layout=org.apache.log4j.PatternLayout
log4j.appender.logFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~

### 回滚文件（rollingFile）
~~~properties
log4j.appender.rollingFile=org.apache.log4j.RollingFileAppender
log4j.appender.rollingFile.Threshold=DEBUG
log4j.appender.rollingFile.ImmediateFlush=true
log4j.appender.rollingFile.Append=true
log4j.appender.rollingFile.File=D:/logs/log.log4j
log4j.appender.rollingFile.MaxFileSize=200KB
log4j.appender.rollingFile.MaxBackupIndex=50
log4j.appender.rollingFile.layout=org.apache.log4j.PatternLayout
log4j.appender.rollingFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~

### 定期回滚日志文件（dailyFile）
~~~properties
log4j.appender.dailyFile=org.apache.log4j.DailyRollingFileAppender
log4j.appender.dailyFile.Threshold=DEBUG
log4j.appender.dailyFile.ImmediateFlush=true
log4j.appender.dailyFile.Append=true
log4j.appender.dailyFile.File=D:/logs/log.log4j
log4j.appender.dailyFile.DatePattern='.'yyyy-MM-dd
log4j.appender.dailyFile.layout=org.apache.log4j.PatternLayout
log4j.appender.dailyFile.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~

### 应用于 socket
~~~properties
log4j.appender.socket=org.apache.log4j.RollingFileAppender
log4j.appender.socket.RemoteHost=localhost
log4j.appender.socket.Port=5001
log4j.appender.socket.LocationInfo=true
# Set up for Log Factor 5
log4j.appender.socket.layout=org.apache.log4j.PatternLayout
log4j.appender.socket.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
# Log Factor 5 Appender
log4j.appender.LF5_APPENDER=org.apache.log4j.lf5.LF5Appender
log4j.appender.LF5_APPENDER.MaxNumberOfRecords=2000
~~~

###  发送日志到指定邮件
~~~properties
log4j.appender.mail=org.apache.log4j.net.SMTPAppender
log4j.appender.mail.Threshold=FATAL
log4j.appender.mail.BufferSize=10
log4j.appender.mail.From = xxx@mail.com
log4j.appender.mail.SMTPHost=mail.com
log4j.appender.mail.Subject=Log4J Message
log4j.appender.mail.To= xxx@mail.com
log4j.appender.mail.layout=org.apache.log4j.PatternLayout
log4j.appender.mail.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~

### 应用于数据库
~~~properties
log4j.appender.database=org.apache.log4j.jdbc.JDBCAppender
log4j.appender.database.URL=jdbc:mysql://localhost:3306/test
log4j.appender.database.driver=com.mysql.jdbc.Driver
log4j.appender.database.user=root
log4j.appender.database.password=
log4j.appender.database.sql=INSERT INTO LOG4J (Message) VALUES('=[%-5p] %d(%r) --> [%t] %l: %m %x %n')
log4j.appender.database.layout=org.apache.log4j.PatternLayout
log4j.appender.database.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~

### 自定义 Appender
~~~properties
log4j.appender.im = net.cybercorlin.util.logger.appender.IMAppender
log4j.appender.im.host = mail.cybercorlin.net
log4j.appender.im.username = username
log4j.appender.im.password = password
log4j.appender.im.recipient = corlin@cybercorlin.net
log4j.appender.im.layout=org.apache.log4j.PatternLayout
log4j.appender.im.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
~~~















































































