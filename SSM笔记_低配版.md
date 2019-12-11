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









