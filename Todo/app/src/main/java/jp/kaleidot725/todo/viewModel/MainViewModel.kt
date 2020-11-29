package jp.kaleidot725.todo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.kaleidot725.todo.model.Todo

class MainViewModel: ViewModel() {
    private val _list: MutableLiveData<List<Todo>> = MutableLiveData(createTodo())
    val list: LiveData<List<Todo>> = _list

    private fun createTodo() : List<Todo> {
        return mutableListOf<Todo>().apply {
            for (value in 0..100) { this.add(Todo("TODO $value")) }
        }
    }
}