package fr.ekito.agi.kotlin.repository

import fr.ekito.agi.kotlin.domain.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {

	fun findOneByLastName(lastName: String): Customer

	fun findByLastName(lastName: String): List<Customer>
}
