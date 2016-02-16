package fr.ekito.agi.kotlin

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
open class Application : InitializingBean {

    val log = LoggerFactory.getLogger(Application::class.java)

    @Autowired
    lateinit var bs: BootStrap;

    override fun afterPropertiesSet() {
        log.info("init after launch ... ")
        // inject data
        bs.initData();
    }
}

// entry point
fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
