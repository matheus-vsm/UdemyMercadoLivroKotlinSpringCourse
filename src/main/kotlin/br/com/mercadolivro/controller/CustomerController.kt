package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    val customers = mutableListOf<Customer>()

    @GetMapping
    fun getCustomer(): MutableList<Customer> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(Customer(id, customer.nome, customer.email))
        println(customers)
    }
}
