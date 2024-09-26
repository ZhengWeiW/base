package com.base;

import com.entity.User1;

/**
 * @author <a href="#">Allen.zww</a>
 * @version v1.0
 * @since GenericRepositoryTest.java v1.0 2024年09月26日 13:21 Allen.zww
 */
public class GenericRepositoryTest {
        public static void main(String[] args) {
            // 创建一个泛型类的实例，并传入具体的实体类型
            GenericRepository<User1> user1Repository = new GenericRepository<>();
            GenericRepository<User> userRepository = new GenericRepository<>();

            // 创建一个实体对象
            User1 user1 = new User1("John", 25);

            User user = new User(12,"tom",18);

            // 调用 save 方法，获取并打印实体的属性和值
            user1Repository.save(user1);
            userRepository.save(user);
        }
}
