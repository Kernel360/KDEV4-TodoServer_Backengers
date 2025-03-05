import { useTodoStore } from '@/stores/todo'
import { useEffect } from 'react'
import TodoItem from './TodoItem'

export default function TodoList() {
  const getTodos = useTodoStore(state => state.getTodos)
  const todos = useTodoStore(state => state.todos)

  useEffect(() => {
    getTodos()
  }, [])

  return (
    <ul>
      {todos.map(todo => (
        <TodoItem
          key={todo.id}
          todo={todo}
        />
      ))}
    </ul>
  )
}
