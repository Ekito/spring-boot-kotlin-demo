package fr.ekito.agi.kotlin

import fr.ekito.agi.kotlin.domain.Customer
import fr.ekito.agi.kotlin.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by arnaud on 16/02/2016.
 */
@Component
class BootStrap @Autowired constructor(val repository: CustomerRepository) {

    private val log = LoggerFactory.getLogger(BootStrap::class.java)

    fun initData() {
        repository.save(Customer("John", "Doe"))
        repository.save(Customer("Sarah", "Connor"))
        repository.save(Customer("Bill", "Murray"))

        val count = repository.count()
        log.info("repository initialized with ${count} entities ...")
    }
}