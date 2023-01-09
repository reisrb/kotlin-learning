package br.com.reis.mercadolivro.repository

import br.com.reis.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int>{

    fun findByName(name: String): List<CustomerModel>
}