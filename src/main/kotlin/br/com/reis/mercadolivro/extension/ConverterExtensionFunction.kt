package br.com.reis.mercadolivro.extension

import br.com.reis.mercadolivro.controller.PostCustomerRequest
import br.com.reis.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}