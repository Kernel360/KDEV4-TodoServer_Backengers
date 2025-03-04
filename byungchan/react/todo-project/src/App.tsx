import TodoCreator from '@/components/todos/TodoCreator'
import TodoList from '@/components/todos/TodoList'
import { useState } from 'react'

export default function App() {
  const [todos, setTodos] = useState<string[]>([])
  return (
    <>
      <TodoCreator todos={todos} />
      <TodoList />
    </>
  )
}
