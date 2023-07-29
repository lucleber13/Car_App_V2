package com.cbcode.car_app_v2.User_Packages.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Role() {
    }
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.getId()) && Objects.equals(name, role.getName());
    }

    @Override
    public String toString(){
        return "Role{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
