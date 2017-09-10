package cc.fudali.demo.controller

import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class UserController(private val mongoOperations: ReactiveMongoOperations) {

    @GetMapping
    fun getAll() = mongoOperations.findAll(User::class.java)

    @PostMapping
    fun insert(@RequestBody user: User) : Mono<User> {
        return mongoOperations.save(user)
    }

}