package carreiras.com.github.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.model.Produto

/*
Esta classe exibe uma lista de produtos em um RecyclerView.
 */

class ListaProdutosAdapter(
    /*Contexto da Aplicação*/
    private val context: Context,

    /* Lista de produtos a ser exibida*/
    private val produtos: List<Produto>

) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    /* ViewHolder é uma classe que representa um item de exibição dentro
    do RecyclerView, utilizado para exibir e manter os elementos visuais de
    forma eficiente*/
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /*
        Essa fução Vincula, ela linka os dados do produto ao item
        de visualização, linkando pelo ID
         */
        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome

            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao

            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString()
        }
    }

    /*
    Essa função onCreateViewHolder é responsável por criar novas instâncias de
    ViewHolder conforme necessário pelo RecyclerView para exibir itens da lista.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaProdutosAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ListaProdutosAdapter.ViewHolder(view)
    }

    /*
    Função que retorna o tamanho da lista de produtos
     */
    override fun getItemCount(): Int = produtos.size

    /*
    Esse método onBindViewHolder exibi os dadosde uma posição específica
     */
    override fun onBindViewHolder(holder: ListaProdutosAdapter.ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }
}
