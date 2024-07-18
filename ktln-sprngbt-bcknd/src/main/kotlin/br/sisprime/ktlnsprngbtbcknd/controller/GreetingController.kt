package br.sisprime.ktlnsprngbtbcknd.controller

import br.sisprime.ktlnsprngbtbcknd.config.GreetingConfiguration
import br.sisprime.ktlnsprngbtbcknd.model.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val contador: AtomicLong = AtomicLong()

    @Autowired
    private lateinit var configuration: GreetingConfiguration

    @RequestMapping("/greeting")
    fun greeting(
            @RequestParam(required = false, defaultValue = "") nome: String
    ): Greeting {
        var valorNome = nome
        if(nome.isEmpty()) valorNome = configuration.defaultValue.toString()
        return Greeting(contador.incrementAndGet(), "${configuration.greeting} $valorNome")
    }
}