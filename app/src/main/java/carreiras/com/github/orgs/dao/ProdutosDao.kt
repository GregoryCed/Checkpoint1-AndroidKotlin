/*
Esta classe representa um Data Access Object (DAO) para a entidade Produto.
 */

package carreiras.com.github.orgs.dao

import carreiras.com.github.orgs.model.Produto

class ProdutosDao {

    /*
    Função que adiciona um produto à lista de produtos.
     */
    fun adiciona(produto: Produto) {
        Companion.produtos.add(produto)
    }

    /*
    Função que retorna todos os produtos armazenados
     */
    fun buscaTodos(): List<Produto> {
        return Companion.produtos.toList()
    }

    /*
    O companion object está sendo usado para manter uma lista de produtos dentro
    da classe ProdutosDao. Isso significa que a lista produtos será compartilhada
    por todas as instâncias da classe ProdutosDao e pode ser acessada diretamente
    através do nome da classe, sem precisar criar uma instância específica de ProdutosDao.
     */
    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}