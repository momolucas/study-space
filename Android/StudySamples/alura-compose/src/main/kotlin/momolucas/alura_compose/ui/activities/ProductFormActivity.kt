package momolucas.alura_compose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import momolucas.alura_compose.R
import momolucas.alura_compose.dao.ProductDao
import momolucas.alura_compose.model.Product
import momolucas.alura_compose.ui.theme.StudySamplesTheme
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormActivity : ComponentActivity() {

    val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudySamplesTheme {
                Surface {
                    ProductFormScreen(onSaveClick = { product ->
                        dao.save(product)
                        finish()
                    })
                }
            }
        }
    }
}

@Composable
fun ProductFormScreen(onSaveClick: (product: Product) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        Text(text = "Criando o produto", style = MaterialTheme.typography.h1)
        var url: String by remember {
            mutableStateOf("")
        }
        AsyncImage(
            model = url,
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.placeholder),
            error = painterResource(id = R.drawable.placeholder),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        TextField(
            value = url,
            onValueChange = { url = it },
            label = { Text("Url da imagem") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        var nome: String by remember {
            mutableStateOf("")
        }
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )
        var preco: String by remember {
            mutableStateOf("")
        }
        val formatter = remember {
            DecimalFormat("#.##")
        }
        TextField(
            value = preco,
            onValueChange = {
                try {
                    preco = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    if (it.isBlank()) {
                        preco = it
                    }
                }
            },
            label = { Text("Preço") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        var descricao: String by remember {
            mutableStateOf("")
        }
        TextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onSaveClick(
                    Product(
                        name = nome,
                        image = url,
                        price = BigDecimal(preco),
                        description = descricao
                    )
                )
            }) {
            Text("Salvar")
        }
        Spacer(Modifier)
    }
}

@Preview
@Composable
fun ProductFormaScreenPreview() {
    StudySamplesTheme {
        Surface {
            ProductFormScreen()
        }
    }
}