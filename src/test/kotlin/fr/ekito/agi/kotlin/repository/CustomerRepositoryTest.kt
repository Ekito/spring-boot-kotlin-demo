package fr.ekito.agi.kotlin.repository

import fr.ekito.agi.kotlin.Application
import fr.ekito.agi.kotlin.BootStrap
import fr.ekito.agi.kotlin.domain.Customer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by arnaud on 16/02/2016.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(Application::class))
class CustomerRepositoryTest {

    val lastName = "Simpson"

    @Autowired
    lateinit var repository: CustomerRepository;
    @Autowired
    lateinit var bootstrap: BootStrap;

    @Before
    fun setup() {
        repository.deleteAll()
        bootstrap.initData()
    }

    @Test
    fun testFindOne() {
        val customer = Customer("Homer", lastName)
        repository.save(customer)

        val result = repository.findOneByLastName(lastName)
        assert(result == customer)
    }

    @Test
    fun testFindSeveral() {
        repository.save(Customer("Homer", lastName))
        repository.save(Customer("Marge", lastName))

        val list = repository.findByLastName(lastName)
        Assert.assertEquals(2, list.size)
    }
}
