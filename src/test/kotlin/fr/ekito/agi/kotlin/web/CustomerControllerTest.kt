package fr.ekito.agi.kotlin.web

import fr.ekito.agi.kotlin.domain.Customer
import fr.ekito.agi.kotlin.repository.CustomerRepository
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * Created by arnaud on 16/02/2016.
 */
class CustomerControllerTest {

    lateinit var mockMvc: MockMvc;

    @InjectMocks
    lateinit var controller: CustomerController;

    @Mock
    lateinit var repository: CustomerRepository;

    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)

        mockMvc = MockMvcBuilders.standaloneSetup(controller).setMessageConverters(MappingJackson2HttpMessageConverter()).build()
    }

    @Test
    open fun test() {
        Mockito.`when`(repository.findAll()).thenReturn(listOf(Customer("John", "Doe")))

        mockMvc.perform(MockMvcRequestBuilders.get("/customer")).andExpect(MockMvcResultMatchers.status().isOk)
    }
}
