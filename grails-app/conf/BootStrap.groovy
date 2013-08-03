import net.withmate.user.Users

class BootStrap {

    def init = { servletContext ->
        if(!Users.count()){

            new Users(email: "test1@narratage.com",name: "test1",passwd: "test1234!").save(failOnError: true)
            new Users(email: "test2@narratage.com",name: "test2",passwd: "test2234!").save(failOnError: true)
            new Users(email: "test3@narratage.com",name: "test3",passwd: "test3234!").save(failOnError: true)
            new Users(email: "test4@narratage.com",name: "test4",passwd: "test4234!").save(failOnError: true)
        }

    }
    def destroy = {
    }
}
