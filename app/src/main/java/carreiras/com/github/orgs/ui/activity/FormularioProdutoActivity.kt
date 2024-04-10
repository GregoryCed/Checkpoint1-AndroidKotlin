package carreiras.com.github.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.model.Produto
import java.math.BigDecimal

/*
Esta classe representa a atividade de formulário para adicionar um novo produto.
 */

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        Pegando o botão da interface e colocando em uma variável
         */
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        /*
            Ppegando as informações digitadas no formulário e armazenando em uma
            variável asssim que o botão armazenado for clicado.
        */

        botaoSalvar.setOnClickListener {

            /*]
            Pegando as informações digitadas nos campos
             */
            val campoNome = findViewById<EditText>(R.id.nome)
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val campoValor = findViewById<EditText>(R.id.valor)

            /*
            Transformando as informações coletadas em String
             */
            val nome = campoNome.text.toString()
            val descricao = campoDescricao.text.toString()
            val valorEmTexto = campoValor.text.toString()

            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            /*
            Passando as informações coletadas para um objeto
             */
            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormularioProduto", "onCreate: $produtoNovo")
            val dao = ProdutosDao()

            /*
            Adicionando as informações do objeto para o ProdutoDao;
             */
            dao.adiciona(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")

            finish()
        }
    }
}