package net.withmate.user

import org.springframework.dao.DataIntegrityViolationException

class UsersController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [usersInstanceList: Users.list(params), usersInstanceTotal: Users.count()]
    }

    def create() {
        [usersInstance: new Users(params)]
    }

    def save() {
        def usersInstance = new Users(params)
        if (!usersInstance.save(flush: true)) {
            render(view: "create", model: [usersInstance: usersInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'users.label', default: 'Users'), usersInstance.id])
        redirect(action: "show", id: usersInstance.id)
    }

    def show(Long id) {
        def usersInstance = Users.get(id)
        if (!usersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "list")
            return
        }

        [usersInstance: usersInstance]
    }

    def edit(Long id) {
        def usersInstance = Users.get(id)
        if (!usersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "list")
            return
        }

        [usersInstance: usersInstance]
    }

    def update(Long id, Long version) {
        def usersInstance = Users.get(id)
        if (!usersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (usersInstance.version > version) {
                usersInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'users.label', default: 'Users')] as Object[],
                          "Another user has updated this Users while you were editing")
                render(view: "edit", model: [usersInstance: usersInstance])
                return
            }
        }

        usersInstance.properties = params

        if (!usersInstance.save(flush: true)) {
            render(view: "edit", model: [usersInstance: usersInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'users.label', default: 'Users'), usersInstance.id])
        redirect(action: "show", id: usersInstance.id)
    }

    def delete(Long id) {
        def usersInstance = Users.get(id)
        if (!usersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "list")
            return
        }

        try {
            usersInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "show", id: id)
        }
    }
}
