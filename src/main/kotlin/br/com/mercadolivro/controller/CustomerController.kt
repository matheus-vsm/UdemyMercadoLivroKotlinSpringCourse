package br.com.mercadolivro.controller

import br.com.mercadolivro.model.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getCustomer(): Customer {
        return Customer(
            id = "1",
            name = "John Doe",
            email = "john@gmail.com")
    }


}