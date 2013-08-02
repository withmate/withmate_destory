package net.withmate.user

class Users {

    String email
    String name
    String passwd

    static constraints = {
    }

    static mapping = {
        id generator: 'assigned' , name: "email"
    }

}
