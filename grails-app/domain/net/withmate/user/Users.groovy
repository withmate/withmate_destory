package net.withmate.user

class Users {

    String email
    String name
    String passwd

    static constraints = {
        email (unique: true, blank: false)
        name (blank: false)
        passwd (size: 9..16, blank: false)
    }


}
