package springcloud;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import java.util.function.Function;

public class T1 {
    public static void main(String[] args) {
        Ls ls = new Ls();
//        Dog cat1 = ls.hi("cat", str -> {
//            Cat cat = new Cat();
//            cat.setName(str);
//            return cat;
//        });

        Dog cat1 = ls.hi("cat", str -> new Cat(str));

        System.out.println(cat1.getName());
    }

}


class Dog {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }
}


class Ls {
//    public RouteLocatorBuilder.Builder route(String id, Function<PredicateSpec, Route.AsyncBuilder> fn) {
//        Route.AsyncBuilder routeBuilder = (Route.AsyncBuilder)fn.apply((new RouteLocatorBuilder.RouteSpec(this)).id(id));
//        this.add(routeBuilder);
//        return this;
//    }

    public Dog hi(String str, Function<String, Cat> fn) {
        Cat apply = fn.apply(str);
        Dog dog = new Dog();
        dog.setName(apply.getName() + "把" + str + "改成了Dog");
        return dog;
    }

}