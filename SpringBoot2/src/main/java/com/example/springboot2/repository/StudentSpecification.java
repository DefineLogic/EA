package com.example.springboot2.repository;

import com.example.springboot2.entity.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class StudentSpecification {
    public static Specification<Student> hasGpaGreaterThan(float gpa) {
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get("gpa"), gpa);
            }
        };
    }

    public static Specification<Student> hasGpaLessThan(float gpa) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("gpa"), gpa);
    }
}
