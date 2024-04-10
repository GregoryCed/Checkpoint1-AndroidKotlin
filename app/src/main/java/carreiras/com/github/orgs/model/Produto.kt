package carreiras.com.github.orgs.model

import java.math.BigDecimal

/*
A classe Produto estabelece os atributos que cada instância de produto conterá,
incluindo um nome, uma descrição e um valor.
*/

data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)
