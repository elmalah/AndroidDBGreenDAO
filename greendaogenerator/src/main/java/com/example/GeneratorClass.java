package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;


public class GeneratorClass {
    public static void main(String[] args)  throws Exception {

        //place where db folder will be created inside the project folder
        Schema schema = new Schema(1,"sample.com.androiddbgreendao.db");

        //Entity Users or table Users
        Entity user= schema.addEntity("SaveUserModel");
        user.addIdProperty();                       //It is the primary key for uniquely identifying a row
        user.addStringProperty("name").notNull();    //Not null is SQL constrain
        user.addStringProperty("email");
        user.addStringProperty("password");
        user.addStringProperty("firstName");
        user.addStringProperty("lastName");
        user.addStringProperty("mobile");
        //user.addDateProperty("date");

        //  ./app/src/main/java/   ----   com/codekrypt/greendao/db is the full path
        new DaoGenerator().generateAll(schema, "./app/src/main/java");
    }
}
