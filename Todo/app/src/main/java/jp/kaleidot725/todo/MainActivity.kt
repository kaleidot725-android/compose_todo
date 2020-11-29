package jp.kaleidot725.todo

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import jp.kaleidot725.todo.ui.TodoTheme
import jp.kaleidot725.todo.ui.purple700
import jp.kaleidot725.todo.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val viewModel = remember { MainViewModel() }

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FloatingActionButton() },
        bodyContent = { BodyContent(viewModel) },
    )
}

@Composable
fun TopBar() {
    TopAppBar(title = { Text("TODO") }, backgroundColor = purple700)
}

@Composable
fun FloatingActionButton() {
    Button(onClick = {}) { Text(text = stringResource(R.string.plus)) }
}

@Composable
fun BodyContent(viewModel: MainViewModel) {
    val todos = viewModel.list.observeAsState(listOf())
    LazyColumnFor(items = todos.value) { todo ->
        Row(Modifier.padding(8.dp).fillMaxWidth()) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                Modifier.align(Alignment.CenterVertically)
            )
            Text(text = todo.name, Modifier.padding(8.dp).align(Alignment.CenterVertically))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        HomeScreen()
    }
}