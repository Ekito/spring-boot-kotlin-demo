package fr.ekito.agi.kotlin.web

import fr.ekito.agi.kotlin.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController @Autowired constructor(val repository: CustomerRepository) {

    @RequestMapping("")
    fun findAll() = repository.findAll()

    @RequestMapping("/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = repository.findOneByLastName(lastName)

    @RequestMapping("/count")
    fun count() = "${repository.count()} entities"
}