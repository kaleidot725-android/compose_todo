package jp.kaleidot725.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import jp.kaleidot725.todo.model.Todo
import jp.kaleidot725.todo.ui.TodoTheme
import jp.kaleidot725.todo.ui.purple700

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen("Android")
                }
            }
        }
    }
}

@Composable
fun HomeScreen(name: String) {
    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FloatingActionButton() },
        bodyContent = { BodyContent() },
    )
}

@Composable
fun TopBar() {
    TopAppBar(title = { Text("TODO") }, backgroundColor = purple700)
}

@Composable
fun FloatingActionButton() {
    Button(onClick = {}) { Text(text = "+") }
}

@Composable
fun BodyContent() {
    val todos = listOf(Todo("TEST1"), Todo("TEST2"), Todo("TEST3"), Todo("TEST4"))
    LazyColumnFor(items = todos) { todo ->
        Row(Modifier.padding(8.dp).fillMaxWidth()) {
            Checkbox(checked = false, onCheckedChange = {}, Modifier.align(Alignment.CenterVertically))
            Text(text = todo.name, Modifier.padding(8.dp).align(Alignment.CenterVertically))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoTheme {
        HomeScreen("Android")
    }
}