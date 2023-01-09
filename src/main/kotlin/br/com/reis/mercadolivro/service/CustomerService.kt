package br.com.reis.mercadolivro.service

import br.com.reis.mercadolivro.controller.PostCustomerRequest
import br.com.reis.mercadolivro.controller.PutCustomerRequest
import br.com.reis.mercadolivro.model.CustomerModel
import br.com.reis.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByName(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        if (!customerRepository.existsById(id)){
            throw Exception()
        }
        return customerRepository.findById(id).get()
    }

    fun update(id: Int, customer: CustomerModel){
        customer.id = id

        if (!customerRepository.existsById(id)){
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)){
            throw Exception()
        }
        customerRepository.deleteById(id)
    }
}