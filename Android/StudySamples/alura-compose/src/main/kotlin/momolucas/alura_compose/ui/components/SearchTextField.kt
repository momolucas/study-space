package momolucas.alura_compose.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import momolucas.alura_compose.ui.theme.StudySamplesTheme

@Composable
fun SearchTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = { value ->
            onValueChange(value)
        },
        modifier,
        shape = RoundedCornerShape(100),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        label = {
            Text(text = "Produto")
        },
        placeholder = {
            Text(text = "O que você procura?")
        },
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    StudySamplesTheme {
        Surface {
            SearchTextField(value = "a", onValueChange = {})
        }
    }
}