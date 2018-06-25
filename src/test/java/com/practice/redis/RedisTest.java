package com.practice.redis;

import com.practice.redis.domain.student.Student;
import com.practice.redis.domain.student.StudentRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by kwonsungyang on 25/06/2018
 */
public class RedisTest extends RedisApplicationTests{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);

        Student retrievedStudent = studentRepository.findOne("Eng2015001");

        retrievedStudent.setName("Richard Watson");
        studentRepository.save(student);
    }

    @Test
    public void testGeo() {
        Point point = new Point(15, 37);
        Distance distance = new Distance(200, Metrics.KILOMETERS);
        Circle circle = new Circle(point, distance);

        GeoResults<RedisGeoCommands.GeoLocation<Object>> leisure = redisTemplate.boundGeoOps("Leisure").geoRadius(circle);
    }
}
