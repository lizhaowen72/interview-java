package com.lzw.java.performance.tuning.lession006;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/10 20:02
 * @Description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Map<String, List<Student>> stuMap = new HashMap<String, List<Student>>();
        List<Student> studentList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getHeight() > 160) {
                if (stuMap.get(student.getSex()) == null) {
                    List<Student> list = new ArrayList<>();
                    list.add(student);
                    stuMap.put(student.getSex(), list);
                } else {
                    stuMap.get(student.getSex()).add(student);
                }
            }
        }
        Map<String, List<Student>> collect = studentList.stream().filter((Student s) -> s.getHeight() > 160).collect(Collectors.groupingBy(Student::getSex));
        studentList.parallelStream().filter((Student s)->s.getHeight()>160).collect(Collectors.groupingBy(Student::getSex));

        List<String> names = Arrays.asList("张三", "李四", "王老五", "李三", "刘老四", "王小二", "张四", "张五六七");

        String maxLenStartWithZ = names.stream()
                .filter(name -> name.startsWith("张"))
                .mapToInt(String::length)
                .max()
                .toString();
    }
}
