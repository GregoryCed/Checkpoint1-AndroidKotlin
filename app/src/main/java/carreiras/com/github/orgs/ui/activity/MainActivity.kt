package carreiras.com.github.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

/*
MainActivity estende da classe Activity, fornecida pelo Android Jetpack Framework.
Esta atividade é responsável por mostrar uma lista  de produtos em um RecyclerView.
 */

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    /*
        OnCreate:
     Este é um método do ciclo de vida de uma atividade Android.
     É invocado durante a criação da atividade, onde inicializa a interface do APP
     e configura o RecyclerView para mostrar a lista de produtos.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /*
        onResume:
       Este método tem a funcionalidade de garantir que a interface do usuário esteja atualizada
       com os dados mais recentes sempre que a atividade se torna visível novamente para o usuário.

     */

    override fun onResume() {
        super.onResume()

        /*Obtém a referência para o RecyclerView do layout da atividade com o ID */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        /*Cria uma instância de ProdutosDao, uma classe responsável por acessar
        e gerenciar os dados dos produtos.*/
        val dao = ProdutosDao()

        /*Registra uma mensagem de log indicando que o método onResume() está sendo
        executado e exibe todos os produtos recuperados pelo método buscaTodos() do ProdutosDao.*/
        Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")

        /*Configura o adaptador do RecyclerView com uma instância de ListaProdutosAdapter.
        Este adaptador é responsável por vincular os dados dos produtos ao RecyclerView para que
        sejam exibidos na interface do usuário.*/
        recyclerView.adapter = ListaProdutosAdapter(
            context = this,
            produtos = dao.buscaTodos()
        )

        /*Obtém a referência para o botão de ação flutuante (FloatingActionButton)
        com o ID R.id.floatingActionButton.*/
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        /*Define um listener de clique para o botão de ação flutuante. Quando o botão é clicado,
        uma nova atividade FormularioProdutoActivity é iniciada, permitindo ao usuário adicionar
        um novo produto.*/
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}