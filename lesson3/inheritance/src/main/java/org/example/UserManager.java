package org.example;

//CRUD operations
// create,

//  bulk operations: toplu işlemler
//  bulk insert: toplu ekleme işlemi ( 2k çalışan ekleme vs)
public class UserManager {
    public void add(User user) {
        System.out.println(user.getFirstName() + " is added");
    }

    public void addMultiple(User[] users){
        for(User user:users)
            add(user);
    }
}
